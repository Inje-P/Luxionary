package com.luan.luxionary;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroEng extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    LinearLayout llIntroTitle;
    TextView tvIntroTitle;
    Animation ani;
    AnimationDrawable aniDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_eng);

        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");
        strAvatar = getData.getStringExtra("avatar");

        llIntroTitle = (LinearLayout) findViewById(R.id.llIntroTitle);
        aniDrawable = (AnimationDrawable) llIntroTitle.getBackground();
        aniDrawable.setEnterFadeDuration(300);
        aniDrawable.setExitFadeDuration(300);
        aniDrawable.start();

        tvIntroTitle = (TextView) findViewById(R.id.tvIntroTitle);
        ani = AnimationUtils.loadAnimation(IntroEng.this, R.anim.ascend);
        tvIntroTitle.startAnimation(ani);

        // 이벤트 핸들러를 통해서 몇초 후의 동작을 시킨다.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroEng.this, MainEng.class);
                intent.putExtra("nick", strNick);
                intent.putExtra("pw", strPw);
                intent.putExtra("name", strName);
                intent.putExtra("email", strEmail);
                intent.putExtra("avatar", strAvatar);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        }, 2000);
    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(IntroEng.this, MainActivity.class);
        intentBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentBack.putExtra("nick", strNick);
        intentBack.putExtra("pw", strPw);
        intentBack.putExtra("name", strName);
        intentBack.putExtra("email", strEmail);
        intentBack.putExtra("avatar", strAvatar);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

}
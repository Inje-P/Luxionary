package com.luan.luxionary;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroSpa extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    LinearLayout llIntroTitle;
    TextView tvIntroTitle;
    Animation ani;
    AnimationDrawable aniDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_spa);

        // Data from Firebase
        Intent getData = getIntent();
        username = getData.getStringExtra("username");
        email = getData.getStringExtra("email");
        profile = getData.getStringExtra("profile");
        avatar = getData.getStringExtra("avatar");

        llIntroTitle = (LinearLayout) findViewById(R.id.llIntroTitle);
        aniDrawable = (AnimationDrawable) llIntroTitle.getBackground();
        aniDrawable.setEnterFadeDuration(300);
        aniDrawable.setExitFadeDuration(300);
        aniDrawable.start();

        tvIntroTitle = (TextView) findViewById(R.id.tvIntroTitle);
        ani = AnimationUtils.loadAnimation(IntroSpa.this, R.anim.ascend);
        tvIntroTitle.startAnimation(ani);

        // 이벤트 핸들러를 통해서 몇초 후의 동작을 시킨다.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroSpa.this, MainSpa.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                intent.putExtra("profile", profile);
                intent.putExtra("avatar", avatar);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        }, 1500);
    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(IntroSpa.this, MainActivity.class);
        intentBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentBack.putExtra("username", username);
        intentBack.putExtra("email", email);
        intentBack.putExtra("profile", profile);
        intentBack.putExtra("avatar", avatar);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

}
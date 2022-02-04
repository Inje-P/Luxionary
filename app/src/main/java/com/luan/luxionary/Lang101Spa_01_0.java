package com.luan.luxionary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lang101Spa_01_0 extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Animation ani1, ani2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lang101_spa_01_0);

        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");
        strAvatar = getData.getStringExtra("avatar");

        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);

        ani1 = AnimationUtils.loadAnimation(Lang101Spa_01_0.this, R.anim.descend);
        ani2 = AnimationUtils.loadAnimation(Lang101Spa_01_0.this, R.anim.ascend);
        tvTitle1.startAnimation(ani1);
        tvTitle2.startAnimation(ani2);

        // 이벤트 핸들러를 통해서 몇초 후의 동작을 시킨다.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentAccount = new Intent(Lang101Spa_01_0.this, Lang101Spa_01_1.class);
                intentAccount.putExtra("nick", strNick);
                intentAccount.putExtra("pw", strPw);
                intentAccount.putExtra("name", strName);
                intentAccount.putExtra("email", strEmail);
                intentAccount.putExtra("avatar", strAvatar);
                startActivity(intentAccount);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        }, 1000);
    }
}
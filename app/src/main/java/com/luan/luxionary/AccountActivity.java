package com.luan.luxionary;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {
    // DB
    String strNick, strPw, strName, strEmail;

    Animation logoAni;
    Animation loginFormAni;
    ImageView imgLogo;
    LinearLayout loginForm;
    Button btnSignup, btnSignin;
    EditText etEmail, etPw;
    String inputEmail, inputPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");

        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        loginForm = (LinearLayout) findViewById(R.id.loginForm);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPw = (EditText) findViewById(R.id.etPw);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnSignin = (Button) findViewById(R.id.btnSignin);

        // logoAni 애니메이션
        logoAni = new TranslateAnimation(0, 0, 0, -100);
        logoAni.setDuration(1000); // 지속시간
        logoAni.setFillAfter(true); // 이동 후 이동한 자리에 남아 있을건지

        // loginFormAni 애니메이션
        loginFormAni = new AlphaAnimation(0, 1);
        loginFormAni.setDuration(1000);
        loginFormAni.setStartOffset(1000);

        imgLogo.setAnimation(logoAni);
        loginForm.setAnimation(loginFormAni);

        btnSignin.setOnClickListener(mClickListener);
        btnSignup.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSignup:
                    Intent intentAccount = new Intent(AccountActivity.this, SignupActivity.class);
                    startActivity(intentAccount);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnSignin:
                    if (etEmail.getText().toString().equals("")) {
                        Toast.makeText(AccountActivity.this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    inputEmail = etEmail.getText().toString();
                    if (etPw.getText().toString().equals("")) {
                        Toast.makeText(AccountActivity.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    inputPw = etPw.getText().toString();

                    // DB와 데이터 비교하는 부분
                    // 추후에 AWS와 연동 필요 !!
                    if (strEmail == null || strPw == null) {
                        Toast.makeText(AccountActivity.this, "등록된 계정이 아닙니다.", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        if (strEmail.equals(inputEmail) && strPw.equals(inputPw)) {
                            showDialog();
                            break;
                        } else {
                            Toast.makeText(AccountActivity.this, "계정 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
            }
        }
    };

    private void showDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.signin_dialog);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Button btnNo = dialog.findViewById(R.id.btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intentAccount = new Intent(AccountActivity.this, WelcomeActivity.class);
                intentAccount.putExtra("nick", strNick);
                intentAccount.putExtra("pw", strPw);
                intentAccount.putExtra("name", strName);
                intentAccount.putExtra("email", strEmail);
                startActivity(intentAccount);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        });
        dialog.show();
    }
}

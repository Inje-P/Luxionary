package com.luan.luxionary;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    // DB
    String strNick, strPw, strPwCheck, strName, strEmail;

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    LinearLayout llSignup1, llSignup2, llSignup3, llSignup4, llSignup5, llSignup6;
    Button btnNickCheck, btnSignup, btnReturn;
    EditText etNickname, etPw, etPwCheck, etPwConfirm, etName, etEmail;
    String TAG = "Sign Up";
    Animation llAni1, llAni2, llAni3, llAni4, llAni5, llAni6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        helper = new MySQLiteOpenHelper(SignupActivity.this, "member.db", null, 1);

        llSignup1 = (LinearLayout) findViewById(R.id.llSignup1);
        llSignup2 = (LinearLayout) findViewById(R.id.llSignup2);
        llSignup3 = (LinearLayout) findViewById(R.id.llSignup3);
        llSignup4 = (LinearLayout) findViewById(R.id.llSignup4);
        llSignup5 = (LinearLayout) findViewById(R.id.llSignup5);
        llSignup6 = (LinearLayout) findViewById(R.id.llSignup6);

        // 애니메이션 부분
        llAni1 = new AlphaAnimation(0, 1);
        llAni1.setDuration(500);
        llAni1.setStartOffset(500);
        llSignup1.setAnimation(llAni1);

        llAni2 = new AlphaAnimation(0, 1);
        llAni2.setDuration(500);
        llAni2.setStartOffset(700);
        llSignup2.setAnimation(llAni2);

        llAni3 = new AlphaAnimation(0, 1);
        llAni3.setDuration(500);
        llAni3.setStartOffset(900);
        llSignup3.setAnimation(llAni3);

        llAni4 = new AlphaAnimation(0, 1);
        llAni4.setDuration(500);
        llAni4.setStartOffset(1100);
        llSignup4.setAnimation(llAni4);

        llAni5 = new AlphaAnimation(0, 1);
        llAni5.setDuration(500);
        llAni5.setStartOffset(1300);
        llSignup5.setAnimation(llAni5);

        llAni6 = new AlphaAnimation(0, 1);
        llAni6.setDuration(500);
        llAni6.setStartOffset(1500);
        llSignup6.setAnimation(llAni6);

        // 닉네임
        etNickname = (EditText) findViewById(R.id.etNickname);

        // 비밀번호
        etPw = (EditText) findViewById(R.id.etPw);
        etPwCheck = (EditText) findViewById(R.id.etPwCheck);
        etPwConfirm = (EditText) findViewById(R.id.etPwConfirm);
        etPwConfirm.setText("비밀번호를 다시 한 번 입력해주세요.");

        // 비밀번호 일치 여부 구간
        etPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etPw.getText().toString().equals(etPwCheck.getText().toString())) {
                    etPwConfirm.setText("비밀번호가 확인되었습니다.");
                    etPwConfirm.setTextColor(Color.parseColor("#0078BD"));
                } else {
                    etPwConfirm.setText("비밀번호가 일치하지 않습니다.");
                    etPwConfirm.setTextColor(Color.parseColor("#C80D0D"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // 이름
        etName = (EditText) findViewById(R.id.etName);

        // 이메일
        etEmail = (EditText) findViewById(R.id.etEmail);

        btnNickCheck = (Button) findViewById(R.id.btnNickCheck);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnNickCheck.setOnClickListener(mClickListener);
        btnSignup.setOnClickListener(mClickListener);
        btnReturn.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNickCheck:
                    Toast.makeText(SignupActivity.this, "기능 제작중...", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnSignup:
                    if (etNickname.getText().toString().equals("")) {
                        Toast.makeText(SignupActivity.this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    strNick = etNickname.getText().toString();

                    // ID 중복 확인 구간

                    if (etPw.getText().toString().equals("")) {
                        Toast.makeText(SignupActivity.this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    strPw = etPw.getText().toString();
                    if (etPwCheck.getText().toString().equals("")) {
                        Toast.makeText(SignupActivity.this, "비밀번호를 한번 더 입력해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    strPwCheck = etPwCheck.getText().toString();

                    if (etName.getText().toString().equals("")) {
                        Toast.makeText(SignupActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    strName = etName.getText().toString();
                    if (etEmail.getText().toString().equals("")) {
                        Toast.makeText(SignupActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    strEmail = etEmail.getText().toString();

                    // 회원가입 다이얼로그
                    dialogSignup();
                    break;
                case R.id.btnReturn:
                    dialogReturn();
                    break;
            }
        }
    };

    public void insert(String nick, String pw, String name, String email) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nick", nick);
        values.put("pw", pw);
        values.put("name", name);
        values.put("email", email);
        db.insert("member", null, values);
        db.close();

        Toast.makeText(getApplicationContext(), "가입된 계정: " + email, Toast.LENGTH_LONG).show();
        Log.d(TAG, "Sign-Up completed: " + nick + " / " + pw + " / " + name + " / " + email);
    }

    private void dialogSignup() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.signup_dialog);
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
                // DB 삽입 구간
                insert(strNick, strPw, strName, strEmail);

                dialog.dismiss();
                Intent intentSignupOk = new Intent(SignupActivity.this, SignupOkActivity.class);
                intentSignupOk.putExtra("nick", strNick);
                intentSignupOk.putExtra("pw", strPw);
                intentSignupOk.putExtra("name", strName);
                intentSignupOk.putExtra("email", strEmail);
                startActivity(intentSignupOk);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        });
        dialog.show();
    }

    private void dialogReturn() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.cancel_dialog);
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
                Intent intentAccount = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intentAccount);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        });
        dialog.show();
    }
}

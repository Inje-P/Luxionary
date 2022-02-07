package com.luan.luxionary;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupOkActivity extends AppCompatActivity {
    String strNick, strPw, strName, strEmail;
    EditText etNickname, etPw, etName, etEmail;
    Button btnReturn;
    String TAG = "Sign Up OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupok);

        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");

        etNickname = (EditText) findViewById(R.id.etNickname);
        etPw = (EditText) findViewById(R.id.etPw);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        etNickname.setText(strNick);
        etPw.setText(strPw);
        etName.setText(strName);
        etEmail.setText(strEmail);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnReturn:
                    dialogNext();
                    break;
            }
        }
    };

    private void dialogNext() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_cancel);
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
                Intent intentSignupOk = new Intent(SignupOkActivity.this, SigninActivity.class);
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
}
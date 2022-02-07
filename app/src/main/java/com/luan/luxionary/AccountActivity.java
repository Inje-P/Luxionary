package com.luan.luxionary;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;

public class AccountActivity extends AppCompatActivity {

    // Data from DB
    String username, email, profile;

    ImageView imgProfile;
    EditText etUsername, etEmail;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Intent getData = getIntent();
        username = getData.getStringExtra("username");
        email = getData.getStringExtra("email");
        profile = getData.getStringExtra("profile");

        // Sidebar
//        tvNickname = (TextView) findViewById(R.id.tvNickname);
//        tvEmail = (TextView) findViewById(R.id.tvEmail);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerView = (View) findViewById(R.id.drawer);
//        drawerLayout.setDrawerListener(drawerListener);
//        drawerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//        btnClose = (ImageView) findViewById(R.id.btnClose);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.closeDrawers();
//            }
//        });

        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);

        // Data Setting
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        Glide.with(this).load(profile).into(imgProfile);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etUsername.setText(username);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etEmail.setText(email);

    }

//    // Sidebar
//    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
//        @Override
//        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//
//        }
//
//        @Override
//        public void onDrawerOpened(@NonNull View drawerView) {
//            if (strNick == null) {
//                tvNickname.setText("해리슨");
//            } else {
//                tvNickname.setText(strNick);
//            }
//            if (strEmail == null) {
//                tvEmail.setText("luxionary@gmail.com");
//            } else {
//                tvEmail.setText(strEmail);
//            }
//        }
//
//        @Override
//        public void onDrawerClosed(@NonNull View drawerView) {
//
//        }
//
//        @Override
//        public void onDrawerStateChanged(int newState) {
//
//        }
//    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSignup:
                    break;
                case R.id.btnSignin:
                    break;
            }
        }
    };

    private void showDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_signin);
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
                startActivity(intentAccount);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                finish();
            }
        });
        dialog.show();
    }
}

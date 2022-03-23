package com.luan.luxionary;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountActivity extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    ImageView imgProfile;
    EditText etUsername, etEmail;
    Button btnSave;
    LinearLayout layoutTop, layoutPi, layoutBtn;
    Animation aniLayoutTop, aniLayoutPi, aniLayoutBtn;
    TextView tvMyLux, tvGemEng, tvGemFra, tvGemDeu, tvGemSpa, tvGemIta, tvGemRus, tvGemTur;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;
    Button btnAccount, btnCharge, btnSupport;

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
        avatar = getData.getStringExtra("avatar");

        // Sidebar
        tvNickname = (TextView) findViewById(R.id.tvNickname);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        drawerLayout.setDrawerListener(drawerListener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        btnClose = (ImageView) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
        btnAccount = (Button) findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAccount = new Intent(AccountActivity.this, AccountActivity.class);
                intentAccount.putExtra("username", username);
                intentAccount.putExtra("email", email);
                intentAccount.putExtra("profile", profile);
                intentAccount.putExtra("avatar", avatar);
                startActivity(intentAccount);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        btnCharge = (Button) findViewById(R.id.btnCharge);
        btnCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCharge = new Intent(AccountActivity.this, ChargeActivity.class);
                intentCharge.putExtra("username", username);
                intentCharge.putExtra("email", email);
                intentCharge.putExtra("profile", profile);
                intentCharge.putExtra("avatar", avatar);
                startActivity(intentCharge);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        btnSupport = (Button) findViewById(R.id.btnSupport);
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSupport = new Intent(AccountActivity.this, SupportActivity.class);
                intentSupport.putExtra("username", username);
                intentSupport.putExtra("email", email);
                intentSupport.putExtra("profile", profile);
                intentSupport.putExtra("avatar", avatar);
                startActivity(intentSupport);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        // Layout Animation
        layoutTop = (LinearLayout) findViewById(R.id.layoutTop);
        layoutPi = (LinearLayout) findViewById(R.id.layoutPi);
        layoutBtn = (LinearLayout) findViewById(R.id.layoutBtn);
        aniLayoutTop = AnimationUtils.loadAnimation(AccountActivity.this, R.anim.descend);
        aniLayoutPi = AnimationUtils.loadAnimation(AccountActivity.this, R.anim.fadein);
        aniLayoutBtn = AnimationUtils.loadAnimation(AccountActivity.this, R.anim.fadein);
        layoutTop.startAnimation(aniLayoutTop);
        layoutPi.startAnimation(aniLayoutPi);
        layoutBtn.startAnimation(aniLayoutBtn);

        // Data Init
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        if (profile == null) {
            Glide.with(this).load(R.drawable.avt_male1).into(imgProfile);
        } else {
            Glide.with(this).load(profile).into(imgProfile);
        }
        etUsername = (EditText) findViewById(R.id.etUsername);
        if (username == null) {
            etUsername.setText("해리슨");
        } else {
            etUsername.setText(username);
        }
        etEmail = (EditText) findViewById(R.id.etEmail);
        if (email == null) {
            etEmail.setText("luxionary@gmail.com");
        } else {
            etEmail.setText(email);
        }

        /*
        * My Lux
        * */
        tvMyLux = (TextView) findViewById(R.id.tvMyLux);

        /*
         * My Gems
         * */
        tvGemEng = (TextView) findViewById(R.id.tvGemEng);
        tvGemDeu = (TextView) findViewById(R.id.tvGemDeu);
        tvGemFra = (TextView) findViewById(R.id.tvGemFra);
        tvGemSpa = (TextView) findViewById(R.id.tvGemSpa);
        tvGemIta = (TextView) findViewById(R.id.tvGemIta);
        tvGemRus = (TextView) findViewById(R.id.tvGemRus);
        tvGemTur = (TextView) findViewById(R.id.tvGemTur);

        // Buttons
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(mClickListener);

        // Footer
        btnSidebar = (ImageButton) findViewById(R.id.btnSidebar);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnUpdate = (ImageButton) findViewById(R.id.btnUpdate);
        btnSidebar.setOnClickListener(mClickListener);
        btnHome.setOnClickListener(mClickListener);
        btnUpdate.setOnClickListener(mClickListener);

    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(AccountActivity.this, MainActivity.class);
        intentBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentBack.putExtra("username", username);
        intentBack.putExtra("email", email);
        intentBack.putExtra("profile", profile);
        intentBack.putExtra("avatar", avatar);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    // Sidebar
    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            if (username == null) {
                tvNickname.setText("해리슨");
            } else {
                tvNickname.setText(username);
            }
            if (email == null) {
                tvEmail.setText("luxionary@gmail.com");
            } else {
                tvEmail.setText(email);
            }
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSave:
                    // Username Setting
                    if (etUsername.getText().toString().equals("")) {
                        Toast.makeText(AccountActivity.this, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        username = etUsername.getText().toString();
                    }

                    // Email Setting
                    if (etEmail.getText().toString().equals("")) {
                        Toast.makeText(AccountActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        email = etEmail.getText().toString();
                        Pattern pattern = Patterns.EMAIL_ADDRESS;
                        Matcher matcher = pattern.matcher(email);
                        if (matcher.find()) {
                            showDialog();
                        } else {
                            Toast.makeText(AccountActivity.this, "잘못된 이메일 형식입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                // Footer
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(AccountActivity.this, MainActivity.class);
                    intentHome.putExtra("username", username);
                    intentHome.putExtra("email", email);
                    intentHome.putExtra("profile", profile);
                    intentHome.putExtra("avatar", avatar);
                    startActivity(intentHome);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    finish();
                    break;
                case R.id.btnUpdate:
                    break;
            }
        }
    };

    private void showDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_accountsave);
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
                Toast.makeText(AccountActivity.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                // 저장할 아바타 변수 전달하기 (Intent & DB)
                Intent intentMain = new Intent(AccountActivity.this, MainActivity.class);
                intentMain.putExtra("username", username);
                intentMain.putExtra("email", email);
                intentMain.putExtra("profile", profile);
                intentMain.putExtra("avatar", avatar);
                startActivity(intentMain);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        dialog.show();
    }
}

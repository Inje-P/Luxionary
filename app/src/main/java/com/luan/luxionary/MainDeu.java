package com.luan.luxionary;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainDeu extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    ImageView imgAvatar;
    ImageButton btnDeu1, btnDeu2, btnDeu3, btnDeu4;
    TextView tvDeu1, tvDeu2, tvDeu3, tvDeu4;
    LinearLayout layoutProfile, llDeu1, llDeu2, llDeu3, llDeu4;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2, aniAvatar;
    Animation aniLayoutProfile, aniLayout1, aniLayout2, aniLayout3, aniLayout4;

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
        setContentView(R.layout.main_deu);

        // Data from SQLite
        Intent getData = getIntent();
        strNick = getData.getStringExtra("nick");
        strPw = getData.getStringExtra("pw");
        strName = getData.getStringExtra("name");
        strEmail = getData.getStringExtra("email");
        strAvatar = getData.getStringExtra("avatar");

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

        // Title
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(MainDeu.this, R.anim.fadein);
        aniLayoutProfile.setStartOffset(600);
        layoutProfile.startAnimation(aniLayoutProfile);

        // Avatar
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        if (strAvatar == null) {
            imgAvatar.setImageResource(R.drawable.avt_male1);
        } else {
            switch (strAvatar) {
                case "male1":
                    imgAvatar.setImageResource(R.drawable.avt_male1);
                    break;
                case "male2":
                    imgAvatar.setImageResource(R.drawable.avt_male2);
                    break;
                case "male3":
                    imgAvatar.setImageResource(R.drawable.avt_male3);
                    break;
                case "male4":
                    imgAvatar.setImageResource(R.drawable.avt_male4);
                    break;
                case "female1":
                    imgAvatar.setImageResource(R.drawable.avt_female1);
                    break;
                case "female2":
                    imgAvatar.setImageResource(R.drawable.avt_female2);
                    break;
                case "female3":
                    imgAvatar.setImageResource(R.drawable.avt_female3);
                    break;
                case "female4":
                    imgAvatar.setImageResource(R.drawable.avt_female4);
                    break;
            }
        }
        aniAvatar = AnimationUtils.loadAnimation(MainDeu.this, R.anim.fadein);
        aniAvatar.setStartOffset(800);
        imgAvatar.startAnimation(aniAvatar);
        imgAvatar.setOnClickListener(mClickListener);

        // Buttons
        btnDeu1 = (ImageButton) findViewById(R.id.btnDeu1);
        btnDeu2 = (ImageButton) findViewById(R.id.btnDeu2);
        btnDeu3 = (ImageButton) findViewById(R.id.btnDeu3);
        btnDeu4 = (ImageButton) findViewById(R.id.btnDeu4);
        btnDeu1.setOnClickListener(mClickListener);
        btnDeu2.setOnClickListener(mClickListener);
        btnDeu3.setOnClickListener(mClickListener);
        btnDeu4.setOnClickListener(mClickListener);
        tvDeu1 = (TextView) findViewById(R.id.tvDeu1);
        tvDeu2 = (TextView) findViewById(R.id.tvDeu2);
        tvDeu3 = (TextView) findViewById(R.id.tvDeu3);
        tvDeu4 = (TextView) findViewById(R.id.tvDeu4);

        // Layout Animation
        llDeu1 = (LinearLayout) findViewById(R.id.llDeu1);
        llDeu2 = (LinearLayout) findViewById(R.id.llDeu2);
        llDeu3 = (LinearLayout) findViewById(R.id.llDeu3);
        llDeu4 = (LinearLayout) findViewById(R.id.llDeu4);
        aniLayout1 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend_fast);
        aniLayout1.setStartOffset(200);
        aniLayout2 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend_fast);
        aniLayout2.setStartOffset(400);
        aniLayout3 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend_fast);
        aniLayout3.setStartOffset(600);
        aniLayout4 = AnimationUtils.loadAnimation(MainDeu.this, R.anim.descend_fast);
        aniLayout4.setStartOffset(800);
        llDeu1.startAnimation(aniLayout1);
        llDeu2.startAnimation(aniLayout2);
        llDeu3.startAnimation(aniLayout3);
        llDeu4.startAnimation(aniLayout4);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MainDeu.this, R.anim.scale);

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
        Intent intentBack = new Intent(MainDeu.this, MainActivity.class);
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

    // Sidebar
    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            if (strNick == null) {
                tvNickname.setText("제이슨");
            } else {
                tvNickname.setText(strNick);
            }
            if (strEmail == null) {
                tvEmail.setText("luxionary@gmail.com");
            } else {
                tvEmail.setText(strEmail);
            }
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    // Main Layout
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgAvatar:
                    imgAvatar.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu1:
                    btnDeu1.startAnimation(aniTouch);
                    pageLang101();
                    break;
                case R.id.btnDeu2:
                    btnDeu2.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu3:
                    btnDeu3.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu4:
                    btnDeu4.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MainDeu.this, MainActivity.class);
                    intentHome.putExtra("nick", strNick);
                    intentHome.putExtra("pw", strPw);
                    intentHome.putExtra("name", strName);
                    intentHome.putExtra("email", strEmail);
                    intentHome.putExtra("avatar", strAvatar);
                    startActivity(intentHome);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnUpdate:
                    break;
            }
        }
    };

    public void pageLang101() {
        Intent intentLang101 = new Intent(MainDeu.this, MonoDeu.class);
        intentLang101.putExtra("nick", strNick);
        intentLang101.putExtra("pw", strPw);
        intentLang101.putExtra("name", strName);
        intentLang101.putExtra("email", strEmail);
        intentLang101.putExtra("avatar", strAvatar);
        startActivity(intentLang101);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

}
package com.luan.luxionary;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MonoIta extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btnIta1, btnIta2, btnIta3, btnIta4, btnIta5, btnIta6, btnIta7, btnIta8;
    Button btnIta9, btnIta10, btnIta11, btnIta12, btnIta13, btnIta14, btnIta15;
    LinearLayout layoutProfile, llBanner;
    LinearLayout llIta1, llIta2, llIta3, llIta4, llIta5, llIta6, llIta7, llIta8;
    LinearLayout llIta9, llIta10, llIta11, llIta12, llIta13, llIta14, llIta15;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile, aniLlBanner;
    Animation aniLl1, aniLl2, aniLl3, aniLl4, aniLl5, aniLl6, aniLl7, aniLl8;
    Animation aniLl9, aniLl10, aniLl11, aniLl12, aniLl13, aniLl14, aniLl15;

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
        setContentView(R.layout.mono_ita);

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
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLayoutProfile.setStartOffset(600);
        layoutProfile.startAnimation(aniLayoutProfile);
        llBanner = (LinearLayout) findViewById(R.id.llBanner);
        aniLlBanner = AnimationUtils.loadAnimation(MonoIta.this, R.anim.ascend_fast);
        llBanner.startAnimation(aniLlBanner);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MonoIta.this, R.anim.scale);

        // Buttons & TextViews
        btnIta1 = (Button) findViewById(R.id.btnIta1);
        btnIta2 = (Button) findViewById(R.id.btnIta2);
        btnIta3 = (Button) findViewById(R.id.btnIta3);
        btnIta4 = (Button) findViewById(R.id.btnIta4);
        btnIta5 = (Button) findViewById(R.id.btnIta5);
        btnIta6 = (Button) findViewById(R.id.btnIta6);
        btnIta7 = (Button) findViewById(R.id.btnIta7);
        btnIta8 = (Button) findViewById(R.id.btnIta8);
        btnIta9 = (Button) findViewById(R.id.btnIta9);
        btnIta10 = (Button) findViewById(R.id.btnIta10);
        btnIta11 = (Button) findViewById(R.id.btnIta11);
        btnIta12 = (Button) findViewById(R.id.btnIta12);
        btnIta13 = (Button) findViewById(R.id.btnIta13);
        btnIta14 = (Button) findViewById(R.id.btnIta14);
        btnIta15 = (Button) findViewById(R.id.btnIta15);
        btnIta1.setOnClickListener(mClickListener);
        btnIta2.setOnClickListener(mClickListener);
        btnIta3.setOnClickListener(mClickListener);
        btnIta4.setOnClickListener(mClickListener);
        btnIta5.setOnClickListener(mClickListener);
        btnIta6.setOnClickListener(mClickListener);
        btnIta7.setOnClickListener(mClickListener);
        btnIta8.setOnClickListener(mClickListener);
        btnIta9.setOnClickListener(mClickListener);
        btnIta10.setOnClickListener(mClickListener);
        btnIta11.setOnClickListener(mClickListener);
        btnIta12.setOnClickListener(mClickListener);
        btnIta13.setOnClickListener(mClickListener);
        btnIta14.setOnClickListener(mClickListener);
        btnIta15.setOnClickListener(mClickListener);
        setColorStateList(btnIta1, ContextCompat.getColor(this, R.color.ita_dark), btnIta1.getCurrentTextColor());
        setColorStateList(btnIta2, ContextCompat.getColor(this, R.color.ita_dark), btnIta2.getCurrentTextColor());
        setColorStateList(btnIta3, ContextCompat.getColor(this, R.color.ita_dark), btnIta3.getCurrentTextColor());
        setColorStateList(btnIta4, ContextCompat.getColor(this, R.color.ita_dark), btnIta4.getCurrentTextColor());
        setColorStateList(btnIta5, ContextCompat.getColor(this, R.color.ita_dark), btnIta5.getCurrentTextColor());
        setColorStateList(btnIta6, ContextCompat.getColor(this, R.color.ita_dark), btnIta6.getCurrentTextColor());
        setColorStateList(btnIta7, ContextCompat.getColor(this, R.color.ita_dark), btnIta7.getCurrentTextColor());
        setColorStateList(btnIta8, ContextCompat.getColor(this, R.color.ita_dark), btnIta8.getCurrentTextColor());
        setColorStateList(btnIta9, ContextCompat.getColor(this, R.color.ita_dark), btnIta9.getCurrentTextColor());
        setColorStateList(btnIta10, ContextCompat.getColor(this, R.color.ita_dark), btnIta10.getCurrentTextColor());
        setColorStateList(btnIta11, ContextCompat.getColor(this, R.color.ita_dark), btnIta11.getCurrentTextColor());
        setColorStateList(btnIta12, ContextCompat.getColor(this, R.color.ita_dark), btnIta12.getCurrentTextColor());
        setColorStateList(btnIta13, ContextCompat.getColor(this, R.color.ita_dark), btnIta13.getCurrentTextColor());
        setColorStateList(btnIta14, ContextCompat.getColor(this, R.color.ita_dark), btnIta14.getCurrentTextColor());
        setColorStateList(btnIta15, ContextCompat.getColor(this, R.color.ita_dark), btnIta15.getCurrentTextColor());

        // Animation
        llIta1 = (LinearLayout) findViewById(R.id.llIta1);
        llIta2 = (LinearLayout) findViewById(R.id.llIta2);
        llIta3 = (LinearLayout) findViewById(R.id.llIta3);
        llIta4 = (LinearLayout) findViewById(R.id.llIta4);
        llIta5 = (LinearLayout) findViewById(R.id.llIta5);
        llIta6 = (LinearLayout) findViewById(R.id.llIta6);
        llIta7 = (LinearLayout) findViewById(R.id.llIta7);
        llIta8 = (LinearLayout) findViewById(R.id.llIta8);
        llIta9 = (LinearLayout) findViewById(R.id.llIta9);
        llIta10 = (LinearLayout) findViewById(R.id.llIta10);
        llIta11 = (LinearLayout) findViewById(R.id.llIta11);
        llIta12 = (LinearLayout) findViewById(R.id.llIta12);
        llIta13 = (LinearLayout) findViewById(R.id.llIta13);
        llIta14 = (LinearLayout) findViewById(R.id.llIta14);
        llIta15 = (LinearLayout) findViewById(R.id.llIta15);
        aniLl1 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(MonoIta.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        llIta1.startAnimation(aniLl1);
        llIta2.startAnimation(aniLl2);
        llIta3.startAnimation(aniLl3);
        llIta4.startAnimation(aniLl4);
        llIta5.startAnimation(aniLl5);
        llIta6.startAnimation(aniLl6);
        llIta7.startAnimation(aniLl7);
        llIta8.startAnimation(aniLl7);
        llIta9.startAnimation(aniLl7);
        llIta10.startAnimation(aniLl7);
        llIta11.startAnimation(aniLl7);
        llIta12.startAnimation(aniLl7);
        llIta13.startAnimation(aniLl7);
        llIta14.startAnimation(aniLl7);
        llIta15.startAnimation(aniLl7);

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
        Intent intentBack = new Intent(MonoIta.this, MainIta.class);
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
                case R.id.btnIta1:
                    btnIta1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnIta2:
                    btnIta2.startAnimation(aniTouch);
                    break;
                case R.id.btnIta3:
                    btnIta3.startAnimation(aniTouch);
                    break;
                case R.id.btnIta4:
                    btnIta4.startAnimation(aniTouch);
                    break;
                case R.id.btnIta5:
                    btnIta5.startAnimation(aniTouch);
                    break;
                case R.id.btnIta6:
                    btnIta6.startAnimation(aniTouch);
                    break;
                case R.id.btnIta7:
                    btnIta7.startAnimation(aniTouch);
                    break;
                case R.id.btnIta8:
                    btnIta8.startAnimation(aniTouch);
                    break;
                case R.id.btnIta9:
                    btnIta9.startAnimation(aniTouch);
                    break;
                case R.id.btnIta10:
                    btnIta10.startAnimation(aniTouch);
                    break;
                case R.id.btnIta11:
                    btnIta11.startAnimation(aniTouch);
                    break;
                case R.id.btnIta12:
                    btnIta12.startAnimation(aniTouch);
                    break;
                case R.id.btnIta13:
                    btnIta13.startAnimation(aniTouch);
                    break;
                case R.id.btnIta14:
                    btnIta14.startAnimation(aniTouch);
                    break;
                case R.id.btnIta15:
                    btnIta15.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MonoIta.this, MainActivity.class);
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

    public void page01() {
        Intent intent01 = new Intent(MonoIta.this, MonoIta_01_0.class);
        intent01.putExtra("nick", strNick);
        intent01.putExtra("pw", strPw);
        intent01.putExtra("name", strName);
        intent01.putExtra("email", strEmail);
        intent01.putExtra("avatar", strAvatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void setColorStateList(View view, int selectedColor, int defaultColor) {
        int[][] states = new int[][] {
                new int[] {
                        android.R.attr.state_pressed,
                        android.R.attr.state_selected
                }, // pressed, selected, focused
                new int[] {} // default
        };

        int[] colors = new int[] {
                selectedColor,
                defaultColor
        };

        ColorStateList textColorList = new ColorStateList(states, colors);
        if (view instanceof TextView || view instanceof AppCompatTextView) { // TextView
            ((TextView)view).setTextColor(textColorList);
            view.setClickable(true);
        } else if (view instanceof Button || view instanceof AppCompatButton) { // Button
            ((Button)view).setTextColor(textColorList);
        }
        view.setSelected(true);
    }

}
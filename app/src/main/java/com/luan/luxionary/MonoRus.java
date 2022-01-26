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

public class MonoRus extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btnRus1, btnRus2, btnRus3, btnRus4, btnRus5, btnRus6, btnRus7, btnRus8;
    Button btnRus9, btnRus10, btnRus11, btnRus12, btnRus13, btnRus14, btnRus15;
    LinearLayout layoutProfile;
    LinearLayout llRus1, llRus2, llRus3, llRus4, llRus5, llRus6, llRus7, llRus8;
    LinearLayout llRus9, llRus10, llRus11, llRus12, llRus13, llRus14, llRus15;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
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
        setContentView(R.layout.mono_rus);

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
        aniTitle1 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLayoutProfile.setStartOffset(600);
        layoutProfile.startAnimation(aniLayoutProfile);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MonoRus.this, R.anim.scale);

        // Buttons & TextViews
        btnRus1 = (Button) findViewById(R.id.btnRus1);
        btnRus2 = (Button) findViewById(R.id.btnRus2);
        btnRus3 = (Button) findViewById(R.id.btnRus3);
        btnRus4 = (Button) findViewById(R.id.btnRus4);
        btnRus5 = (Button) findViewById(R.id.btnRus5);
        btnRus6 = (Button) findViewById(R.id.btnRus6);
        btnRus7 = (Button) findViewById(R.id.btnRus7);
        btnRus8 = (Button) findViewById(R.id.btnRus8);
        btnRus9 = (Button) findViewById(R.id.btnRus9);
        btnRus10 = (Button) findViewById(R.id.btnRus10);
        btnRus11 = (Button) findViewById(R.id.btnRus11);
        btnRus12 = (Button) findViewById(R.id.btnRus12);
        btnRus13 = (Button) findViewById(R.id.btnRus13);
        btnRus14 = (Button) findViewById(R.id.btnRus14);
        btnRus15 = (Button) findViewById(R.id.btnRus15);
        btnRus1.setOnClickListener(mClickListener);
        btnRus2.setOnClickListener(mClickListener);
        btnRus3.setOnClickListener(mClickListener);
        btnRus4.setOnClickListener(mClickListener);
        btnRus5.setOnClickListener(mClickListener);
        btnRus6.setOnClickListener(mClickListener);
        btnRus7.setOnClickListener(mClickListener);
        btnRus8.setOnClickListener(mClickListener);
        btnRus9.setOnClickListener(mClickListener);
        btnRus10.setOnClickListener(mClickListener);
        btnRus11.setOnClickListener(mClickListener);
        btnRus12.setOnClickListener(mClickListener);
        btnRus13.setOnClickListener(mClickListener);
        btnRus14.setOnClickListener(mClickListener);
        btnRus15.setOnClickListener(mClickListener);
        setColorStateList(btnRus1, ContextCompat.getColor(this, R.color.rus_dark), btnRus1.getCurrentTextColor());
        setColorStateList(btnRus2, ContextCompat.getColor(this, R.color.rus_dark), btnRus2.getCurrentTextColor());
        setColorStateList(btnRus3, ContextCompat.getColor(this, R.color.rus_dark), btnRus3.getCurrentTextColor());
        setColorStateList(btnRus4, ContextCompat.getColor(this, R.color.rus_dark), btnRus4.getCurrentTextColor());
        setColorStateList(btnRus5, ContextCompat.getColor(this, R.color.rus_dark), btnRus5.getCurrentTextColor());
        setColorStateList(btnRus6, ContextCompat.getColor(this, R.color.rus_dark), btnRus6.getCurrentTextColor());
        setColorStateList(btnRus7, ContextCompat.getColor(this, R.color.rus_dark), btnRus7.getCurrentTextColor());
        setColorStateList(btnRus8, ContextCompat.getColor(this, R.color.rus_dark), btnRus8.getCurrentTextColor());
        setColorStateList(btnRus9, ContextCompat.getColor(this, R.color.rus_dark), btnRus9.getCurrentTextColor());
        setColorStateList(btnRus10, ContextCompat.getColor(this, R.color.rus_dark), btnRus10.getCurrentTextColor());
        setColorStateList(btnRus11, ContextCompat.getColor(this, R.color.rus_dark), btnRus11.getCurrentTextColor());
        setColorStateList(btnRus12, ContextCompat.getColor(this, R.color.rus_dark), btnRus12.getCurrentTextColor());
        setColorStateList(btnRus13, ContextCompat.getColor(this, R.color.rus_dark), btnRus13.getCurrentTextColor());
        setColorStateList(btnRus14, ContextCompat.getColor(this, R.color.rus_dark), btnRus14.getCurrentTextColor());
        setColorStateList(btnRus15, ContextCompat.getColor(this, R.color.rus_dark), btnRus15.getCurrentTextColor());

        // Animation
        llRus1 = (LinearLayout) findViewById(R.id.llRus1);
        llRus2 = (LinearLayout) findViewById(R.id.llRus2);
        llRus3 = (LinearLayout) findViewById(R.id.llRus3);
        llRus4 = (LinearLayout) findViewById(R.id.llRus4);
        llRus5 = (LinearLayout) findViewById(R.id.llRus5);
        llRus6 = (LinearLayout) findViewById(R.id.llRus6);
        llRus7 = (LinearLayout) findViewById(R.id.llRus7);
        llRus8 = (LinearLayout) findViewById(R.id.llRus8);
        llRus9 = (LinearLayout) findViewById(R.id.llRus9);
        llRus10 = (LinearLayout) findViewById(R.id.llRus10);
        llRus11 = (LinearLayout) findViewById(R.id.llRus11);
        llRus12 = (LinearLayout) findViewById(R.id.llRus12);
        llRus13 = (LinearLayout) findViewById(R.id.llRus13);
        llRus14 = (LinearLayout) findViewById(R.id.llRus14);
        llRus15 = (LinearLayout) findViewById(R.id.llRus15);
        aniLl1 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(MonoRus.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        llRus1.startAnimation(aniLl1);
        llRus2.startAnimation(aniLl2);
        llRus3.startAnimation(aniLl3);
        llRus4.startAnimation(aniLl4);
        llRus5.startAnimation(aniLl5);
        llRus6.startAnimation(aniLl6);
        llRus7.startAnimation(aniLl7);
        llRus8.startAnimation(aniLl7);
        llRus9.startAnimation(aniLl7);
        llRus10.startAnimation(aniLl7);
        llRus11.startAnimation(aniLl7);
        llRus12.startAnimation(aniLl7);
        llRus13.startAnimation(aniLl7);
        llRus14.startAnimation(aniLl7);
        llRus15.startAnimation(aniLl7);

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
        Intent intentBack = new Intent(MonoRus.this, MainRus.class);
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
                case R.id.btnRus1:
                    btnRus1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnRus2:
                    btnRus2.startAnimation(aniTouch);
                    break;
                case R.id.btnRus3:
                    btnRus3.startAnimation(aniTouch);
                    break;
                case R.id.btnRus4:
                    btnRus4.startAnimation(aniTouch);
                    break;
                case R.id.btnRus5:
                    btnRus5.startAnimation(aniTouch);
                    break;
                case R.id.btnRus6:
                    btnRus6.startAnimation(aniTouch);
                    break;
                case R.id.btnRus7:
                    btnRus7.startAnimation(aniTouch);
                    break;
                case R.id.btnRus8:
                    btnRus8.startAnimation(aniTouch);
                    break;
                case R.id.btnRus9:
                    btnRus9.startAnimation(aniTouch);
                    break;
                case R.id.btnRus10:
                    btnRus10.startAnimation(aniTouch);
                    break;
                case R.id.btnRus11:
                    btnRus11.startAnimation(aniTouch);
                    break;
                case R.id.btnRus12:
                    btnRus12.startAnimation(aniTouch);
                    break;
                case R.id.btnRus13:
                    btnRus13.startAnimation(aniTouch);
                    break;
                case R.id.btnRus14:
                    btnRus14.startAnimation(aniTouch);
                    break;
                case R.id.btnRus15:
                    btnRus15.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MonoRus.this, MainActivity.class);
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
        Intent intent01 = new Intent(MonoRus.this, MonoRus_01_0.class);
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
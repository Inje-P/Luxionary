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

public class Lang101Spa extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btnSpa1, btnSpa2, btnSpa3, btnSpa4, btnSpa5, btnSpa6, btnSpa7, btnSpa8;
    Button btnSpa9, btnSpa10, btnSpa11, btnSpa12, btnSpa13, btnSpa14, btnSpa15, btnSpa16;
    LinearLayout layoutProfile;
    LinearLayout llSpa1, llSpa2, llSpa3, llSpa4, llSpa5, llSpa6, llSpa7, llSpa8;
    LinearLayout llSpa9, llSpa10, llSpa11, llSpa12, llSpa13, llSpa14, llSpa15, llSpa16;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
    Animation aniLl1, aniLl2, aniLl3, aniLl4, aniLl5, aniLl6, aniLl7, aniLl8;
    Animation aniLl9, aniLl10, aniLl11, aniLl12, aniLl13, aniLl14, aniLl15, aniLl16;

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
        setContentView(R.layout.lang101_spa);

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
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.scale);

        // Buttons & TextViews
        btnSpa1 = (Button) findViewById(R.id.btnSpa1);
        btnSpa2 = (Button) findViewById(R.id.btnSpa2);
        btnSpa3 = (Button) findViewById(R.id.btnSpa3);
        btnSpa4 = (Button) findViewById(R.id.btnSpa4);
        btnSpa5 = (Button) findViewById(R.id.btnSpa5);
        btnSpa6 = (Button) findViewById(R.id.btnSpa6);
        btnSpa7 = (Button) findViewById(R.id.btnSpa7);
        btnSpa8 = (Button) findViewById(R.id.btnSpa8);
        btnSpa9 = (Button) findViewById(R.id.btnSpa9);
        btnSpa10 = (Button) findViewById(R.id.btnSpa10);
        btnSpa11 = (Button) findViewById(R.id.btnSpa11);
        btnSpa12 = (Button) findViewById(R.id.btnSpa12);
        btnSpa13 = (Button) findViewById(R.id.btnSpa13);
        btnSpa14 = (Button) findViewById(R.id.btnSpa14);
        btnSpa15 = (Button) findViewById(R.id.btnSpa15);
        btnSpa16 = (Button) findViewById(R.id.btnSpa16);
        btnSpa1.setOnClickListener(mClickListener);
        btnSpa2.setOnClickListener(mClickListener);
        btnSpa3.setOnClickListener(mClickListener);
        btnSpa4.setOnClickListener(mClickListener);
        btnSpa5.setOnClickListener(mClickListener);
        btnSpa6.setOnClickListener(mClickListener);
        btnSpa7.setOnClickListener(mClickListener);
        btnSpa8.setOnClickListener(mClickListener);
        btnSpa9.setOnClickListener(mClickListener);
        btnSpa10.setOnClickListener(mClickListener);
        btnSpa11.setOnClickListener(mClickListener);
        btnSpa12.setOnClickListener(mClickListener);
        btnSpa13.setOnClickListener(mClickListener);
        btnSpa14.setOnClickListener(mClickListener);
        btnSpa15.setOnClickListener(mClickListener);
        btnSpa16.setOnClickListener(mClickListener);
        setColorStateList(btnSpa2, ContextCompat.getColor(this, R.color.spa_dark), btnSpa2.getCurrentTextColor());
        setColorStateList(btnSpa3, ContextCompat.getColor(this, R.color.spa_dark), btnSpa3.getCurrentTextColor());
        setColorStateList(btnSpa4, ContextCompat.getColor(this, R.color.spa_dark), btnSpa4.getCurrentTextColor());
        setColorStateList(btnSpa5, ContextCompat.getColor(this, R.color.spa_dark), btnSpa5.getCurrentTextColor());
        setColorStateList(btnSpa6, ContextCompat.getColor(this, R.color.spa_dark), btnSpa6.getCurrentTextColor());
        setColorStateList(btnSpa7, ContextCompat.getColor(this, R.color.spa_dark), btnSpa7.getCurrentTextColor());
        setColorStateList(btnSpa8, ContextCompat.getColor(this, R.color.spa_dark), btnSpa8.getCurrentTextColor());
        setColorStateList(btnSpa9, ContextCompat.getColor(this, R.color.spa_dark), btnSpa9.getCurrentTextColor());
        setColorStateList(btnSpa10, ContextCompat.getColor(this, R.color.spa_dark), btnSpa10.getCurrentTextColor());
        setColorStateList(btnSpa11, ContextCompat.getColor(this, R.color.spa_dark), btnSpa11.getCurrentTextColor());
        setColorStateList(btnSpa12, ContextCompat.getColor(this, R.color.spa_dark), btnSpa12.getCurrentTextColor());
        setColorStateList(btnSpa13, ContextCompat.getColor(this, R.color.spa_dark), btnSpa13.getCurrentTextColor());
        setColorStateList(btnSpa14, ContextCompat.getColor(this, R.color.spa_dark), btnSpa14.getCurrentTextColor());
        setColorStateList(btnSpa15, ContextCompat.getColor(this, R.color.spa_dark), btnSpa15.getCurrentTextColor());

        // Animation
        llSpa1 = (LinearLayout) findViewById(R.id.llSpa1);
        llSpa2 = (LinearLayout) findViewById(R.id.llSpa2);
        llSpa3 = (LinearLayout) findViewById(R.id.llSpa3);
        llSpa4 = (LinearLayout) findViewById(R.id.llSpa4);
        llSpa5 = (LinearLayout) findViewById(R.id.llSpa5);
        llSpa6 = (LinearLayout) findViewById(R.id.llSpa6);
        llSpa7 = (LinearLayout) findViewById(R.id.llSpa7);
        llSpa8 = (LinearLayout) findViewById(R.id.llSpa8);
        llSpa9 = (LinearLayout) findViewById(R.id.llSpa9);
        llSpa10 = (LinearLayout) findViewById(R.id.llSpa10);
        llSpa11 = (LinearLayout) findViewById(R.id.llSpa11);
        llSpa12 = (LinearLayout) findViewById(R.id.llSpa12);
        llSpa13 = (LinearLayout) findViewById(R.id.llSpa13);
        llSpa14 = (LinearLayout) findViewById(R.id.llSpa14);
        llSpa15 = (LinearLayout) findViewById(R.id.llSpa15);
        llSpa16 = (LinearLayout) findViewById(R.id.llSpa16);
        aniLl1 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        aniLl16 = AnimationUtils.loadAnimation(Lang101Spa.this, R.anim.fadein);
        aniLl16.setStartOffset(2300);
        llSpa1.startAnimation(aniLl1);
        llSpa2.startAnimation(aniLl2);
        llSpa3.startAnimation(aniLl3);
        llSpa4.startAnimation(aniLl4);
        llSpa5.startAnimation(aniLl5);
        llSpa6.startAnimation(aniLl6);
        llSpa7.startAnimation(aniLl7);
        llSpa8.startAnimation(aniLl8);
        llSpa9.startAnimation(aniLl9);
        llSpa10.startAnimation(aniLl10);
        llSpa11.startAnimation(aniLl11);
        llSpa12.startAnimation(aniLl12);
        llSpa13.startAnimation(aniLl13);
        llSpa14.startAnimation(aniLl14);
        llSpa15.startAnimation(aniLl15);
        llSpa16.startAnimation(aniLl16);

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
        Intent intentBack = new Intent(Lang101Spa.this, MainSpa.class);
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
                case R.id.btnSpa1:
                    btnSpa1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnSpa2:
                    btnSpa2.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa3:
                    btnSpa3.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa4:
                    btnSpa4.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa5:
                    btnSpa5.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa6:
                    btnSpa6.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa7:
                    btnSpa7.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa8:
                    btnSpa8.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa9:
                    btnSpa9.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa10:
                    btnSpa10.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa11:
                    btnSpa11.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa12:
                    btnSpa12.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa13:
                    btnSpa13.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa14:
                    btnSpa14.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa15:
                    btnSpa15.startAnimation(aniTouch);
                    break;
                case R.id.btnSpa16:
                    btnSpa16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Spa.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Spa.this, Lang101Spa_01_1.class);
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
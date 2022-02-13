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

public class Lang101Deu extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btnDeu1, btnDeu2, btnDeu3, btnDeu4, btnDeu5, btnDeu6, btnDeu7, btnDeu8;
    Button btnDeu9, btnDeu10, btnDeu11, btnDeu12, btnDeu13, btnDeu14, btnDeu15, btnDeu16;
    LinearLayout layoutProfile;
    LinearLayout llDeu1, llDeu2, llDeu3, llDeu4, llDeu5, llDeu6, llDeu7, llDeu8;
    LinearLayout llDeu9, llDeu10, llDeu11, llDeu12, llDeu13, llDeu14, llDeu15, llDeu16;

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
        setContentView(R.layout.lang101_deu);

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
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.scale);

        // Buttons & TextViews
        btnDeu1 = (Button) findViewById(R.id.btnDeu1);
        btnDeu2 = (Button) findViewById(R.id.btnDeu2);
        btnDeu3 = (Button) findViewById(R.id.btnDeu3);
        btnDeu4 = (Button) findViewById(R.id.btnDeu4);
        btnDeu5 = (Button) findViewById(R.id.btnDeu5);
        btnDeu6 = (Button) findViewById(R.id.btnDeu6);
        btnDeu7 = (Button) findViewById(R.id.btnDeu7);
        btnDeu8 = (Button) findViewById(R.id.btnDeu8);
        btnDeu9 = (Button) findViewById(R.id.btnDeu9);
        btnDeu10 = (Button) findViewById(R.id.btnDeu10);
        btnDeu11 = (Button) findViewById(R.id.btnDeu11);
        btnDeu12 = (Button) findViewById(R.id.btnDeu12);
        btnDeu13 = (Button) findViewById(R.id.btnDeu13);
        btnDeu14 = (Button) findViewById(R.id.btnDeu14);
        btnDeu15 = (Button) findViewById(R.id.btnDeu15);
        btnDeu16 = (Button) findViewById(R.id.btnDeu16);
        btnDeu1.setOnClickListener(mClickListener);
        btnDeu2.setOnClickListener(mClickListener);
        btnDeu3.setOnClickListener(mClickListener);
        btnDeu4.setOnClickListener(mClickListener);
        btnDeu5.setOnClickListener(mClickListener);
        btnDeu6.setOnClickListener(mClickListener);
        btnDeu7.setOnClickListener(mClickListener);
        btnDeu8.setOnClickListener(mClickListener);
        btnDeu9.setOnClickListener(mClickListener);
        btnDeu10.setOnClickListener(mClickListener);
        btnDeu11.setOnClickListener(mClickListener);
        btnDeu12.setOnClickListener(mClickListener);
        btnDeu13.setOnClickListener(mClickListener);
        btnDeu14.setOnClickListener(mClickListener);
        btnDeu15.setOnClickListener(mClickListener);
        btnDeu16.setOnClickListener(mClickListener);
        setColorStateList(btnDeu2, ContextCompat.getColor(this, R.color.deu_dark), btnDeu2.getCurrentTextColor());
        setColorStateList(btnDeu3, ContextCompat.getColor(this, R.color.deu_dark), btnDeu3.getCurrentTextColor());
        setColorStateList(btnDeu4, ContextCompat.getColor(this, R.color.deu_dark), btnDeu4.getCurrentTextColor());
        setColorStateList(btnDeu5, ContextCompat.getColor(this, R.color.deu_dark), btnDeu5.getCurrentTextColor());
        setColorStateList(btnDeu6, ContextCompat.getColor(this, R.color.deu_dark), btnDeu6.getCurrentTextColor());
        setColorStateList(btnDeu7, ContextCompat.getColor(this, R.color.deu_dark), btnDeu7.getCurrentTextColor());
        setColorStateList(btnDeu8, ContextCompat.getColor(this, R.color.deu_dark), btnDeu8.getCurrentTextColor());
        setColorStateList(btnDeu9, ContextCompat.getColor(this, R.color.deu_dark), btnDeu9.getCurrentTextColor());
        setColorStateList(btnDeu10, ContextCompat.getColor(this, R.color.deu_dark), btnDeu10.getCurrentTextColor());
        setColorStateList(btnDeu11, ContextCompat.getColor(this, R.color.deu_dark), btnDeu11.getCurrentTextColor());
        setColorStateList(btnDeu12, ContextCompat.getColor(this, R.color.deu_dark), btnDeu12.getCurrentTextColor());
        setColorStateList(btnDeu13, ContextCompat.getColor(this, R.color.deu_dark), btnDeu13.getCurrentTextColor());
        setColorStateList(btnDeu14, ContextCompat.getColor(this, R.color.deu_dark), btnDeu14.getCurrentTextColor());
        setColorStateList(btnDeu15, ContextCompat.getColor(this, R.color.deu_dark), btnDeu15.getCurrentTextColor());

        // Animation
        llDeu1 = (LinearLayout) findViewById(R.id.llDeu1);
        llDeu2 = (LinearLayout) findViewById(R.id.llDeu2);
        llDeu3 = (LinearLayout) findViewById(R.id.llDeu3);
        llDeu4 = (LinearLayout) findViewById(R.id.llDeu4);
        llDeu5 = (LinearLayout) findViewById(R.id.llDeu5);
        llDeu6 = (LinearLayout) findViewById(R.id.llDeu6);
        llDeu7 = (LinearLayout) findViewById(R.id.llDeu7);
        llDeu8 = (LinearLayout) findViewById(R.id.llDeu8);
        llDeu9 = (LinearLayout) findViewById(R.id.llDeu9);
        llDeu10 = (LinearLayout) findViewById(R.id.llDeu10);
        llDeu11 = (LinearLayout) findViewById(R.id.llDeu11);
        llDeu12 = (LinearLayout) findViewById(R.id.llDeu12);
        llDeu13 = (LinearLayout) findViewById(R.id.llDeu13);
        llDeu14 = (LinearLayout) findViewById(R.id.llDeu14);
        llDeu15 = (LinearLayout) findViewById(R.id.llDeu15);
        llDeu16 = (LinearLayout) findViewById(R.id.llDeu16);
        aniLl1 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        aniLl16 = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLl16.setStartOffset(2300);
        llDeu1.startAnimation(aniLl1);
        llDeu2.startAnimation(aniLl2);
        llDeu3.startAnimation(aniLl3);
        llDeu4.startAnimation(aniLl4);
        llDeu5.startAnimation(aniLl5);
        llDeu6.startAnimation(aniLl6);
        llDeu7.startAnimation(aniLl7);
        llDeu8.startAnimation(aniLl8);
        llDeu9.startAnimation(aniLl9);
        llDeu10.startAnimation(aniLl10);
        llDeu11.startAnimation(aniLl11);
        llDeu12.startAnimation(aniLl12);
        llDeu13.startAnimation(aniLl13);
        llDeu14.startAnimation(aniLl14);
        llDeu15.startAnimation(aniLl15);
        llDeu16.startAnimation(aniLl16);

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
        Intent intentBack = new Intent(Lang101Deu.this, MainDeu.class);
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
                case R.id.btnDeu1:
                    btnDeu1.startAnimation(aniTouch);
                    page01();
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
                case R.id.btnDeu5:
                    btnDeu5.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu6:
                    btnDeu6.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu7:
                    btnDeu7.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu8:
                    btnDeu8.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu9:
                    btnDeu9.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu10:
                    btnDeu10.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu11:
                    btnDeu11.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu12:
                    btnDeu12.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu13:
                    btnDeu13.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu14:
                    btnDeu14.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu15:
                    btnDeu15.startAnimation(aniTouch);
                    break;
                case R.id.btnDeu16:
                    btnDeu16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Deu.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Deu.this, Lang101Deu_01_1.class);
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
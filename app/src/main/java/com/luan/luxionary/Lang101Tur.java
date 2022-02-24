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

public class Lang101Tur extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnTur1, btnTur2, btnTur3, btnTur4, btnTur5, btnTur6, btnTur7, btnTur8;
    Button btnTur9, btnTur10, btnTur11, btnTur12, btnTur13, btnTur14, btnTur15, btnTur16;
    LinearLayout layoutProfile;
    LinearLayout layoutMain;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
    Animation aniLayoutMain;

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
        setContentView(R.layout.lang101_tur);

        // Data from Firebase
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
                Intent intentAccount = new Intent(Lang101Tur.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Tur.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Tur.this, SupportActivity.class);
                intentSupport.putExtra("username", username);
                intentSupport.putExtra("email", email);
                intentSupport.putExtra("profile", profile);
                intentSupport.putExtra("avatar", avatar);
                startActivity(intentSupport);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        // Title
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Tur.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Tur.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Tur.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Tur.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Tur.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

        // Buttons & TextViews
        btnTur1 = (Button) findViewById(R.id.btnTur1);
        btnTur2 = (Button) findViewById(R.id.btnTur2);
        btnTur3 = (Button) findViewById(R.id.btnTur3);
        btnTur4 = (Button) findViewById(R.id.btnTur4);
        btnTur5 = (Button) findViewById(R.id.btnTur5);
        btnTur6 = (Button) findViewById(R.id.btnTur6);
        btnTur7 = (Button) findViewById(R.id.btnTur7);
        btnTur8 = (Button) findViewById(R.id.btnTur8);
        btnTur9 = (Button) findViewById(R.id.btnTur9);
        btnTur10 = (Button) findViewById(R.id.btnTur10);
        btnTur11 = (Button) findViewById(R.id.btnTur11);
        btnTur12 = (Button) findViewById(R.id.btnTur12);
        btnTur13 = (Button) findViewById(R.id.btnTur13);
        btnTur14 = (Button) findViewById(R.id.btnTur14);
        btnTur15 = (Button) findViewById(R.id.btnTur15);
        btnTur16 = (Button) findViewById(R.id.btnTur16);
        btnTur1.setOnClickListener(mClickListener);
        btnTur2.setOnClickListener(mClickListener);
        btnTur3.setOnClickListener(mClickListener);
        btnTur4.setOnClickListener(mClickListener);
        btnTur5.setOnClickListener(mClickListener);
        btnTur6.setOnClickListener(mClickListener);
        btnTur7.setOnClickListener(mClickListener);
        btnTur8.setOnClickListener(mClickListener);
        btnTur9.setOnClickListener(mClickListener);
        btnTur10.setOnClickListener(mClickListener);
        btnTur11.setOnClickListener(mClickListener);
        btnTur12.setOnClickListener(mClickListener);
        btnTur13.setOnClickListener(mClickListener);
        btnTur14.setOnClickListener(mClickListener);
        btnTur15.setOnClickListener(mClickListener);
        btnTur16.setOnClickListener(mClickListener);
        setColorStateList(btnTur2, ContextCompat.getColor(this, R.color.tur_dark), btnTur2.getCurrentTextColor());
        setColorStateList(btnTur3, ContextCompat.getColor(this, R.color.tur_dark), btnTur3.getCurrentTextColor());
        setColorStateList(btnTur4, ContextCompat.getColor(this, R.color.tur_dark), btnTur4.getCurrentTextColor());
        setColorStateList(btnTur5, ContextCompat.getColor(this, R.color.tur_dark), btnTur5.getCurrentTextColor());
        setColorStateList(btnTur6, ContextCompat.getColor(this, R.color.tur_dark), btnTur6.getCurrentTextColor());
        setColorStateList(btnTur7, ContextCompat.getColor(this, R.color.tur_dark), btnTur7.getCurrentTextColor());
        setColorStateList(btnTur8, ContextCompat.getColor(this, R.color.tur_dark), btnTur8.getCurrentTextColor());
        setColorStateList(btnTur9, ContextCompat.getColor(this, R.color.tur_dark), btnTur9.getCurrentTextColor());
        setColorStateList(btnTur10, ContextCompat.getColor(this, R.color.tur_dark), btnTur10.getCurrentTextColor());
        setColorStateList(btnTur11, ContextCompat.getColor(this, R.color.tur_dark), btnTur11.getCurrentTextColor());
        setColorStateList(btnTur12, ContextCompat.getColor(this, R.color.tur_dark), btnTur12.getCurrentTextColor());
        setColorStateList(btnTur13, ContextCompat.getColor(this, R.color.tur_dark), btnTur13.getCurrentTextColor());
        setColorStateList(btnTur14, ContextCompat.getColor(this, R.color.tur_dark), btnTur14.getCurrentTextColor());
        setColorStateList(btnTur15, ContextCompat.getColor(this, R.color.tur_dark), btnTur15.getCurrentTextColor());

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
        Intent intentBack = new Intent(Lang101Tur.this, MainTur.class);
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
            if (username== null) {
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

    // Main Layout
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnTur1:
                    btnTur1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnTur2:
                    btnTur2.startAnimation(aniTouch);
                    page02();
                    break;
                case R.id.btnTur3:
                    btnTur3.startAnimation(aniTouch);
                    break;
                case R.id.btnTur4:
                    btnTur4.startAnimation(aniTouch);
                    break;
                case R.id.btnTur5:
                    btnTur5.startAnimation(aniTouch);
                    break;
                case R.id.btnTur6:
                    btnTur6.startAnimation(aniTouch);
                    break;
                case R.id.btnTur7:
                    btnTur7.startAnimation(aniTouch);
                    break;
                case R.id.btnTur8:
                    btnTur8.startAnimation(aniTouch);
                    break;
                case R.id.btnTur9:
                    btnTur9.startAnimation(aniTouch);
                    break;
                case R.id.btnTur10:
                    btnTur10.startAnimation(aniTouch);
                    break;
                case R.id.btnTur11:
                    btnTur11.startAnimation(aniTouch);
                    break;
                case R.id.btnTur12:
                    btnTur12.startAnimation(aniTouch);
                    break;
                case R.id.btnTur13:
                    btnTur13.startAnimation(aniTouch);
                    break;
                case R.id.btnTur14:
                    btnTur14.startAnimation(aniTouch);
                    break;
                case R.id.btnTur15:
                    btnTur15.startAnimation(aniTouch);
                    break;
                case R.id.btnTur16:
                    btnTur16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Tur.this, MainActivity.class);
                    intentHome.putExtra("username", username);
                    intentHome.putExtra("email", email);
                    intentHome.putExtra("profile", profile);
                    intentHome.putExtra("avatar", avatar);
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
        Intent intent01 = new Intent(Lang101Tur.this, Lang101Tur_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Tur.this, Lang101Rus_02_1.class);
        intent02.putExtra("username", username);
        intent02.putExtra("email", email);
        intent02.putExtra("profile", profile);
        intent02.putExtra("avatar", avatar);
        startActivity(intent02);
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
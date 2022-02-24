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

public class Lang101Ita extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnIta1, btnIta2, btnIta3, btnIta4, btnIta5, btnIta6, btnIta7, btnIta8;
    Button btnIta9, btnIta10, btnIta11, btnIta12, btnIta13, btnIta14, btnIta15, btnIta16;
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
        setContentView(R.layout.lang101_ita);

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
                Intent intentAccount = new Intent(Lang101Ita.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Ita.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Ita.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Ita.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Ita.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Ita.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Ita.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Ita.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

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
        btnIta16 = (Button) findViewById(R.id.btnIta16);
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
        btnIta16.setOnClickListener(mClickListener);
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
        Intent intentBack = new Intent(Lang101Ita.this, MainIta.class);
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
                case R.id.btnIta1:
                    btnIta1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnIta2:
                    btnIta2.startAnimation(aniTouch);
                    page02();
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
                case R.id.btnIta16:
                    btnIta16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Ita.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Ita.this, Lang101Ita_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Ita.this, Lang101Ita_02_1.class);
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
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
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnDeu1, btnDeu2, btnDeu3, btnDeu4, btnDeu5, btnDeu6, btnDeu7, btnDeu8;
    Button btnDeu9, btnDeu10, btnDeu11, btnDeu12, btnDeu13, btnDeu14, btnDeu15, btnDeu16;
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
        setContentView(R.layout.lang101_deu);

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
                Intent intentAccount = new Intent(Lang101Deu.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Deu.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Deu.this, SupportActivity.class);
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

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Deu.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

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
                case R.id.btnDeu1:
                    btnDeu1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnDeu2:
                    btnDeu2.startAnimation(aniTouch);
                    page02();
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
        Intent intent01 = new Intent(Lang101Deu.this, Lang101Deu_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Deu.this, Lang101Deu_02_1.class);
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
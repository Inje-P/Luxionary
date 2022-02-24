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

public class Lang101Rus extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnRus1, btnRus2, btnRus3, btnRus4, btnRus5, btnRus6, btnRus7, btnRus8;
    Button btnRus9, btnRus10, btnRus11, btnRus12, btnRus13, btnRus14, btnRus15, btnRus16;
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
        setContentView(R.layout.lang101_rus);

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
                Intent intentAccount = new Intent(Lang101Rus.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Rus.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Rus.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Rus.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Rus.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Rus.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Rus.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Rus.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

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
        btnRus16 = (Button) findViewById(R.id.btnRus16);
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
        btnRus16.setOnClickListener(mClickListener);
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
        Intent intentBack = new Intent(Lang101Rus.this, MainRus.class);
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
                case R.id.btnRus1:
                    btnRus1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnRus2:
                    btnRus2.startAnimation(aniTouch);
                    page02();
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
                case R.id.btnRus16:
                    btnRus16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Rus.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Rus.this, Lang101Rus_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Rus.this, Lang101Rus_02_1.class);
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
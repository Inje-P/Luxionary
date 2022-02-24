package com.luan.luxionary;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
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

import com.google.android.material.snackbar.Snackbar;

public class Lang101Eng_02_2 extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    LinearLayout layoutContainer;
    ImageButton btnPrev, btnNext;

    // Main
    Button btnTitle;
    ImageButton btnDown1, btnDown2;
    ImageButton btnEnd;
    Button btnText1_1, btnText1_2, btnText1_3, btnText1_4, btnText1_5, btnText1_6;
    Button btnText2_1, btnText2_2, btnText2_3, btnText2_4, btnText2_5, btnText2_6;
    Button btnText3_1, btnText3_2, btnText3_3, btnText3_4, btnText3_5, btnText3_6, btnText3_7;
    ImageView imgHorizontal1, imgHorizontal2, imgHorizontal3;
    ImageView imgVertical1, imgVertical2;

    // Animation
    Animation ani1_1, ani1_2, ani1_3, ani1_4, ani1_5, ani1_6;
    Animation ani2_1, ani2_2, ani2_3, ani2_4, ani2_5, ani2_6;
    Animation ani3_1, ani3_2, ani3_3, ani3_4, ani3_5, ani3_6, ani3_7;
    Animation aniTitle, aniBtnDown1, aniBtnDown2, aniBtnEnd;

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
        setContentView(R.layout.lang101_eng_02_2);

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
                Intent intentAccount = new Intent(Lang101Eng_02_2.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Eng_02_2.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Eng_02_2.this, SupportActivity.class);
                intentSupport.putExtra("username", username);
                intentSupport.putExtra("email", email);
                intentSupport.putExtra("profile", profile);
                intentSupport.putExtra("avatar", avatar);
                startActivity(intentSupport);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        // Prev & Next Buttons
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);
        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPrev.setOnClickListener(mClickListener);
        btnNext.setOnClickListener(mClickListener);

        /*
         * Main
         * */
        // Title
        btnTitle = (Button) findViewById(R.id.btnTitle);
        setColorStateList(btnTitle, ContextCompat.getColor(this, R.color.eng_background), btnTitle.getCurrentTextColor());

        // Buttons & Lines
        btnDown1 = (ImageButton) findViewById(R.id.btnDown1);
        btnDown1.setVisibility(View.INVISIBLE);
        btnDown2 = (ImageButton) findViewById(R.id.btnDown2);
        btnDown2.setVisibility(View.INVISIBLE);
        btnEnd = (ImageButton) findViewById(R.id.btnEnd);
        btnEnd.setVisibility(View.INVISIBLE);

        imgHorizontal1 = (ImageView) findViewById(R.id.imgHorizontal1);
        imgHorizontal1.setVisibility(View.INVISIBLE);
        imgHorizontal2 = (ImageView) findViewById(R.id.imgHorizontal2);
        imgHorizontal2.setVisibility(View.INVISIBLE);
        imgHorizontal3 = (ImageView) findViewById(R.id.imgHorizontal3);
        imgHorizontal3.setVisibility(View.INVISIBLE);

        imgVertical1 = (ImageView) findViewById(R.id.imgVertical1);
        imgVertical1.setVisibility(View.INVISIBLE);
        imgVertical2 = (ImageView) findViewById(R.id.imgVertical2);
        imgVertical2.setVisibility(View.INVISIBLE);

        // 1st Section
        btnText1_1 = (Button) findViewById(R.id.btnText1_1);
        btnText1_2 = (Button) findViewById(R.id.btnText1_2);
        btnText1_3 = (Button) findViewById(R.id.btnText1_3);
        btnText1_4 = (Button) findViewById(R.id.btnText1_4);
        btnText1_5 = (Button) findViewById(R.id.btnText1_5);
        btnText1_6 = (Button) findViewById(R.id.btnText1_6);
        setColorStateList(btnText1_1, ContextCompat.getColor(this, R.color.eng_background), btnText1_1.getCurrentTextColor());
        setColorStateList(btnText1_2, ContextCompat.getColor(this, R.color.eng_background), btnText1_2.getCurrentTextColor());
        setColorStateList(btnText1_3, ContextCompat.getColor(this, R.color.eng_background), btnText1_3.getCurrentTextColor());
        setColorStateList(btnText1_4, ContextCompat.getColor(this, R.color.eng_background), btnText1_4.getCurrentTextColor());
        setColorStateList(btnText1_5, ContextCompat.getColor(this, R.color.eng_background), btnText1_5.getCurrentTextColor());
        setColorStateList(btnText1_6, ContextCompat.getColor(this, R.color.eng_background), btnText1_6.getCurrentTextColor());
        btnText1_1.setVisibility(View.INVISIBLE);
        btnText1_2.setVisibility(View.INVISIBLE);
        btnText1_3.setVisibility(View.INVISIBLE);
        btnText1_4.setVisibility(View.INVISIBLE);
        btnText1_5.setVisibility(View.INVISIBLE);
        btnText1_6.setVisibility(View.INVISIBLE);
        ani1_1 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_2 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_2.setStartOffset(200);
        ani1_3 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_3.setStartOffset(400);
        ani1_4 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_4.setStartOffset(600);
        ani1_5 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_5.setStartOffset(800);
        ani1_6 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani1_6.setStartOffset(1000);

        // 2nd Section
        btnText2_1 = (Button) findViewById(R.id.btnText2_1);
        btnText2_2 = (Button) findViewById(R.id.btnText2_2);
        btnText2_3 = (Button) findViewById(R.id.btnText2_3);
        btnText2_4 = (Button) findViewById(R.id.btnText2_4);
        btnText2_5 = (Button) findViewById(R.id.btnText2_5);
        btnText2_6 = (Button) findViewById(R.id.btnText2_6);
        setColorStateList(btnText2_1, ContextCompat.getColor(this, R.color.eng_background), btnText2_1.getCurrentTextColor());
        setColorStateList(btnText2_2, ContextCompat.getColor(this, R.color.eng_background), btnText2_2.getCurrentTextColor());
        setColorStateList(btnText2_3, ContextCompat.getColor(this, R.color.eng_background), btnText2_3.getCurrentTextColor());
        setColorStateList(btnText2_4, ContextCompat.getColor(this, R.color.eng_background), btnText2_4.getCurrentTextColor());
        setColorStateList(btnText2_5, ContextCompat.getColor(this, R.color.eng_background), btnText2_5.getCurrentTextColor());
        setColorStateList(btnText2_6, ContextCompat.getColor(this, R.color.eng_background), btnText2_6.getCurrentTextColor());
        btnText2_1.setVisibility(View.INVISIBLE);
        btnText2_2.setVisibility(View.INVISIBLE);
        btnText2_3.setVisibility(View.INVISIBLE);
        btnText2_4.setVisibility(View.INVISIBLE);
        btnText2_5.setVisibility(View.INVISIBLE);
        btnText2_6.setVisibility(View.INVISIBLE);
        ani2_1 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_2 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_2.setStartOffset(200);
        ani2_3 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_3.setStartOffset(400);
        ani2_4 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_4.setStartOffset(600);
        ani2_5 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_5.setStartOffset(800);
        ani2_6 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani2_6.setStartOffset(1000);

        // 3rd Section
        btnText3_1 = (Button) findViewById(R.id.btnText3_1);
        btnText3_2 = (Button) findViewById(R.id.btnText3_2);
        btnText3_3 = (Button) findViewById(R.id.btnText3_3);
        btnText3_4 = (Button) findViewById(R.id.btnText3_4);
        btnText3_5 = (Button) findViewById(R.id.btnText3_5);
        btnText3_6 = (Button) findViewById(R.id.btnText3_6);
        btnText3_7 = (Button) findViewById(R.id.btnText3_7);
        setColorStateList(btnText3_1, ContextCompat.getColor(this, R.color.eng_background), btnText3_1.getCurrentTextColor());
        setColorStateList(btnText3_2, ContextCompat.getColor(this, R.color.eng_background), btnText3_2.getCurrentTextColor());
        setColorStateList(btnText3_3, ContextCompat.getColor(this, R.color.eng_background), btnText3_3.getCurrentTextColor());
        setColorStateList(btnText3_4, ContextCompat.getColor(this, R.color.eng_background), btnText3_4.getCurrentTextColor());
        setColorStateList(btnText3_5, ContextCompat.getColor(this, R.color.eng_background), btnText3_5.getCurrentTextColor());
        setColorStateList(btnText3_6, ContextCompat.getColor(this, R.color.eng_background), btnText3_6.getCurrentTextColor());
        setColorStateList(btnText3_7, ContextCompat.getColor(this, R.color.eng_background), btnText3_7.getCurrentTextColor());
        btnText3_1.setVisibility(View.INVISIBLE);
        btnText3_2.setVisibility(View.INVISIBLE);
        btnText3_3.setVisibility(View.INVISIBLE);
        btnText3_4.setVisibility(View.INVISIBLE);
        btnText3_5.setVisibility(View.INVISIBLE);
        btnText3_6.setVisibility(View.INVISIBLE);
        btnText3_7.setVisibility(View.INVISIBLE);
        ani3_1 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_2 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_2.setStartOffset(200);
        ani3_3 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_3.setStartOffset(400);
        ani3_4 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_4.setStartOffset(600);
        ani3_5 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_5.setStartOffset(800);
        ani3_6 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_6.setStartOffset(1000);
        ani3_7 = AnimationUtils.loadAnimation(Lang101Eng_02_2.this, R.anim.ascend_fast);
        ani3_7.setStartOffset(1200);

        btnText1_1.setOnClickListener(mClickListener);
        btnText1_2.setOnClickListener(mClickListener);
        btnText1_3.setOnClickListener(mClickListener);
        btnText1_4.setOnClickListener(mClickListener);
        btnText1_5.setOnClickListener(mClickListener);
        btnText1_6.setOnClickListener(mClickListener);
        btnText2_1.setOnClickListener(mClickListener);
        btnText2_2.setOnClickListener(mClickListener);
        btnText2_3.setOnClickListener(mClickListener);
        btnText2_4.setOnClickListener(mClickListener);
        btnText2_5.setOnClickListener(mClickListener);
        btnText2_6.setOnClickListener(mClickListener);
        btnText3_1.setOnClickListener(mClickListener);
        btnText3_2.setOnClickListener(mClickListener);
        btnText3_3.setOnClickListener(mClickListener);
        btnText3_4.setOnClickListener(mClickListener);
        btnText3_5.setOnClickListener(mClickListener);
        btnText3_6.setOnClickListener(mClickListener);
        btnText3_7.setOnClickListener(mClickListener);

        // Start
        aniTitle = new AlphaAnimation(0.0f, 1.0f);
        aniTitle.setDuration(300);
        aniTitle.setStartOffset(400);
        aniTitle.setRepeatMode(Animation.REVERSE);
        aniTitle.setRepeatCount(Animation.INFINITE);
        btnTitle.startAnimation(aniTitle);
        btnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTitle.clearAnimation();

                imgHorizontal1.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable1 = (AnimatedVectorDrawable) imgHorizontal1.getDrawable();
                drawable1.start();

                imgVertical1.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable1v = (AnimatedVectorDrawable) imgVertical1.getDrawable();
                drawable1v.start();

                btnText1_1.setVisibility(View.VISIBLE);
                btnText1_2.setVisibility(View.VISIBLE);
                btnText1_3.setVisibility(View.VISIBLE);
                btnText1_4.setVisibility(View.VISIBLE);
                btnText1_5.setVisibility(View.VISIBLE);
                btnText1_6.setVisibility(View.VISIBLE);
                btnText1_1.startAnimation(ani1_1);
                btnText1_2.startAnimation(ani1_2);
                btnText1_3.startAnimation(ani1_3);
                btnText1_4.startAnimation(ani1_4);
                btnText1_5.startAnimation(ani1_5);
                btnText1_6.startAnimation(ani1_6);

                btnDown1.setVisibility(View.VISIBLE);
                aniBtnDown1 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown1.setDuration(200);
                aniBtnDown1.setStartOffset(400);
                aniBtnDown1.setRepeatMode(Animation.REVERSE);
                aniBtnDown1.setRepeatCount(Animation.INFINITE);
                btnDown1.startAnimation(aniBtnDown1);
            }
        });

        btnDown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDown1.clearAnimation();
                btnDown1.setVisibility(View.INVISIBLE);

                imgHorizontal2.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) imgHorizontal2.getDrawable();
                drawable2.start();

                imgVertical2.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable2v = (AnimatedVectorDrawable) imgVertical2.getDrawable();
                drawable2v.start();

                btnText2_1.setVisibility(View.VISIBLE);
                btnText2_2.setVisibility(View.VISIBLE);
                btnText2_3.setVisibility(View.VISIBLE);
                btnText2_4.setVisibility(View.VISIBLE);
                btnText2_5.setVisibility(View.VISIBLE);
                btnText2_6.setVisibility(View.VISIBLE);
                btnText2_1.startAnimation(ani2_1);
                btnText2_2.startAnimation(ani2_2);
                btnText2_3.startAnimation(ani2_3);
                btnText2_4.startAnimation(ani2_4);
                btnText2_5.startAnimation(ani2_5);
                btnText2_6.startAnimation(ani2_6);

                btnDown2.setVisibility(View.VISIBLE);
                aniBtnDown2 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown2.setDuration(200);
                aniBtnDown2.setStartOffset(400);
                aniBtnDown2.setRepeatMode(Animation.REVERSE);
                aniBtnDown2.setRepeatCount(Animation.INFINITE);
                btnDown2.startAnimation(aniBtnDown2);
            }
        });

        btnDown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDown2.clearAnimation();
                btnDown2.setVisibility(View.INVISIBLE);

                imgHorizontal3.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable3 = (AnimatedVectorDrawable) imgHorizontal3.getDrawable();
                drawable3.start();

                btnText3_1.setVisibility(View.VISIBLE);
                btnText3_2.setVisibility(View.VISIBLE);
                btnText3_3.setVisibility(View.VISIBLE);
                btnText3_4.setVisibility(View.VISIBLE);
                btnText3_5.setVisibility(View.VISIBLE);
                btnText3_6.setVisibility(View.VISIBLE);
                btnText3_7.setVisibility(View.VISIBLE);
                btnText3_1.startAnimation(ani3_1);
                btnText3_2.startAnimation(ani3_2);
                btnText3_3.startAnimation(ani3_3);
                btnText3_4.startAnimation(ani3_3);
                btnText3_5.startAnimation(ani3_3);
                btnText3_6.startAnimation(ani3_3);
                btnText3_7.startAnimation(ani3_3);

                btnEnd.setVisibility(View.VISIBLE);
                aniBtnEnd = new AlphaAnimation(0.0f, 1.0f);
                aniBtnEnd.setDuration(200);
                aniBtnEnd.setStartOffset(400);
                aniBtnEnd.setRepeatMode(Animation.REVERSE);
                aniBtnEnd.setRepeatCount(Animation.INFINITE);
                btnEnd.startAnimation(aniBtnEnd);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnd = new Intent(Lang101Eng_02_2.this, Lang101Eng_02_3.class);
                intentEnd.putExtra("username", username);
                intentEnd.putExtra("email", email);
                intentEnd.putExtra("profile", profile);
                intentEnd.putExtra("avatar", avatar);
                startActivity(intentEnd);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();

            }
        });

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
        Intent intentBack = new Intent(Lang101Eng_02_2.this, Lang101Eng_02_1.class);
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

    // Main Layout
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnText1_1:
                    showSnackbar("나 (1인칭 단수)");
                    break;
                case R.id.btnText1_2:
                    showSnackbar("너 (2인칭 단수)");
                    break;
                case R.id.btnText1_3:
                    showSnackbar("그, 그녀, 그것 (3인칭 단수)");
                    break;
                case R.id.btnText1_4:
                    showSnackbar("우리 (1인칭 복수)");
                    break;
                case R.id.btnText1_5:
                    showSnackbar("너희 (2인칭 복수)");
                    break;
                case R.id.btnText1_6:
                    showSnackbar("그들 (3인칭 복수)");
                    break;
                case R.id.btnText2_1:
                    showSnackbar("나는 -이다.");
                    break;
                case R.id.btnText2_2:
                    showSnackbar("너는 -이다.");
                    break;
                case R.id.btnText2_3:
                    showSnackbar("그/그녀/그것은 -이다.");
                    break;
                case R.id.btnText2_4:
                    showSnackbar("우리는 -이다.");
                    break;
                case R.id.btnText2_5:
                    showSnackbar("너희는 -이다.");
                    break;
                case R.id.btnText2_6:
                    showSnackbar("그들은 -이다.");
                    break;
                case R.id.btnText3_1:
                    showSnackbar("나는 Noah다.");
                    break;
                case R.id.btnText3_2:
                    showSnackbar("너는 Lily다.");
                    break;
                case R.id.btnText3_3:
                    showSnackbar("그는 Henry다.");
                    break;
                case R.id.btnText3_4:
                    showSnackbar("그녀는 Olivia다.");
                    break;
                case R.id.btnText3_5:
                    showSnackbar("우리는 가족이다.");
                    break;
                case R.id.btnText3_6:
                    showSnackbar("너희는 친구들이다.");
                    break;
                case R.id.btnText3_7:
                    showSnackbar("그들은 동료들이다.");
                    break;
                // Prev & Next Buttons
                case R.id.btnPrev:
                    Intent intentPrev = new Intent(Lang101Eng_02_2.this, Lang101Eng.class);
                    intentPrev.putExtra("username", username);
                    intentPrev.putExtra("email", email);
                    intentPrev.putExtra("profile", profile);
                    intentPrev.putExtra("avatar", avatar);
                    startActivity(intentPrev);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnNext:
                    Intent intentNext = new Intent(Lang101Eng_02_2.this, Lang101Eng.class);
                    intentNext.putExtra("username", username);
                    intentNext.putExtra("email", email);
                    intentNext.putExtra("profile", profile);
                    intentNext.putExtra("avatar", avatar);
                    startActivity(intentNext);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                // Footer
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Eng_02_2.this, MainActivity.class);
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

    // Snackbar
    public void showSnackbar(String str) {
        layoutContainer = findViewById(R.id.layoutContainer);
        Snackbar snackbar = Snackbar.make(layoutContainer, "", Snackbar.LENGTH_SHORT);
        View custom = getLayoutInflater().inflate(R.layout.snackbar_eng, null);
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

        TextView tvText = (TextView) custom.findViewById(R.id.tvText);
        tvText.setText(str);
        tvText.setTextColor(ContextCompat.getColor(this, R.color.main_white));
        tvText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(custom, 0);
        snackbar.show();
    }

    // Text Color
    public void setColorStateList(View view, int selectedColor, int defaultColor) {
        int[][] states = new int[][]{
                new int[]{
                        android.R.attr.state_pressed,
                        android.R.attr.state_selected
                }, // pressed, selected, focused
                new int[]{} // default
        };

        int[] colors = new int[]{
                selectedColor,
                defaultColor
        };

        ColorStateList textColorList = new ColorStateList(states, colors);
        if (view instanceof TextView || view instanceof AppCompatTextView) { // TextView
            ((TextView) view).setTextColor(textColorList);
            view.setClickable(true);
        } else if (view instanceof Button || view instanceof AppCompatButton) { // Button
            ((Button) view).setTextColor(textColorList);
        }
        view.setSelected(true);
    }

}
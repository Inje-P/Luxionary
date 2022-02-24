package com.luan.luxionary;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Lang101Eng extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnEng1, btnEng2, btnEng3, btnEng4, btnEng5, btnEng6, btnEng7, btnEng8;
    Button btnEng9, btnEng10, btnEng11, btnEng12, btnEng13, btnEng14, btnEng15, btnEng16;
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
        setContentView(R.layout.lang101_eng);

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
                Intent intentAccount = new Intent(Lang101Eng.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Eng.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Eng.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Eng.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Eng.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Eng.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Eng.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Eng.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

        // Buttons & TextViews
        btnEng1 = (Button) findViewById(R.id.btnEng1);
        btnEng2 = (Button) findViewById(R.id.btnEng2);
        btnEng3 = (Button) findViewById(R.id.btnEng3);
        btnEng4 = (Button) findViewById(R.id.btnEng4);
        btnEng5 = (Button) findViewById(R.id.btnEng5);
        btnEng6 = (Button) findViewById(R.id.btnEng6);
        btnEng7 = (Button) findViewById(R.id.btnEng7);
        btnEng8 = (Button) findViewById(R.id.btnEng8);
        btnEng9 = (Button) findViewById(R.id.btnEng9);
        btnEng10 = (Button) findViewById(R.id.btnEng10);
        btnEng11 = (Button) findViewById(R.id.btnEng11);
        btnEng12 = (Button) findViewById(R.id.btnEng12);
        btnEng13 = (Button) findViewById(R.id.btnEng13);
        btnEng14 = (Button) findViewById(R.id.btnEng14);
        btnEng15 = (Button) findViewById(R.id.btnEng15);
        btnEng16 = (Button) findViewById(R.id.btnEng16);
        btnEng1.setOnClickListener(mClickListener);
        btnEng2.setOnClickListener(mClickListener);
        btnEng3.setOnClickListener(mClickListener);
        btnEng4.setOnClickListener(mClickListener);
        btnEng5.setOnClickListener(mClickListener);
        btnEng6.setOnClickListener(mClickListener);
        btnEng7.setOnClickListener(mClickListener);
        btnEng8.setOnClickListener(mClickListener);
        btnEng9.setOnClickListener(mClickListener);
        btnEng10.setOnClickListener(mClickListener);
        btnEng11.setOnClickListener(mClickListener);
        btnEng12.setOnClickListener(mClickListener);
        btnEng13.setOnClickListener(mClickListener);
        btnEng14.setOnClickListener(mClickListener);
        btnEng15.setOnClickListener(mClickListener);
        btnEng16.setOnClickListener(mClickListener);
        setColorStateList(btnEng2, ContextCompat.getColor(this, R.color.eng_background), btnEng2.getCurrentTextColor());
        setColorStateList(btnEng3, ContextCompat.getColor(this, R.color.eng_background), btnEng3.getCurrentTextColor());
        setColorStateList(btnEng4, ContextCompat.getColor(this, R.color.eng_background), btnEng4.getCurrentTextColor());
        setColorStateList(btnEng5, ContextCompat.getColor(this, R.color.eng_background), btnEng5.getCurrentTextColor());
        setColorStateList(btnEng6, ContextCompat.getColor(this, R.color.eng_background), btnEng6.getCurrentTextColor());
        setColorStateList(btnEng7, ContextCompat.getColor(this, R.color.eng_background), btnEng7.getCurrentTextColor());
        setColorStateList(btnEng8, ContextCompat.getColor(this, R.color.eng_background), btnEng8.getCurrentTextColor());
        setColorStateList(btnEng9, ContextCompat.getColor(this, R.color.eng_background), btnEng9.getCurrentTextColor());
        setColorStateList(btnEng10, ContextCompat.getColor(this, R.color.eng_background), btnEng10.getCurrentTextColor());
        setColorStateList(btnEng11, ContextCompat.getColor(this, R.color.eng_background), btnEng11.getCurrentTextColor());
        setColorStateList(btnEng12, ContextCompat.getColor(this, R.color.eng_background), btnEng12.getCurrentTextColor());
        setColorStateList(btnEng13, ContextCompat.getColor(this, R.color.eng_background), btnEng13.getCurrentTextColor());
        setColorStateList(btnEng14, ContextCompat.getColor(this, R.color.eng_background), btnEng14.getCurrentTextColor());
        setColorStateList(btnEng15, ContextCompat.getColor(this, R.color.eng_background), btnEng15.getCurrentTextColor());

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
        Intent intentBack = new Intent(Lang101Eng.this, MainEng.class);
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
                // Title Animation
                case R.id.tvTitle1:
                    engTitle();
                    break;
                case R.id.btnEng1:
                    btnEng1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnEng2:
                    btnEng2.startAnimation(aniTouch);
                    page02();
                    break;
                case R.id.btnEng3:
                    btnEng3.startAnimation(aniTouch);
                    break;
                case R.id.btnEng4:
                    btnEng4.startAnimation(aniTouch);
                    break;
                case R.id.btnEng5:
                    btnEng5.startAnimation(aniTouch);
                    break;
                case R.id.btnEng6:
                    btnEng6.startAnimation(aniTouch);
                    break;
                case R.id.btnEng7:
                    btnEng7.startAnimation(aniTouch);
                    break;
                case R.id.btnEng8:
                    btnEng8.startAnimation(aniTouch);
                    break;
                case R.id.btnEng9:
                    btnEng9.startAnimation(aniTouch);
                    break;
                case R.id.btnEng10:
                    btnEng10.startAnimation(aniTouch);
                    break;
                case R.id.btnEng11:
                    btnEng11.startAnimation(aniTouch);
                    break;
                case R.id.btnEng12:
                    btnEng12.startAnimation(aniTouch);
                    break;
                case R.id.btnEng13:
                    btnEng13.startAnimation(aniTouch);
                    break;
                case R.id.btnEng14:
                    btnEng14.startAnimation(aniTouch);
                    break;
                case R.id.btnEng15:
                    btnEng15.startAnimation(aniTouch);
                    break;
                case R.id.btnEng16:
                    btnEng16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Eng.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Eng.this, Lang101Eng_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Eng.this, Lang101Eng_02_1.class);
        intent02.putExtra("username", username);
        intent02.putExtra("email", email);
        intent02.putExtra("profile", profile);
        intent02.putExtra("avatar", avatar);
        startActivity(intent02);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    // Title Animation
    private void engTitle() {
        Integer engDark = Color.parseColor("#B83756");
        Integer engMain = Color.parseColor("#FF6388");
        Integer engLight = Color.parseColor("#FF93AD");

        ValueAnimator colorAni1 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engDark);
        colorAni1.setDuration(100);
        colorAni1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni2 = ValueAnimator.ofObject(new ArgbEvaluator(), engDark, engMain);
        colorAni2.setDuration(100);
        colorAni2.setStartDelay(100);
        colorAni2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni3 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engLight);
        colorAni3.setDuration(100);
        colorAni3.setStartDelay(200);
        colorAni3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni4 = ValueAnimator.ofObject(new ArgbEvaluator(), engLight, engMain);
        colorAni4.setDuration(100);
        colorAni4.setStartDelay(300);
        colorAni4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAni1.start();
        colorAni2.start();
        colorAni3.start();
        colorAni4.start();
    }

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
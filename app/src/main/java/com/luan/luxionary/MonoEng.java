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

public class MonoEng extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    ImageView imgAvatar;
    Button btnEng1, btnEng2, btnEng3, btnEng4, btnEng5, btnEng6, btnEng7, btnEng8;
    Button btnEng9, btnEng10, btnEng11, btnEng12, btnEng13, btnEng14, btnEng15;
    LinearLayout layoutProfile, llBanner;
    LinearLayout llEng1, llEng2, llEng3, llEng4, llEng5, llEng6, llEng7, llEng8;
    LinearLayout llEng9, llEng10, llEng11, llEng12, llEng13, llEng14, llEng15;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2, aniAvatar;
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
        setContentView(R.layout.mono_eng);

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
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLayoutProfile.setStartOffset(600);
        layoutProfile.startAnimation(aniLayoutProfile);
        llBanner = (LinearLayout) findViewById(R.id.llBanner);
        aniLlBanner = AnimationUtils.loadAnimation(MonoEng.this, R.anim.ascend_fast);
        llBanner.startAnimation(aniLlBanner);

        // Avatar
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        if (strAvatar == null) {
            imgAvatar.setImageResource(R.drawable.avt_male1);
        } else {
            switch (strAvatar) {
                case "male1":
                    imgAvatar.setImageResource(R.drawable.avt_male1);
                    break;
                case "male2":
                    imgAvatar.setImageResource(R.drawable.avt_male2);
                    break;
                case "male3":
                    imgAvatar.setImageResource(R.drawable.avt_male3);
                    break;
                case "male4":
                    imgAvatar.setImageResource(R.drawable.avt_male4);
                    break;
                case "female1":
                    imgAvatar.setImageResource(R.drawable.avt_female1);
                    break;
                case "female2":
                    imgAvatar.setImageResource(R.drawable.avt_female2);
                    break;
                case "female3":
                    imgAvatar.setImageResource(R.drawable.avt_female3);
                    break;
                case "female4":
                    imgAvatar.setImageResource(R.drawable.avt_female4);
                    break;
            }
        }
        aniAvatar = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniAvatar.setStartOffset(800);
        imgAvatar.startAnimation(aniAvatar);
        imgAvatar.setOnClickListener(mClickListener);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MonoEng.this, R.anim.scale);

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
        setColorStateList(btnEng1, ContextCompat.getColor(this, R.color.eng_dark), btnEng1.getCurrentTextColor());
        setColorStateList(btnEng2, ContextCompat.getColor(this, R.color.eng_dark), btnEng2.getCurrentTextColor());
        setColorStateList(btnEng3, ContextCompat.getColor(this, R.color.eng_dark), btnEng3.getCurrentTextColor());
        setColorStateList(btnEng4, ContextCompat.getColor(this, R.color.eng_dark), btnEng4.getCurrentTextColor());
        setColorStateList(btnEng5, ContextCompat.getColor(this, R.color.eng_dark), btnEng5.getCurrentTextColor());
        setColorStateList(btnEng6, ContextCompat.getColor(this, R.color.eng_dark), btnEng6.getCurrentTextColor());
        setColorStateList(btnEng7, ContextCompat.getColor(this, R.color.eng_dark), btnEng7.getCurrentTextColor());
        setColorStateList(btnEng8, ContextCompat.getColor(this, R.color.eng_dark), btnEng8.getCurrentTextColor());
        setColorStateList(btnEng9, ContextCompat.getColor(this, R.color.eng_dark), btnEng9.getCurrentTextColor());
        setColorStateList(btnEng10, ContextCompat.getColor(this, R.color.eng_dark), btnEng10.getCurrentTextColor());
        setColorStateList(btnEng11, ContextCompat.getColor(this, R.color.eng_dark), btnEng11.getCurrentTextColor());
        setColorStateList(btnEng12, ContextCompat.getColor(this, R.color.eng_dark), btnEng12.getCurrentTextColor());
        setColorStateList(btnEng13, ContextCompat.getColor(this, R.color.eng_dark), btnEng13.getCurrentTextColor());
        setColorStateList(btnEng14, ContextCompat.getColor(this, R.color.eng_dark), btnEng14.getCurrentTextColor());
        setColorStateList(btnEng15, ContextCompat.getColor(this, R.color.eng_dark), btnEng15.getCurrentTextColor());

        // Animation
        llEng1 = (LinearLayout) findViewById(R.id.llEng1);
        llEng2 = (LinearLayout) findViewById(R.id.llEng2);
        llEng3 = (LinearLayout) findViewById(R.id.llEng3);
        llEng4 = (LinearLayout) findViewById(R.id.llEng4);
        llEng5 = (LinearLayout) findViewById(R.id.llEng5);
        llEng6 = (LinearLayout) findViewById(R.id.llEng6);
        llEng7 = (LinearLayout) findViewById(R.id.llEng7);
        llEng8 = (LinearLayout) findViewById(R.id.llEng8);
        llEng9 = (LinearLayout) findViewById(R.id.llEng9);
        llEng10 = (LinearLayout) findViewById(R.id.llEng10);
        llEng11 = (LinearLayout) findViewById(R.id.llEng11);
        llEng12 = (LinearLayout) findViewById(R.id.llEng12);
        llEng13 = (LinearLayout) findViewById(R.id.llEng13);
        llEng14 = (LinearLayout) findViewById(R.id.llEng14);
        llEng15 = (LinearLayout) findViewById(R.id.llEng15);
        aniLl1 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(MonoEng.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        llEng1.startAnimation(aniLl1);
        llEng2.startAnimation(aniLl2);
        llEng3.startAnimation(aniLl3);
        llEng4.startAnimation(aniLl4);
        llEng5.startAnimation(aniLl5);
        llEng6.startAnimation(aniLl6);
        llEng7.startAnimation(aniLl7);
        llEng8.startAnimation(aniLl8);
        llEng9.startAnimation(aniLl9);
        llEng10.startAnimation(aniLl10);
        llEng11.startAnimation(aniLl11);
        llEng12.startAnimation(aniLl12);
        llEng13.startAnimation(aniLl13);
        llEng14.startAnimation(aniLl14);
        llEng15.startAnimation(aniLl15);

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
        Intent intentBack = new Intent(MonoEng.this, MainEng.class);
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
                // Title Animation
                case R.id.tvTitle1:
                    engTitle();
                    break;
                case R.id.imgAvatar:
                    imgAvatar.startAnimation(aniTouch);
                    break;
                case R.id.btnEng1:
                    btnEng1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnEng2:
                    btnEng2.startAnimation(aniTouch);
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
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MonoEng.this, MainActivity.class);
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
        Intent intent01 = new Intent(MonoEng.this, MonoEng_01_0.class);
        intent01.putExtra("nick", strNick);
        intent01.putExtra("pw", strPw);
        intent01.putExtra("name", strName);
        intent01.putExtra("email", strEmail);
        intent01.putExtra("avatar", strAvatar);
        startActivity(intent01);
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
                tvTitle1.setTextColor((Integer)animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni2 = ValueAnimator.ofObject(new ArgbEvaluator(), engDark, engMain);
        colorAni2.setDuration(100);
        colorAni2.setStartDelay(100);
        colorAni2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer)animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni3 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engLight);
        colorAni3.setDuration(100);
        colorAni3.setStartDelay(200);
        colorAni3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer)animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni4 = ValueAnimator.ofObject(new ArgbEvaluator(), engLight, engMain);
        colorAni4.setDuration(100);
        colorAni4.setStartDelay(300);
        colorAni4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer)animator.getAnimatedValue());
            }
        });

        colorAni1.start();
        colorAni2.start();
        colorAni3.start();
        colorAni4.start();
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
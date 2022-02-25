package com.luan.luxionary;

import android.content.Intent;
import android.content.res.ColorStateList;
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

public class VocaSpa_001_1 extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    // Main
    Button btnTitle;
    ImageView imgHorizontal;
    ImageButton btnEnd;
    Animation aniTitle, aniBtnEnd;

    // Layout & Animation
    LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, ll10;
    LinearLayout ll11, ll12, ll13, ll14, ll15, ll16, ll17, ll18, ll19, ll20;
    LinearLayout ll21, ll22;
    Animation aniLl1, aniLl2, aniLl3, aniLl4, aniLl5, aniLl6, aniLl7, aniLl8, aniLl9, aniLl10;
    Animation aniLl11, aniLl12, aniLl13, aniLl14, aniLl15, aniLl16, aniLl17, aniLl18, aniLl19, aniLl20;
    Animation aniLl21, aniLl22;

    /*
    * 이후 DB와 연결하는 부분 !!
    * */
    String[] spa = {"la cara", "la cabeza", "el pelo", "la frente", "el ojo", "la ceja", "el párpado", "la pestaña", "el iris", "la pupila",
            "la nariz", "la fosa nasal", "la oreja", "la mejilla", "la mandíbula", "el diente", "la boca", "el labio", "la barbilla", "la lengua",
            "el bigote", "la barba"};
    String[] kor = {"얼굴", "머리", "머리카락", "이마", "눈", "눈썹", "눈커풀", "속눈썹", "홍채", "동공",
            "코", "콧구멍", "귀", "뺨", "아래턱", "치아", "입", "입술", "턱", "혀",
            "콧수염", "턱수염"};

    // Words
    Button btnL1, btnL2, btnL3, btnL4, btnL5, btnL6, btnL7, btnL8, btnL9, btnL10;
    Button btnL11, btnL12, btnL13, btnL14, btnL15, btnL16, btnL17, btnL18, btnL19, btnL20;
    Button btnL21, btnL22;

    // Translations
    Button btnR1, btnR2, btnR3, btnR4, btnR5, btnR6, btnR7, btnR8, btnR9, btnR10;
    Button btnR11, btnR12, btnR13, btnR14, btnR15, btnR16, btnR17, btnR18, btnR19, btnR20;
    Button btnR21, btnR22;

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
        setContentView(R.layout.voca_spa_001_1);

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
                Intent intentAccount = new Intent(VocaSpa_001_1.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(VocaSpa_001_1.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(VocaSpa_001_1.this, VocaSpa_001_1.class);
                intentSupport.putExtra("username", username);
                intentSupport.putExtra("email", email);
                intentSupport.putExtra("profile", profile);
                intentSupport.putExtra("avatar", avatar);
                startActivity(intentSupport);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        // Main
        btnTitle = (Button) findViewById(R.id.btnTitle);
        setColorStateList(btnTitle, ContextCompat.getColor(this, R.color.spa_background), btnTitle.getCurrentTextColor());

        imgHorizontal = (ImageView) findViewById(R.id.imgHorizontal);
        imgHorizontal.setVisibility(View.INVISIBLE);

        btnEnd = (ImageButton) findViewById(R.id.btnEnd);
        btnEnd.setVisibility(View.INVISIBLE);

        btnL1 = (Button) findViewById(R.id.btnL1);
        btnL2 = (Button) findViewById(R.id.btnL2);
        btnL3 = (Button) findViewById(R.id.btnL3);
        btnL4 = (Button) findViewById(R.id.btnL4);
        btnL5 = (Button) findViewById(R.id.btnL5);
        btnL6 = (Button) findViewById(R.id.btnL6);
        btnL7 = (Button) findViewById(R.id.btnL7);
        btnL8 = (Button) findViewById(R.id.btnL8);
        btnL9 = (Button) findViewById(R.id.btnL9);
        btnL10 = (Button) findViewById(R.id.btnL10);
        btnL11 = (Button) findViewById(R.id.btnL11);
        btnL12 = (Button) findViewById(R.id.btnL12);
        btnL13 = (Button) findViewById(R.id.btnL13);
        btnL14 = (Button) findViewById(R.id.btnL14);
        btnL15 = (Button) findViewById(R.id.btnL15);
        btnL16 = (Button) findViewById(R.id.btnL16);
        btnL17 = (Button) findViewById(R.id.btnL17);
        btnL18 = (Button) findViewById(R.id.btnL18);
        btnL19 = (Button) findViewById(R.id.btnL19);
        btnL20 = (Button) findViewById(R.id.btnL20);
        btnL21 = (Button) findViewById(R.id.btnL21);
        btnL22 = (Button) findViewById(R.id.btnL22);
        btnL1.setText(spa[0]);
        btnL2.setText(spa[1]);
        btnL3.setText(spa[2]);
        btnL4.setText(spa[3]);
        btnL5.setText(spa[4]);
        btnL6.setText(spa[5]);
        btnL7.setText(spa[6]);
        btnL8.setText(spa[7]);
        btnL9.setText(spa[8]);
        btnL10.setText(spa[9]);
        btnL11.setText(spa[10]);
        btnL12.setText(spa[11]);
        btnL13.setText(spa[12]);
        btnL14.setText(spa[13]);
        btnL15.setText(spa[14]);
        btnL16.setText(spa[15]);
        btnL17.setText(spa[16]);
        btnL18.setText(spa[17]);
        btnL19.setText(spa[18]);
        btnL20.setText(spa[19]);
        btnL21.setText(spa[20]);
        btnL22.setText(spa[21]);

        btnR1 = (Button) findViewById(R.id.btnR1);
        btnR2 = (Button) findViewById(R.id.btnR2);
        btnR3 = (Button) findViewById(R.id.btnR3);
        btnR4 = (Button) findViewById(R.id.btnR4);
        btnR5 = (Button) findViewById(R.id.btnR5);
        btnR6 = (Button) findViewById(R.id.btnR6);
        btnR7 = (Button) findViewById(R.id.btnR7);
        btnR8 = (Button) findViewById(R.id.btnR8);
        btnR9 = (Button) findViewById(R.id.btnR9);
        btnR10 = (Button) findViewById(R.id.btnR10);
        btnR11 = (Button) findViewById(R.id.btnR11);
        btnR12 = (Button) findViewById(R.id.btnR12);
        btnR13 = (Button) findViewById(R.id.btnR13);
        btnR14 = (Button) findViewById(R.id.btnR14);
        btnR15 = (Button) findViewById(R.id.btnR15);
        btnR16 = (Button) findViewById(R.id.btnR16);
        btnR17 = (Button) findViewById(R.id.btnR17);
        btnR18 = (Button) findViewById(R.id.btnR18);
        btnR19 = (Button) findViewById(R.id.btnR19);
        btnR20 = (Button) findViewById(R.id.btnR20);
        btnR21 = (Button) findViewById(R.id.btnR21);
        btnR22 = (Button) findViewById(R.id.btnR22);
        btnR1.setText(kor[0]);
        btnR2.setText(kor[1]);
        btnR3.setText(kor[2]);
        btnR4.setText(kor[3]);
        btnR5.setText(kor[4]);
        btnR6.setText(kor[5]);
        btnR7.setText(kor[6]);
        btnR8.setText(kor[7]);
        btnR9.setText(kor[8]);
        btnR10.setText(kor[9]);
        btnR11.setText(kor[10]);
        btnR12.setText(kor[11]);
        btnR13.setText(kor[12]);
        btnR14.setText(kor[13]);
        btnR15.setText(kor[14]);
        btnR16.setText(kor[15]);
        btnR17.setText(kor[16]);
        btnR18.setText(kor[17]);
        btnR19.setText(kor[18]);
        btnR20.setText(kor[19]);
        btnR21.setText(kor[20]);
        btnR22.setText(kor[21]);

        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        ll5 = (LinearLayout) findViewById(R.id.ll5);
        ll6 = (LinearLayout) findViewById(R.id.ll6);
        ll7 = (LinearLayout) findViewById(R.id.ll7);
        ll8 = (LinearLayout) findViewById(R.id.ll8);
        ll9 = (LinearLayout) findViewById(R.id.ll9);
        ll10 = (LinearLayout) findViewById(R.id.ll10);
        ll11 = (LinearLayout) findViewById(R.id.ll11);
        ll12 = (LinearLayout) findViewById(R.id.ll12);
        ll13 = (LinearLayout) findViewById(R.id.ll13);
        ll14 = (LinearLayout) findViewById(R.id.ll14);
        ll15 = (LinearLayout) findViewById(R.id.ll15);
        ll16 = (LinearLayout) findViewById(R.id.ll16);
        ll17 = (LinearLayout) findViewById(R.id.ll17);
        ll18 = (LinearLayout) findViewById(R.id.ll18);
        ll19 = (LinearLayout) findViewById(R.id.ll19);
        ll20 = (LinearLayout) findViewById(R.id.ll20);
        ll21 = (LinearLayout) findViewById(R.id.ll21);
        ll22 = (LinearLayout) findViewById(R.id.ll22);
        ll1.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.INVISIBLE);
        ll4.setVisibility(View.INVISIBLE);
        ll5.setVisibility(View.INVISIBLE);
        ll6.setVisibility(View.INVISIBLE);
        ll7.setVisibility(View.INVISIBLE);
        ll8.setVisibility(View.INVISIBLE);
        ll9.setVisibility(View.INVISIBLE);
        ll10.setVisibility(View.INVISIBLE);
        ll11.setVisibility(View.INVISIBLE);
        ll12.setVisibility(View.INVISIBLE);
        ll13.setVisibility(View.INVISIBLE);
        ll14.setVisibility(View.INVISIBLE);
        ll15.setVisibility(View.INVISIBLE);
        ll16.setVisibility(View.INVISIBLE);
        ll17.setVisibility(View.INVISIBLE);
        ll18.setVisibility(View.INVISIBLE);
        ll19.setVisibility(View.INVISIBLE);
        ll20.setVisibility(View.INVISIBLE);
        ll21.setVisibility(View.INVISIBLE);
        ll22.setVisibility(View.INVISIBLE);

        aniLl1 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl2 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl2.setStartOffset(100);
        aniLl3 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl3.setStartOffset(200);
        aniLl4 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl4.setStartOffset(300);
        aniLl5 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl5.setStartOffset(400);
        aniLl6 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl6.setStartOffset(500);
        aniLl7 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl7.setStartOffset(600);
        aniLl8 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl8.setStartOffset(700);
        aniLl9 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl9.setStartOffset(800);
        aniLl10 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl10.setStartOffset(900);
        aniLl11 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl11.setStartOffset(1000);
        aniLl12 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl12.setStartOffset(1100);
        aniLl13 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl13.setStartOffset(1200);
        aniLl14 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl14.setStartOffset(1300);
        aniLl15 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl15.setStartOffset(1400);
        aniLl16 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl16.setStartOffset(1500);
        aniLl17 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl17.setStartOffset(1600);
        aniLl18 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl18.setStartOffset(1700);
        aniLl19 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl19.setStartOffset(1800);
        aniLl20 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl20.setStartOffset(1900);
        aniLl21 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl21.setStartOffset(2000);
        aniLl22 = AnimationUtils.loadAnimation(VocaSpa_001_1.this, R.anim.fadein);
        aniLl22.setStartOffset(2100);

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

                imgHorizontal.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) imgHorizontal.getDrawable();
                drawable.start();

                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                ll9.setVisibility(View.VISIBLE);
                ll10.setVisibility(View.VISIBLE);
                ll11.setVisibility(View.VISIBLE);
                ll12.setVisibility(View.VISIBLE);
                ll13.setVisibility(View.VISIBLE);
                ll14.setVisibility(View.VISIBLE);
                ll15.setVisibility(View.VISIBLE);
                ll16.setVisibility(View.VISIBLE);
                ll17.setVisibility(View.VISIBLE);
                ll18.setVisibility(View.VISIBLE);
                ll19.setVisibility(View.VISIBLE);
                ll20.setVisibility(View.VISIBLE);
                ll21.setVisibility(View.VISIBLE);
                ll22.setVisibility(View.VISIBLE);
                ll1.startAnimation(aniLl1);
                ll2.startAnimation(aniLl2);
                ll3.startAnimation(aniLl3);
                ll4.startAnimation(aniLl4);
                ll5.startAnimation(aniLl5);
                ll6.startAnimation(aniLl6);
                ll7.startAnimation(aniLl7);
                ll8.startAnimation(aniLl8);
                ll9.startAnimation(aniLl9);
                ll10.startAnimation(aniLl10);
                ll11.startAnimation(aniLl11);
                ll12.startAnimation(aniLl12);
                ll13.startAnimation(aniLl13);
                ll14.startAnimation(aniLl14);
                ll15.startAnimation(aniLl15);
                ll16.startAnimation(aniLl16);
                ll17.startAnimation(aniLl17);
                ll18.startAnimation(aniLl18);
                ll19.startAnimation(aniLl19);
                ll20.startAnimation(aniLl20);
                ll21.startAnimation(aniLl21);
                ll22.startAnimation(aniLl22);

                btnEnd.setVisibility(View.VISIBLE);
                aniBtnEnd = new AlphaAnimation(0.0f, 1.0f);
                aniBtnEnd.setDuration(200);
                aniBtnEnd.setStartOffset(400);
                aniBtnEnd.setRepeatMode(Animation.REVERSE);
                aniBtnEnd.setRepeatCount(Animation.INFINITE);
                btnEnd.startAnimation(aniBtnEnd);
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
        Intent intentBack = new Intent(VocaSpa_001_1.this, VocaSpa.class);
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

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // Footer
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(VocaSpa_001_1.this, MainActivity.class);
                    intentHome.putExtra("username", username);
                    intentHome.putExtra("email", email);
                    intentHome.putExtra("profile", profile);
                    intentHome.putExtra("avatar", avatar);
                    startActivity(intentHome);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    finish();
                    break;
                case R.id.btnUpdate:
                    break;
            }
        }
    };

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

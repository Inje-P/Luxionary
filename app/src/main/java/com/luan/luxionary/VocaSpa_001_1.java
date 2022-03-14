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
    String[] spa = {"la cara", "la cabeza", "el pelo", "la frente", "el ojo",
            "la ceja", "el párpado", "la pestaña", "el iris", "la pupila",
            "la nariz", "la fosa nasal", "la oreja", "la mejilla", "la mandíbula",
            "el diente", "la boca", "el labio", "la barbilla", "la lengua",
            "el bigote", "la barba"};
    String[] kor = {"얼굴", "머리", "머리카락", "이마", "눈",
            "눈썹", "눈커풀", "속눈썹", "홍채", "동공",
            "코", "콧구멍", "귀", "뺨", "아래턱",
            "치아", "입", "입술", "턱", "혀",
            "콧수염", "턱수염"};
    /*
    * -----------------------
    * */

    // Words
    Button btnTop1, btnTop2, btnTop3, btnTop4, btnTop5, btnTop6, btnTop7, btnTop8, btnTop9, btnTop10;
    Button btnTop11, btnTop12, btnTop13, btnTop14, btnTop15, btnTop16, btnTop17, btnTop18, btnTop19, btnTop20;
    Button btnTop21, btnTop22;

    // Translations
    Button btnBot1, btnBot2, btnBot3, btnBot4, btnBot5, btnBot6, btnBot7, btnBot8, btnBot9, btnBot10;
    Button btnBot11, btnBot12, btnBot13, btnBot14, btnBot15, btnBot16, btnBot17, btnBot18, btnBot19, btnBot20;
    Button btnBot21, btnBot22;

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

        btnTop1 = (Button) findViewById(R.id.btnTop1);
        btnTop2 = (Button) findViewById(R.id.btnTop2);
        btnTop3 = (Button) findViewById(R.id.btnTop3);
        btnTop4 = (Button) findViewById(R.id.btnTop4);
        btnTop5 = (Button) findViewById(R.id.btnTop5);
        btnTop6 = (Button) findViewById(R.id.btnTop6);
        btnTop7 = (Button) findViewById(R.id.btnTop7);
        btnTop8 = (Button) findViewById(R.id.btnTop8);
        btnTop9 = (Button) findViewById(R.id.btnTop9);
        btnTop10 = (Button) findViewById(R.id.btnTop10);
        btnTop11 = (Button) findViewById(R.id.btnTop11);
        btnTop12 = (Button) findViewById(R.id.btnTop12);
        btnTop13 = (Button) findViewById(R.id.btnTop13);
        btnTop14 = (Button) findViewById(R.id.btnTop14);
        btnTop15 = (Button) findViewById(R.id.btnTop15);
        btnTop16 = (Button) findViewById(R.id.btnTop16);
        btnTop17 = (Button) findViewById(R.id.btnTop17);
        btnTop18 = (Button) findViewById(R.id.btnTop18);
        btnTop19 = (Button) findViewById(R.id.btnTop19);
        btnTop20 = (Button) findViewById(R.id.btnTop20);
        btnTop21 = (Button) findViewById(R.id.btnTop21);
        btnTop22 = (Button) findViewById(R.id.btnTop22);
        btnTop1.setText(spa[0]);
        btnTop2.setText(spa[1]);
        btnTop3.setText(spa[2]);
        btnTop4.setText(spa[3]);
        btnTop5.setText(spa[4]);
        btnTop6.setText(spa[5]);
        btnTop7.setText(spa[6]);
        btnTop8.setText(spa[7]);
        btnTop9.setText(spa[8]);
        btnTop10.setText(spa[9]);
        btnTop11.setText(spa[10]);
        btnTop12.setText(spa[11]);
        btnTop13.setText(spa[12]);
        btnTop14.setText(spa[13]);
        btnTop15.setText(spa[14]);
        btnTop16.setText(spa[15]);
        btnTop17.setText(spa[16]);
        btnTop18.setText(spa[17]);
        btnTop19.setText(spa[18]);
        btnTop20.setText(spa[19]);
        btnTop21.setText(spa[20]);
        btnTop22.setText(spa[21]);

        btnBot1 = (Button) findViewById(R.id.btnBot1);
        btnBot2 = (Button) findViewById(R.id.btnBot2);
        btnBot3 = (Button) findViewById(R.id.btnBot3);
        btnBot4 = (Button) findViewById(R.id.btnBot4);
        btnBot5 = (Button) findViewById(R.id.btnBot5);
        btnBot6 = (Button) findViewById(R.id.btnBot6);
        btnBot7 = (Button) findViewById(R.id.btnBot7);
        btnBot8 = (Button) findViewById(R.id.btnBot8);
        btnBot9 = (Button) findViewById(R.id.btnBot9);
        btnBot10 = (Button) findViewById(R.id.btnBot10);
        btnBot11 = (Button) findViewById(R.id.btnBot11);
        btnBot12 = (Button) findViewById(R.id.btnBot12);
        btnBot13 = (Button) findViewById(R.id.btnBot13);
        btnBot14 = (Button) findViewById(R.id.btnBot14);
        btnBot15 = (Button) findViewById(R.id.btnBot15);
        btnBot16 = (Button) findViewById(R.id.btnBot16);
        btnBot17 = (Button) findViewById(R.id.btnBot17);
        btnBot18 = (Button) findViewById(R.id.btnBot18);
        btnBot19 = (Button) findViewById(R.id.btnBot19);
        btnBot20 = (Button) findViewById(R.id.btnBot20);
        btnBot21 = (Button) findViewById(R.id.btnBot21);
        btnBot22 = (Button) findViewById(R.id.btnBot22);
        btnBot1.setText(kor[0]);
        btnBot2.setText(kor[1]);
        btnBot3.setText(kor[2]);
        btnBot4.setText(kor[3]);
        btnBot5.setText(kor[4]);
        btnBot6.setText(kor[5]);
        btnBot7.setText(kor[6]);
        btnBot8.setText(kor[7]);
        btnBot9.setText(kor[8]);
        btnBot10.setText(kor[9]);
        btnBot11.setText(kor[10]);
        btnBot12.setText(kor[11]);
        btnBot13.setText(kor[12]);
        btnBot14.setText(kor[13]);
        btnBot15.setText(kor[14]);
        btnBot16.setText(kor[15]);
        btnBot17.setText(kor[16]);
        btnBot18.setText(kor[17]);
        btnBot19.setText(kor[18]);
        btnBot20.setText(kor[19]);
        btnBot21.setText(kor[20]);
        btnBot22.setText(kor[21]);

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

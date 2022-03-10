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

public class VocaEng extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    Button btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    Button btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30;
    Button btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40;
    Button btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50;
    Button btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60;
    Button btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70;
    Button btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78, btn79, btn80;
    Button btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88, btn89, btn90;
    Button btn91, btn92, btn93, btn94, btn95, btn96, btn97, btn98, btn99, btn100;
    Button btn101, btn102, btn103, btn104, btn105;
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
        setContentView(R.layout.voca_eng);

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
                Intent intentAccount = new Intent(VocaEng.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(VocaEng.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(VocaEng.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(VocaEng.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(VocaEng.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(VocaEng.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(VocaEng.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(VocaEng.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

        // Buttons & TextViews
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);
        btn18 = (Button) findViewById(R.id.btn18);
        btn19 = (Button) findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);

        btn21 = (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23 = (Button) findViewById(R.id.btn23);
        btn24 = (Button) findViewById(R.id.btn24);
        btn25 = (Button) findViewById(R.id.btn25);
        btn26 = (Button) findViewById(R.id.btn26);
        btn27 = (Button) findViewById(R.id.btn27);
        btn28 = (Button) findViewById(R.id.btn28);
        btn29 = (Button) findViewById(R.id.btn29);
        btn30 = (Button) findViewById(R.id.btn30);
        btn31 = (Button) findViewById(R.id.btn31);
        btn32 = (Button) findViewById(R.id.btn32);
        btn33 = (Button) findViewById(R.id.btn33);
        btn34 = (Button) findViewById(R.id.btn34);
        btn35 = (Button) findViewById(R.id.btn35);
        btn36 = (Button) findViewById(R.id.btn36);
        btn37 = (Button) findViewById(R.id.btn37);
        btn38 = (Button) findViewById(R.id.btn38);
        btn39 = (Button) findViewById(R.id.btn39);
        btn40 = (Button) findViewById(R.id.btn40);

        btn41 = (Button) findViewById(R.id.btn41);
        btn42 = (Button) findViewById(R.id.btn42);
        btn43 = (Button) findViewById(R.id.btn43);
        btn44 = (Button) findViewById(R.id.btn44);
        btn45 = (Button) findViewById(R.id.btn45);
        btn46 = (Button) findViewById(R.id.btn46);
        btn47 = (Button) findViewById(R.id.btn47);
        btn48 = (Button) findViewById(R.id.btn48);
        btn49 = (Button) findViewById(R.id.btn49);
        btn50 = (Button) findViewById(R.id.btn50);
        btn51 = (Button) findViewById(R.id.btn51);
        btn52 = (Button) findViewById(R.id.btn52);
        btn53 = (Button) findViewById(R.id.btn53);
        btn54 = (Button) findViewById(R.id.btn54);
        btn55 = (Button) findViewById(R.id.btn55);
        btn56 = (Button) findViewById(R.id.btn56);
        btn57 = (Button) findViewById(R.id.btn57);
        btn58 = (Button) findViewById(R.id.btn58);
        btn59 = (Button) findViewById(R.id.btn59);
        btn60 = (Button) findViewById(R.id.btn60);

        btn61 = (Button) findViewById(R.id.btn61);
        btn62 = (Button) findViewById(R.id.btn62);
        btn63 = (Button) findViewById(R.id.btn63);
        btn64 = (Button) findViewById(R.id.btn64);
        btn65 = (Button) findViewById(R.id.btn65);
        btn66 = (Button) findViewById(R.id.btn66);
        btn67 = (Button) findViewById(R.id.btn67);
        btn68 = (Button) findViewById(R.id.btn68);
        btn69 = (Button) findViewById(R.id.btn69);
        btn70 = (Button) findViewById(R.id.btn70);
        btn71 = (Button) findViewById(R.id.btn71);
        btn72 = (Button) findViewById(R.id.btn72);
        btn73 = (Button) findViewById(R.id.btn73);
        btn74 = (Button) findViewById(R.id.btn74);
        btn75 = (Button) findViewById(R.id.btn75);
        btn76 = (Button) findViewById(R.id.btn76);
        btn77 = (Button) findViewById(R.id.btn77);
        btn78 = (Button) findViewById(R.id.btn78);
        btn79 = (Button) findViewById(R.id.btn79);
        btn80 = (Button) findViewById(R.id.btn80);

        btn81 = (Button) findViewById(R.id.btn81);
        btn82 = (Button) findViewById(R.id.btn82);
        btn83 = (Button) findViewById(R.id.btn83);
        btn84 = (Button) findViewById(R.id.btn84);
        btn85 = (Button) findViewById(R.id.btn85);
        btn86 = (Button) findViewById(R.id.btn86);
        btn87 = (Button) findViewById(R.id.btn87);
        btn88 = (Button) findViewById(R.id.btn88);
        btn89 = (Button) findViewById(R.id.btn89);
        btn90 = (Button) findViewById(R.id.btn90);
        btn91 = (Button) findViewById(R.id.btn91);
        btn92 = (Button) findViewById(R.id.btn92);
        btn93 = (Button) findViewById(R.id.btn93);
        btn94 = (Button) findViewById(R.id.btn94);
        btn95 = (Button) findViewById(R.id.btn95);
        btn96 = (Button) findViewById(R.id.btn96);
        btn97 = (Button) findViewById(R.id.btn97);
        btn98 = (Button) findViewById(R.id.btn98);
        btn99 = (Button) findViewById(R.id.btn99);
        btn100 = (Button) findViewById(R.id.btn100);

        btn101 = (Button) findViewById(R.id.btn101);
        btn102 = (Button) findViewById(R.id.btn102);
        btn103 = (Button) findViewById(R.id.btn103);
        btn104 = (Button) findViewById(R.id.btn104);
        btn105 = (Button) findViewById(R.id.btn105);

        btn1.setOnClickListener(mClickListener);
        btn2.setOnClickListener(mClickListener);
        btn3.setOnClickListener(mClickListener);
        btn4.setOnClickListener(mClickListener);
        btn5.setOnClickListener(mClickListener);
        btn6.setOnClickListener(mClickListener);
        btn7.setOnClickListener(mClickListener);
        btn8.setOnClickListener(mClickListener);
        btn9.setOnClickListener(mClickListener);
        btn10.setOnClickListener(mClickListener);
        btn11.setOnClickListener(mClickListener);
        btn12.setOnClickListener(mClickListener);
        btn13.setOnClickListener(mClickListener);
        btn14.setOnClickListener(mClickListener);
        btn15.setOnClickListener(mClickListener);
        btn16.setOnClickListener(mClickListener);
        btn17.setOnClickListener(mClickListener);
        btn18.setOnClickListener(mClickListener);
        btn19.setOnClickListener(mClickListener);
        btn20.setOnClickListener(mClickListener);

        btn21.setOnClickListener(mClickListener);
        btn22.setOnClickListener(mClickListener);
        btn23.setOnClickListener(mClickListener);
        btn24.setOnClickListener(mClickListener);
        btn25.setOnClickListener(mClickListener);
        btn26.setOnClickListener(mClickListener);
        btn27.setOnClickListener(mClickListener);
        btn28.setOnClickListener(mClickListener);
        btn29.setOnClickListener(mClickListener);
        btn30.setOnClickListener(mClickListener);
        btn31.setOnClickListener(mClickListener);
        btn32.setOnClickListener(mClickListener);
        btn33.setOnClickListener(mClickListener);
        btn34.setOnClickListener(mClickListener);
        btn35.setOnClickListener(mClickListener);
        btn36.setOnClickListener(mClickListener);
        btn37.setOnClickListener(mClickListener);
        btn38.setOnClickListener(mClickListener);
        btn39.setOnClickListener(mClickListener);
        btn40.setOnClickListener(mClickListener);

        btn41.setOnClickListener(mClickListener);
        btn42.setOnClickListener(mClickListener);
        btn43.setOnClickListener(mClickListener);
        btn44.setOnClickListener(mClickListener);
        btn45.setOnClickListener(mClickListener);
        btn46.setOnClickListener(mClickListener);
        btn47.setOnClickListener(mClickListener);
        btn48.setOnClickListener(mClickListener);
        btn49.setOnClickListener(mClickListener);
        btn50.setOnClickListener(mClickListener);
        btn51.setOnClickListener(mClickListener);
        btn52.setOnClickListener(mClickListener);
        btn53.setOnClickListener(mClickListener);
        btn54.setOnClickListener(mClickListener);
        btn55.setOnClickListener(mClickListener);
        btn56.setOnClickListener(mClickListener);
        btn57.setOnClickListener(mClickListener);
        btn58.setOnClickListener(mClickListener);
        btn59.setOnClickListener(mClickListener);
        btn60.setOnClickListener(mClickListener);

        btn61.setOnClickListener(mClickListener);
        btn62.setOnClickListener(mClickListener);
        btn63.setOnClickListener(mClickListener);
        btn64.setOnClickListener(mClickListener);
        btn65.setOnClickListener(mClickListener);
        btn66.setOnClickListener(mClickListener);
        btn67.setOnClickListener(mClickListener);
        btn68.setOnClickListener(mClickListener);
        btn69.setOnClickListener(mClickListener);
        btn70.setOnClickListener(mClickListener);
        btn71.setOnClickListener(mClickListener);
        btn72.setOnClickListener(mClickListener);
        btn73.setOnClickListener(mClickListener);
        btn74.setOnClickListener(mClickListener);
        btn75.setOnClickListener(mClickListener);
        btn76.setOnClickListener(mClickListener);
        btn77.setOnClickListener(mClickListener);
        btn78.setOnClickListener(mClickListener);
        btn79.setOnClickListener(mClickListener);
        btn80.setOnClickListener(mClickListener);

        btn81.setOnClickListener(mClickListener);
        btn82.setOnClickListener(mClickListener);
        btn83.setOnClickListener(mClickListener);
        btn84.setOnClickListener(mClickListener);
        btn85.setOnClickListener(mClickListener);
        btn86.setOnClickListener(mClickListener);
        btn87.setOnClickListener(mClickListener);
        btn88.setOnClickListener(mClickListener);
        btn89.setOnClickListener(mClickListener);
        btn90.setOnClickListener(mClickListener);
        btn91.setOnClickListener(mClickListener);
        btn92.setOnClickListener(mClickListener);
        btn93.setOnClickListener(mClickListener);
        btn94.setOnClickListener(mClickListener);
        btn95.setOnClickListener(mClickListener);
        btn96.setOnClickListener(mClickListener);
        btn97.setOnClickListener(mClickListener);
        btn98.setOnClickListener(mClickListener);
        btn99.setOnClickListener(mClickListener);
        btn100.setOnClickListener(mClickListener);

        btn101.setOnClickListener(mClickListener);
        btn102.setOnClickListener(mClickListener);
        btn103.setOnClickListener(mClickListener);
        btn104.setOnClickListener(mClickListener);
        btn105.setOnClickListener(mClickListener);

        setColorStateList(btn1, ContextCompat.getColor(this, R.color.eng_background), btn1.getCurrentTextColor());
        setColorStateList(btn2, ContextCompat.getColor(this, R.color.eng_background), btn2.getCurrentTextColor());
        setColorStateList(btn3, ContextCompat.getColor(this, R.color.eng_background), btn3.getCurrentTextColor());
        setColorStateList(btn4, ContextCompat.getColor(this, R.color.eng_background), btn4.getCurrentTextColor());
        setColorStateList(btn5, ContextCompat.getColor(this, R.color.eng_background), btn5.getCurrentTextColor());
        setColorStateList(btn6, ContextCompat.getColor(this, R.color.eng_background), btn6.getCurrentTextColor());
        setColorStateList(btn7, ContextCompat.getColor(this, R.color.eng_background), btn7.getCurrentTextColor());
        setColorStateList(btn8, ContextCompat.getColor(this, R.color.eng_background), btn8.getCurrentTextColor());
        setColorStateList(btn9, ContextCompat.getColor(this, R.color.eng_background), btn9.getCurrentTextColor());
        setColorStateList(btn10, ContextCompat.getColor(this, R.color.eng_background), btn10.getCurrentTextColor());
        setColorStateList(btn11, ContextCompat.getColor(this, R.color.eng_background), btn11.getCurrentTextColor());
        setColorStateList(btn12, ContextCompat.getColor(this, R.color.eng_background), btn12.getCurrentTextColor());
        setColorStateList(btn13, ContextCompat.getColor(this, R.color.eng_background), btn13.getCurrentTextColor());
        setColorStateList(btn14, ContextCompat.getColor(this, R.color.eng_background), btn14.getCurrentTextColor());
        setColorStateList(btn15, ContextCompat.getColor(this, R.color.eng_background), btn15.getCurrentTextColor());
        setColorStateList(btn16, ContextCompat.getColor(this, R.color.eng_background), btn16.getCurrentTextColor());
        setColorStateList(btn17, ContextCompat.getColor(this, R.color.eng_background), btn17.getCurrentTextColor());
        setColorStateList(btn18, ContextCompat.getColor(this, R.color.eng_background), btn18.getCurrentTextColor());
        setColorStateList(btn19, ContextCompat.getColor(this, R.color.eng_background), btn19.getCurrentTextColor());
        setColorStateList(btn20, ContextCompat.getColor(this, R.color.eng_background), btn20.getCurrentTextColor());

        setColorStateList(btn21, ContextCompat.getColor(this, R.color.eng_background), btn21.getCurrentTextColor());
        setColorStateList(btn22, ContextCompat.getColor(this, R.color.eng_background), btn22.getCurrentTextColor());
        setColorStateList(btn23, ContextCompat.getColor(this, R.color.eng_background), btn23.getCurrentTextColor());
        setColorStateList(btn24, ContextCompat.getColor(this, R.color.eng_background), btn24.getCurrentTextColor());
        setColorStateList(btn25, ContextCompat.getColor(this, R.color.eng_background), btn25.getCurrentTextColor());
        setColorStateList(btn26, ContextCompat.getColor(this, R.color.eng_background), btn26.getCurrentTextColor());
        setColorStateList(btn27, ContextCompat.getColor(this, R.color.eng_background), btn27.getCurrentTextColor());
        setColorStateList(btn28, ContextCompat.getColor(this, R.color.eng_background), btn28.getCurrentTextColor());
        setColorStateList(btn29, ContextCompat.getColor(this, R.color.eng_background), btn29.getCurrentTextColor());
        setColorStateList(btn30, ContextCompat.getColor(this, R.color.eng_background), btn30.getCurrentTextColor());
        setColorStateList(btn31, ContextCompat.getColor(this, R.color.eng_background), btn31.getCurrentTextColor());
        setColorStateList(btn32, ContextCompat.getColor(this, R.color.eng_background), btn32.getCurrentTextColor());
        setColorStateList(btn33, ContextCompat.getColor(this, R.color.eng_background), btn33.getCurrentTextColor());
        setColorStateList(btn34, ContextCompat.getColor(this, R.color.eng_background), btn34.getCurrentTextColor());
        setColorStateList(btn35, ContextCompat.getColor(this, R.color.eng_background), btn35.getCurrentTextColor());
        setColorStateList(btn36, ContextCompat.getColor(this, R.color.eng_background), btn36.getCurrentTextColor());
        setColorStateList(btn37, ContextCompat.getColor(this, R.color.eng_background), btn37.getCurrentTextColor());
        setColorStateList(btn38, ContextCompat.getColor(this, R.color.eng_background), btn38.getCurrentTextColor());
        setColorStateList(btn39, ContextCompat.getColor(this, R.color.eng_background), btn39.getCurrentTextColor());
        setColorStateList(btn40, ContextCompat.getColor(this, R.color.eng_background), btn40.getCurrentTextColor());

        setColorStateList(btn41, ContextCompat.getColor(this, R.color.eng_background), btn41.getCurrentTextColor());
        setColorStateList(btn42, ContextCompat.getColor(this, R.color.eng_background), btn42.getCurrentTextColor());
        setColorStateList(btn43, ContextCompat.getColor(this, R.color.eng_background), btn43.getCurrentTextColor());
        setColorStateList(btn44, ContextCompat.getColor(this, R.color.eng_background), btn44.getCurrentTextColor());
        setColorStateList(btn45, ContextCompat.getColor(this, R.color.eng_background), btn45.getCurrentTextColor());
        setColorStateList(btn46, ContextCompat.getColor(this, R.color.eng_background), btn46.getCurrentTextColor());
        setColorStateList(btn47, ContextCompat.getColor(this, R.color.eng_background), btn47.getCurrentTextColor());
        setColorStateList(btn48, ContextCompat.getColor(this, R.color.eng_background), btn48.getCurrentTextColor());
        setColorStateList(btn49, ContextCompat.getColor(this, R.color.eng_background), btn49.getCurrentTextColor());
        setColorStateList(btn50, ContextCompat.getColor(this, R.color.eng_background), btn50.getCurrentTextColor());
        setColorStateList(btn51, ContextCompat.getColor(this, R.color.eng_background), btn51.getCurrentTextColor());
        setColorStateList(btn52, ContextCompat.getColor(this, R.color.eng_background), btn52.getCurrentTextColor());
        setColorStateList(btn53, ContextCompat.getColor(this, R.color.eng_background), btn53.getCurrentTextColor());
        setColorStateList(btn54, ContextCompat.getColor(this, R.color.eng_background), btn54.getCurrentTextColor());
        setColorStateList(btn55, ContextCompat.getColor(this, R.color.eng_background), btn55.getCurrentTextColor());
        setColorStateList(btn56, ContextCompat.getColor(this, R.color.eng_background), btn56.getCurrentTextColor());
        setColorStateList(btn57, ContextCompat.getColor(this, R.color.eng_background), btn57.getCurrentTextColor());
        setColorStateList(btn58, ContextCompat.getColor(this, R.color.eng_background), btn58.getCurrentTextColor());
        setColorStateList(btn59, ContextCompat.getColor(this, R.color.eng_background), btn59.getCurrentTextColor());
        setColorStateList(btn60, ContextCompat.getColor(this, R.color.eng_background), btn60.getCurrentTextColor());

        setColorStateList(btn61, ContextCompat.getColor(this, R.color.eng_background), btn61.getCurrentTextColor());
        setColorStateList(btn62, ContextCompat.getColor(this, R.color.eng_background), btn62.getCurrentTextColor());
        setColorStateList(btn63, ContextCompat.getColor(this, R.color.eng_background), btn63.getCurrentTextColor());
        setColorStateList(btn64, ContextCompat.getColor(this, R.color.eng_background), btn64.getCurrentTextColor());
        setColorStateList(btn65, ContextCompat.getColor(this, R.color.eng_background), btn65.getCurrentTextColor());
        setColorStateList(btn66, ContextCompat.getColor(this, R.color.eng_background), btn66.getCurrentTextColor());
        setColorStateList(btn67, ContextCompat.getColor(this, R.color.eng_background), btn67.getCurrentTextColor());
        setColorStateList(btn68, ContextCompat.getColor(this, R.color.eng_background), btn68.getCurrentTextColor());
        setColorStateList(btn69, ContextCompat.getColor(this, R.color.eng_background), btn69.getCurrentTextColor());
        setColorStateList(btn70, ContextCompat.getColor(this, R.color.eng_background), btn70.getCurrentTextColor());
        setColorStateList(btn71, ContextCompat.getColor(this, R.color.eng_background), btn71.getCurrentTextColor());
        setColorStateList(btn72, ContextCompat.getColor(this, R.color.eng_background), btn72.getCurrentTextColor());
        setColorStateList(btn73, ContextCompat.getColor(this, R.color.eng_background), btn73.getCurrentTextColor());
        setColorStateList(btn74, ContextCompat.getColor(this, R.color.eng_background), btn74.getCurrentTextColor());
        setColorStateList(btn75, ContextCompat.getColor(this, R.color.eng_background), btn75.getCurrentTextColor());
        setColorStateList(btn76, ContextCompat.getColor(this, R.color.eng_background), btn76.getCurrentTextColor());
        setColorStateList(btn77, ContextCompat.getColor(this, R.color.eng_background), btn77.getCurrentTextColor());
        setColorStateList(btn78, ContextCompat.getColor(this, R.color.eng_background), btn78.getCurrentTextColor());
        setColorStateList(btn79, ContextCompat.getColor(this, R.color.eng_background), btn79.getCurrentTextColor());
        setColorStateList(btn80, ContextCompat.getColor(this, R.color.eng_background), btn80.getCurrentTextColor());

        setColorStateList(btn81, ContextCompat.getColor(this, R.color.eng_background), btn81.getCurrentTextColor());
        setColorStateList(btn82, ContextCompat.getColor(this, R.color.eng_background), btn82.getCurrentTextColor());
        setColorStateList(btn83, ContextCompat.getColor(this, R.color.eng_background), btn83.getCurrentTextColor());
        setColorStateList(btn84, ContextCompat.getColor(this, R.color.eng_background), btn84.getCurrentTextColor());
        setColorStateList(btn85, ContextCompat.getColor(this, R.color.eng_background), btn85.getCurrentTextColor());
        setColorStateList(btn86, ContextCompat.getColor(this, R.color.eng_background), btn86.getCurrentTextColor());
        setColorStateList(btn87, ContextCompat.getColor(this, R.color.eng_background), btn87.getCurrentTextColor());
        setColorStateList(btn88, ContextCompat.getColor(this, R.color.eng_background), btn88.getCurrentTextColor());
        setColorStateList(btn89, ContextCompat.getColor(this, R.color.eng_background), btn89.getCurrentTextColor());
        setColorStateList(btn90, ContextCompat.getColor(this, R.color.eng_background), btn90.getCurrentTextColor());
        setColorStateList(btn91, ContextCompat.getColor(this, R.color.eng_background), btn91.getCurrentTextColor());
        setColorStateList(btn92, ContextCompat.getColor(this, R.color.eng_background), btn92.getCurrentTextColor());
        setColorStateList(btn93, ContextCompat.getColor(this, R.color.eng_background), btn93.getCurrentTextColor());
        setColorStateList(btn94, ContextCompat.getColor(this, R.color.eng_background), btn94.getCurrentTextColor());
        setColorStateList(btn95, ContextCompat.getColor(this, R.color.eng_background), btn95.getCurrentTextColor());
        setColorStateList(btn96, ContextCompat.getColor(this, R.color.eng_background), btn96.getCurrentTextColor());
        setColorStateList(btn97, ContextCompat.getColor(this, R.color.eng_background), btn97.getCurrentTextColor());
        setColorStateList(btn98, ContextCompat.getColor(this, R.color.eng_background), btn98.getCurrentTextColor());
        setColorStateList(btn99, ContextCompat.getColor(this, R.color.eng_background), btn99.getCurrentTextColor());
        setColorStateList(btn100, ContextCompat.getColor(this, R.color.eng_background), btn100.getCurrentTextColor());

        setColorStateList(btn101, ContextCompat.getColor(this, R.color.eng_background), btn101.getCurrentTextColor());
        setColorStateList(btn102, ContextCompat.getColor(this, R.color.eng_background), btn102.getCurrentTextColor());
        setColorStateList(btn103, ContextCompat.getColor(this, R.color.eng_background), btn103.getCurrentTextColor());
        setColorStateList(btn104, ContextCompat.getColor(this, R.color.eng_background), btn104.getCurrentTextColor());
        setColorStateList(btn105, ContextCompat.getColor(this, R.color.eng_background), btn105.getCurrentTextColor());

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
        Intent intentBack = new Intent(VocaEng.this, MainEng.class);
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
                // Button 1 - 20
                case R.id.btn1:
                    btn1.startAnimation(aniTouch);
                    page001();
                    break;
                case R.id.btn2:
                    btn2.startAnimation(aniTouch);
                    break;
                case R.id.btn3:
                    btn3.startAnimation(aniTouch);
                    break;
                case R.id.btn4:
                    btn4.startAnimation(aniTouch);
                    break;
                case R.id.btn5:
                    btn5.startAnimation(aniTouch);
                    break;
                case R.id.btn6:
                    btn6.startAnimation(aniTouch);
                    break;
                case R.id.btn7:
                    btn7.startAnimation(aniTouch);
                    break;
                case R.id.btn8:
                    btn8.startAnimation(aniTouch);
                    break;
                case R.id.btn9:
                    btn9.startAnimation(aniTouch);
                    break;
                case R.id.btn10:
                    btn10.startAnimation(aniTouch);
                    break;
                case R.id.btn11:
                    btn11.startAnimation(aniTouch);
                    break;
                case R.id.btn12:
                    btn12.startAnimation(aniTouch);
                    break;
                case R.id.btn13:
                    btn13.startAnimation(aniTouch);
                    break;
                case R.id.btn14:
                    btn14.startAnimation(aniTouch);
                    break;
                case R.id.btn15:
                    btn15.startAnimation(aniTouch);
                    break;
                case R.id.btn16:
                    btn16.startAnimation(aniTouch);
                    break;
                case R.id.btn17:
                    btn17.startAnimation(aniTouch);
                    break;
                case R.id.btn18:
                    btn18.startAnimation(aniTouch);
                    break;
                case R.id.btn19:
                    btn19.startAnimation(aniTouch);
                    break;
                case R.id.btn20:
                    btn20.startAnimation(aniTouch);
                    break;
                // Button 21 - 40
                case R.id.btn21:
                    btn21.startAnimation(aniTouch);
                    break;
                case R.id.btn22:
                    btn22.startAnimation(aniTouch);
                    break;
                case R.id.btn23:
                    btn23.startAnimation(aniTouch);
                    break;
                case R.id.btn24:
                    btn24.startAnimation(aniTouch);
                    break;
                case R.id.btn25:
                    btn25.startAnimation(aniTouch);
                    break;
                case R.id.btn26:
                    btn26.startAnimation(aniTouch);
                    break;
                case R.id.btn27:
                    btn27.startAnimation(aniTouch);
                    break;
                case R.id.btn28:
                    btn28.startAnimation(aniTouch);
                    break;
                case R.id.btn29:
                    btn29.startAnimation(aniTouch);
                    break;
                case R.id.btn30:
                    btn30.startAnimation(aniTouch);
                    break;
                case R.id.btn31:
                    btn31.startAnimation(aniTouch);
                    break;
                case R.id.btn32:
                    btn32.startAnimation(aniTouch);
                    break;
                case R.id.btn33:
                    btn33.startAnimation(aniTouch);
                    break;
                case R.id.btn34:
                    btn34.startAnimation(aniTouch);
                    break;
                case R.id.btn35:
                    btn35.startAnimation(aniTouch);
                    break;
                case R.id.btn36:
                    btn36.startAnimation(aniTouch);
                    break;
                case R.id.btn37:
                    btn37.startAnimation(aniTouch);
                    break;
                case R.id.btn38:
                    btn38.startAnimation(aniTouch);
                    break;
                case R.id.btn39:
                    btn39.startAnimation(aniTouch);
                    break;
                case R.id.btn40:
                    btn40.startAnimation(aniTouch);
                    break;
                // Button 41 - 60
                case R.id.btn41:
                    btn41.startAnimation(aniTouch);
                    break;
                case R.id.btn42:
                    btn42.startAnimation(aniTouch);
                    break;
                case R.id.btn43:
                    btn43.startAnimation(aniTouch);
                    break;
                case R.id.btn44:
                    btn44.startAnimation(aniTouch);
                    break;
                case R.id.btn45:
                    btn45.startAnimation(aniTouch);
                    break;
                case R.id.btn46:
                    btn46.startAnimation(aniTouch);
                    break;
                case R.id.btn47:
                    btn47.startAnimation(aniTouch);
                    break;
                case R.id.btn48:
                    btn48.startAnimation(aniTouch);
                    break;
                case R.id.btn49:
                    btn49.startAnimation(aniTouch);
                    break;
                case R.id.btn50:
                    btn50.startAnimation(aniTouch);
                    break;
                case R.id.btn51:
                    btn51.startAnimation(aniTouch);
                    break;
                case R.id.btn52:
                    btn52.startAnimation(aniTouch);
                    break;
                case R.id.btn53:
                    btn53.startAnimation(aniTouch);
                    break;
                case R.id.btn54:
                    btn54.startAnimation(aniTouch);
                    break;
                case R.id.btn55:
                    btn55.startAnimation(aniTouch);
                    break;
                case R.id.btn56:
                    btn56.startAnimation(aniTouch);
                    break;
                case R.id.btn57:
                    btn57.startAnimation(aniTouch);
                    break;
                case R.id.btn58:
                    btn58.startAnimation(aniTouch);
                    break;
                case R.id.btn59:
                    btn59.startAnimation(aniTouch);
                    break;
                case R.id.btn60:
                    btn60.startAnimation(aniTouch);
                    break;
                // Button 61 - 80
                case R.id.btn61:
                    btn61.startAnimation(aniTouch);
                    break;
                case R.id.btn62:
                    btn62.startAnimation(aniTouch);
                    break;
                case R.id.btn63:
                    btn63.startAnimation(aniTouch);
                    break;
                case R.id.btn64:
                    btn64.startAnimation(aniTouch);
                    break;
                case R.id.btn65:
                    btn65.startAnimation(aniTouch);
                    break;
                case R.id.btn66:
                    btn66.startAnimation(aniTouch);
                    break;
                case R.id.btn67:
                    btn67.startAnimation(aniTouch);
                    break;
                case R.id.btn68:
                    btn68.startAnimation(aniTouch);
                    break;
                case R.id.btn69:
                    btn69.startAnimation(aniTouch);
                    break;
                case R.id.btn70:
                    btn70.startAnimation(aniTouch);
                    break;
                case R.id.btn71:
                    btn71.startAnimation(aniTouch);
                    break;
                case R.id.btn72:
                    btn72.startAnimation(aniTouch);
                    break;
                case R.id.btn73:
                    btn73.startAnimation(aniTouch);
                    break;
                case R.id.btn74:
                    btn74.startAnimation(aniTouch);
                    break;
                case R.id.btn75:
                    btn75.startAnimation(aniTouch);
                    break;
                case R.id.btn76:
                    btn76.startAnimation(aniTouch);
                    break;
                case R.id.btn77:
                    btn77.startAnimation(aniTouch);
                    break;
                case R.id.btn78:
                    btn78.startAnimation(aniTouch);
                    break;
                case R.id.btn79:
                    btn79.startAnimation(aniTouch);
                    break;
                case R.id.btn80:
                    btn80.startAnimation(aniTouch);
                    break;
                // Button 81 - 100
                case R.id.btn81:
                    btn81.startAnimation(aniTouch);
                    break;
                case R.id.btn82:
                    btn82.startAnimation(aniTouch);
                    break;
                case R.id.btn83:
                    btn83.startAnimation(aniTouch);
                    break;
                case R.id.btn84:
                    btn84.startAnimation(aniTouch);
                    break;
                case R.id.btn85:
                    btn85.startAnimation(aniTouch);
                    break;
                case R.id.btn86:
                    btn86.startAnimation(aniTouch);
                    break;
                case R.id.btn87:
                    btn87.startAnimation(aniTouch);
                    break;
                case R.id.btn88:
                    btn88.startAnimation(aniTouch);
                    break;
                case R.id.btn89:
                    btn89.startAnimation(aniTouch);
                    break;
                case R.id.btn90:
                    btn90.startAnimation(aniTouch);
                    break;
                case R.id.btn91:
                    btn91.startAnimation(aniTouch);
                    break;
                case R.id.btn92:
                    btn92.startAnimation(aniTouch);
                    break;
                case R.id.btn93:
                    btn93.startAnimation(aniTouch);
                    break;
                case R.id.btn94:
                    btn94.startAnimation(aniTouch);
                    break;
                case R.id.btn95:
                    btn95.startAnimation(aniTouch);
                    break;
                case R.id.btn96:
                    btn96.startAnimation(aniTouch);
                    break;
                case R.id.btn97:
                    btn97.startAnimation(aniTouch);
                    break;
                case R.id.btn98:
                    btn98.startAnimation(aniTouch);
                    break;
                case R.id.btn99:
                    btn99.startAnimation(aniTouch);
                    break;
                case R.id.btn100:
                    btn100.startAnimation(aniTouch);
                    break;
                // Button 101 - 110
                case R.id.btn101:
                    btn101.startAnimation(aniTouch);
                    break;
                case R.id.btn102:
                    btn102.startAnimation(aniTouch);
                    break;
                case R.id.btn103:
                    btn103.startAnimation(aniTouch);
                    break;
                case R.id.btn104:
                    btn104.startAnimation(aniTouch);
                    break;
                case R.id.btn105:
                    btn105.startAnimation(aniTouch);
                    break;
                // Bottom Menu
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(VocaEng.this, MainActivity.class);
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

    public void page001() {
        Intent intent001 = new Intent(VocaEng.this, Lang101Eng_01_1.class);
        intent001.putExtra("username", username);
        intent001.putExtra("email", email);
        intent001.putExtra("profile", profile);
        intent001.putExtra("avatar", avatar);
        startActivity(intent001);
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
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

public class ConjEng extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    Button btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    Button btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30;
    Button btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40;
    Button btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50;
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

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conj_eng);

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
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(ConjEng.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(ConjEng.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(ConjEng.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(ConjEng.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(ConjEng.this, R.anim.fadein);
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

        setColorStateList(btn1, ContextCompat.getColor(this, R.color.eng_dark), btn1.getCurrentTextColor());
        setColorStateList(btn2, ContextCompat.getColor(this, R.color.eng_dark), btn2.getCurrentTextColor());
        setColorStateList(btn3, ContextCompat.getColor(this, R.color.eng_dark), btn3.getCurrentTextColor());
        setColorStateList(btn4, ContextCompat.getColor(this, R.color.eng_dark), btn4.getCurrentTextColor());
        setColorStateList(btn5, ContextCompat.getColor(this, R.color.eng_dark), btn5.getCurrentTextColor());
        setColorStateList(btn6, ContextCompat.getColor(this, R.color.eng_dark), btn6.getCurrentTextColor());
        setColorStateList(btn7, ContextCompat.getColor(this, R.color.eng_dark), btn7.getCurrentTextColor());
        setColorStateList(btn8, ContextCompat.getColor(this, R.color.eng_dark), btn8.getCurrentTextColor());
        setColorStateList(btn9, ContextCompat.getColor(this, R.color.eng_dark), btn9.getCurrentTextColor());
        setColorStateList(btn10, ContextCompat.getColor(this, R.color.eng_dark), btn10.getCurrentTextColor());
        setColorStateList(btn11, ContextCompat.getColor(this, R.color.eng_dark), btn11.getCurrentTextColor());
        setColorStateList(btn12, ContextCompat.getColor(this, R.color.eng_dark), btn12.getCurrentTextColor());
        setColorStateList(btn13, ContextCompat.getColor(this, R.color.eng_dark), btn13.getCurrentTextColor());
        setColorStateList(btn14, ContextCompat.getColor(this, R.color.eng_dark), btn14.getCurrentTextColor());
        setColorStateList(btn15, ContextCompat.getColor(this, R.color.eng_dark), btn15.getCurrentTextColor());
        setColorStateList(btn16, ContextCompat.getColor(this, R.color.eng_dark), btn16.getCurrentTextColor());
        setColorStateList(btn17, ContextCompat.getColor(this, R.color.eng_dark), btn17.getCurrentTextColor());
        setColorStateList(btn18, ContextCompat.getColor(this, R.color.eng_dark), btn18.getCurrentTextColor());
        setColorStateList(btn19, ContextCompat.getColor(this, R.color.eng_dark), btn19.getCurrentTextColor());
        setColorStateList(btn20, ContextCompat.getColor(this, R.color.eng_dark), btn20.getCurrentTextColor());

        setColorStateList(btn21, ContextCompat.getColor(this, R.color.eng_dark), btn21.getCurrentTextColor());
        setColorStateList(btn22, ContextCompat.getColor(this, R.color.eng_dark), btn22.getCurrentTextColor());
        setColorStateList(btn23, ContextCompat.getColor(this, R.color.eng_dark), btn23.getCurrentTextColor());
        setColorStateList(btn24, ContextCompat.getColor(this, R.color.eng_dark), btn24.getCurrentTextColor());
        setColorStateList(btn25, ContextCompat.getColor(this, R.color.eng_dark), btn25.getCurrentTextColor());
        setColorStateList(btn26, ContextCompat.getColor(this, R.color.eng_dark), btn26.getCurrentTextColor());
        setColorStateList(btn27, ContextCompat.getColor(this, R.color.eng_dark), btn27.getCurrentTextColor());
        setColorStateList(btn28, ContextCompat.getColor(this, R.color.eng_dark), btn28.getCurrentTextColor());
        setColorStateList(btn29, ContextCompat.getColor(this, R.color.eng_dark), btn29.getCurrentTextColor());
        setColorStateList(btn30, ContextCompat.getColor(this, R.color.eng_dark), btn30.getCurrentTextColor());
        setColorStateList(btn31, ContextCompat.getColor(this, R.color.eng_dark), btn31.getCurrentTextColor());
        setColorStateList(btn32, ContextCompat.getColor(this, R.color.eng_dark), btn32.getCurrentTextColor());
        setColorStateList(btn33, ContextCompat.getColor(this, R.color.eng_dark), btn33.getCurrentTextColor());
        setColorStateList(btn34, ContextCompat.getColor(this, R.color.eng_dark), btn34.getCurrentTextColor());
        setColorStateList(btn35, ContextCompat.getColor(this, R.color.eng_dark), btn35.getCurrentTextColor());
        setColorStateList(btn36, ContextCompat.getColor(this, R.color.eng_dark), btn36.getCurrentTextColor());
        setColorStateList(btn37, ContextCompat.getColor(this, R.color.eng_dark), btn37.getCurrentTextColor());
        setColorStateList(btn38, ContextCompat.getColor(this, R.color.eng_dark), btn38.getCurrentTextColor());
        setColorStateList(btn39, ContextCompat.getColor(this, R.color.eng_dark), btn39.getCurrentTextColor());
        setColorStateList(btn40, ContextCompat.getColor(this, R.color.eng_dark), btn40.getCurrentTextColor());

        setColorStateList(btn41, ContextCompat.getColor(this, R.color.eng_dark), btn41.getCurrentTextColor());
        setColorStateList(btn42, ContextCompat.getColor(this, R.color.eng_dark), btn42.getCurrentTextColor());
        setColorStateList(btn43, ContextCompat.getColor(this, R.color.eng_dark), btn43.getCurrentTextColor());
        setColorStateList(btn44, ContextCompat.getColor(this, R.color.eng_dark), btn44.getCurrentTextColor());
        setColorStateList(btn45, ContextCompat.getColor(this, R.color.eng_dark), btn45.getCurrentTextColor());
        setColorStateList(btn46, ContextCompat.getColor(this, R.color.eng_dark), btn46.getCurrentTextColor());
        setColorStateList(btn47, ContextCompat.getColor(this, R.color.eng_dark), btn47.getCurrentTextColor());
        setColorStateList(btn48, ContextCompat.getColor(this, R.color.eng_dark), btn48.getCurrentTextColor());
        setColorStateList(btn49, ContextCompat.getColor(this, R.color.eng_dark), btn49.getCurrentTextColor());
        setColorStateList(btn50, ContextCompat.getColor(this, R.color.eng_dark), btn50.getCurrentTextColor());

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
        Intent intentBack = new Intent(ConjEng.this, MainEng.class);
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
                // Bottom Menu
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(ConjEng.this, MainActivity.class);
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

    public void page001() {
        Intent intent01 = new Intent(ConjEng.this, Lang101Eng_01_1.class);
        intent01.putExtra("nick", strNick);
        intent01.putExtra("pw", strPw);
        intent01.putExtra("name", strName);
        intent01.putExtra("email", strEmail);
        intent01.putExtra("avatar", strAvatar);
        startActivity(intent01);
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
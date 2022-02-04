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

public class Lang101Fra extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    Button btnFra1, btnFra2, btnFra3, btnFra4, btnFra5, btnFra6, btnFra7, btnFra8;
    Button btnFra9, btnFra10, btnFra11, btnFra12, btnFra13, btnFra14, btnFra15;
    LinearLayout layoutProfile;
    LinearLayout llFra1, llFra2, llFra3, llFra4, llFra5, llFra6, llFra7, llFra8;
    LinearLayout llFra9, llFra10, llFra11, llFra12, llFra13, llFra14, llFra15;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
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
        setContentView(R.layout.lang101_fra);

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
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLayoutProfile.setStartOffset(600);
        layoutProfile.startAnimation(aniLayoutProfile);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.scale);

        // Buttons & TextViews
        btnFra1 = (Button) findViewById(R.id.btnFra1);
        btnFra2 = (Button) findViewById(R.id.btnFra2);
        btnFra3 = (Button) findViewById(R.id.btnFra3);
        btnFra4 = (Button) findViewById(R.id.btnFra4);
        btnFra5 = (Button) findViewById(R.id.btnFra5);
        btnFra6 = (Button) findViewById(R.id.btnFra6);
        btnFra7 = (Button) findViewById(R.id.btnFra7);
        btnFra8 = (Button) findViewById(R.id.btnFra8);
        btnFra9 = (Button) findViewById(R.id.btnFra9);
        btnFra10 = (Button) findViewById(R.id.btnFra10);
        btnFra11 = (Button) findViewById(R.id.btnFra11);
        btnFra12 = (Button) findViewById(R.id.btnFra12);
        btnFra13 = (Button) findViewById(R.id.btnFra13);
        btnFra14 = (Button) findViewById(R.id.btnFra14);
        btnFra15 = (Button) findViewById(R.id.btnFra15);
        btnFra1.setOnClickListener(mClickListener);
        btnFra2.setOnClickListener(mClickListener);
        btnFra3.setOnClickListener(mClickListener);
        btnFra4.setOnClickListener(mClickListener);
        btnFra5.setOnClickListener(mClickListener);
        btnFra6.setOnClickListener(mClickListener);
        btnFra7.setOnClickListener(mClickListener);
        btnFra8.setOnClickListener(mClickListener);
        btnFra9.setOnClickListener(mClickListener);
        btnFra10.setOnClickListener(mClickListener);
        btnFra11.setOnClickListener(mClickListener);
        btnFra12.setOnClickListener(mClickListener);
        btnFra13.setOnClickListener(mClickListener);
        btnFra14.setOnClickListener(mClickListener);
        btnFra15.setOnClickListener(mClickListener);
        setColorStateList(btnFra1, ContextCompat.getColor(this, R.color.fra_dark), btnFra1.getCurrentTextColor());
        setColorStateList(btnFra2, ContextCompat.getColor(this, R.color.fra_dark), btnFra2.getCurrentTextColor());
        setColorStateList(btnFra3, ContextCompat.getColor(this, R.color.fra_dark), btnFra3.getCurrentTextColor());
        setColorStateList(btnFra4, ContextCompat.getColor(this, R.color.fra_dark), btnFra4.getCurrentTextColor());
        setColorStateList(btnFra5, ContextCompat.getColor(this, R.color.fra_dark), btnFra5.getCurrentTextColor());
        setColorStateList(btnFra6, ContextCompat.getColor(this, R.color.fra_dark), btnFra6.getCurrentTextColor());
        setColorStateList(btnFra7, ContextCompat.getColor(this, R.color.fra_dark), btnFra7.getCurrentTextColor());
        setColorStateList(btnFra8, ContextCompat.getColor(this, R.color.fra_dark), btnFra8.getCurrentTextColor());
        setColorStateList(btnFra9, ContextCompat.getColor(this, R.color.fra_dark), btnFra9.getCurrentTextColor());
        setColorStateList(btnFra10, ContextCompat.getColor(this, R.color.fra_dark), btnFra10.getCurrentTextColor());
        setColorStateList(btnFra11, ContextCompat.getColor(this, R.color.fra_dark), btnFra11.getCurrentTextColor());
        setColorStateList(btnFra12, ContextCompat.getColor(this, R.color.fra_dark), btnFra12.getCurrentTextColor());
        setColorStateList(btnFra13, ContextCompat.getColor(this, R.color.fra_dark), btnFra13.getCurrentTextColor());
        setColorStateList(btnFra14, ContextCompat.getColor(this, R.color.fra_dark), btnFra14.getCurrentTextColor());
        setColorStateList(btnFra15, ContextCompat.getColor(this, R.color.fra_dark), btnFra15.getCurrentTextColor());

        // Animation
        llFra1 = (LinearLayout) findViewById(R.id.llFra1);
        llFra2 = (LinearLayout) findViewById(R.id.llFra2);
        llFra3 = (LinearLayout) findViewById(R.id.llFra3);
        llFra4 = (LinearLayout) findViewById(R.id.llFra4);
        llFra5 = (LinearLayout) findViewById(R.id.llFra5);
        llFra6 = (LinearLayout) findViewById(R.id.llFra6);
        llFra7 = (LinearLayout) findViewById(R.id.llFra7);
        llFra8 = (LinearLayout) findViewById(R.id.llFra8);
        llFra9 = (LinearLayout) findViewById(R.id.llFra9);
        llFra10 = (LinearLayout) findViewById(R.id.llFra10);
        llFra11 = (LinearLayout) findViewById(R.id.llFra11);
        llFra12 = (LinearLayout) findViewById(R.id.llFra12);
        llFra13 = (LinearLayout) findViewById(R.id.llFra13);
        llFra14 = (LinearLayout) findViewById(R.id.llFra14);
        llFra15 = (LinearLayout) findViewById(R.id.llFra15);
        aniLl1 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl1.setStartOffset(200);
        aniLl2 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl2.setStartOffset(400);
        aniLl3 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl3.setStartOffset(600);
        aniLl4 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl4.setStartOffset(800);
        aniLl5 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl5.setStartOffset(1000);
        aniLl6 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl6.setStartOffset(1200);
        aniLl7 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl7.setStartOffset(1400);
        aniLl8 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl8.setStartOffset(1500);
        aniLl9 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl9.setStartOffset(1600);
        aniLl10 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl10.setStartOffset(1700);
        aniLl11 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl11.setStartOffset(1800);
        aniLl12 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl12.setStartOffset(1900);
        aniLl13 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl13.setStartOffset(2000);
        aniLl14 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl14.setStartOffset(2100);
        aniLl15 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLl15.setStartOffset(2200);
        llFra1.startAnimation(aniLl1);
        llFra2.startAnimation(aniLl2);
        llFra3.startAnimation(aniLl3);
        llFra4.startAnimation(aniLl4);
        llFra5.startAnimation(aniLl5);
        llFra6.startAnimation(aniLl6);
        llFra7.startAnimation(aniLl7);
        llFra8.startAnimation(aniLl8);
        llFra9.startAnimation(aniLl9);
        llFra10.startAnimation(aniLl10);
        llFra11.startAnimation(aniLl11);
        llFra12.startAnimation(aniLl12);
        llFra13.startAnimation(aniLl13);
        llFra14.startAnimation(aniLl14);
        llFra15.startAnimation(aniLl15);

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
        Intent intentBack = new Intent(Lang101Fra.this, MainFra.class);
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
                case R.id.btnFra1:
                    btnFra1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnFra2:
                    btnFra2.startAnimation(aniTouch);
                    break;
                case R.id.btnFra3:
                    btnFra3.startAnimation(aniTouch);
                    break;
                case R.id.btnFra4:
                    btnFra4.startAnimation(aniTouch);
                    break;
                case R.id.btnFra5:
                    btnFra5.startAnimation(aniTouch);
                    break;
                case R.id.btnFra6:
                    btnFra6.startAnimation(aniTouch);
                    break;
                case R.id.btnFra7:
                    btnFra7.startAnimation(aniTouch);
                    break;
                case R.id.btnFra8:
                    btnFra8.startAnimation(aniTouch);
                    break;
                case R.id.btnFra9:
                    btnFra9.startAnimation(aniTouch);
                    break;
                case R.id.btnFra10:
                    btnFra10.startAnimation(aniTouch);
                    break;
                case R.id.btnFra11:
                    btnFra11.startAnimation(aniTouch);
                    break;
                case R.id.btnFra12:
                    btnFra12.startAnimation(aniTouch);
                    break;
                case R.id.btnFra13:
                    btnFra13.startAnimation(aniTouch);
                    break;
                case R.id.btnFra14:
                    btnFra14.startAnimation(aniTouch);
                    break;
                case R.id.btnFra15:
                    btnFra15.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Fra.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Fra.this, Lang101Fra_01_0.class);
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
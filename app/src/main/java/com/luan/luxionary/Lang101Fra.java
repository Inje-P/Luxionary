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
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    Button btnFra1, btnFra2, btnFra3, btnFra4, btnFra5, btnFra6, btnFra7, btnFra8;
    Button btnFra9, btnFra10, btnFra11, btnFra12, btnFra13, btnFra14, btnFra15, btnFra16;
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
        setContentView(R.layout.lang101_fra);

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
                Intent intentAccount = new Intent(Lang101Fra.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Fra.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Fra.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.scale);

        // Main Layout
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(Lang101Fra.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

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
        btnFra16 = (Button) findViewById(R.id.btnFra16);
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
        btnFra16.setOnClickListener(mClickListener);
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
                case R.id.btnFra1:
                    btnFra1.startAnimation(aniTouch);
                    page01();
                    break;
                case R.id.btnFra2:
                    btnFra2.startAnimation(aniTouch);
                    page02();
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
                case R.id.btnFra16:
                    btnFra16.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Fra.this, MainActivity.class);
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
        Intent intent01 = new Intent(Lang101Fra.this, Lang101Fra_01_1.class);
        intent01.putExtra("username", username);
        intent01.putExtra("email", email);
        intent01.putExtra("profile", profile);
        intent01.putExtra("avatar", avatar);
        startActivity(intent01);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void page02() {
        Intent intent02 = new Intent(Lang101Fra.this, Lang101Fra_02_1.class);
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
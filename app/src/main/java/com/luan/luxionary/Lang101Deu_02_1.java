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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.snackbar.Snackbar;
import com.muddzdev.styleabletoast.StyleableToast;

public class Lang101Deu_02_1 extends AppCompatActivity {

    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    LinearLayout layoutContainer;
    ImageButton btnPrev, btnNext;

    // Main
    Button btnTitle;
    ImageButton btnCircle1, btnCircle2;
    ImageButton btnEnd;
    Button btnText1_1, btnText1_2, btnText1_3, btnText1_4;
    Button btnText2_1, btnText2_2;
    Button btnText3_1, btnText3_2, btnText3_3;
    ImageView imgHorizontal1, imgHorizontal2, imgHorizontal3;

    // Animation
    Animation ani1_1, ani1_2, ani1_3, ani1_4;
    Animation ani2_1, ani2_2;
    Animation ani3_1, ani3_2, ani3_3;
    Animation aniTitle, aniBtnCircle1, aniBtnCircle2, aniBtnEnd;

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
        setContentView(R.layout.lang101_deu_02_1);

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
        setColorStateList(btnTitle, ContextCompat.getColor(this, R.color.deu_background), btnTitle.getCurrentTextColor());

        // Buttons & Lines
        btnCircle1 = (ImageButton) findViewById(R.id.btnCircle1);
        btnCircle1.setVisibility(View.INVISIBLE);
        btnCircle2 = (ImageButton) findViewById(R.id.btnCircle2);
        btnCircle2.setVisibility(View.INVISIBLE);
        btnEnd = (ImageButton) findViewById(R.id.btnEnd);
        btnEnd.setVisibility(View.INVISIBLE);

        imgHorizontal1 = (ImageView) findViewById(R.id.imgHorizontal1);
        imgHorizontal1.setVisibility(View.INVISIBLE);
        imgHorizontal2 = (ImageView) findViewById(R.id.imgHorizontal2);
        imgHorizontal2.setVisibility(View.INVISIBLE);
        imgHorizontal3 = (ImageView) findViewById(R.id.imgHorizontal3);
        imgHorizontal3.setVisibility(View.INVISIBLE);

        // 1st Section
        btnText1_1 = (Button) findViewById(R.id.btnText1_1);
        btnText1_2 = (Button) findViewById(R.id.btnText1_2);
        btnText1_3 = (Button) findViewById(R.id.btnText1_3);
        btnText1_4 = (Button) findViewById(R.id.btnText1_4);
        setColorStateList(btnText1_1, ContextCompat.getColor(this, R.color.deu_background), btnText1_1.getCurrentTextColor());
        setColorStateList(btnText1_2, ContextCompat.getColor(this, R.color.deu_background), btnText1_2.getCurrentTextColor());
        setColorStateList(btnText1_3, ContextCompat.getColor(this, R.color.deu_background), btnText1_3.getCurrentTextColor());
        setColorStateList(btnText1_4, ContextCompat.getColor(this, R.color.deu_background), btnText1_4.getCurrentTextColor());
        btnText1_1.setVisibility(View.INVISIBLE);
        btnText1_2.setVisibility(View.INVISIBLE);
        btnText1_3.setVisibility(View.INVISIBLE);
        btnText1_4.setVisibility(View.INVISIBLE);
        ani1_1 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani1_2 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani1_2.setStartOffset(200);
        ani1_3 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani1_3.setStartOffset(400);
        ani1_4 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani1_4.setStartOffset(600);

        // 2nd Section
        btnText2_1 = (Button) findViewById(R.id.btnText2_1);
        btnText2_2 = (Button) findViewById(R.id.btnText2_2);
        setColorStateList(btnText2_1, ContextCompat.getColor(this, R.color.deu_background), btnText2_1.getCurrentTextColor());
        setColorStateList(btnText2_2, ContextCompat.getColor(this, R.color.deu_background), btnText2_2.getCurrentTextColor());
        btnText2_1.setVisibility(View.INVISIBLE);
        btnText2_2.setVisibility(View.INVISIBLE);
        ani2_1 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani2_2 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani2_2.setStartOffset(200);

        // 3rd Section
        btnText3_1 = (Button) findViewById(R.id.btnText3_1);
        btnText3_2 = (Button) findViewById(R.id.btnText3_2);
        btnText3_3 = (Button) findViewById(R.id.btnText3_3);
        setColorStateList(btnText3_1, ContextCompat.getColor(this, R.color.deu_background), btnText3_1.getCurrentTextColor());
        setColorStateList(btnText3_2, ContextCompat.getColor(this, R.color.deu_background), btnText3_2.getCurrentTextColor());
        setColorStateList(btnText3_3, ContextCompat.getColor(this, R.color.deu_background), btnText3_3.getCurrentTextColor());
        btnText3_1.setVisibility(View.INVISIBLE);
        btnText3_2.setVisibility(View.INVISIBLE);
        btnText3_3.setVisibility(View.INVISIBLE);
        ani3_1 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani3_2 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani3_2.setStartOffset(200);
        ani3_3 = AnimationUtils.loadAnimation(Lang101Deu_02_1.this, R.anim.ascend_fast);
        ani3_3.setStartOffset(400);

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

                btnText1_1.setVisibility(View.VISIBLE);
                btnText1_2.setVisibility(View.VISIBLE);
                btnText1_3.setVisibility(View.VISIBLE);
                btnText1_4.setVisibility(View.VISIBLE);
                btnText1_1.startAnimation(ani1_1);
                btnText1_2.startAnimation(ani1_2);
                btnText1_3.startAnimation(ani1_3);
                btnText1_4.startAnimation(ani1_4);

                btnCircle1.setVisibility(View.VISIBLE);
                aniBtnCircle1 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnCircle1.setDuration(200);
                aniBtnCircle1.setStartOffset(400);
                aniBtnCircle1.setRepeatMode(Animation.REVERSE);
                aniBtnCircle1.setRepeatCount(Animation.INFINITE);
                btnCircle1.startAnimation(aniBtnCircle1);
            }
        });

        btnCircle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCircle1.clearAnimation();
                btnCircle1.setVisibility(View.INVISIBLE);

                imgHorizontal2.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) imgHorizontal2.getDrawable();
                drawable2.start();

                btnText2_1.setVisibility(View.VISIBLE);
                btnText2_2.setVisibility(View.VISIBLE);
                btnText2_1.startAnimation(ani2_1);
                btnText2_2.startAnimation(ani2_2);

                btnCircle2.setVisibility(View.VISIBLE);
                aniBtnCircle2 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnCircle2.setDuration(200);
                aniBtnCircle2.setStartOffset(400);
                aniBtnCircle2.setRepeatMode(Animation.REVERSE);
                aniBtnCircle2.setRepeatCount(Animation.INFINITE);
                btnCircle2.startAnimation(aniBtnCircle2);
            }
        });

        btnCircle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCircle2.clearAnimation();
                btnCircle2.setVisibility(View.INVISIBLE);

                imgHorizontal3.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable3 = (AnimatedVectorDrawable) imgHorizontal3.getDrawable();
                drawable3.start();

                btnText3_1.setVisibility(View.VISIBLE);
                btnText3_2.setVisibility(View.VISIBLE);
                btnText3_3.setVisibility(View.VISIBLE);
                btnText3_1.startAnimation(ani3_1);
                btnText3_2.startAnimation(ani3_2);
                btnText3_3.startAnimation(ani3_3);

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
        Intent intentBack = new Intent(Lang101Deu_02_1.this, Lang101Deu.class);
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
                case R.id.btnText1_1:
                    showSnackbar("안녕하세요! (아침)");
                    break;
                case R.id.btnText1_2:
                    showSnackbar("안녕하세요! (점심)");
                    break;
                case R.id.btnText1_3:
                    showSnackbar("안녕하세요! (저녁)");
                    break;
                case R.id.btnText1_4:
                    showSnackbar("안녕히 주무세요! (밤)");
                    break;
                case R.id.btnText2_1:
                    showSnackbar("안녕!");
                    break;
                case R.id.btnText2_2:
                    showSnackbar("만나서 반가워요.");
                    break;
                case R.id.btnText3_1:
                    showSnackbar("안녕하세요,");
                    break;
                case R.id.btnText3_2:
                    showSnackbar("제 이름은 플로리안이에요.");
                    break;
                case R.id.btnText3_3:
                    showSnackbar("만나서 반갑습니다.");
                    break;
                // Prev & Next Buttons
                case R.id.btnPrev:
                    Intent intentPrev = new Intent(Lang101Deu_02_1.this, Lang101Deu.class);
                    intentPrev.putExtra("nick", strNick);
                    intentPrev.putExtra("pw", strPw);
                    intentPrev.putExtra("name", strName);
                    intentPrev.putExtra("email", strEmail);
                    intentPrev.putExtra("avatar", strAvatar);
                    startActivity(intentPrev);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnNext:
                    Intent intentNext = new Intent(Lang101Deu_02_1.this, Lang101Deu_01_2.class);
                    intentNext.putExtra("nick", strNick);
                    intentNext.putExtra("pw", strPw);
                    intentNext.putExtra("name", strName);
                    intentNext.putExtra("email", strEmail);
                    intentNext.putExtra("avatar", strAvatar);
                    startActivity(intentNext);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                // Footer
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(Lang101Deu_02_1.this, MainActivity.class);
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

    // Snackbar
    public void showSnackbar(String str) {
        layoutContainer = findViewById(R.id.layoutContainer);
        Snackbar snackbar = Snackbar.make(layoutContainer, "", Snackbar.LENGTH_SHORT);
        View custom = getLayoutInflater().inflate(R.layout.snackbar_deu, null);
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
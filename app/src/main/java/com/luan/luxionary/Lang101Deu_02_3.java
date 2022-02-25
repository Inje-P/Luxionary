package com.luan.luxionary;

import android.app.Dialog;
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

public class Lang101Deu_02_3 extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    LinearLayout layoutContainer;
    ImageButton btnPrev, btnNext;

    // Main
    LinearLayout llQ1, llQ2, llQ3, llQ4, llQ5, llQ6, llQ7;
    Button btnQ1, btnQ2, btnQ3, btnQ4, btnQ5, btnQ6, btnQ7;
    ImageButton btnDown1, btnDown2, btnDown3, btnDown4, btnDown5, btnDown6, btnDown7;
    LinearLayout llA1, llA2, llA3, llA4, llA5, llA6, llA7;
    Button btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7;
    Button btnYes1, btnYes2, btnYes3, btnYes4, btnYes5, btnYes6, btnYes7;
    Button btnNo1, btnNo2, btnNo3, btnNo4, btnNo5, btnNo6, btnNo7;
    ImageView imgHorizontal1, imgHorizontal2, imgHorizontal3, imgHorizontal4, imgHorizontal5, imgHorizontal6;

    // Animation
    Animation aniLlQ1, aniLlQ2, aniLlQ3, aniLlQ4, aniLlQ5, aniLlQ6, aniLlQ7;
    Animation aniBtnDown1, aniBtnDown2, aniBtnDown3, aniBtnDown4, aniBtnDown5, aniBtnDown6, aniBtnDown7;
    Animation aniLlA1, aniLlA2, aniLlA3, aniLlA4, aniLlA5, aniLlA6, aniLlA7;

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
        setContentView(R.layout.lang101_deu_02_3);

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
                Intent intentAccount = new Intent(Lang101Deu_02_3.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(Lang101Deu_02_3.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(Lang101Deu_02_3.this, SupportActivity.class);
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
        imgHorizontal1 = (ImageView) findViewById(R.id.imgHorizontal1);
        imgHorizontal1.setVisibility(View.INVISIBLE);
        imgHorizontal2 = (ImageView) findViewById(R.id.imgHorizontal2);
        imgHorizontal2.setVisibility(View.INVISIBLE);
        imgHorizontal3 = (ImageView) findViewById(R.id.imgHorizontal3);
        imgHorizontal3.setVisibility(View.INVISIBLE);
        imgHorizontal4 = (ImageView) findViewById(R.id.imgHorizontal4);
        imgHorizontal4.setVisibility(View.INVISIBLE);
        imgHorizontal5 = (ImageView) findViewById(R.id.imgHorizontal5);
        imgHorizontal5.setVisibility(View.INVISIBLE);
        imgHorizontal6 = (ImageView) findViewById(R.id.imgHorizontal6);
        imgHorizontal6.setVisibility(View.INVISIBLE);

        // 1st Section
        llQ1 = (LinearLayout) findViewById(R.id.llQ1);
        btnQ1 = (Button) findViewById(R.id.btnQ1);
        btnDown1 = (ImageButton) findViewById(R.id.btnDown1);
        llA1 = (LinearLayout) findViewById(R.id.llA1);
        btnA1 = (Button) findViewById(R.id.btnA1);
        btnYes1 = (Button) findViewById(R.id.btnYes1);
        btnNo1 = (Button) findViewById(R.id.btnNo1);
        // anim
        aniLlQ1 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown1 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown1.setStartOffset(300);
        aniLlA1 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA1.setStartOffset(600);

        // 2nd Section
        llQ2 = (LinearLayout) findViewById(R.id.llQ2);
        llQ2.setVisibility(View.INVISIBLE);
        btnQ2 = (Button) findViewById(R.id.btnQ2);
        btnDown2 = (ImageButton) findViewById(R.id.btnDown2);
        btnDown2.setVisibility(View.INVISIBLE);
        llA2 = (LinearLayout) findViewById(R.id.llA2);
        llA2.setVisibility(View.INVISIBLE);
        btnA2 = (Button) findViewById(R.id.btnA2);
        btnYes2 = (Button) findViewById(R.id.btnYes2);
        btnNo2 = (Button) findViewById(R.id.btnNo2);
        // anim
        aniLlQ2 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown2 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown2.setStartOffset(300);
        aniLlA2 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA2.setStartOffset(600);

        // 3rd Section
        llQ3 = (LinearLayout) findViewById(R.id.llQ3);
        llQ3.setVisibility(View.INVISIBLE);
        btnQ3 = (Button) findViewById(R.id.btnQ3);
        btnDown3 = (ImageButton) findViewById(R.id.btnDown3);
        btnDown3.setVisibility(View.INVISIBLE);
        llA3 = (LinearLayout) findViewById(R.id.llA3);
        llA3.setVisibility(View.INVISIBLE);
        btnA3 = (Button) findViewById(R.id.btnA3);
        btnYes3 = (Button) findViewById(R.id.btnYes3);
        btnNo3 = (Button) findViewById(R.id.btnNo3);
        // anim
        aniLlQ3 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown3 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown3.setStartOffset(300);
        aniLlA3 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA3.setStartOffset(600);

        // 4th Section
        llQ4 = (LinearLayout) findViewById(R.id.llQ4);
        llQ4.setVisibility(View.INVISIBLE);
        btnQ4 = (Button) findViewById(R.id.btnQ4);
        btnDown4 = (ImageButton) findViewById(R.id.btnDown4);
        btnDown4.setVisibility(View.INVISIBLE);
        llA4 = (LinearLayout) findViewById(R.id.llA4);
        llA4.setVisibility(View.INVISIBLE);
        btnA4 = (Button) findViewById(R.id.btnA4);
        btnYes4 = (Button) findViewById(R.id.btnYes4);
        btnNo4 = (Button) findViewById(R.id.btnNo4);
        // anim
        aniLlQ4 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown4 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown4.setStartOffset(300);
        aniLlA4 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA4.setStartOffset(600);

        // 5th Section
        llQ5 = (LinearLayout) findViewById(R.id.llQ5);
        llQ5.setVisibility(View.INVISIBLE);
        btnQ5 = (Button) findViewById(R.id.btnQ5);
        btnDown5 = (ImageButton) findViewById(R.id.btnDown5);
        btnDown5.setVisibility(View.INVISIBLE);
        llA5 = (LinearLayout) findViewById(R.id.llA5);
        llA5.setVisibility(View.INVISIBLE);
        btnA5 = (Button) findViewById(R.id.btnA5);
        btnYes5 = (Button) findViewById(R.id.btnYes5);
        btnNo5 = (Button) findViewById(R.id.btnNo5);
        // anim
        aniLlQ5 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown5 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown5.setStartOffset(300);
        aniLlA5 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA5.setStartOffset(600);

        // 6th Section
        llQ6 = (LinearLayout) findViewById(R.id.llQ6);
        llQ6.setVisibility(View.INVISIBLE);
        btnQ6 = (Button) findViewById(R.id.btnQ6);
        btnDown6 = (ImageButton) findViewById(R.id.btnDown6);
        btnDown6.setVisibility(View.INVISIBLE);
        llA6 = (LinearLayout) findViewById(R.id.llA6);
        llA6.setVisibility(View.INVISIBLE);
        btnA6 = (Button) findViewById(R.id.btnA6);
        btnYes6 = (Button) findViewById(R.id.btnYes6);
        btnNo6 = (Button) findViewById(R.id.btnNo6);
        // anim
        aniLlQ6 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown6 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown6.setStartOffset(300);
        aniLlA6 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA6.setStartOffset(600);

        // 7th Section
        llQ7 = (LinearLayout) findViewById(R.id.llQ7);
        llQ7.setVisibility(View.INVISIBLE);
        btnQ7 = (Button) findViewById(R.id.btnQ7);
        btnDown7 = (ImageButton) findViewById(R.id.btnDown7);
        btnDown7.setVisibility(View.INVISIBLE);
        llA7 = (LinearLayout) findViewById(R.id.llA7);
        llA7.setVisibility(View.INVISIBLE);
        btnA7 = (Button) findViewById(R.id.btnA7);
        btnYes7 = (Button) findViewById(R.id.btnYes7);
        btnNo7 = (Button) findViewById(R.id.btnNo7);
        // anim
        aniLlQ7 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.descend_fast);
        aniBtnDown7 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.fadein);
        aniBtnDown7.setStartOffset(300);
        aniLlA7 = AnimationUtils.loadAnimation(Lang101Deu_02_3.this, R.anim.ascend_fast);
        aniLlA7.setStartOffset(600);

        // Question 1
        llQ1.startAnimation(aniLlQ1);
        btnDown1.startAnimation(aniBtnDown1);
        llA1.startAnimation(aniLlA1);
        aniBtnDown1 = new AlphaAnimation(0.0f, 1.0f);
        aniBtnDown1.setDuration(300);
        aniBtnDown1.setStartOffset(400);
        aniBtnDown1.setRepeatMode(Animation.REVERSE);
        aniBtnDown1.setRepeatCount(Animation.INFINITE);
        btnDown1.startAnimation(aniBtnDown1);
        btnYes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown1.clearAnimation();

                imgHorizontal1.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable1 = (AnimatedVectorDrawable) imgHorizontal1.getDrawable();
                drawable1.start();

                llQ2.setVisibility(View.VISIBLE);
                btnDown2.setVisibility(View.VISIBLE);
                llA2.setVisibility(View.VISIBLE);

                llQ2.startAnimation(aniLlQ2);
                btnDown2.startAnimation(aniBtnDown2);
                llA2.startAnimation(aniLlA2);

                aniBtnDown2 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown2.setDuration(300);
                aniBtnDown2.setStartOffset(400);
                aniBtnDown2.setRepeatMode(Animation.REVERSE);
                aniBtnDown2.setRepeatCount(Animation.INFINITE);
                btnDown2.startAnimation(aniBtnDown2);
            }
        });
        btnNo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });

        // Question 2
        btnYes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });
        btnNo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown2.clearAnimation();

                imgHorizontal2.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable2 = (AnimatedVectorDrawable) imgHorizontal2.getDrawable();
                drawable2.start();

                llQ3.setVisibility(View.VISIBLE);
                btnDown3.setVisibility(View.VISIBLE);
                llA3.setVisibility(View.VISIBLE);

                llQ3.startAnimation(aniLlQ3);
                btnDown3.startAnimation(aniBtnDown3);
                llA3.startAnimation(aniLlA3);

                aniBtnDown3 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown3.setDuration(300);
                aniBtnDown3.setStartOffset(400);
                aniBtnDown3.setRepeatMode(Animation.REVERSE);
                aniBtnDown3.setRepeatCount(Animation.INFINITE);
                btnDown3.startAnimation(aniBtnDown3);
            }
        });

        // Question 3
        btnYes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });
        btnNo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown3.clearAnimation();

                imgHorizontal3.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable3 = (AnimatedVectorDrawable) imgHorizontal3.getDrawable();
                drawable3.start();

                llQ4.setVisibility(View.VISIBLE);
                btnDown4.setVisibility(View.VISIBLE);
                llA4.setVisibility(View.VISIBLE);

                llQ4.startAnimation(aniLlQ4);
                btnDown4.startAnimation(aniBtnDown4);
                llA4.startAnimation(aniLlA4);

                aniBtnDown4 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown4.setDuration(300);
                aniBtnDown4.setStartOffset(400);
                aniBtnDown4.setRepeatMode(Animation.REVERSE);
                aniBtnDown4.setRepeatCount(Animation.INFINITE);
                btnDown4.startAnimation(aniBtnDown4);
            }
        });

        // Question 4
        btnYes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown4.clearAnimation();

                imgHorizontal4.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable4 = (AnimatedVectorDrawable) imgHorizontal4.getDrawable();
                drawable4.start();

                llQ5.setVisibility(View.VISIBLE);
                btnDown5.setVisibility(View.VISIBLE);
                llA5.setVisibility(View.VISIBLE);

                llQ5.startAnimation(aniLlQ5);
                btnDown5.startAnimation(aniBtnDown5);
                llA5.startAnimation(aniLlA5);

                aniBtnDown5 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown5.setDuration(300);
                aniBtnDown5.setStartOffset(400);
                aniBtnDown5.setRepeatMode(Animation.REVERSE);
                aniBtnDown5.setRepeatCount(Animation.INFINITE);
                btnDown5.startAnimation(aniBtnDown5);
            }
        });
        btnNo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });

        // Question 5
        btnYes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });
        btnNo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown5.clearAnimation();

                imgHorizontal5.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable5 = (AnimatedVectorDrawable) imgHorizontal5.getDrawable();
                drawable5.start();

                llQ6.setVisibility(View.VISIBLE);
                btnDown6.setVisibility(View.VISIBLE);
                llA6.setVisibility(View.VISIBLE);

                llQ6.startAnimation(aniLlQ6);
                btnDown6.startAnimation(aniBtnDown6);
                llA6.startAnimation(aniLlA6);

                aniBtnDown6 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown6.setDuration(300);
                aniBtnDown6.setStartOffset(400);
                aniBtnDown6.setRepeatMode(Animation.REVERSE);
                aniBtnDown6.setRepeatCount(Animation.INFINITE);
                btnDown6.startAnimation(aniBtnDown6);
            }
        });

        // Question 6
        btnYes6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown6.clearAnimation();

                imgHorizontal6.setVisibility(View.VISIBLE);
                AnimatedVectorDrawable drawable6 = (AnimatedVectorDrawable) imgHorizontal6.getDrawable();
                drawable6.start();

                llQ7.setVisibility(View.VISIBLE);
                btnDown7.setVisibility(View.VISIBLE);
                llA7.setVisibility(View.VISIBLE);

                llQ7.startAnimation(aniLlQ7);
                btnDown7.startAnimation(aniBtnDown7);
                llA7.startAnimation(aniLlA7);

                aniBtnDown7 = new AlphaAnimation(0.0f, 1.0f);
                aniBtnDown7.setDuration(300);
                aniBtnDown7.setStartOffset(400);
                aniBtnDown7.setRepeatMode(Animation.REVERSE);
                aniBtnDown7.setRepeatCount(Animation.INFINITE);
                btnDown7.startAnimation(aniBtnDown7);
            }
        });
        btnNo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });

        // Question 7
        btnYes7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIncorrect("틀렸습니다.");
            }
        });
        btnNo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCorrect("정답입니다.");

                btnDown7.clearAnimation();

                dialogEnd();
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
        Intent intentBack = new Intent(Lang101Deu_02_3.this, Lang101Eng_02_1.class);
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
                case R.id.btnPrev:
                    Intent intentPrev = new Intent(Lang101Deu_02_3.this, Lang101Eng.class);
                    intentPrev.putExtra("username", username);
                    intentPrev.putExtra("email", email);
                    intentPrev.putExtra("profile", profile);
                    intentPrev.putExtra("avatar", avatar);
                    startActivity(intentPrev);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
                case R.id.btnNext:
                    Intent intentNext = new Intent(Lang101Deu_02_3.this, Lang101Eng.class);
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
                    Intent intentHome = new Intent(Lang101Deu_02_3.this, MainActivity.class);
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

    // Snackbar : Correct
    public void showCorrect(String str) {
        layoutContainer = findViewById(R.id.layoutContainer);
        Snackbar snackbar = Snackbar.make(layoutContainer, "", Snackbar.LENGTH_SHORT);
        View custom = getLayoutInflater().inflate(R.layout.snackbar_correct, null);
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

    // Snackbar : Incorrect
    public void showIncorrect(String str) {
        layoutContainer = findViewById(R.id.layoutContainer);
        Snackbar snackbar = Snackbar.make(layoutContainer, "", Snackbar.LENGTH_SHORT);
        View custom = getLayoutInflater().inflate(R.layout.snackbar_incorrect, null);
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

    // End Dialog
    private void dialogEnd() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.lang101_deu_end);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        Button btnOk = dialog.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intentEnd = new Intent(Lang101Deu_02_3.this, Lang101Deu.class);
                intentEnd.putExtra("username", username);
                intentEnd.putExtra("email", email);
                intentEnd.putExtra("profile", profile);
                intentEnd.putExtra("avatar", avatar);
                startActivity(intentEnd);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        dialog.show();
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
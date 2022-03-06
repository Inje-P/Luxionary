package com.luan.luxionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.*;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.*;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.*;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    // Back Button
    private BackHandler backHandler = new BackHandler(this);

    TextView tvTitleHello, tvTitleName;
    TextView tvBanner1, tvBanner2;
    LinearLayout llTop, llProfile, llAvatar, llBanner;
    ImageView imgAvatar;
    Button btnDate;

    // Random Choice
    LinearLayout llRandom;
    Button btnRandom;
    int randomChoice = 0;

    LinearLayout llEngBox, llFraBox, llDeuBox, llItaBox, llSpaBox, llRusBox, llTurBox;
    LinearLayout llEngImage, llFraImage, llDeuImage, llItaImage, llSpaImage, llRusImage, llTurImage;
    ImageButton btnEng, btnFra, btnDeu, btnSpa, btnIta, btnRus, btnTur;
    TextView tvEng, tvFra, tvDeu, tvIta, tvSpa, tvRus, tvTur;

    Animation aniTouch;
    Animation aniLlTop, aniLlProfile, aniTitle1, aniTitle2, aniLlAvatar, aniAvatar;
    Animation aniBtnDate;
    Animation aniLlBanner;
    Animation aniBanner1, aniBanner2, aniLlRandom, aniBtnRandom;

    Animation aniLlEngBox, aniLlFraBox, aniLlDeuBox, aniLlSpaBox, aniLlItaBox, aniLlRusBox, aniLlTurBox;
    Animation aniLlEngImage, aniLlFraImage, aniLlDeuImage, aniLlSpaImage, aniLlItaImage, aniLlRusImage, aniLlTurImage;
    Animation aniBtnEng, aniBtnFra, aniBtnDeu, aniBtnSpa, aniBtnIta, aniBtnRus, aniBtnTur;
    Animation aniTvEng, aniTvFra, aniTvDeu, aniTvSpa, aniTvIta, aniTvRus, aniTvTur;

    // Sound
    MediaPlayer soundEng, soundFra, soundDeu, soundIta, soundSpa, soundRus;

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
        setContentView(R.layout.activity_main);

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
                Intent intentAccount = new Intent(MainActivity.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(MainActivity.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(MainActivity.this, SupportActivity.class);
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
        llTop = (LinearLayout) findViewById(R.id.llTop);
        aniLlTop = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        llTop.startAnimation(aniLlTop);
        llProfile = (LinearLayout) findViewById(R.id.llProfile);
        aniLlProfile = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        llProfile.startAnimation(aniLlProfile);
        tvTitleHello = (TextView) findViewById(R.id.tvTitleHello);
        tvTitleName = (TextView) findViewById(R.id.tvTitleName);
        if (username == null) {
            tvTitleName.setText("해리슨");
        } else {
            tvTitleName.setText(username);
        }
        aniTitle1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniTitle1.setStartOffset(200);
        aniTitle2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitleHello.startAnimation(aniTitle1);
        tvTitleName.startAnimation(aniTitle2);

        // Avatar
        llAvatar = (LinearLayout) findViewById(R.id.llAvatar);
        aniLlAvatar = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        llAvatar.startAnimation(aniLlAvatar);
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        if (avatar == null) {
            imgAvatar.setImageResource(R.drawable.avt_male1);
            avatar = "male1";
        } else {
            switch (avatar) {
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
        aniAvatar = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniAvatar.setStartOffset(800);
        imgAvatar.startAnimation(aniAvatar);
        imgAvatar.setOnClickListener(mClickListener);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);

        // Date & Tasks Section
        btnDate = (Button) findViewById(R.id.btnDate);
        aniBtnDate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend_fast);
        aniBtnDate.setStartOffset(400);
        btnDate.startAnimation(aniBtnDate);
        btnDate.setOnClickListener(mClickListener);

        // Center Image
        llRandom = (LinearLayout) findViewById(R.id.llRandom);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        aniLlRandom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend_fast);
        aniLlRandom.setStartOffset(400);
        aniBtnRandom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ascend_fast);
        aniBtnRandom.setStartOffset(600);
        llRandom.startAnimation(aniLlRandom);
        btnRandom.startAnimation(aniBtnRandom);
        btnRandom.setOnClickListener(mClickListener);

        // Banner
        llBanner = (LinearLayout) findViewById(R.id.llBanner);
        tvBanner1 = (TextView) findViewById(R.id.tvBanner1);
        tvBanner2 = (TextView) findViewById(R.id.tvBanner2);
        aniLlBanner = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ascend_fast);
        aniLlBanner.setStartOffset(400);
        aniBanner1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ascend);
        aniBanner1.setStartOffset(600);
        aniBanner2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.ascend);
        aniBanner2.setStartOffset(800);
        llBanner.startAnimation(aniLlBanner);
        tvBanner1.startAnimation(aniBanner1);
        tvBanner2.startAnimation(aniBanner2);

        // Sound
//        soundEng = MediaPlayer.create(MainActivity.this, R.raw.main_eng);
//        soundFra = MediaPlayer.create(MainActivity.this, R.raw.main_fra);
//        soundDeu = MediaPlayer.create(MainActivity.this, R.raw.main_deu);
//        soundIta = MediaPlayer.create(MainActivity.this, R.raw.main_ita);
//        soundSpa = MediaPlayer.create(MainActivity.this, R.raw.main_spa);
//        soundRus = MediaPlayer.create(MainActivity.this, R.raw.main_rus);

        // LinearLayout & TextView
        llEngBox = (LinearLayout) findViewById(R.id.llEngBox);
        llFraBox = (LinearLayout) findViewById(R.id.llFraBox);
        llSpaBox = (LinearLayout) findViewById(R.id.llSpaBox);
        llDeuBox = (LinearLayout) findViewById(R.id.llDeuBox);
        llItaBox = (LinearLayout) findViewById(R.id.llItaBox);
        llRusBox = (LinearLayout) findViewById(R.id.llRusBox);
        llTurBox = (LinearLayout) findViewById(R.id.llTurBox);
        llEngImage = (LinearLayout) findViewById(R.id.llEngImage);
        llFraImage = (LinearLayout) findViewById(R.id.llFraImage);
        llSpaImage = (LinearLayout) findViewById(R.id.llSpaImage);
        llDeuImage = (LinearLayout) findViewById(R.id.llDeuImage);
        llItaImage = (LinearLayout) findViewById(R.id.llItaImage);
        llRusImage = (LinearLayout) findViewById(R.id.llRusImage);
        llTurImage = (LinearLayout) findViewById(R.id.llTurImage);
        tvEng = (TextView) findViewById(R.id.tvEng);
        tvFra = (TextView) findViewById(R.id.tvFra);
        tvSpa = (TextView) findViewById(R.id.tvSpa);
        tvDeu = (TextView) findViewById(R.id.tvDeu);
        tvIta = (TextView) findViewById(R.id.tvIta);
        tvRus = (TextView) findViewById(R.id.tvRus);
        tvTur = (TextView) findViewById(R.id.tvTur);

        aniLlEngBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlFraBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlFraBox.setStartOffset(200);
        aniLlSpaBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlSpaBox.setStartOffset(400);
        aniLlDeuBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlDeuBox.setStartOffset(600);
        aniLlItaBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlItaBox.setStartOffset(800);
        aniLlRusBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlRusBox.setStartOffset(1000);
        aniLlTurBox = AnimationUtils.loadAnimation(MainActivity.this, R.anim.descend);
        aniLlTurBox.setStartOffset(1200);
        aniLlEngImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlFraImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlFraImage.setStartOffset(200);
        aniLlSpaImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlSpaImage.setStartOffset(400);
        aniLlDeuImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlDeuImage.setStartOffset(600);
        aniLlItaImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlItaImage.setStartOffset(800);
        aniLlRusImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlRusImage.setStartOffset(1000);
        aniLlTurImage = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniLlTurImage.setStartOffset(1200);
        aniTvEng = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvEng.setStartOffset(600);
        aniTvFra = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvFra.setStartOffset(800);
        aniTvSpa = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvSpa.setStartOffset(1000);
        aniTvDeu = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvDeu.setStartOffset(1200);
        aniTvIta = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvIta.setStartOffset(1400);
        aniTvRus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvRus.setStartOffset(1600);
        aniTvTur = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniTvTur.setStartOffset(1800);

        llEngBox.startAnimation(aniLlEngBox);
        llFraBox.startAnimation(aniLlFraBox);
        llSpaBox.startAnimation(aniLlSpaBox);
        llDeuBox.startAnimation(aniLlDeuBox);
        llItaBox.startAnimation(aniLlItaBox);
        llRusBox.startAnimation(aniLlRusBox);
        llTurBox.startAnimation(aniLlTurBox);
        llEngImage.startAnimation(aniLlEngImage);
        llFraImage.startAnimation(aniLlFraImage);
        llSpaImage.startAnimation(aniLlSpaImage);
        llDeuImage.startAnimation(aniLlDeuImage);
        llItaImage.startAnimation(aniLlItaImage);
        llRusImage.startAnimation(aniLlRusImage);
        llTurImage.startAnimation(aniLlTurImage);
        tvEng.startAnimation(aniTvEng);
        tvFra.startAnimation(aniTvFra);
        tvSpa.startAnimation(aniTvSpa);
        tvDeu.startAnimation(aniTvDeu);
        tvIta.startAnimation(aniTvIta);
        tvRus.startAnimation(aniTvRus);
        tvTur.startAnimation(aniTvTur);

        // Button
        btnEng = (ImageButton) findViewById(R.id.btnEng);
        btnFra = (ImageButton) findViewById(R.id.btnFra);
        btnSpa = (ImageButton) findViewById(R.id.btnSpa);
        btnDeu = (ImageButton) findViewById(R.id.btnDeu);
        btnIta = (ImageButton) findViewById(R.id.btnIta);
        btnRus = (ImageButton) findViewById(R.id.btnRus);
        btnTur = (ImageButton) findViewById(R.id.btnTur);
        aniBtnEng = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnEng.setStartOffset(600);
        aniBtnFra = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnFra.setStartOffset(800);
        aniBtnSpa = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnSpa.setStartOffset(1000);
        aniBtnDeu = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnDeu.setStartOffset(1200);
        aniBtnIta = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnIta.setStartOffset(1400);
        aniBtnRus = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnRus.setStartOffset(1600);
        aniBtnTur = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fadein);
        aniBtnTur.setStartOffset(1800);
        btnEng.startAnimation(aniBtnEng);
        btnFra.startAnimation(aniBtnFra);
        btnSpa.startAnimation(aniBtnSpa);
        btnDeu.startAnimation(aniBtnDeu);
        btnIta.startAnimation(aniBtnIta);
        btnRus.startAnimation(aniBtnRus);
        btnTur.startAnimation(aniBtnTur);
        btnEng.setOnClickListener(mClickListener);
        btnFra.setOnClickListener(mClickListener);
        btnSpa.setOnClickListener(mClickListener);
        btnDeu.setOnClickListener(mClickListener);
        btnIta.setOnClickListener(mClickListener);
        btnRus.setOnClickListener(mClickListener);
        btnTur.setOnClickListener(mClickListener);

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
        backHandler.onBackPressed();
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
                case R.id.imgAvatar:
                    imgAvatar.startAnimation(aniTouch);
                    dialogAvatar();
                    break;
                case R.id.btnDate:
                    Intent intentDate = new Intent(MainActivity.this, DateActivity.class);
                    intentDate.putExtra("username", username);
                    intentDate.putExtra("email", email);
                    intentDate.putExtra("profile", profile);
                    intentDate.putExtra("avatar", avatar);
                    startActivity(intentDate);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    finish();
                    break;
                case R.id.btnRandom:
                    rainbow();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Random random = new Random();
                            randomChoice = random.nextInt(7) + 1;
                            switch (randomChoice) {
                                case 1:
                                    dialogEng();
                                    break;
                                case 2:
                                    dialogFra();
                                    break;
                                case 3:
                                    dialogSpa();
                                    break;
                                case 4:
                                    dialogDeu();
                                    break;
                                case 5:
                                    dialogIta();
                                    break;
                                case 6:
                                    dialogRus();
                                    break;
                                case 7:
                                    dialogTur();
                                    break;
                            }
                        }
                    }, 1600);
                    break;
                case R.id.btnEng:
                    pageEng();
                    break;
                case R.id.btnFra:
                    pageFra();
                    break;
                case R.id.btnSpa:
                    pageSpa();
                    break;
                case R.id.btnDeu:
                    pageDeu();
                    break;
                case R.id.btnIta:
                    pageIta();
                    break;
                case R.id.btnRus:
                    pageRus();
                    break;
                case R.id.btnTur:
                    pageTur();
                    break;
                // Footer
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MainActivity.this, MainActivity.class);
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

    // Rainbow Animation
    private void rainbow() {
        Integer white = Color.parseColor("#FFFFFF");
        Integer eng = Color.parseColor("#FF6388");
        Integer fra = Color.parseColor("#0FB8EF");
        Integer spa = Color.parseColor("#FF9450");
        Integer deu = Color.parseColor("#FFD36B");
        Integer ita = Color.parseColor("#0EDFA9");
        Integer rus = Color.parseColor("#9A89FF");
        Integer tur = Color.parseColor("#FF5757");

        ValueAnimator colorAni1 = ValueAnimator.ofObject(new ArgbEvaluator(), white, eng);
        colorAni1.setDuration(200);
        colorAni1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni2 = ValueAnimator.ofObject(new ArgbEvaluator(), eng, fra);
        colorAni2.setDuration(200);
        colorAni2.setStartDelay(200);
        colorAni2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni3 = ValueAnimator.ofObject(new ArgbEvaluator(), fra, spa);
        colorAni3.setDuration(200);
        colorAni3.setStartDelay(400);
        colorAni3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni4 = ValueAnimator.ofObject(new ArgbEvaluator(), spa, deu);
        colorAni4.setDuration(200);
        colorAni4.setStartDelay(600);
        colorAni4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni5 = ValueAnimator.ofObject(new ArgbEvaluator(), deu, ita);
        colorAni5.setDuration(200);
        colorAni5.setStartDelay(800);
        colorAni5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni6 = ValueAnimator.ofObject(new ArgbEvaluator(), ita, rus);
        colorAni6.setDuration(200);
        colorAni6.setStartDelay(1000);
        colorAni6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni7 = ValueAnimator.ofObject(new ArgbEvaluator(), rus, tur);
        colorAni7.setDuration(200);
        colorAni7.setStartDelay(1200);
        colorAni7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni8 = ValueAnimator.ofObject(new ArgbEvaluator(), tur, white);
        colorAni8.setDuration(200);
        colorAni8.setStartDelay(1400);
        colorAni8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                btnRandom.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAni1.start();
        colorAni2.start();
        colorAni3.start();
        colorAni4.start();
        colorAni5.start();
        colorAni6.start();
        colorAni7.start();
        colorAni8.start();
    }

    // Random Dialog (English)
    private void dialogEng() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_eng);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageEng();
            }
        });

        dialog.show();
    }

    // Random Dialog (French)
    private void dialogFra() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_fra);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageFra();
            }
        });

        dialog.show();
    }

    // Random Dialog (Spanish)
    private void dialogSpa() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_spa);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageSpa();
            }
        });

        dialog.show();
    }

    // Random Dialog (German)
    private void dialogDeu() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_deu);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageDeu();
            }
        });

        dialog.show();
    }

    // Random Dialog (Italian)
    private void dialogIta() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_ita);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageIta();
            }
        });

        dialog.show();
    }

    // Random Dialog (Russian)
    private void dialogRus() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_rus);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageRus();
            }
        });

        dialog.show();
    }

    // Random Dialog (Turkish)
    private void dialogTur() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle2);
        dialog.setContentView(R.layout.dialog_tur);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.random_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        ImageView btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                pageTur();
            }
        });

        dialog.show();
    }

    // Avatar Dialog
    private void dialogAvatar() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_avatar);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);
        dialog.setCancelable(false);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Button btnNo = dialog.findViewById(R.id.btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                // 현재 아바타 변수 전달하기 (Intent & DB)
                Intent intentAvatar = new Intent(MainActivity.this, AvatarActivity.class);
                intentAvatar.putExtra("username", username);
                intentAvatar.putExtra("email", email);
                intentAvatar.putExtra("profile", profile);
                intentAvatar.putExtra("avatar", avatar);
                startActivity(intentAvatar);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        dialog.show();
    }

    public void pageEng() {
        Intent intentEng = new Intent(MainActivity.this, IntroEng.class);
        intentEng.putExtra("username", username);
        intentEng.putExtra("email", email);
        intentEng.putExtra("profile", profile);
        intentEng.putExtra("avatar", avatar);
        startActivity(intentEng);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageFra() {
        Intent intentFra = new Intent(MainActivity.this, IntroFra.class);
        intentFra.putExtra("username", username);
        intentFra.putExtra("email", email);
        intentFra.putExtra("profile", profile);
        intentFra.putExtra("avatar", avatar);
        startActivity(intentFra);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageSpa() {
        Intent intentSpa = new Intent(MainActivity.this, IntroSpa.class);
        intentSpa.putExtra("username", username);
        intentSpa.putExtra("email", email);
        intentSpa.putExtra("profile", profile);
        intentSpa.putExtra("avatar", avatar);
        startActivity(intentSpa);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageDeu() {
        Intent intentDeu = new Intent(MainActivity.this, IntroDeu.class);
        intentDeu.putExtra("username", username);
        intentDeu.putExtra("email", email);
        intentDeu.putExtra("profile", profile);
        intentDeu.putExtra("avatar", avatar);
        startActivity(intentDeu);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageIta() {
        Intent intentIta = new Intent(MainActivity.this, IntroIta.class);
        intentIta.putExtra("username", username);
        intentIta.putExtra("email", email);
        intentIta.putExtra("profile", profile);
        intentIta.putExtra("avatar", avatar);
        startActivity(intentIta);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageRus() {
        Intent intentRus = new Intent(MainActivity.this, IntroRus.class);
        intentRus.putExtra("username", username);
        intentRus.putExtra("email", email);
        intentRus.putExtra("profile", profile);
        intentRus.putExtra("avatar", avatar);
        startActivity(intentRus);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageTur() {
        Intent intentTur = new Intent(MainActivity.this, IntroTur.class);
        intentTur.putExtra("username", username);
        intentTur.putExtra("email", email);
        intentTur.putExtra("profile", profile);
        intentTur.putExtra("avatar", avatar);
        startActivity(intentTur);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
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
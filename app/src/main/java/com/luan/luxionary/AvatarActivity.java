package com.luan.luxionary;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class AvatarActivity extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    LinearLayout llTop;
    TextView tvTitleHello, tvTitleName, tvBanner;
    ImageView imgAvatar;
    Button btnSave;
    ImageButton btnMale1, btnMale2, btnMale3, btnMale4;
    ImageButton btnFemale1, btnFemale2, btnFemale3, btnFemale4;

    Animation aniTouch;
    Animation aniLlTop;
    Animation aniAvtTouch, aniAvtAlpha;
    Animation aniTitle1, aniTitle2;
    Animation aniBanner, aniBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        // Data from Firebase
        Intent getData = getIntent();
        username = getData.getStringExtra("username");
        email = getData.getStringExtra("email");
        profile = getData.getStringExtra("profile");
        avatar = getData.getStringExtra("avatar");

        // Header
        llTop = (LinearLayout) findViewById(R.id.llTop);
        aniLlTop = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.descend);
        llTop.startAnimation(aniLlTop);

        // Title
        tvTitleHello = (TextView) findViewById(R.id.tvTitleHello);
        tvTitleName = (TextView) findViewById(R.id.tvTitleName);
        if (username == null) {
            tvTitleName.setText("해리슨");
        } else {
            tvTitleName.setText(username);
        }
        aniTitle1 = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.descend);
        aniTitle2 = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.descend);
        aniTitle2.setStartOffset(400);
        tvTitleHello.startAnimation(aniTitle1);
        tvTitleName.startAnimation(aniTitle2);

        // My Avatar
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        imgAvatar.setOnClickListener(mClickListener);
        aniAvtTouch = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 50, 50);
        aniAvtTouch.setDuration(200);
        aniAvtTouch.setRepeatCount(1);
        aniAvtTouch.setRepeatMode(Animation.REVERSE);
        aniAvtAlpha = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.alpha);
        aniAvtAlpha.setStartOffset(1000);
        imgAvatar.startAnimation(aniAvtAlpha);

        // Banner & Save Button
        tvBanner = (TextView) findViewById(R.id.tvBanner);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(mClickListener);
        aniBanner = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.ascend);
        aniBanner.setStartOffset(600);
        aniBtnSave = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.ascend);
        aniBtnSave.setStartOffset(1000);
        tvBanner.startAnimation(aniBanner);
        btnSave.startAnimation(aniBtnSave);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(AvatarActivity.this, R.anim.scale);

        // Avatars (Button)
        btnMale1 = (ImageButton) findViewById(R.id.btnMale1);
        btnMale2 = (ImageButton) findViewById(R.id.btnMale2);
        btnMale3 = (ImageButton) findViewById(R.id.btnMale3);
        btnMale4 = (ImageButton) findViewById(R.id.btnMale4);
        btnFemale1 = (ImageButton) findViewById(R.id.btnFemale1);
        btnFemale2 = (ImageButton) findViewById(R.id.btnFemale2);
        btnFemale3 = (ImageButton) findViewById(R.id.btnFemale3);
        btnFemale4 = (ImageButton) findViewById(R.id.btnFemale4);
        btnMale1.setOnClickListener(mClickListener);
        btnMale2.setOnClickListener(mClickListener);
        btnMale3.setOnClickListener(mClickListener);
        btnMale4.setOnClickListener(mClickListener);
        btnFemale1.setOnClickListener(mClickListener);
        btnFemale2.setOnClickListener(mClickListener);
        btnFemale3.setOnClickListener(mClickListener);
        btnFemale4.setOnClickListener(mClickListener);
    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(AvatarActivity.this, MainActivity.class);
        intentBack.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentBack.putExtra("username", username);
        intentBack.putExtra("email", email);
        intentBack.putExtra("profile", profile);
        intentBack.putExtra("avatar", avatar);
        startActivity(intentBack);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgAvatar:
                    imgAvatar.startAnimation(aniAvtTouch);
                    break;
                case R.id.btnSave:
                    if (avatar == null) {
                        Toast.makeText(AvatarActivity.this,"아바타를 선택해주세요",Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        showDialog();
                    }
                    break;
                case R.id.btnMale1:
                    btnMale1.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_male1);
                    avatar = "male1";
                    break;
                case R.id.btnMale2:
                    btnMale2.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_male2);
                    avatar = "male2";
                    break;
                case R.id.btnMale3:
                    btnMale3.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_male3);
                    avatar = "male3";
                    break;
                case R.id.btnMale4:
                    btnMale4.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_male4);
                    avatar = "male4";
                    break;
                case R.id.btnFemale1:
                    btnFemale1.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_female1);
                    avatar = "female1";
                    break;
                case R.id.btnFemale2:
                    btnFemale2.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_female2);
                    avatar = "female2";
                    break;
                case R.id.btnFemale3:
                    btnFemale3.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_female3);
                    avatar = "female3";
                    break;
                case R.id.btnFemale4:
                    btnFemale4.startAnimation(aniTouch);
                    imgAvatar.setImageResource(R.drawable.avt_female4);
                    avatar = "female4";
                    break;
            }
        }
    };

    private void showDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialog_save);
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
                Toast.makeText(AvatarActivity.this,"저장되었습니다",Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                // 저장할 아바타 변수 전달하기 (Intent & DB)
                Intent intentMain = new Intent(AvatarActivity.this, MainActivity.class);
                intentMain.putExtra("username", username);
                intentMain.putExtra("email", email);
                intentMain.putExtra("profile", profile);
                intentMain.putExtra("avatar", avatar);
                startActivity(intentMain);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        dialog.show();
    }
}
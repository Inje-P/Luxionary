package com.luan.luxionary;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class VocaEng extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;

    Button[] buttons = new Button[105];
    int[] btnId = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10,
            R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20,
            R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29, R.id.btn30,
            R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34, R.id.btn35, R.id.btn36, R.id.btn37, R.id.btn38, R.id.btn39, R.id.btn40,
            R.id.btn41, R.id.btn42, R.id.btn43, R.id.btn44, R.id.btn45, R.id.btn46, R.id.btn47, R.id.btn48, R.id.btn49, R.id.btn50,
            R.id.btn51, R.id.btn52, R.id.btn53, R.id.btn54, R.id.btn55, R.id.btn56, R.id.btn57, R.id.btn58, R.id.btn59, R.id.btn60,
            R.id.btn61, R.id.btn62, R.id.btn63, R.id.btn64, R.id.btn65, R.id.btn66, R.id.btn67, R.id.btn68, R.id.btn69, R.id.btn70,
            R.id.btn71, R.id.btn72, R.id.btn73, R.id.btn74, R.id.btn75, R.id.btn76, R.id.btn77, R.id.btn78, R.id.btn79, R.id.btn80,
            R.id.btn81, R.id.btn82, R.id.btn83, R.id.btn84, R.id.btn85, R.id.btn86, R.id.btn87, R.id.btn88, R.id.btn89, R.id.btn90,
            R.id.btn91, R.id.btn92, R.id.btn93, R.id.btn94, R.id.btn95, R.id.btn96, R.id.btn97, R.id.btn98, R.id.btn99, R.id.btn100,
            R.id.btn101, R.id.btn102, R.id.btn103, R.id.btn104, R.id.btn105};
    LinearLayout layoutProfile;
    LinearLayout layoutMain;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
    Animation aniLayoutMain;

    String TAG = "FIREBASE";
    String[] titles = new String[10];

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
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(btnId[i]);
            buttons[i].setOnClickListener(mClickListener);
            setColorStateList(buttons[i], ContextCompat.getColor(this, R.color.eng_background), buttons[i].getCurrentTextColor());
        }

        /*
         * Retrieving data from Firestore
         * */
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        db.collection("vocaindex")
//                .orderBy("idx", Query.Direction.ASCENDING)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getString("eng"));
//                                int i = Integer.parseInt(document.getId()) - 1;
//                                titles[i] = document.getString("eng");
//                                buttons[i].setText(document.getId() + ". " + titles[i]);
//                            }
//                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
//                        }
//                    }
//                });

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
                    buttons[0].startAnimation(aniTouch);
                    page001();
                    break;
                case R.id.btn2:
                    buttons[1].startAnimation(aniTouch);
                    break;
                case R.id.btn3:
                    buttons[2].startAnimation(aniTouch);
                    break;
                case R.id.btn4:
                    buttons[3].startAnimation(aniTouch);
                    break;
                case R.id.btn5:
                    buttons[4].startAnimation(aniTouch);
                    break;
                case R.id.btn6:
                    buttons[5].startAnimation(aniTouch);
                    break;
                case R.id.btn7:
                    buttons[6].startAnimation(aniTouch);
                    break;
                case R.id.btn8:
                    buttons[7].startAnimation(aniTouch);
                    break;
                case R.id.btn9:
                    buttons[8].startAnimation(aniTouch);
                    break;
                case R.id.btn10:
                    buttons[9].startAnimation(aniTouch);
                    break;
                case R.id.btn11:
                    buttons[10].startAnimation(aniTouch);
                    break;
                case R.id.btn12:
                    buttons[11].startAnimation(aniTouch);
                    break;
                case R.id.btn13:
                    buttons[12].startAnimation(aniTouch);
                    break;
                case R.id.btn14:
                    buttons[13].startAnimation(aniTouch);
                    break;
                case R.id.btn15:
                    buttons[14].startAnimation(aniTouch);
                    break;
                case R.id.btn16:
                    buttons[15].startAnimation(aniTouch);
                    break;
                case R.id.btn17:
                    buttons[16].startAnimation(aniTouch);
                    break;
                case R.id.btn18:
                    buttons[17].startAnimation(aniTouch);
                    break;
                case R.id.btn19:
                    buttons[18].startAnimation(aniTouch);
                    break;
                case R.id.btn20:
                    buttons[19].startAnimation(aniTouch);
                    break;
                // Button 21 - 40
                case R.id.btn21:
                    buttons[20].startAnimation(aniTouch);
                    break;
                case R.id.btn22:
                    buttons[21].startAnimation(aniTouch);
                    break;
                case R.id.btn23:
                    buttons[22].startAnimation(aniTouch);
                    break;
                case R.id.btn24:
                    buttons[23].startAnimation(aniTouch);
                    break;
                case R.id.btn25:
                    buttons[24].startAnimation(aniTouch);
                    break;
                case R.id.btn26:
                    buttons[25].startAnimation(aniTouch);
                    break;
                case R.id.btn27:
                    buttons[26].startAnimation(aniTouch);
                    break;
                case R.id.btn28:
                    buttons[27].startAnimation(aniTouch);
                    break;
                case R.id.btn29:
                    buttons[28].startAnimation(aniTouch);
                    break;
                case R.id.btn30:
                    buttons[29].startAnimation(aniTouch);
                    break;
                case R.id.btn31:
                    buttons[30].startAnimation(aniTouch);
                    break;
                case R.id.btn32:
                    buttons[31].startAnimation(aniTouch);
                    break;
                case R.id.btn33:
                    buttons[32].startAnimation(aniTouch);
                    break;
                case R.id.btn34:
                    buttons[33].startAnimation(aniTouch);
                    break;
                case R.id.btn35:
                    buttons[34].startAnimation(aniTouch);
                    break;
                case R.id.btn36:
                    buttons[35].startAnimation(aniTouch);
                    break;
                case R.id.btn37:
                    buttons[36].startAnimation(aniTouch);
                    break;
                case R.id.btn38:
                    buttons[37].startAnimation(aniTouch);
                    break;
                case R.id.btn39:
                    buttons[38].startAnimation(aniTouch);
                    break;
                case R.id.btn40:
                    buttons[39].startAnimation(aniTouch);
                    break;
                // Button 41 - 60
                case R.id.btn41:
                    buttons[40].startAnimation(aniTouch);
                    break;
                case R.id.btn42:
                    buttons[41].startAnimation(aniTouch);
                    break;
                case R.id.btn43:
                    buttons[42].startAnimation(aniTouch);
                    break;
                case R.id.btn44:
                    buttons[43].startAnimation(aniTouch);
                    break;
                case R.id.btn45:
                    buttons[44].startAnimation(aniTouch);
                    break;
                case R.id.btn46:
                    buttons[45].startAnimation(aniTouch);
                    break;
                case R.id.btn47:
                    buttons[46].startAnimation(aniTouch);
                    break;
                case R.id.btn48:
                    buttons[47].startAnimation(aniTouch);
                    break;
                case R.id.btn49:
                    buttons[48].startAnimation(aniTouch);
                    break;
                case R.id.btn50:
                    buttons[49].startAnimation(aniTouch);
                    break;
                case R.id.btn51:
                    buttons[50].startAnimation(aniTouch);
                    break;
                case R.id.btn52:
                    buttons[51].startAnimation(aniTouch);
                    break;
                case R.id.btn53:
                    buttons[52].startAnimation(aniTouch);
                    break;
                case R.id.btn54:
                    buttons[53].startAnimation(aniTouch);
                    break;
                case R.id.btn55:
                    buttons[54].startAnimation(aniTouch);
                    break;
                case R.id.btn56:
                    buttons[55].startAnimation(aniTouch);
                    break;
                case R.id.btn57:
                    buttons[56].startAnimation(aniTouch);
                    break;
                case R.id.btn58:
                    buttons[57].startAnimation(aniTouch);
                    break;
                case R.id.btn59:
                    buttons[58].startAnimation(aniTouch);
                    break;
                case R.id.btn60:
                    buttons[59].startAnimation(aniTouch);
                    break;
                // Button 61 - 80
                case R.id.btn61:
                    buttons[60].startAnimation(aniTouch);
                    break;
                case R.id.btn62:
                    buttons[61].startAnimation(aniTouch);
                    break;
                case R.id.btn63:
                    buttons[62].startAnimation(aniTouch);
                    break;
                case R.id.btn64:
                    buttons[63].startAnimation(aniTouch);
                    break;
                case R.id.btn65:
                    buttons[64].startAnimation(aniTouch);
                    break;
                case R.id.btn66:
                    buttons[65].startAnimation(aniTouch);
                    break;
                case R.id.btn67:
                    buttons[66].startAnimation(aniTouch);
                    break;
                case R.id.btn68:
                    buttons[67].startAnimation(aniTouch);
                    break;
                case R.id.btn69:
                    buttons[68].startAnimation(aniTouch);
                    break;
                case R.id.btn70:
                    buttons[69].startAnimation(aniTouch);
                    break;
                case R.id.btn71:
                    buttons[70].startAnimation(aniTouch);
                    break;
                case R.id.btn72:
                    buttons[71].startAnimation(aniTouch);
                    break;
                case R.id.btn73:
                    buttons[72].startAnimation(aniTouch);
                    break;
                case R.id.btn74:
                    buttons[73].startAnimation(aniTouch);
                    break;
                case R.id.btn75:
                    buttons[74].startAnimation(aniTouch);
                    break;
                case R.id.btn76:
                    buttons[75].startAnimation(aniTouch);
                    break;
                case R.id.btn77:
                    buttons[76].startAnimation(aniTouch);
                    break;
                case R.id.btn78:
                    buttons[77].startAnimation(aniTouch);
                    break;
                case R.id.btn79:
                    buttons[78].startAnimation(aniTouch);
                    break;
                case R.id.btn80:
                    buttons[79].startAnimation(aniTouch);
                    break;
                // Button 81 - 100
                case R.id.btn81:
                    buttons[80].startAnimation(aniTouch);
                    break;
                case R.id.btn82:
                    buttons[81].startAnimation(aniTouch);
                    break;
                case R.id.btn83:
                    buttons[82].startAnimation(aniTouch);
                    break;
                case R.id.btn84:
                    buttons[83].startAnimation(aniTouch);
                    break;
                case R.id.btn85:
                    buttons[84].startAnimation(aniTouch);
                    break;
                case R.id.btn86:
                    buttons[85].startAnimation(aniTouch);
                    break;
                case R.id.btn87:
                    buttons[86].startAnimation(aniTouch);
                    break;
                case R.id.btn88:
                    buttons[87].startAnimation(aniTouch);
                    break;
                case R.id.btn89:
                    buttons[88].startAnimation(aniTouch);
                    break;
                case R.id.btn90:
                    buttons[89].startAnimation(aniTouch);
                    break;
                case R.id.btn91:
                    buttons[90].startAnimation(aniTouch);
                    break;
                case R.id.btn92:
                    buttons[91].startAnimation(aniTouch);
                    break;
                case R.id.btn93:
                    buttons[92].startAnimation(aniTouch);
                    break;
                case R.id.btn94:
                    buttons[93].startAnimation(aniTouch);
                    break;
                case R.id.btn95:
                    buttons[94].startAnimation(aniTouch);
                    break;
                case R.id.btn96:
                    buttons[95].startAnimation(aniTouch);
                    break;
                case R.id.btn97:
                    buttons[96].startAnimation(aniTouch);
                    break;
                case R.id.btn98:
                    buttons[97].startAnimation(aniTouch);
                    break;
                case R.id.btn99:
                    buttons[98].startAnimation(aniTouch);
                    break;
                case R.id.btn100:
                    buttons[99].startAnimation(aniTouch);
                    break;
                // Button 101 - 110
                case R.id.btn101:
                    buttons[100].startAnimation(aniTouch);
                    break;
                case R.id.btn102:
                    buttons[101].startAnimation(aniTouch);
                    break;
                case R.id.btn103:
                    buttons[102].startAnimation(aniTouch);
                    break;
                case R.id.btn104:
                    buttons[103].startAnimation(aniTouch);
                    break;
                case R.id.btn105:
                    buttons[104].startAnimation(aniTouch);
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
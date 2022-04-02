package com.luan.luxionary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainSpa extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle1, tvTitle2;
    ImageView imgAvatar;
    LinearLayout layoutProfile;
    RelativeLayout layoutMain;

    // Header
    LinearLayout llTop;
    Animation aniLlTop;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2, aniAvatar;
    Animation aniLayoutProfile;
    Animation aniLayoutMain;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;
    Button btnAccount, btnCharge, btnSupport;

    // ViewPager
    private ViewPager viewPager;
    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_spa);

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
                Intent intentAccount = new Intent(MainSpa.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(MainSpa.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(MainSpa.this, SupportActivity.class);
                intentSupport.putExtra("username", username);
                intentSupport.putExtra("email", email);
                intentSupport.putExtra("profile", profile);
                intentSupport.putExtra("avatar", avatar);
                startActivity(intentSupport);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        // Header
        llTop = (LinearLayout) findViewById(R.id.llTop);
        aniLlTop = AnimationUtils.loadAnimation(MainSpa.this, R.anim.descend);
        llTop.startAnimation(aniLlTop);

        // Title
        layoutProfile = (LinearLayout) findViewById(R.id.layoutProfile);
        aniLayoutProfile = AnimationUtils.loadAnimation(MainSpa.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(MainSpa.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(MainSpa.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Avatar
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
        aniAvatar = AnimationUtils.loadAnimation(MainSpa.this, R.anim.fadein);
        aniAvatar.setStartOffset(800);
        imgAvatar.startAnimation(aniAvatar);
        imgAvatar.setOnClickListener(mClickListener);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(MainSpa.this, R.anim.scale);

        // init UI Views
        viewPager = findViewById(R.id.viewPager);
        loadCards();

        // set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Main Layout
        layoutMain = (RelativeLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(MainSpa.this, R.anim.fadein);
        aniLayoutMain.setStartOffset(400);
        layoutMain.startAnimation(aniLayoutMain);

        // Footer
        btnSidebar = (ImageButton) findViewById(R.id.btnSidebar);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnUpdate = (ImageButton) findViewById(R.id.btnUpdate);
        btnSidebar.setOnClickListener(mClickListener);
        btnHome.setOnClickListener(mClickListener);
        btnUpdate.setOnClickListener(mClickListener);
    }

    // LoadCards Method
    private void loadCards() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel(
                "Español 101",
                "스페인어 첫걸음",
                1,
                R.drawable.banner_lang101));
        modelArrayList.add(new MyModel(
                "Vocabulario",
                "테마별 어휘",
                2,
                R.drawable.banner_vocabulary));
        modelArrayList.add(new MyModel(
                "Gramática",
                "종합 문법",
                3,
                R.drawable.banner_grammar));
        modelArrayList.add(new MyModel(
                "Conjugación",
                "동사변화",
                4,
                R.drawable.banner_verbs));
        modelArrayList.add(new MyModel(
                "Global Citizen",
                "España",
                5,
                R.drawable.banner_gc_spa));

        // set up adapter
        myAdapter = new MyAdapter(this, modelArrayList);

        // set adapter to view pager
        viewPager.setAdapter(myAdapter);

        // set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    // ViewPager Adapter
    class MyAdapter extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel> modelArrayList;

        // Constructor
        public MyAdapter(Context context, ArrayList<MyModel> modelArrayList) {
            this.context = context;
            this.modelArrayList = modelArrayList;
        }

        @Override
        public int getCount() {
            return modelArrayList.size(); // returns size of items in list
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view.equals(object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            // inflate layout card_item.xml
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_large, container, false);

            // init uid views from card_item.xml
            ImageView ivBanner = view.findViewById(R.id.ivBanner);
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvDescription = view.findViewById(R.id.tvDescription);

            // get data
            MyModel model = modelArrayList.get(position);
            String title = model.getTitle();
            String description = model.getDescription();
            int idx = model.getIdx();
            int image = model.getImage();

            // set data
            ivBanner.setImageResource(image);
            tvTitle.setText(title);
            tvDescription.setText(description);

            // handle card click
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (idx) {
                        case 1:
                            pageLang101();
                            break;
                        case 2:
                            pageVoca();
                            break;
                        case 3:
                            break;
                        case 4:
                            pageConj();
                            break;
                        case 5:
                            break;
                    }
                }
            });

            // add view to container
            try {
                container.addView(view, position - 1);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

    }

    // Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentBack = new Intent(MainSpa.this, MainActivity.class);
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
                case R.id.imgAvatar:
                    imgAvatar.startAnimation(aniTouch);
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(MainSpa.this, MainActivity.class);
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

    public void pageLang101() {
        Intent intentLang101 = new Intent(MainSpa.this, Lang101Spa.class);
        intentLang101.putExtra("username", username);
        intentLang101.putExtra("email", email);
        intentLang101.putExtra("profile", profile);
        intentLang101.putExtra("avatar", avatar);
        startActivity(intentLang101);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageVoca() {
        Intent intentVoca = new Intent(MainSpa.this, VocaSpa.class);
        intentVoca.putExtra("username", username);
        intentVoca.putExtra("email", email);
        intentVoca.putExtra("profile", profile);
        intentVoca.putExtra("avatar", avatar);
        startActivity(intentVoca);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageGram() {
        Intent intentGram = new Intent(MainSpa.this, GrammarEng.class);
        intentGram.putExtra("username", username);
        intentGram.putExtra("email", email);
        intentGram.putExtra("profile", profile);
        intentGram.putExtra("avatar", avatar);
        startActivity(intentGram);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageConj() {
        Intent intentConj = new Intent(MainSpa.this, ConjSpa.class);
        intentConj.putExtra("username", username);
        intentConj.putExtra("email", email);
        intentConj.putExtra("profile", profile);
        intentConj.putExtra("avatar", avatar);
        startActivity(intentConj);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

    public void pageGlobal() {
        Intent intentGlobal = new Intent(MainSpa.this, GlobalEng.class);
        intentGlobal.putExtra("username", username);
        intentGlobal.putExtra("email", email);
        intentGlobal.putExtra("profile", profile);
        intentGlobal.putExtra("avatar", avatar);
        startActivity(intentGlobal);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

}
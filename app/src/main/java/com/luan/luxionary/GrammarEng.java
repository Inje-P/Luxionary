package com.luan.luxionary;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class GrammarEng extends AppCompatActivity {
    // Data from DB
    String strNick, strPw, strName, strEmail, strAvatar;

    TextView tvTitle1, tvTitle2;
    LinearLayout layoutProfile;
    LinearLayout layoutMain;
    TextView tvGrammar1, tvGrammar2, tvGrammar3, tvGrammar4, tvGrammar5, tvGrammar6;

    Animation aniTouch;
    Animation aniTitle1, aniTitle2;
    Animation aniLayoutProfile;
    Animation aniLayoutMain;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;

    // ViewPager
    RelativeLayout container1, container2, container3, container4, container5, container6;
    private ViewPager viewPager1, viewPager2, viewPager3, viewPager4, viewPager5, viewPager6;
    private ArrayList<MyModel2> modelArrayList;
    private MyAdapter myAdapter;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gram_eng);

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
        aniLayoutProfile = AnimationUtils.loadAnimation(GrammarEng.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(mClickListener);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        aniTitle1 = AnimationUtils.loadAnimation(GrammarEng.this, R.anim.fadein);
        aniTitle1.setStartOffset(600);
        aniTitle2 = AnimationUtils.loadAnimation(GrammarEng.this, R.anim.fadein);
        aniTitle2.setStartOffset(800);
        tvTitle1.startAnimation(aniTitle1);
        tvTitle2.startAnimation(aniTitle2);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(GrammarEng.this, R.anim.scale);

        // init UI Views
        viewPager1 = findViewById(R.id.viewPager1);
        loadCards1();

        // set viewpager change listener
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        aniLayoutMain = AnimationUtils.loadAnimation(GrammarEng.this, R.anim.fadein);
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
    private void loadCards1() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Plural Nouns",
                1));
        modelArrayList.add(new MyModel2(
                "Collective Nouns",
                2));
        modelArrayList.add(new MyModel2(
                "Possessive Nouns",
                3));
        modelArrayList.add(new MyModel2(
                "Indefinite Articles",
                4));
        modelArrayList.add(new MyModel2(
                "Definite Articles",
                5));

        // set up adapter
        myAdapter = new MyAdapter(this, modelArrayList);

        // set adapter to view pager
        viewPager1.setAdapter(myAdapter);

        // set default padding from left/right
        viewPager1.setPadding(100, 0, 100, 0);
    }

    // ViewPager Adapter
    class MyAdapter extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter(Context context, ArrayList<MyModel2> modelArrayList) {
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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_medium, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.color.eng_background);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);

            // handle card click
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (idx) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
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
        Intent intentBack = new Intent(GrammarEng.this, MainActivity.class);
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
                // Title Animation
                case R.id.tvTitle1:
                    engTitle();
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(GrammarEng.this, MainActivity.class);
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

    // Title Animation
    private void engTitle() {
        Integer engDark = Color.parseColor("#B83756");
        Integer engMain = Color.parseColor("#FF6388");
        Integer engLight = Color.parseColor("#FF93AD");

        ValueAnimator colorAni1 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engDark);
        colorAni1.setDuration(100);
        colorAni1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni2 = ValueAnimator.ofObject(new ArgbEvaluator(), engDark, engMain);
        colorAni2.setDuration(100);
        colorAni2.setStartDelay(100);
        colorAni2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni3 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engLight);
        colorAni3.setDuration(100);
        colorAni3.setStartDelay(200);
        colorAni3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni4 = ValueAnimator.ofObject(new ArgbEvaluator(), engLight, engMain);
        colorAni4.setDuration(100);
        colorAni4.setStartDelay(300);
        colorAni4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle1.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAni1.start();
        colorAni2.start();
        colorAni3.start();
        colorAni4.start();
    }

    public void pageLang101() {
        Intent intentLang101 = new Intent(GrammarEng.this, Lang101Eng.class);
        intentLang101.putExtra("nick", strNick);
        intentLang101.putExtra("pw", strPw);
        intentLang101.putExtra("name", strName);
        intentLang101.putExtra("email", strEmail);
        intentLang101.putExtra("avatar", strAvatar);
        startActivity(intentLang101);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        finish();
    }

}
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class GrammarEng extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

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
    Button btnAccount, btnCharge, btnSupport;

    // ViewPager
    RelativeLayout container1, container2, container3, container4, container5, container6;
    private ViewPager viewPager1, viewPager2, viewPager3, viewPager4, viewPager5, viewPager6;
    private ArrayList<MyModel2> modelArrayList;
    private MyAdapter1 myAdapter1;
    private MyAdapter2 myAdapter2;
    private MyAdapter3 myAdapter3;
    private MyAdapter4 myAdapter4;
    private MyAdapter5 myAdapter5;
    private MyAdapter6 myAdapter6;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gram_eng);

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
                Intent intentAccount = new Intent(GrammarEng.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(GrammarEng.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(GrammarEng.this, SupportActivity.class);
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
        viewPager2 = findViewById(R.id.viewPager2);
        loadCards2();
        viewPager3 = findViewById(R.id.viewPager3);
        loadCards3();
        viewPager4 = findViewById(R.id.viewPager4);
        loadCards4();
        viewPager5 = findViewById(R.id.viewPager5);
        loadCards5();
        viewPager6 = findViewById(R.id.viewPager6);
        loadCards6();

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
        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        viewPager3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        viewPager4.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        viewPager5.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        viewPager6.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    // LoadCards 1
    private void loadCards1() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Types of nouns",
                "명사의 종류",
                1));
        modelArrayList.add(new MyModel2(
                "Countable & uncountable",
                "셀 수 있는/없는 명사",
                2));
        modelArrayList.add(new MyModel2(
                "Indefinite articles",
                "부정관사",
                3));
        modelArrayList.add(new MyModel2(
                "Definite articles",
                "정관사",
                4));
        modelArrayList.add(new MyModel2(
                "Plural",
                "복수형",
                5));
        modelArrayList.add(new MyModel2(
                "Gender, Number, Case",
                "성, 수, 격",
                6));

        myAdapter1 = new MyAdapter1(this, modelArrayList);
        viewPager1.setAdapter(myAdapter1);
        viewPager1.setPadding(100, 0, 100, 0);
    }

    // LoadCards 2
    private void loadCards2() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Personal Pronouns",
                "인칭 대명사",
                1));
        modelArrayList.add(new MyModel2(
                "Demonstrative Pronouns",
                "지시 대명사",
                2));
        modelArrayList.add(new MyModel2(
                "Possessive Pronouns",
                "소유 대명사",
                3));
        modelArrayList.add(new MyModel2(
                "Interrogative Pronouns",
                "의문 대명사",
                4));
        modelArrayList.add(new MyModel2(
                "Reflexive Pronouns",
                "재귀 대명사",
                5));
        modelArrayList.add(new MyModel2(
                "Indefinite Pronouns",
                "부정 대명사",
                6));
        modelArrayList.add(new MyModel2(
                "Relative Pronouns",
                "관계 대명사",
                7));
        modelArrayList.add(new MyModel2(
                "Reciprocal Pronouns",
                "상호 대명사",
                8));

        myAdapter2 = new MyAdapter2(this, modelArrayList);
        viewPager2.setAdapter(myAdapter2);
        viewPager2.setPadding(100, 0, 100, 0);
    }

    // LoadCards 3
    private void loadCards3() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Adjective Formation",
                "형용사의 형태",
                1));
        modelArrayList.add(new MyModel2(
                "Comparative Adjectives",
                "비교급",
                2));
        modelArrayList.add(new MyModel2(
                "Superlative Adjectives",
                "최상급",
                3));

        myAdapter3 = new MyAdapter3(this, modelArrayList);
        viewPager3.setAdapter(myAdapter3);
        viewPager3.setPadding(100, 0, 100, 0);
    }

    // LoadCards 4
    private void loadCards4() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Auxiliary Verbs",
                "조동사",
                1));
        modelArrayList.add(new MyModel2(
                "Modal Verbs",
                "법조동사",
                2));
        modelArrayList.add(new MyModel2(
                "Stative Verbs",
                "상태동사",
                3));
        modelArrayList.add(new MyModel2(
                "Infinitive & Gerund",
                "동사원형 & 동명사",
                4));
        modelArrayList.add(new MyModel2(
                "Participles",
                "분사",
                5));
        modelArrayList.add(new MyModel2(
                "Phrasal Verbs",
                "구동사",
                6));
        modelArrayList.add(new MyModel2(
                "Passive Voice",
                "수동태",
                7));
        modelArrayList.add(new MyModel2(
                "Imperative Mood",
                "명령법",
                8));
        modelArrayList.add(new MyModel2(
                "Conditional Mood",
                "조건법",
                9));
        modelArrayList.add(new MyModel2(
                "Subjunctive Mood",
                "가정법",
                10));

        myAdapter4 = new MyAdapter4(this, modelArrayList);
        viewPager4.setAdapter(myAdapter4);
        viewPager4.setPadding(100, 0, 100, 0);
    }

    // LoadCards 5
    private void loadCards5() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Simple Present",
                "단순 현재 시제",
                1));
        modelArrayList.add(new MyModel2(
                "Simple Past",
                "단순 과거 시제",
                2));
        modelArrayList.add(new MyModel2(
                "Simple Future",
                "단순 미래 시제",
                3));
        modelArrayList.add(new MyModel2(
                "Present Perfect",
                "현재 완료 시제",
                4));
        modelArrayList.add(new MyModel2(
                "Past Perfect",
                "과거 완료 시제",
                5));
        modelArrayList.add(new MyModel2(
                "Future Perfect",
                "미래 완료 시제",
                6));
        modelArrayList.add(new MyModel2(
                "Present Continuous",
                "현재 진행 시제",
                7));
        modelArrayList.add(new MyModel2(
                "Past Continuous",
                "과거 진행 시제",
                8));
        modelArrayList.add(new MyModel2(
                "Future Continuous",
                "미래 진행 시제",
                9));
        modelArrayList.add(new MyModel2(
                "Present Perfect Continuous",
                "현재 완료 진행 시제",
                10));
        modelArrayList.add(new MyModel2(
                "Past Perfect Continuous",
                "과거 완료 진행 시제",
                11));
        modelArrayList.add(new MyModel2(
                "Future Perfect Continuous",
                "미래 완료 진행 시제",
                12));

        myAdapter5 = new MyAdapter5(this, modelArrayList);
        viewPager5.setAdapter(myAdapter5);
        viewPager5.setPadding(100, 0, 100, 0);
    }

    // LoadCards 6
    private void loadCards6() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Preposition Rules",
                "전치사 사용법",
                1));
        modelArrayList.add(new MyModel2(
                "Prepositions of Place",
                "장소와 관련된 전치사",
                2));
        modelArrayList.add(new MyModel2(
                "Prepositions of Time",
                "시간과 관련된 전치사",
                3));
        modelArrayList.add(new MyModel2(
                "Adverb Formation",
                "부사의 형태",
                4));
        modelArrayList.add(new MyModel2(
                "Adverbs of Frequency",
                "빈도부사",
                5));
        modelArrayList.add(new MyModel2(
                "Adverb Position",
                "부사의 어순",
                6));
        modelArrayList.add(new MyModel2(
                "Comparative Adverbs",
                "부사의 비교급",
                7));

        myAdapter6 = new MyAdapter6(this, modelArrayList);
        viewPager6.setAdapter(myAdapter6);
        viewPager6.setPadding(100, 0, 100, 0);
    }

    // ViewPager Adapter 1
    class MyAdapter1 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter1(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                        case 6:
                            break;
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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

    // ViewPager Adapter 2
    class MyAdapter2 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter2(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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

    // ViewPager Adapter 3
    class MyAdapter3 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter3(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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

    // ViewPager Adapter 4
    class MyAdapter4 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter4(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            break;
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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

    // ViewPager Adapter 5
    class MyAdapter5 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter5(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            break;
                        case 11:
                            break;
                        case 12:
                            break;
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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

    // ViewPager Adapter 6
    class MyAdapter6 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter6(Context context, ArrayList<MyModel2> modelArrayList) {
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
            TextView tvSub = view.findViewById(R.id.tvSub);
            LinearLayout llCard = view.findViewById(R.id.llCard);
            llCard.setBackgroundResource(R.drawable.cards_eng);

            // get data
            MyModel2 model = modelArrayList.get(position);
            String title = model.getTitle();
            String sub = model.getSub();
            int idx = model.getIdx();

            // set data
            tvTitle.setText(title);
            tvSub.setText(sub);

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
                        case 6:
                            break;
                        case 7:
                            break;
                    }
                }
            });

            // add view to container
            // ViewPager가 가지고 있는 자녀의 수가 position 값 보다 큰 지를 판별
            try {
                container.addView(view, container.getChildCount() > position ? position : container.getChildCount());
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
        Intent intentBack = new Intent(GrammarEng.this, MainEng.class);
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
                // Title Animation
                case R.id.tvTitle1:
                    engTitle();
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(GrammarEng.this, MainActivity.class);
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

}
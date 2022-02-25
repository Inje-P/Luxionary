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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class GlobalEng extends AppCompatActivity {

    // Data from DB
    String username, email, profile, avatar;

    TextView tvTitle;
    LinearLayout layoutProfile;
    LinearLayout layoutMain;
    TextView tvGlobal1, tvGlobal2, tvGlobal3, tvGlobal4, tvGlobal5, tvGlobal6, tvGlobal7;

    Animation aniTouch;
    Animation aniTitle;
    Animation aniLayoutProfile;
    Animation aniLayoutMain;

    // Sidebar
    private DrawerLayout drawerLayout;
    private View drawerView;
    TextView tvNickname, tvEmail;
    ImageView btnClose;
    Button btnAccount, btnCharge, btnSupport;

    // ViewPager
    private ViewPager viewPager1, viewPager2, viewPager3, viewPager4, viewPager5, viewPager6, viewPager7, viewPager8;
    private ArrayList<MyModel2> modelArrayList;
    private MyAdapter1 myAdapter1;
    private MyAdapter2 myAdapter2;
    private MyAdapter3 myAdapter3;
    private MyAdapter4 myAdapter4;
    private MyAdapter5 myAdapter5;
    private MyAdapter6 myAdapter6;
    private MyAdapter7 myAdapter7;
    private MyAdapter8 myAdapter8;

    // Footer
    ImageButton btnSidebar, btnHome, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.global_eng);

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
                Intent intentAccount = new Intent(GlobalEng.this, AccountActivity.class);
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
                Intent intentCharge = new Intent(GlobalEng.this, ChargeActivity.class);
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
                Intent intentSupport = new Intent(GlobalEng.this, SupportActivity.class);
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
        aniLayoutProfile = AnimationUtils.loadAnimation(GlobalEng.this, R.anim.descend);
        layoutProfile.startAnimation(aniLayoutProfile);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setOnClickListener(mClickListener);
        aniTitle = AnimationUtils.loadAnimation(GlobalEng.this, R.anim.fadein);
        aniTitle.setStartOffset(600);
        tvTitle.startAnimation(aniTitle);

        // Touch Animation
        aniTouch = AnimationUtils.loadAnimation(GlobalEng.this, R.anim.scale);

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
        viewPager7 = findViewById(R.id.viewPager7);
        loadCards7();
        viewPager8 = findViewById(R.id.viewPager8);
        loadCards8();

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
        viewPager7.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        viewPager8.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        aniLayoutMain = AnimationUtils.loadAnimation(GlobalEng.this, R.anim.fadein);
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
                "National symbol",
                "국가 상징",
                1));
        modelArrayList.add(new MyModel2(
                "Administrative districts",
                "행정구역",
                2));
        modelArrayList.add(new MyModel2(
                "Major cities",
                "주요 도시",
                3));
        modelArrayList.add(new MyModel2(
                "Natural environment",
                "자연환경",
                4));

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
                "Native Americans",
                "아메리카 원주민",
                1));
        modelArrayList.add(new MyModel2(
                "European settlements",
                "유럽의 식민지화",
                2));
        modelArrayList.add(new MyModel2(
                "Independence & Expansion",
                "독립과 영토 확장",
                3));
        modelArrayList.add(new MyModel2(
                "Civil war & Reconstruction era",
                "내전과 재건",
                4));
        modelArrayList.add(new MyModel2(
                "Industrialization",
                "산업화",
                5));
        modelArrayList.add(new MyModel2(
                "WWⅠ & Great Depression",
                "제1차 세계 대전과 대공황",
                6));
        modelArrayList.add(new MyModel2(
                "WWⅡ",
                "제2차 세계 대전",
                7));
        modelArrayList.add(new MyModel2(
                "Cold war",
                "냉전",
                8));
        modelArrayList.add(new MyModel2(
                "America in the 21st century",
                "21세기의 미국",
                9));

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
                "Head of state",
                "국가 수장",
                1));
        modelArrayList.add(new MyModel2(
                "Government",
                "정부",
                2));
        modelArrayList.add(new MyModel2(
                "Political party",
                "정당",
                3));
        modelArrayList.add(new MyModel2(
                "Legislative branch",
                "입법부",
                4));
        modelArrayList.add(new MyModel2(
                "Judicial branch",
                "사법부",
                5));

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
                "Economy",
                "경제",
                1));
        modelArrayList.add(new MyModel2(
                "Business administration",
                "경영",
                2));
        modelArrayList.add(new MyModel2(
                "Bank",
                "은행",
                3));
        modelArrayList.add(new MyModel2(
                "Stock exchange",
                "증권거래소",
                4));
        modelArrayList.add(new MyModel2(
                "Conglomerate",
                "대기업",
                5));
        modelArrayList.add(new MyModel2(
                "Business entity",
                "사업체",
                6));
        modelArrayList.add(new MyModel2(
                "Tax",
                "세금",
                7));

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
                "Public holidays",
                "공휴일",
                1));
        modelArrayList.add(new MyModel2(
                "Cuisines",
                "요리",
                2));
        modelArrayList.add(new MyModel2(
                "Sports",
                "스포츠",
                3));
        modelArrayList.add(new MyModel2(
                "Tourism",
                "관광",
                4));
        modelArrayList.add(new MyModel2(
                "Education",
                "교육",
                5));

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
                "Broadcasting",
                "방송",
                1));
        modelArrayList.add(new MyModel2(
                "Newspaper",
                "신문",
                2));
        modelArrayList.add(new MyModel2(
                "Magazine",
                "잡지",
                3));
        modelArrayList.add(new MyModel2(
                "Music",
                "음악",
                4));
        modelArrayList.add(new MyModel2(
                "Movie",
                "영화",
                5));

        myAdapter6 = new MyAdapter6(this, modelArrayList);
        viewPager6.setAdapter(myAdapter6);
        viewPager6.setPadding(100, 0, 100, 0);
    }

    // LoadCards 7
    private void loadCards7() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "Driving",
                "운전",
                1));
        modelArrayList.add(new MyModel2(
                "Public transportation",
                "대중교통",
                2));
        modelArrayList.add(new MyModel2(
                "Air transportation",
                "항공교통",
                3));
        modelArrayList.add(new MyModel2(
                "Railway transportation",
                "철도교통",
                4));
        modelArrayList.add(new MyModel2(
                "Water transportation",
                "수상교통",
                5));

        myAdapter7 = new MyAdapter7(this, modelArrayList);
        viewPager7.setAdapter(myAdapter7);
        viewPager7.setPadding(100, 0, 100, 0);
    }

    // LoadCards 8
    private void loadCards8() {
        // init list
        modelArrayList = new ArrayList<>();

        // add items to list
        modelArrayList.add(new MyModel2(
                "International Organization",
                "국제기구",
                1));
        modelArrayList.add(new MyModel2(
                "Treaty & Agreement",
                "조약과 협약",
                2));
        modelArrayList.add(new MyModel2(
                "Army",
                "육군",
                3));
        modelArrayList.add(new MyModel2(
                "Air Force",
                "공군",
                4));
        modelArrayList.add(new MyModel2(
                "Navy",
                "해군",
                5));
        modelArrayList.add(new MyModel2(
                "Marines",
                "해병대",
                6));
        modelArrayList.add(new MyModel2(
                "Intelligence agency",
                "정보기관",
                7));

        myAdapter8 = new MyAdapter8(this, modelArrayList);
        viewPager8.setAdapter(myAdapter8);
        viewPager8.setPadding(100, 0, 100, 0);
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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_1);

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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_2);

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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_3);

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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_4);

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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_5);

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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_6);

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

    // ViewPager Adapter 7
    class MyAdapter7 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter7(Context context, ArrayList<MyModel2> modelArrayList) {
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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_7);

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

    // ViewPager Adapter 8
    class MyAdapter8 extends PagerAdapter {

        private Context context;
        private ArrayList<MyModel2> modelArrayList;

        // Constructor
        public MyAdapter8(Context context, ArrayList<MyModel2> modelArrayList) {
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
            View view = LayoutInflater.from(context).inflate(R.layout.card_item_gc, container, false);

            // init uid views from card_item.xml
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            TextView tvSub = view.findViewById(R.id.tvSub);
            RelativeLayout rlCard = view.findViewById(R.id.rlCard);
            rlCard.setBackgroundResource(R.drawable.global_8);

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
        Intent intentBack = new Intent(GlobalEng.this, MainEng.class);
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
                case R.id.tvTitle:
                    engTitle();
                    break;
                case R.id.btnSidebar:
                    drawerLayout.openDrawer(drawerView);
                    break;
                case R.id.btnHome:
                    Intent intentHome = new Intent(GlobalEng.this, MainActivity.class);
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
        Integer white = Color.parseColor("#FFFFFF");
        Integer engLight = Color.parseColor("#FF93AD");
        Integer engMain = Color.parseColor("#FF6388");

        ValueAnimator colorAni1 = ValueAnimator.ofObject(new ArgbEvaluator(), white, engLight);
        colorAni1.setDuration(100);
        colorAni1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni2 = ValueAnimator.ofObject(new ArgbEvaluator(), engLight, engMain);
        colorAni2.setDuration(100);
        colorAni2.setStartDelay(100);
        colorAni2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni3 = ValueAnimator.ofObject(new ArgbEvaluator(), engMain, engLight);
        colorAni3.setDuration(100);
        colorAni3.setStartDelay(200);
        colorAni3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator colorAni4 = ValueAnimator.ofObject(new ArgbEvaluator(), engLight, white);
        colorAni4.setDuration(100);
        colorAni4.setStartDelay(300);
        colorAni4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                tvTitle.setTextColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAni1.start();
        colorAni2.start();
        colorAni3.start();
        colorAni4.start();
    }

}
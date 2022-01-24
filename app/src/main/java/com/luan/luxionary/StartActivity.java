package com.luan.luxionary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    Button btnGoogle, btnFacebook, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnEmail = findViewById(R.id.btnEmail);
        btnGoogle.setOnClickListener(mClickListener);
        btnFacebook.setOnClickListener(mClickListener);
        btnEmail.setOnClickListener(mClickListener);

        // ViewPager Content
        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(R.drawable.viewpager1, "하루를 채우는 외국어 학습", "일상 곳곳에서 외국어를 내것으로 만들어보세요"));
        list.add(new DataPage(R.drawable.viewpager2, "다양한 언어를 한번에", "커피 한잔 가격으로 다양한 언어를 배울 수 있어요"));
        list.add(new DataPage(R.drawable.viewpager3, "럭셔리한 나의 작은 습관", "평범한 일상에 품격을 더해보세요"));

        viewPager2.setAdapter(new ViewPagerAdapter(list));

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGoogle:
                    break;
                case R.id.btnFacebook:
                    break;
                case R.id.btnEmail:
                    Intent intentEmail = new Intent(StartActivity.this, SigninActivity.class);
                    startActivity(intentEmail);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
                    finish();
                    break;
            }
        }
    };

}

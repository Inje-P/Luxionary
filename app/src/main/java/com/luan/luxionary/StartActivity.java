package com.luan.luxionary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;

    // Google Authentication
//    private SignInButton btnGoogle;
//    private FirebaseAuth auth;
//    private static final int REQ_SIGN_GOOGLE = 100;
//    private GoogleSignInClient googleSignInClient;

    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        btnEmail = findViewById(R.id.btnEmail);
//        btnEmail.setOnClickListener(mClickListener);

        /*
         * ViewPager
         *  */
        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(R.drawable.viewpager1, "하루를 채우는 외국어 학습", "일상 곳곳에서 외국어를 내것으로 만들어보세요"));
        list.add(new DataPage(R.drawable.viewpager2, "다양한 언어를 한번에", "다양한 언어를 하나의 앱으로 배울 수 있어요"));
        list.add(new DataPage(R.drawable.viewpager3, "럭셔리한 나의 작은 습관", "평범한 일상에 품격을 더해보세요"));
        viewPager2.setAdapter(new ViewPagerAdapter(list));

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();

        /*
         * Google Authentication
         *  */
//        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
//        auth = FirebaseAuth.getInstance();
//
//        btnGoogle = findViewById(R.id.btnGoogle);
//        btnGoogle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = googleSignInClient.getSignInIntent();
//                startActivityForResult(intent, REQ_SIGN_GOOGLE);
//            }
//        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQ_SIGN_GOOGLE) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            if (task.isSuccessful()) {
//                GoogleSignInAccount account = task.getResult();
//                resultLogin(account);
//                Toast.makeText(StartActivity.this, "Completed", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(StartActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void resultLogin(GoogleSignInAccount account) {
//        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
//        auth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(StartActivity.this, "Welcome, " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
//                            Log.d("Login", "Success");
//                            Intent intent = new Intent(StartActivity.this, WelcomeActivity.class);
//                            intent.putExtra("username", account.getDisplayName());
//                            intent.putExtra("email", account.getEmail());
//                            intent.putExtra("profile", String.valueOf(account.getPhotoUrl()));
//                            startActivity(intent);
//                            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
//                            finish();
//                        } else {
//                            Log.d("Login", "Failed");
//                        }
//                    }
//                });
//    }
//
//    View.OnClickListener mClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btnEmail:
//                    Intent intentEmail = new Intent(StartActivity.this, MainActivity.class);
//                    startActivity(intentEmail);
//                    overridePendingTransition(R.anim.fadein, R.anim.fadeout); // 화면 전환 애니메이션
//                    finish();
//                    break;
//            }
//        }
//    };

}
package com.aps.halabook.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.aps.halabook.R;
import com.aps.halabook.adapters.ViewPagerAdapter;
import com.aps.halabook.model.LoginBannerModel;
import com.aps.halabook.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    ViewPager view_pager_offers ;
    private LinearLayout dotsLayout;
    List<LoginBannerModel> list = new ArrayList<>() ;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro) ;
        initViews() ;
        manageClickListener() ;
    }

    private void manageClickListener() {

        findViewById(R.id.txt_login).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , LoginActivity.class)) ;
        });
        findViewById(R.id.btn_signup).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , SignUpActivity.class)) ;
        });


    }

    private void initViews() {
        view_pager_offers = findViewById(R.id.view_pager_offers) ;
        dotsLayout = findViewById(R.id.layoutDots);

        list.add(new LoginBannerModel("Choose Your Beauty Service","https://picsum.photos/200/300")) ;
        list.add(new LoginBannerModel("Find your nearest salon","https://picsum.photos/200/300?grayscale")) ;
        list.add(new LoginBannerModel("Select your preferred date and time","https://picsum.photos/200/300/?blur")) ;

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getApplicationContext() , list) ;
        view_pager_offers.setAdapter(viewPagerAdapter) ;
        view_pager_offers.setAdapter(viewPagerAdapter);
        view_pager_offers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Utility.addBottomDots(list.size() , position ,dotsLayout , getApplicationContext() );

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Utility.addBottomDots(list.size() , 0 ,dotsLayout , getApplicationContext() );


    }



}
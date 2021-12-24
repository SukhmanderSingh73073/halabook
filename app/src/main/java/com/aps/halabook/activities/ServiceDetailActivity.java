package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.aps.halabook.R;
import com.aps.halabook.adapters.ServiceImagesAdapter;
import com.aps.halabook.adapters.ViewPagerAdapter;
import com.aps.halabook.model.LoginBannerModel;
import com.aps.halabook.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class ServiceDetailActivity extends AppCompatActivity {

    ViewPager view_pager_offers ;
    private LinearLayout dotsLayout;
    List<String> list = new ArrayList<>() ;
    int count =0;
    RecyclerView rv_cat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail) ;

        initViews();
        manageClickListener() ;
    }

    private void manageClickListener() {

        findViewById(R.id.rl_view).setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext() , SpecialistActivity.class)) ;
        });

    }

    void initViews(){
        view_pager_offers = findViewById(R.id.view_pager_offers) ;
        dotsLayout = findViewById(R.id.layoutDots);

        list.add("https://picsum.photos/200/300") ;
        list.add("https://picsum.photos/200/300?grayscale") ;
        list.add("https://picsum.photos/200/300/?blur") ;

        ServiceImagesAdapter viewPagerAdapter = new ServiceImagesAdapter(getApplicationContext() , list) ;
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
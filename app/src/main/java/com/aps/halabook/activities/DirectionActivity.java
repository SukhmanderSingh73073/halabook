package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aps.halabook.R;
import com.aps.halabook.adapters.BookingAdapter;
import com.aps.halabook.adapters.ServiceImagesAdapter;
import com.aps.halabook.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class DirectionActivity extends AppCompatActivity {
    ViewPager view_pager_offers ;
    private LinearLayout dotsLayout;
    List<String> list = new ArrayList<>() ;
    int count =0;
    RecyclerView rv_ser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction) ;

        initViews() ;
        rv_ser = findViewById(R.id.rv_ser) ;
        rv_ser.setLayoutManager(new LinearLayoutManager(getApplicationContext())) ;

        rv_ser.setAdapter(new BookingAdapter("DIRECTION" , (t , p)->{
            showCancelDialog();
        })) ;

    }

    private void initViews() {
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

    void showCancelDialog(){

        Dialog dialog = new Dialog(DirectionActivity.this ) ;
        dialog.setContentView(R.layout.location_dialog) ;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show() ;
        TextView txt_dec = dialog.findViewById(R.id.txt_dec) ;
        txt_dec.setText("Are you sure you would like to cancel your booking?") ;

        dialog.findViewById(R.id.btn_no).setOnClickListener(v->{
            dialog.dismiss() ;

        });

        dialog.findViewById(R.id.btn_yes).setOnClickListener(v->{
            dialog.dismiss() ;
            showCancelReasonDialog();
        });

    }

    void showCancelReasonDialog(){

        Dialog dialog = new Dialog(DirectionActivity.this ) ;
        dialog.setContentView(R.layout.cancel_reason_dialog) ;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show() ;

        dialog.findViewById(R.id.btn_no).setOnClickListener(v->{
            dialog.dismiss() ;
        });

        dialog.findViewById(R.id.btn_yes).setOnClickListener(v->{
            dialog.dismiss() ;
        });

    }

}
package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.BookingAdapter;
import com.aps.halabook.adapters.NotificationAapter;
import com.google.android.material.tabs.TabLayout;

public class BookingActivity extends AppCompatActivity {
    TabLayout tab_layout ;
    RecyclerView rv_ser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking) ;


        rv_ser = findViewById(R.id.rv_ser) ;
        tab_layout = findViewById(R.id.tab_layout) ;

        TabLayout.Tab firstTab = tab_layout.newTab();
        firstTab.setText("Upcoming");
        tab_layout.addTab(firstTab,0,true);

        TabLayout.Tab Finished = tab_layout.newTab();
        Finished.setText("Finished");
        tab_layout.addTab(Finished,1,false);

        TabLayout.Tab Canceled = tab_layout.newTab();
        Canceled.setText("Canceled");
        tab_layout.addTab(Canceled,2,false);


        rv_ser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_ser.setAdapter(new BookingAdapter("BOOKING" , (type, pos)->{

            startActivity(new Intent(getApplicationContext() , DirectionActivity.class)) ;
        })) ;


    }
}
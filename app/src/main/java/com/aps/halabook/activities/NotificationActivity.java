package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.NotificationAapter;
import com.google.android.material.tabs.TabLayout;

public class NotificationActivity extends AppCompatActivity {

    TabLayout tab_layout ;
    RecyclerView rv_notification ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification) ;

        rv_notification = findViewById(R.id.rv_notification) ;
        tab_layout = findViewById(R.id.tab_layout) ;

        TabLayout.Tab firstTab = tab_layout.newTab();
        firstTab.setText("Important");
        tab_layout.addTab(firstTab,0,true);

        TabLayout.Tab firstTab2 = tab_layout.newTab();
        firstTab2.setText("Promotion");
        tab_layout.addTab(firstTab2,1,false);


        rv_notification.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_notification.setAdapter(new NotificationAapter()) ;





    }
}
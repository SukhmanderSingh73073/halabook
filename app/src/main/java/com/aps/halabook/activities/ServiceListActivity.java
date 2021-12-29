package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.CategoryAdapter;
import com.aps.halabook.adapters.ServiceAdapter;
import com.aps.halabook.adapters.ServiceListAdapter;
import com.aps.halabook.util.Utility;

public class ServiceListActivity extends AppCompatActivity {
    RecyclerView rv_ser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        rv_ser = findViewById(R.id.rv_ser) ;
        rv_ser.setLayoutManager(new LinearLayoutManager(getApplicationContext())) ;

        rv_ser.setAdapter(new ServiceAdapter("VERTICAL_MATCH" , (type,pos)->{
            Utility.ratingDialog(ServiceListActivity.this)  ;
        })) ;

    }
}
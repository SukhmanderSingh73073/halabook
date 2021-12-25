package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.ServiceAdapter;

public class LocationServiceActivity extends AppCompatActivity {

    RecyclerView rv_ser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_service);

        initViews() ;
        setServiceAdapter() ;

    }

    private void setServiceAdapter() {

        rv_ser.setAdapter(new ServiceAdapter("HORIZONTAL" , (type , pos)->{
           if (type.equalsIgnoreCase("btn_book")){

               startActivity(new Intent(getApplicationContext() , MyCartActivity.class)) ;
           }
        })) ;
    }

    private void initViews() {
        rv_ser = findViewById(R.id.rv_ser) ;
        rv_ser.setLayoutManager(new LinearLayoutManager(getApplicationContext())) ;

    }
}
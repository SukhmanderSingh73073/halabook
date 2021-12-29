package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.CartAdapter;

public class MyCartActivity extends AppCompatActivity {

    RecyclerView rv_ser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        initViews() ;
        setCartAdapter() ;
        findViewById(R.id.btn_confirm).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , ConfirmOrderActivity.class)) ;
        });


    }

    private void setCartAdapter() {
      rv_ser.setAdapter(new CartAdapter()) ;


    }

    private void initViews() {
        rv_ser= findViewById(R.id.rv_ser) ;
        rv_ser.setLayoutManager(new LinearLayoutManager(getApplicationContext())) ;


    }
}
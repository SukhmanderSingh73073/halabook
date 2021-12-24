package com.aps.halabook.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.aps.halabook.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 startActivity(new Intent(getApplicationContext() , MainActivity.class)) ;
             }
         } , 3000) ;


    }
}
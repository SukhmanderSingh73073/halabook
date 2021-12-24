package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login) ;

        findViewById(R.id.txt_signup).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , SignUpActivity.class)) ;
        });
        findViewById(R.id.btn_login).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , MainActivity.class)) ;
        });

    }
}
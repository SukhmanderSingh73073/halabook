package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.CategoryAdapter;

public class CategoryListActivity extends AppCompatActivity {

    RecyclerView rv_cat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        rv_cat = findViewById(R.id.rv_cat) ;
        rv_cat.setLayoutManager(new GridLayoutManager(getApplicationContext() , 3)) ;
        rv_cat.setAdapter(new CategoryAdapter((type,pos)->{
            startActivity(new Intent(getApplicationContext() , ServiceListActivity.class)) ;
        })) ;




    }
}
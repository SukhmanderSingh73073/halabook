package com.aps.halabook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aps.halabook.R;
import com.aps.halabook.adapters.SpecialistAdapter;

import java.util.ArrayList;
import java.util.List;

public class SpecialistActivity extends AppCompatActivity {

    RecyclerView rv_specialist ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist) ;

        initViews() ;
        setSpecialistAdapter() ;

    }

    private void setSpecialistAdapter() {
        List<String> list = new ArrayList<>() ;

        list.add("https://picsum.photos/200/300") ;
        list.add("https://picsum.photos/200/300?grayscale") ;
        list.add("https://picsum.photos/200/300/?blur") ;
        list.add("https://picsum.photos/200/300") ;
        list.add("https://picsum.photos/200/300?grayscale") ;
        list.add("https://picsum.photos/200/300/?blur") ;
        list.add("https://picsum.photos/200/300") ;
        list.add("https://picsum.photos/200/300?grayscale") ;
        list.add("https://picsum.photos/200/300/?blur") ;
        list.add("https://picsum.photos/200/300") ;
        list.add("https://picsum.photos/200/300?grayscale") ;
        list.add("https://picsum.photos/200/300/?blur") ;

        SpecialistAdapter specialistAdapter = new SpecialistAdapter(list) ;
        rv_specialist.setAdapter(specialistAdapter) ;


    }

    private void initViews() {
        rv_specialist = findViewById(R.id.rv_specialist) ;
        rv_specialist.setLayoutManager(new GridLayoutManager(getApplicationContext() , 3)) ;

    }
}
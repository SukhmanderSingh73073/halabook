package com.aps.halabook.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.aps.halabook.R;
import com.aps.halabook.adapters.FragmentAdapter;
import com.aps.halabook.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout ;
    ViewPager2 view_pager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        initViews() ;
        setFragmentAdapter() ;
        manageClickListener() ;
        showLocationDialog();

    }

    private void setFragmentAdapter() {
        List<Fragment> list = new ArrayList<>() ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        FragmentAdapter fragmentAdapter  = new FragmentAdapter(MainActivity.this ,list ) ;
        view_pager.setAdapter(fragmentAdapter );


    }

    private void initViews() {
        drawer_layout = findViewById(R.id.drawer_layout) ;
        view_pager = findViewById(R.id.view_pager) ;
    }

    private void manageClickListener() {

        findViewById(R.id.iv_menu).setOnClickListener(v->{
            drawer_layout.openDrawer(Gravity.LEFT);
        });

    }

    void showLocationDialog(){

        Dialog dialog = new Dialog(MainActivity.this ) ;
        dialog.setContentView(R.layout.location_dialog) ;
        dialog.show() ;

        dialog.findViewById(R.id.btn_no).setOnClickListener(v->{
            dialog.dismiss() ;
        });

        dialog.findViewById(R.id.btn_yes).setOnClickListener(v->{
            dialog.dismiss() ;
        });

    }

}
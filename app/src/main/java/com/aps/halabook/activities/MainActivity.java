package com.aps.halabook.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.aps.halabook.R;
import com.aps.halabook.adapters.FragmentAdapter;
import com.aps.halabook.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

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
        // showLocationDialog();

    }

    private void setFragmentAdapter() {
        List<Fragment> list = new ArrayList<>() ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        list.add(new  HomeFragment()) ;
        FragmentAdapter fragmentAdapter  = new FragmentAdapter(MainActivity.this ,list ) ;
        view_pager.setAdapter(fragmentAdapter );
        view_pager.setUserInputEnabled(false);


    }

    private void initViews() {
        drawer_layout = findViewById(R.id.drawer_layout) ;
        view_pager = findViewById(R.id.view_pager) ;
    }

    private void manageClickListener() {



        NavigationView  nav_view = (NavigationView) findViewById(R.id.nav_view);
        View header = nav_view.getHeaderView(0);
        header.findViewById(R.id.lin_notification).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , NotificationActivity.class)) ;
        });

        header.findViewById(R.id.lin_booking).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , BookingActivity.class)) ;
        });
        header.findViewById(R.id.lin_chnage_pass).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , ChangePasswordActivity.class)) ;
        });


        findViewById(R.id.iv_profile).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , ProfileActivity.class)) ;
        });

        findViewById(R.id.iv_menu).setOnClickListener(v->{
            drawer_layout.openDrawer(Gravity.LEFT);
        });

    }

    void showLocationDialog(){

        Dialog dialog = new Dialog(MainActivity.this ) ;
        dialog.setContentView(R.layout.location_dialog) ;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show() ;

        dialog.findViewById(R.id.btn_no).setOnClickListener(v->{
            dialog.dismiss() ;
        });

        dialog.findViewById(R.id.btn_yes).setOnClickListener(v->{
            dialog.dismiss() ;
        });

    }

}
package com.aps.halabook.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aps.halabook.R;
import com.aps.halabook.activities.CategoryListActivity;
import com.aps.halabook.activities.LocationServiceActivity;
import com.aps.halabook.activities.MainActivity;
import com.aps.halabook.activities.ServiceDetailActivity;
import com.aps.halabook.activities.ServiceListActivity;
import com.aps.halabook.adapters.CategoryAdapter;
import com.aps.halabook.adapters.ServiceListAdapter;
import com.aps.halabook.util.Utility;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view ;
    RecyclerView rv_cat , rv_ser ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        initViews() ;
        setCategoryAdapter() ;
        setServiceAdapter() ;
        manageListener() ;
        return  view ;
    }

    private void manageListener() {

        view.findViewById(R.id.txt_view_cat).setOnClickListener(v->{
            startActivity(new Intent(getContext() , CategoryListActivity.class)) ;
        });

    }

    private void setServiceAdapter() {

        rv_ser.setAdapter(new ServiceListAdapter(getContext() , (type , pos)->{
            if (type.equalsIgnoreCase("root")){
                startActivity(new Intent(getContext() , ServiceDetailActivity.class)) ;
            }else if (type.equalsIgnoreCase("rating")){
                Utility.ratingDialog(getActivity())  ;
            } else {
                startActivity(new Intent(getContext() , LocationServiceActivity.class)) ;
            }

        })) ;

    }


    private void initViews() {


        rv_cat = view.findViewById(R.id.rv_cat) ;
        rv_ser = view.findViewById(R.id.rv_ser) ;
        rv_cat.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL , false));
        rv_ser.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    void setCategoryAdapter(){
        rv_cat.setAdapter(new CategoryAdapter((type,pos)->{
            startActivity(new Intent(getContext() , ServiceListActivity.class)) ;

        })) ;


    }
}
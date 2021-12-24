package com.aps.halabook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aps.halabook.R;

import java.util.ArrayList;
import java.util.List;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.Holder> {

    List<String> list = new ArrayList<>() ;

    public SpecialistAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.specialist_adapter_item , parent , false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        try {
            holder.itemView.setOnClickListener(v->{

            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

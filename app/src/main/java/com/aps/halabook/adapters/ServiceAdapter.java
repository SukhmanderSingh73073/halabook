package com.aps.halabook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aps.halabook.R;
import com.aps.halabook.callbacks.CommonInterface;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.Holder> {
    CommonInterface commonInterface ;
    String type ;

    public ServiceAdapter(String type , CommonInterface commonInterface) {
        this.type = type;
        this.commonInterface = commonInterface;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = R.layout.service_adapter_horizontal ;
        if (type.equalsIgnoreCase("VERTICAL")){
            layout = R.layout.service_adapter_item ;
        }else if (type.equalsIgnoreCase("VERTICAL_MATCH")){
            layout = R.layout.service_adapter_match ;
        }
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(layout , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.itemView.findViewById(R.id.txt_location).setOnClickListener(v->{
            commonInterface.onItemClicked("txt_location" , position ) ;
        });


        holder.itemView.findViewById(R.id.btn_book).setOnClickListener(v->{
            commonInterface.onItemClicked("btn_book" , position ) ;
        });
        holder.itemView.setOnClickListener(v->{
            commonInterface.onItemClicked("root" , position ) ;
        });

        holder.itemView.findViewById(R.id.rating_bar).setOnClickListener(v->{
            commonInterface.onItemClicked("rating" , position ) ;
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

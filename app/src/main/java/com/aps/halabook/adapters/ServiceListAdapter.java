package com.aps.halabook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aps.halabook.R;
import com.aps.halabook.callbacks.CommonInterface;

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.Holder> {
    Context context ;
    CommonInterface commonInterface ;

    public ServiceListAdapter(Context context, CommonInterface commonInterface) {
        this.context = context;
        this.commonInterface = commonInterface;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_adapter_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.rv_ser.setAdapter(new ServiceAdapter(commonInterface)) ;
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class Holder extends RecyclerView.ViewHolder {
        RecyclerView rv_ser ;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rv_ser = itemView.findViewById(R.id.rv_ser) ;
            rv_ser.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL , false));
        }
    }
}

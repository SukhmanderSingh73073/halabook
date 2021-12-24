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

    public ServiceAdapter(CommonInterface commonInterface) {
        this.commonInterface = commonInterface;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.service_adapter_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.itemView.setOnClickListener(v->{
            commonInterface.onItemClicked(position ) ;
        });
    }

    @Override
    public int getItemCount() {
        return 110;
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.aps.halabook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aps.halabook.R;
import com.aps.halabook.callbacks.CommonInterface;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.Holder> {
    String type ;
    CommonInterface commonInterface ;

    public BookingAdapter(String type , CommonInterface commonInterface) {
        this.type = type;
        this.commonInterface = commonInterface;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = R.layout.booking_adapter_item ;
        if (type.equalsIgnoreCase("DIRECTION")){
            layout = R.layout.direction_booking_adapter_item ;
        }
        return new Holder(LayoutInflater.from(parent.getContext())
        .inflate(layout , parent , false) );
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.itemView.setOnClickListener(v->{
            commonInterface.onItemClicked("" , position) ;
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

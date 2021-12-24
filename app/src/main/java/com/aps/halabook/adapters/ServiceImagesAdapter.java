package com.aps.halabook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.aps.halabook.R;
import com.aps.halabook.model.LoginBannerModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ServiceImagesAdapter extends PagerAdapter {

    private Context context;
    private List<String> list;

    public ServiceImagesAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_image_adapter_item,
                container, false);
        ImageView txvOffer = view.findViewById(R.id.txv_lay_1);
        Glide.with(context)
                .load(list.get(position))
                //.apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                .into(txvOffer) ;

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}

package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.R;
import com.example.model.Banner;

import java.util.List;


public class AdapterBanner extends RecyclerView.Adapter<AdapterBanner.MyViewHolder> {
    private Context context;
    private List<Banner> bannerList;

    public AdapterBanner(Context context, List<Banner> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView imvBanner;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBanner=itemView.findViewById(R.id.imvBanner);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_banner,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Banner banner = bannerList.get(position);
        holder.imvBanner.setImageResource(banner.getHinhBanner());
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

}
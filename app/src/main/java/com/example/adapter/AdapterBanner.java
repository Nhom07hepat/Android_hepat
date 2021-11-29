package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.RecyclerOnItemClick;
import com.example.giaodientrangchu.R;
import com.example.model.Banner;

import java.util.List;

public class AdapterBanner extends RecyclerView.Adapter<AdapterBanner.MyViewHolder> implements RecyclerOnItemClick {
    private Context context;
    private List<Banner> bannerList;
    private RecyclerOnItemClick recyclerOnItemClick;

    public AdapterBanner(Context context, List<Banner> bannerList, RecyclerOnItemClick recyclerOnItemClick) {
        this.context = context;
        this.bannerList = bannerList;
        this.recyclerOnItemClick = recyclerOnItemClick;
    }

    @Override
    public void onItemClick(int position) {

    }

    class MyViewHolder extends  RecyclerView.ViewHolder{
        ImageView imvBanner;
        //        RelativeLayout layoutBanner;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBanner=itemView.findViewById(R.id.imvBanner);
//            layoutBanner = itemView.findViewById(R.id.layout_banner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerOnItemClick.onItemClick(getBindingAdapterPosition());
                }
            });
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
//    holder.layoutBanner.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            onClickDetail();
//        }
//
//        public void onClickDetail() {
//            Intent intent = new Intent(context, Detal1.class);
//            context.startActivity(intent);
//        }
    }

    @Override
    public int getItemCount() {
        if(bannerList != null){
            return bannerList.size();
        }
        return 0;
    }


}

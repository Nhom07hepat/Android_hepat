package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.DatLich2_Activity;
import com.example.giaodientrangchu.R;
import com.example.model.BenhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterBV extends RecyclerView.Adapter<AdapterBV.BVViewHolder>{
    private List<BenhVien> listBV;
    private List<BenhVien> list;
    private Context context;

    public AdapterBV(Context context, List<BenhVien> listBV) {
        this.context = context;
        this.listBV = listBV;
        list = new ArrayList<>();
        list.addAll(listBV);
    }

    @NonNull
    @Override
    public BVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bv,parent,false);
        return new BVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BVViewHolder holder, int position) {
        BenhVien benhVien = listBV.get(position);
        if(benhVien == null){
            return;
        }
        holder.imvBenhVien.setImageResource(benhVien.getImvBenhVien());
        holder.txtName.setText(benhVien.getTxtName());
        holder.txtAddress.setText(benhVien.getTxtAddress());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickDetail(benhVien);
            }
        });
        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickDetail(benhVien);
            }
        });
    }
    public void filter(String svSearch){
        int s = svSearch.length();
        if(s == 0){
            listBV.clear();
            listBV.addAll(list);
        }
        else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<BenhVien> collection = listBV.stream().filter(i -> i.getTxtName().toLowerCase().contains(svSearch.toLowerCase())).collect(Collectors.toList());
                listBV.clear();
                listBV.addAll(collection);
            }
            else {
                for (BenhVien b: list){
                    if(b.getTxtName().toLowerCase().contains(svSearch.toLowerCase())){
                        listBV.add(b);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
        public void onclickDetail(BenhVien benhVien){
        Intent intent = new Intent(context, DatLich2_Activity.class);
        Bundle bundle = new Bundle();
            bundle.putSerializable("Benh vien", benhVien);
            intent.putExtras(bundle);
            context.startActivity(intent);


        }
    @Override
    public int getItemCount() {
        if(listBV != null){
            return listBV.size();
        }
        return 0;
    }

    public class BVViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imvBenhVien;
        private TextView txtName;
        private TextView txtAddress;
        private RelativeLayout layoutItem;
        Button btnBooking;

        public BVViewHolder(@NonNull View itemView) {
            super(itemView);
            imvBenhVien = itemView.findViewById(R.id.imvBenhVien);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            layoutItem = itemView.findViewById(R.id.layout_item);
            btnBooking = itemView.findViewById(R.id.btnBooking);
        }
    }
}

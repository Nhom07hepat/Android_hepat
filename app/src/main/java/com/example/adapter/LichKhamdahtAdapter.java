package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.R;
import com.example.model.LichKhamDaHuy;
import com.example.model.LichKhamDaht;

import java.util.ArrayList;
import java.util.List;


public class LichKhamdahtAdapter extends RecyclerView.Adapter<LichKhamdahtAdapter.LichKhamDaHtVH>  {
    ArrayList<LichKhamDaht> lichKhamDahts;
    Context context;

    public LichKhamdahtAdapter(ArrayList<LichKhamDaht> lichKhamDahts, Context context) {
        this.lichKhamDahts = lichKhamDahts;
        this.context = context;
    }

    @NonNull
    @Override
    public LichKhamDaHtVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view_lich_kham_da_hoan_thanh,parent,false);
        LichKhamDaHtVH lhtvh = new LichKhamDaHtVH(view);
        return lhtvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LichKhamDaHtVH holder, int position) {
        LichKhamDaht l2 = lichKhamDahts.get(position);
        holder.txtName.setText(l2.getName());
        holder.txtDate.setText(l2.getDate());
        holder.txtTime.setText(l2.getTime());
    }

    @Override
    public int getItemCount() {
        return lichKhamDahts.size();
    }

    class LichKhamDaHtVH extends RecyclerView.ViewHolder {
        TextView txtName, txtDate, txtTime;
        public LichKhamDaHtVH(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtHospitalNamedaht);
            txtDate = itemView.findViewById(R.id.txtHospitalDatedaht);
            txtTime = itemView.findViewById(R.id.txtHospitalTimedaht);


        }

    }
}

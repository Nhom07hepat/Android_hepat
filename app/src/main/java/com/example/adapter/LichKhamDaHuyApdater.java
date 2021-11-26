package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.ChinhSuaLK;
import com.example.giaodientrangchu.DBBooking;
import com.example.giaodientrangchu.DB_HUY;
import com.example.giaodientrangchu.DB_LichHT;
import com.example.giaodientrangchu.R;
import com.example.model.LichKhamDaHuy;
import com.example.model.LichKhamht;

import java.util.ArrayList;
import java.util.List;

public class LichKhamDaHuyApdater extends RecyclerView.Adapter<LichKhamDaHuyApdater.LichKhamDaHuyVH>  {
    ArrayList<LichKhamDaHuy> lichKhamDaHuys;
    Context context;

    public LichKhamDaHuyApdater(ArrayList<LichKhamDaHuy> lichKhamDaHuys, Context context) {
        this.lichKhamDaHuys = lichKhamDaHuys;
        this.context = context;
    }

    @NonNull
    @Override
    public LichKhamDaHuyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view_lich_kham_da_huy,parent,false);
        LichKhamDaHuyVH lhvh = new LichKhamDaHuyVH(view);
        return lhvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LichKhamDaHuyVH holder, int position) {
        LichKhamDaHuy l1 = lichKhamDaHuys.get(position);
        holder.txtName.setText(l1.getName());
        holder.txtDate.setText(l1.getDate());
        holder.txtTime.setText(l1.getTime());
    }

    @Override
    public int getItemCount() {
        return lichKhamDaHuys.size();
    }

    class LichKhamDaHuyVH extends RecyclerView.ViewHolder {
        TextView txtName, txtDate, txtTime;
        Button btnHuy, btnChinhSua;
        CardView cardView;
        public LichKhamDaHuyVH(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtHospitalNamedahuy);
            txtDate = itemView.findViewById(R.id.txtHospitalDatedahuy);
            txtTime = itemView.findViewById(R.id.txtHospitalTimedahuy);


        }

    }
}

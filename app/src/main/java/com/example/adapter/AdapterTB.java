package com.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giaodientrangchu.Activity_Binhluan;
import com.example.giaodientrangchu.Booking_Activity;
import com.example.giaodientrangchu.DienDan;
import com.example.giaodientrangchu.LichKham;
import com.example.giaodientrangchu.R;
import com.example.model.ThongBao;
import java.util.ArrayList;

public class AdapterTB extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<ThongBao> thongBaos;

    public AdapterTB(Context context, int item_layout, ArrayList<ThongBao> thongBaos) {
        this.context = context;
        this.item_layout = item_layout;
        this.thongBaos = thongBaos;
    }

    @Override
    public int getCount() {
        return thongBaos.size();
    }

    @Override
    public Object getItem(int i) {
        return thongBaos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null) {
            holder = new ViewHolder1();
            view = inflater.inflate(item_layout, null);
            holder.imvThumbTB = view.findViewById(R.id.imvThumbTB);
            holder.txtThongBao = view.findViewById(R.id.txtThongBao);
            holder.txtNgay = view.findViewById(R.id.txtNgay);
            holder.txtGioKham = view.findViewById(R.id.txtGioKham);
            holder.txtTime= view.findViewById(R.id.txtTime);
            holder.btnXemTB= view.findViewById(R.id.btnXemTB);
            view.setTag(holder);
        }else {
            holder=(ViewHolder1)  view.getTag();
        }
        ThongBao b= thongBaos.get(i);
        holder.imvThumbTB.setImageResource(b.getThumbTB());
        holder.txtThongBao.setText(String.valueOf(b.getThongBao()));
        holder.txtNgay.setText(String.valueOf(b.getNgay()));
        holder.txtGioKham.setText(String.valueOf(b.getTime()));

        if(i==0)
        {
            holder.btnXemTB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, LichKham.class);
                    context.startActivity(intent);
                }
            });
        }

        if(i==1)
        {
            holder.btnXemTB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Booking_Activity.class);
                    context.startActivity(intent);
                }
            });
        }

        if(i==2)
        {
            holder.btnXemTB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DienDan.class);
                    context.startActivity(intent);
                }
            });
        }
        return view;

    }
    protected static class ViewHolder1{
        ImageView imvThumbTB;
        Button btnXemTB;
        TextView txtNgay,txtGioKham,txtTime,txtThongBao;
    }



}

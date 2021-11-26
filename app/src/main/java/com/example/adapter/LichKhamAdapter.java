package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
import com.example.giaodientrangchu.LichKham;
import com.example.giaodientrangchu.R;
import com.example.model.LichKhamht;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LichKhamAdapter extends RecyclerView.Adapter<LichKhamAdapter.LichKhamVH>  {
    ArrayList<LichKhamht> lichKhamhts;
    Context context;

    public LichKhamAdapter(ArrayList<LichKhamht> lichKhamhts, Context context) {
        this.lichKhamhts = lichKhamhts;
        this.context = context;
    }

    @NonNull
    @Override
    public LichKhamVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view_lich_kham_hien_tai,parent,false);
        LichKhamVH lvh = new LichKhamVH(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LichKhamVH holder, int position) {
        LichKhamht l = lichKhamhts.get(position);
        holder.txtName.setText(l.getName());
        holder.txtDate.setText(l.getDate());
        holder.txtTime.setText(l.getTime());
        holder.btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChinhSuaLK.class);
                intent.putExtra("LichKham",l);
                context.startActivity(intent);
            }
        });
        holder.btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xác nhận !!!");
                builder.setMessage("Bạn chắc chắn xóa lịch hẹn này?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DBBooking dbBooking = new DBBooking(context);
                        int result = dbBooking.deleteLK(l.getId());
                        if (result > 0) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            lichKhamhts.remove(l);
                            notifyDataSetChanged();

                        } else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                        String name = holder.txtName.getText().toString().trim();
                        String date = holder.txtDate.getText().toString().trim();
                        String time = holder.txtTime.getText().toString().trim();
                        DB_HUY db_huy = new DB_HUY(context);
                        LichKhamht l = new LichKhamht(name,date,time);
                        long res = db_huy.addLichKhamht(l);
                        if(res>0){
                            Toast.makeText(context,"Saved",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                builder.setNegativeButton("No", null);
                builder.show();

            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xác nhận !!!");
                builder.setMessage("Bạn đã hoàn thành lịch hẹn này?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        DBBooking dbBooking = new DBBooking(context);
                        int result = dbBooking.deleteLK(l.getId());
                        if (result > 0) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            lichKhamhts.remove(l);
                            notifyDataSetChanged();

                        } else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                        String name = holder.txtName.getText().toString().trim();
                        String date = holder.txtDate.getText().toString().trim();
                        String time = holder.txtTime.getText().toString().trim();
                        DB_LichHT db_lichHT = new DB_LichHT(context);
                        LichKhamht l = new LichKhamht(name,date,time);
                        long res = db_lichHT.addLichKhamht(l);
                        if(res>0){
                            Toast.makeText(context,"Saved",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                builder.setNegativeButton("No", null);
                builder.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lichKhamhts.size();
    }

    class LichKhamVH extends RecyclerView.ViewHolder {
        TextView txtName, txtDate, txtTime;
        Button btnHuy, btnChinhSua;
        CardView cardView;
        public LichKhamVH(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtHospitalNameht);
            txtDate = itemView.findViewById(R.id.txtHospitalDateht);
            txtTime = itemView.findViewById(R.id.txtHospitalTimeht);
            btnChinhSua = itemView.findViewById(R.id.btnChinhsua);
            btnHuy = itemView.findViewById(R.id.btnHuy);
            cardView = itemView.findViewById(R.id.mCardview);

    }

}
}

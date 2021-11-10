package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.giaodientrangchu.R;
import com.example.model.LichKhamDaHuy;

import java.util.List;

public class LichKhamDaHuyApdater extends BaseAdapter {
    Activity context;
    int item_listtview;
    List<LichKhamDaHuy> lichKhamDaHuyList;

    public LichKhamDaHuyApdater(Activity context, int item_listtview, List<LichKhamDaHuy> lichKhamDaHuyList) {
        this.context = context;
        this.item_listtview = item_listtview;
        this.lichKhamDaHuyList = lichKhamDaHuyList;
    }

    @Override
    public int getCount() {
        return lichKhamDaHuyList.size();
    }

    @Override
    public Object getItem(int i) {
        return lichKhamDaHuyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){

            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(item_listtview,null);
            holder.txtName=view.findViewById(R.id.txtHospitalNamedahuy);
            holder.txtTime=view.findViewById(R.id.txtHospitalTimedahuy);
            holder.txtDate=view.findViewById(R.id.txtHospitalDatedahuy);

        }else {
            holder= (ViewHolder) view.getTag();
        }


        LichKhamDaHuy lichKhamDaHuy=lichKhamDaHuyList.get(i);
        holder.txtName.setText(lichKhamDaHuy.getHospitalNamedahuy());
        holder.txtTime.setText(lichKhamDaHuy.getHospitalTimedahuy());
        holder.txtDate.setText(lichKhamDaHuy.getHospitalDatedahuy());
        return view;
    }
    public static  class ViewHolder{
        TextView txtName,txtTime, txtDate;
    }
}

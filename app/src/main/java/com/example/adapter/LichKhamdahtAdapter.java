package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.giaodientrangchu.R;
import com.example.model.LichKhamDaht;

import java.util.List;

public class LichKhamdahtAdapter extends BaseAdapter {
    Activity context;
    int item_lisview;
    List<LichKhamDaht> lichKhamDahtList;

    public LichKhamdahtAdapter(Activity context, int item_lisview, List<LichKhamDaht> lichKhamDahtList) {
        this.context = context;
        this.item_lisview = item_lisview;
        this.lichKhamDahtList = lichKhamDahtList;
    }

    @Override
    public int getCount() {
        return lichKhamDahtList.size();
    }

    @Override
    public Object getItem(int i) {
        return lichKhamDahtList.get(i);
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
            view=inflater.inflate(item_lisview,null);
            holder.txtName=view.findViewById(R.id.txtHospitalNamedaht);
            holder.txtTime=view.findViewById(R.id.txtHospitalTimedaht);
            holder.txtDate=view.findViewById(R.id.txtHospitalDatedaht);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        LichKhamDaht lichKhamDaht=lichKhamDahtList.get(i);
        holder.txtName.setText(lichKhamDaht.getHospitalNamedht());
        holder.txtTime.setText(lichKhamDaht.getHospitalTimedht());
        holder.txtDate.setText(lichKhamDaht.getHospitalDatedht());

        return view;
    }
    public  static class ViewHolder{
        TextView txtName, txtTime, txtDate;
    }
}

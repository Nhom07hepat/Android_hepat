package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giaodientrangchu.R;
import com.example.model.TrieuChung;

import java.util.ArrayList;

public class AdapterTrieuChung extends BaseAdapter {
    Context context;
    int item_layout;
    ArrayList<TrieuChung> trieuchung;

    public AdapterTrieuChung(Context context, int item_layout, ArrayList<TrieuChung> trieuchung) {
        this.context = context;
        this.item_layout = item_layout;
        this.trieuchung = trieuchung;
    }

    @Override
    public int getCount() {
        return trieuchung.size();
    }

    @Override
    public Object getItem(int i) {
        return trieuchung.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AdapterTrieuChung.ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            holder = new AdapterTrieuChung.ViewHolder();
            view = inflater.inflate(item_layout, null);
            holder.txtTrieuChung = view.findViewById(R.id.txtTrieuChung);

            view.setTag(holder);
        } else {
            holder = (AdapterTrieuChung.ViewHolder) view.getTag();
        }
        TrieuChung t = trieuchung.get(i);
        holder.txtTrieuChung.setText(String.valueOf(t.getTrieuChung()));
        return view;

    }
    protected static class ViewHolder {
        TextView txtTrieuChung;

    }
}
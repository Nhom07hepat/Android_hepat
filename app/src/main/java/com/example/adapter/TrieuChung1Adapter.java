package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.giaodientrangchu.R;
import com.example.model.TrieuChung;
import com.example.giaodientrangchu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TrieuChung1Adapter extends ArrayAdapter<TrieuChung> {
    private List<TrieuChung> listTrieuChungS;
    public TrieuChung1Adapter(Context context, int resource,List<TrieuChung> objects) {
        super(context, resource, objects);
        listTrieuChungS = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trieuchung1_layout_custom, parent,false);
        }
        TextView txtTrieuChung = convertView.findViewById(R.id.txtNameTC);
        TrieuChung trieuChung = getItem(position);
        txtTrieuChung.setText(trieuChung.getTrieuchung());
        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<TrieuChung> listSuggest = new ArrayList<>();
                if (charSequence == null || charSequence.length()==0) {
                    listSuggest.addAll(listTrieuChungS);
                } else {
                    String filter = charSequence.toString().toLowerCase().trim();
                    for (TrieuChung trieuChung : listTrieuChungS) {
                        if (trieuChung.getTrieuchung().toLowerCase().contains(filter)) {
                            listSuggest.add(trieuChung);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listSuggest;
                filterResults.count = listSuggest.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                clear();
                addAll((List<TrieuChung>)filterResults.values);
                notifyDataSetChanged();

            }
            @Override
            public CharSequence convertResultToString(Object resultValue){
                return ((TrieuChung) resultValue).getTrieuchung();
            }
        };
    }
}

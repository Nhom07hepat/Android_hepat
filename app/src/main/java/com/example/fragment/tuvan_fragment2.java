package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.giaodientrangchu.R;
import com.example.giaodientrangchu.ds_benhvien;

public class tuvan_fragment2 extends Fragment {
    Button btnXem2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuvan_fragment2,container,false);
        btnXem2 = view.findViewById(R.id.btnXem2);
        btnXem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ds_benhvien.class);
                startActivity(intent);

            }
        });
        return view;
    }
}
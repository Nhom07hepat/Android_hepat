package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adapter.AdapterBV;
import com.example.giaodientrangchu.R;
import com.example.model.BenhVien;

import java.util.ArrayList;
import java.util.List;

public class tuvan_fragment2 extends Fragment {
    private RecyclerView rcvBV;
    private AdapterBV adapterBV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuvan_fragment2,container,false);
        rcvBV = view.findViewById(R.id.recBV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvBV.setLayoutManager(linearLayoutManager);

        adapterBV = new AdapterBV(getActivity(),getListBV());
        rcvBV.setAdapter(adapterBV);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        rcvBV.addItemDecoration(itemDecoration);
        return view;
    }
    private List<BenhVien> getListBV() {
        List<BenhVien> benhViens = new ArrayList<>();
        benhViens.add(new BenhVien(R.drawable.bv_choray,"Bệnh viện Chợ Rẫy","21B,Nguyễn Chí Thanh,P.12,Q.5,HCM"));
        benhViens.add(new BenhVien(R.drawable.bv_yduoc,"Bệnh viện Y Dược","201,Nguyễn Chí Thanh,P.12,Q.5,HCM"));
        return  benhViens;

    }
}
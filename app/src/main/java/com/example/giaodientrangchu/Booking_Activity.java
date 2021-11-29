package com.example.giaodientrangchu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.BenhVien;
import com.example.adapter.AdapterBV;

import java.util.ArrayList;
import java.util.List;

public class Booking_Activity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    ImageButton imbtnBack;
    private RecyclerView rcvBV;
    private AdapterBV adapterBV;
    private SearchView svSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        imbtnBack=findViewById(R.id.imbtnBack);
        rcvBV = findViewById(R.id.recBV);
        svSearch = findViewById(R.id.svSearch);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvBV.setLayoutManager(linearLayoutManager);
        addEvents();
        adapterBV = new AdapterBV(this,getListBV());
        rcvBV.setAdapter(adapterBV);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvBV.addItemDecoration(itemDecoration);
        svSearch.setOnQueryTextListener(this);

    }
    private void addEvents() {
        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Booking_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<BenhVien> getListBV() {
        List<BenhVien> benhViens = new ArrayList<>();
        benhViens.add(new BenhVien(R.drawable.bv_tudu,"Bệnh viện Từ Dũ","284,Cống Quỳnh,Phạm Ngũ Lão,Q.1,HCM"));
        benhViens.add(new BenhVien(R.drawable.bv_choray,"Bệnh viện Chợ Rẫy","21B,Nguyễn Chí Thanh,P.12,Q.5,HCM"));
        benhViens.add(new BenhVien(R.drawable.bv_yduoc,"Bệnh viện Y Dược","201,Nguyễn Chí Thanh,P.12,Q.5,HCM"));
        return  benhViens;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapterBV.filter(newText);

        return false;
    }
}



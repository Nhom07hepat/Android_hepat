package com.example.giaodientrangchu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.LichKhamAdapter;
import com.example.adapter.LichKhamDaHuyApdater;
import com.example.adapter.LichKhamdahtAdapter;
import com.example.model.LichKhamDaHuy;
import com.example.model.LichKhamDaht;
import com.example.model.LichKhamht;

import java.util.ArrayList;

public class Lichsukham extends AppCompatActivity {
    RecyclerView reclichsukham;
    ArrayList<LichKhamht> lichKhamhts;
    LichKhamAdapter adapter;
    ImageButton imbBack;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_kham);
        reclichsukham = findViewById(R.id.reclichkhamdatkham);
        imbBack = findViewById(R.id.imbtnBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lichsukham.this, TrangUser.class);
                startActivity(intent);
            }
        });

        DBBooking dbBooking = new DBBooking(this);
        lichKhamhts = dbBooking.getAllLichKhamht();
        adapter = new LichKhamAdapter(lichKhamhts,this);
        reclichsukham.setAdapter(adapter);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(RecyclerView.VERTICAL);
        reclichsukham.setLayoutManager(layout);


    }
}

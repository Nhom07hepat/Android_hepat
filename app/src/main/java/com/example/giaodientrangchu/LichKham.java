package com.example.giaodientrangchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;


import com.example.adapter.LichKhamAdapter;
import com.example.adapter.LichKhamDaHuyApdater;
import com.example.adapter.LichKhamdahtAdapter;
import com.example.model.LichKhamDaHuy;
import com.example.model.LichKhamDaht;
import com.example.model.LichKhamht;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class LichKham extends AppCompatActivity {
    RecyclerView reclichkhamht, reclichkhamhuy,reclichkhamdaht;
    ArrayList<LichKhamht> lichKhamhts;
    ArrayList<LichKhamDaht> lichKhamDahts;
    ArrayList<LichKhamDaHuy> lichKhamDaHuys;
    LichKhamDaHuyApdater lichKhamDaHuyApdater;
    LichKhamdahtAdapter lichKhamdahtAdapter;
    LichKhamAdapter adapter;
    ImageButton imbtnBack;
    BottomNavigationView navigationView;
    //
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_kham);

        linkView();
        loadTab();
//        initData();
//        loadData();
        addEvents();
        DB_HUY db_huy = new DB_HUY(this);
        lichKhamDaHuys = db_huy.getAllLichKhamht();
        lichKhamDaHuyApdater = new LichKhamDaHuyApdater(lichKhamDaHuys,this);
        reclichkhamhuy.setAdapter(lichKhamDaHuyApdater);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(RecyclerView.VERTICAL);
        reclichkhamhuy.setLayoutManager(layout);

        DB_LichHT db_lichHT = new DB_LichHT(this);
        lichKhamDahts = db_lichHT.getAllLichKhamht();
        lichKhamdahtAdapter = new LichKhamdahtAdapter(lichKhamDahts,this);
        reclichkhamdaht.setAdapter(lichKhamdahtAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        reclichkhamdaht.setLayoutManager(linearLayoutManager);

        navigationView.setSelectedItemId(R.id.action_lich);
    }

    @Override
    protected void onStart() {
        super.onStart();
        DBBooking dbBooking = new DBBooking(this);
        lichKhamhts = dbBooking.getAllLichKhamht();
        adapter = new LichKhamAdapter(lichKhamhts,this);
        reclichkhamht.setAdapter(adapter);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(RecyclerView.VERTICAL);
        reclichkhamht.setLayoutManager(layout);

    }

    private void addEvents() {
        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LichKham.this, MainActivity.class);
                startActivity(intent);
            }
        });
        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_lich:
                        break;
                    case R.id.action_qr:
                        break;
                    case R.id.action_thongbao:
                        startActivity(new Intent(getApplicationContext(),ThongBao_Activity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_taikhoan:
                        startActivity(new Intent(getApplicationContext(),TrangUser.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }

    private void loadTab() {
        final TabHost tab=findViewById(android.R.id.tabhost);
        tab.setup();
        TabHost.TabSpec spec;
        spec=tab.newTabSpec("t1");
        spec.setContent(R.id.tab_1);
        spec.setIndicator("Hiện tại");
        tab.addTab(spec);
        spec=tab.newTabSpec("t2");
        spec.setContent(R.id.tab_2);
        spec.setIndicator("Đã hoàn thành");
        tab.addTab(spec);
        spec=tab.newTabSpec("t3");
        spec.setContent(R.id.tab_3);
        spec.setIndicator("Đã hủy");
        tab.addTab(spec);
        tab.setCurrentTab(0);
    }
    //
//    private void loadData() {
//        adapter=new LichKhamAdapter(this,R.layout.list_view_lich_kham_hien_tai,lichKhamhts);
//        lvLichkhamht.setAdapter(adapter);
//
//        lichKhamdahtAdapter=new LichKhamdahtAdapter(this,R.layout.list_view_lich_kham_da_hoan_thanh,lichKhamDahts);
//        lvLichKhamdaht.setAdapter(lichKhamdahtAdapter);
//
//        lichKhamDaHuyApdater=new LichKhamDaHuyApdater(this,R.layout.list_view_lich_kham_da_huy,lichKhamDaHuys);
//        lvLichKhamdahuy.setAdapter(lichKhamDaHuyApdater);
//    }
//
//    private void initData() {
//        lichKhamhts=new ArrayList<>();
//        lichKhamhts.add(new LichKhamht("Bệnh viện Từ Dũ","10:00 AM","12/09/21","Đã xác nhận",R.drawable.ic_baseline_check_24));
//        lichKhamhts.add(new LichKhamht("Bệnh viện Y dược","8:00 AM","12/10/21","Chưa xác nhận",R.drawable.ic_baseline_close_24));
//        lichKhamhts.add(new LichKhamht("Bệnh viện Chợ Rẫy","14:00 PM","30/11/21","Đã xác nhận",R.drawable.ic_baseline_check_24));
//
//        lichKhamDahts=new ArrayList<>();
//        lichKhamDahts.add(new LichKhamDaht("Bệnh viện Từ Dũ","10:00 AM","12/09/21"));
//        lichKhamDahts.add(new  LichKhamDaht("Bệnh viện Y dươc","8:00 AM","12/10/21"));
//        lichKhamDahts.add(new LichKhamDaht("Bệnh viện Chợ Rẫy","14:00 PM","30/11/21"));
//
//        lichKhamDaHuys=new ArrayList<>();
//        lichKhamDaHuys.add(new LichKhamDaHuy("Bệnh viện Từ Dũ","10:00 AM","12/09/21"));
//        lichKhamDaHuys.add(new LichKhamDaHuy("Bệnh viện Y dươc","8:00 AM","12/10/21"));
//        lichKhamDaHuys.add(new LichKhamDaHuy("Bệnh viện Chợ Rẫy","14:00 PM","30/11/21"));
//
//    }
//
//
    private void linkView() {
//
//        lvLichkhamht=findViewById(R.id.lvlichkhamht);
//
//        lvLichKhamdaht=findViewById(R.id.lvlichkhamdaht);
//        lvLichKhamdahuy=findViewById(R.id.lvlichkhamdahuy);
        reclichkhamht = findViewById(R.id.reclichkhamht);
        reclichkhamhuy = findViewById(R.id.reclichkhamdahuy);
        reclichkhamdaht = findViewById(R.id.reclichkhamdaht);
        imbtnBack = findViewById(R.id.imbtnBack);
        navigationView = findViewById(R.id.navigation);
    }
}
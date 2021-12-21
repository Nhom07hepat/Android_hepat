package com.example.giaodientrangchu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.model.ThongBao;
import com.example.adapter.AdapterTB;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ThongBao_Activity extends AppCompatActivity {
    ImageButton imbtnBack;
    ListView lvTB;
    ArrayList<ThongBao> arrayList;
    AdapterTB adapterTB;
    BottomNavigationView navigationView;
    Button btnXoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        linkView();
        loadData();
        addEvents();
        navigationView.setSelectedItemId(R.id.action_thongbao);
    }

    private void addEvents() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvTB.setAdapter(null);
            }
        });

        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongBao_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

       lvTB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(ThongBao_Activity.this,MainActivity.class);
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
                      startActivity(new Intent(getApplicationContext(),LichKham.class));
                      finish();
                      overridePendingTransition(0,0);
                      return;
                  case R.id.action_qr:
                      startActivity(new Intent(getApplicationContext(),Activity_QR.class));
                      finish();
                      overridePendingTransition(0,0);
                      return;
                  case R.id.action_thongbao:
                      break;
                  case R.id.action_taikhoan:
                      startActivity(new Intent(getApplicationContext(),TrangUser.class));
                      finish();
                      overridePendingTransition(0,0);
                      return;
              }
          }
      });

    }

    private void linkView() {
        lvTB = findViewById(R.id.lvTB);
        imbtnBack = findViewById(R.id.imbtnBack);
        navigationView = findViewById(R.id.navigation);
        btnXoa = findViewById(R.id.btnXoa);

    }

    private void loadData() {
        arrayList = new ArrayList<>();
        arrayList.add(new ThongBao(R.drawable.tb_lich,"Bạn có một lịch khám","21/11/2021","10:00 AM","13:19"));
        arrayList.add(new ThongBao(R.drawable.hopital,"Một bệnh viện được thêm vào Hepat","21/11/2021","3:00 PM","13:19"));
        arrayList.add(new ThongBao(R.drawable.tinmoi,"Một tin mới trên diễn đàn","21/11/2021","4:10 PM","13:19"));

        adapterTB = new AdapterTB(ThongBao_Activity.this, R.layout.item_list_thongbao, arrayList);
        lvTB.setAdapter(adapterTB);
    }
}
package com.example.giaodientrangchu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.model.ThongBao;
import com.example.adapter.AdapterTB;

import java.util.ArrayList;

public class ThongBao_Activity extends AppCompatActivity {
    ImageButton imbtnHomePage, imbtnLichKham, imbtnThongBao, imbtnTaiKhoan;
    ListView lvTB;
    ArrayList<ThongBao> arrayList;
    AdapterTB adapterTB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        linkView();
        loadData();
        addEvents();
    }

    private void addEvents() {

       lvTB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(ThongBao_Activity.this,MainActivity.class);
               startActivity(intent);
           }
       });
        imbtnLichKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongBao_Activity.this, LichKham.class);
                startActivity(intent);
            }
        });
        imbtnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongBao_Activity.this, TrangUser.class);
                startActivity(intent);
            }
        });

        imbtnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongBao_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void linkView() {
        lvTB = findViewById(R.id.lvTB);
        imbtnHomePage = findViewById(R.id.imbtnHomePage);
        imbtnLichKham = findViewById(R.id.imbtnLichKham);
        imbtnThongBao = findViewById(R.id.imbtnThongBao);
        imbtnTaiKhoan = findViewById(R.id.imbtnTaikhoan);

    }

    private void loadData() {
        arrayList = new ArrayList<>();
        arrayList.add(new ThongBao(R.drawable.tb_lich,"Bạn có một lịch khám","21/11/2021","10:00 AM","13:19"));
        arrayList.add(new ThongBao(R.drawable.vithuoc,"Uống thuốc bạn ơi","21/11/2021","8:00 AM","12:00"));
        arrayList.add(new ThongBao(R.drawable.hopital,"Một bệnh viện được thêm vào Hepat","21/11/2021","3:00 PM","13:19"));
        arrayList.add(new ThongBao(R.drawable.tinmoi,"Một tin mới trên diễn đàn","21/11/2021","4:10 PM","13:19"));

        adapterTB = new AdapterTB(ThongBao_Activity.this, R.layout.item_list_thongbao, arrayList);
        lvTB.setAdapter(adapterTB);
    }
}
package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imbtnDatlich,imbtnTuVan,imbtnBenhAn,imbtnDienDan,imbtnUser,imbtnHomePage,imbtnLichKham,imbtnThongBao,imbtnTaiKhoan;
    Button btnXemthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkView();
        addEvents();
    }

    private void addEvents() {
        imbtnLichKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LichKham.class);
                startActivity(intent);
            }
        });
       imbtnDatlich.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Booking_Activity.class);
               startActivity(intent);
           }
       });

        imbtnDienDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DienDan.class);
                startActivity(intent);
            }
        });
        imbtnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ThongBao_Activity.class);
                startActivity(intent);
            }
        });
        imbtnBenhAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HoSo_Activity.class);
                startActivity(intent);
            }
        });
        imbtnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TrangUser.class);
                startActivity(intent);
            }
        });
        imbtnTuVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_tu_van.class);
                startActivity(intent);
            }
        });
        btnXemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GioithieuveHepat.class);
                startActivity(intent);
            }
        });
    }


    private void linkView() {
        imbtnDatlich=findViewById(R.id.imbtnDatLich);
        imbtnTuVan=findViewById(R.id.imbtnTuVan);
        imbtnBenhAn=findViewById(R.id.imbtnBenhAn);
        imbtnDienDan=findViewById(R.id.imbtnDienDan);
        imbtnUser=findViewById(R.id.imbtnUser);
        imbtnHomePage=findViewById(R.id.imbtnHomePage);
        imbtnLichKham=findViewById(R.id.imbtnLichKham);
        imbtnThongBao=findViewById(R.id.imbtnThongBao);
        imbtnTaiKhoan=findViewById(R.id.imbtnTaikhoan);
        btnXemthem=findViewById(R.id.btnXemthem);
    }
}
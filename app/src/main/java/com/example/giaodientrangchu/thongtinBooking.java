package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.LichKhamht;

import java.util.Locale;

public class thongtinBooking extends AppCompatActivity {
    TextView txtBV, txtDate, txtTime;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_booking);
        linkViews();
        nhanDL();
        addEvents();
    }

    private void addEvents() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtBV.getText().toString().trim();
                String date = txtDate.getText().toString().trim();
                String time = txtTime.getText().toString().trim();
                DBBooking dbBooking = new DBBooking(thongtinBooking.this);
                LichKhamht l = new LichKhamht(name,date,time);
                long res = dbBooking.addLichKham(l);
                if(res >0){
                    Toast.makeText(thongtinBooking.this,"Saved",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(thongtinBooking.this,"Failed",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(thongtinBooking.this, LichKham.class);
                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        txtBV = findViewById(R.id.txtBV);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        btnOK = findViewById(R.id.btnOK);
    }
    public void nhanDL(){
        Intent intent = getIntent();
        String bv = intent.getStringExtra(DatLich2_Activity.Bv);
        String ngaydat = intent.getStringExtra(DatLich2_Activity.Ngaydat);
        String giodat = intent.getStringExtra(DatLich2_Activity.Giodat);
        txtBV.setText(bv);
        txtDate.setText(ngaydat);
        txtTime.setText(giodat);
    }
}
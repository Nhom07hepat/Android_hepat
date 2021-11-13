package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class thongtinBooking extends AppCompatActivity {
    TextView txtBV, txtDate, txtTime;
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_booking);
        linkViews();
        nhanDL();
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
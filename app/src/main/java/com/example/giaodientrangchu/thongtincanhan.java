package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class thongtincanhan extends AppCompatActivity {
    TextView txtHoTen, txtNgaySinh, txtSDT, txtDiaChi, txtGT;
    Button btnLuu;
    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincanhan);
        txtHoTen = findViewById(R.id.txtTen);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtGT = findViewById(R.id.txtGioiTinh);
        txtSDT = findViewById(R.id.txtSDT);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        btnLuu = findViewById(R.id.btnLuu);
        imbBack = findViewById(R.id.imbtnBack);


        nhanDL();
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(thongtincanhan.this,"Lưu thành công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(thongtincanhan.this,TrangUser.class);
                startActivity(intent);
            }
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongtincanhan.this,TrangUser.class);
                startActivity(intent);
            }
        });

    }
    public  void nhanDL(){
        Intent intent = getIntent();
        String hoten = intent.getStringExtra(capnhatthongtin.Hoten);
        String ngaysinh = intent.getStringExtra(capnhatthongtin.NgaySinh);
        String gioitinh = intent.getStringExtra(capnhatthongtin.GT);
        String SDT = intent.getStringExtra(capnhatthongtin.SDT);
        String DiaChi = intent.getStringExtra(capnhatthongtin.DiaChi);
        txtHoTen.setText(hoten);
        txtNgaySinh.setText(ngaysinh);
        txtGT.setText(gioitinh);
        txtSDT.setText(SDT);
        txtDiaChi.setText(DiaChi);

    }
}
package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class capnhatthongtin extends AppCompatActivity {
    EditText edtHoTen, edtNgaySinh, edtSDT, edtDiaChi;
    Button btnCapNhat;
    ImageButton imbBack;
    Spinner spinnerGT;
    String[] GioiTinh = new String[]{
            "Nam", "Nữ"
    };
    public  static final String Hoten ="Họ tên";
    public  static final String NgaySinh ="Ngày sinh";
    public static final String GT = "Giới tính";
    public static final String SDT = "Số điện thoại";
    public static final String DiaChi = "Địa chỉ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhatthongtin);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtSDT = findViewById(R.id.edtSDT);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        spinnerGT = findViewById(R.id.spinerGT);
        btnCapNhat = findViewById(R.id.btnCapNhatTT);
        imbBack = findViewById(R.id.imbtnBack);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GioiTinh);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGT.setAdapter(adapter);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoTen.getText().toString();
                String ngaysinh = edtNgaySinh.getText().toString();
                String gioitinh = spinnerGT.getSelectedItem().toString();
                String sdt = edtSDT.getText().toString();
                String diachi = edtDiaChi.getText().toString();
                truyenDL(hoten,ngaysinh,gioitinh,sdt,diachi);
            }
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(capnhatthongtin.this,TrangUser.class);
                startActivity(intent);
            }
        });
    }

    public void truyenDL (String hoten, String ngaysinh, String gioitinh, String sdt, String diachi){
        Intent intent = new Intent(capnhatthongtin.this,thongtincanhan.class);
        intent.putExtra(Hoten,hoten);
        intent.putExtra(NgaySinh,ngaysinh);
        intent.putExtra(GT,gioitinh);
        intent.putExtra(SDT,sdt);
        intent.putExtra(DiaChi,diachi);
        startActivity(intent);

    }
}
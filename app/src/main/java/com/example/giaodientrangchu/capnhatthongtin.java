package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class capnhatthongtin extends AppCompatActivity {
    EditText edtHoTen, edtNgaySinh, edtSDT, edtDiaChi;
    Button btnCapNhat;
    ImageButton imbBack;
    Spinner spinnerGT;
    String[] GioiTinh = new String[]{
            "Nam", "Nữ"
    };
    SharedPreferences sharedPreferences;
    public static final String SHARE_PREFERENCES = "share_preferences";
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

        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        String ngaysinh = sharedPreferences.getString(NgaySinh,null);
        String gioitinh = sharedPreferences.getString(GT,null);
        String sdt = sharedPreferences.getString(SDT,null);
        String diachi = sharedPreferences.getString(DiaChi,null);
        if(hoten != null && ngaysinh!= null && sdt != null && diachi !=null){
            Intent intent = new Intent(capnhatthongtin.this,thongtincanhan.class);
            startActivity(intent);
        }

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Hoten, edtHoTen.getText().toString());
                editor.putString(NgaySinh, edtNgaySinh.getText().toString());
                editor.putString(GT, spinnerGT.getSelectedItem().toString());
                editor.putString(SDT, edtSDT.getText().toString());
                editor.putString(DiaChi, edtDiaChi.getText().toString());
                editor.apply();
                Intent intent = new Intent(capnhatthongtin.this,thongtincanhan.class);
                startActivity(intent);
                Toast.makeText(capnhatthongtin.this,"Saved",Toast.LENGTH_SHORT).show();

//                String hoten = edtHoTen.getText().toString();
//                String ngaysinh = edtNgaySinh.getText().toString();
//                String gioitinh = spinnerGT.getSelectedItem().toString();
//                String sdt = edtSDT.getText().toString();
//                String diachi = edtDiaChi.getText().toString();
//                truyenDL(hoten,ngaysinh,gioitinh,sdt,diachi);
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

//    public void truyenDL (String hoten, String ngaysinh, String gioitinh, String sdt, String diachi){
//        Intent intent = new Intent(capnhatthongtin.this,thongtincanhan.class);
//        intent.putExtra(Hoten,hoten);
//        intent.putExtra(NgaySinh,ngaysinh);
//        intent.putExtra(GT,gioitinh);
//        intent.putExtra(SDT,sdt);
//        intent.putExtra(DiaChi,diachi);
//        startActivity(intent);
//
//    }
}
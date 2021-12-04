package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    Button btnCSTT, btnOK;
    ImageButton imbBack;
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
        setContentView(R.layout.activity_thongtincanhan);
        txtHoTen = findViewById(R.id.txtTen);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtGT = findViewById(R.id.txtGioiTinh);
        txtSDT = findViewById(R.id.txtSDT);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        btnCSTT = findViewById(R.id.btnCSTT);
        btnOK = findViewById(R.id.btnOK);
        imbBack = findViewById(R.id.imbtnBack);

        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        String ngaysinh = sharedPreferences.getString(NgaySinh,null);
        String gioitinh = sharedPreferences.getString(GT,null);
        String sdt = sharedPreferences.getString(SDT,null);
        String diachi = sharedPreferences.getString(DiaChi,null);
        if(hoten != null || ngaysinh!= null || gioitinh != null || sdt != null || diachi !=null){
           txtHoTen.setText(hoten);
           txtNgaySinh.setText(ngaysinh);
           txtGT.setText(gioitinh);
           txtSDT.setText(sdt);
           txtDiaChi.setText(diachi);
        }

//        nhanDL();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(thongtincanhan.this,TrangUser.class);
                startActivity(intent);

            }
        });
        btnCSTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(Hoten);
                editor.remove(NgaySinh);
                editor.remove(GT);
                editor.remove(SDT);
                editor.remove(DiaChi);
                editor.commit();
                Intent intent = new Intent(thongtincanhan.this, capnhatthongtin.class);
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


//    public  void nhanDL(){
//        Intent intent = getIntent();
//        String hoten = intent.getStringExtra(capnhatthongtin.Hoten);
//        String ngaysinh = intent.getStringExtra(capnhatthongtin.NgaySinh);
//        String gioitinh = intent.getStringExtra(capnhatthongtin.GT);
//        String SDT = intent.getStringExtra(capnhatthongtin.SDT);
//        String DiaChi = intent.getStringExtra(capnhatthongtin.DiaChi);
//        txtHoTen.setText(hoten);
//        txtNgaySinh.setText(ngaysinh);
//        txtGT.setText(gioitinh);
//        txtSDT.setText(SDT);
//        txtDiaChi.setText(DiaChi);
//
//    }
}
package com.example.giaodientrangchu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HoSo_Activity extends AppCompatActivity {
    ImageButton imbtnBack;
    TextView txtTen, txtNgaySinh, txtGt, txtsdt, txtdiachi;
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
        setContentView(R.layout.activity_ho_so);
        linkView();
        addEvents();
    }

    private void addEvents() {
        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HoSo_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        String ngaysinh = sharedPreferences.getString(NgaySinh,null);
        String gioitinh = sharedPreferences.getString(GT,null);
        String sdt = sharedPreferences.getString(SDT,null);
        String diachi = sharedPreferences.getString(DiaChi,null);
        if(hoten != null || ngaysinh!= null || gioitinh != null || sdt != null || diachi !=null){
            txtTen.setText(hoten);
            txtNgaySinh.setText(ngaysinh);
            txtGt.setText(gioitinh);
            txtsdt.setText(sdt);
            txtdiachi.setText(diachi);
        }
    }

    private void linkView() {
        imbtnBack=findViewById(R.id.imbtnBackHoso);
        txtTen = findViewById(R.id.txtTen);
        txtGt = findViewById(R.id.txtGt);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtsdt = findViewById(R.id.txtsdt);
        txtdiachi = findViewById(R.id.txtdiachi);
    }
}
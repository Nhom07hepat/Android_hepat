package com.example.giaodientrangchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangUser extends AppCompatActivity {
    Button btnDangXuat,btnCapNhat,btnGioiThieu,btnHotline, btnlichsuKham;
    Dialog dialog_hotline,dialog;
    BottomNavigationView navigationView;
    TextView txtHovaTen, txtSoDienThoai;

    SharedPreferences sharedPreferences;
    public static final String SHARE_PREFERENCES = "share_preferences";
    public  static final String Hoten ="Họ tên";
    public static final String SDT = "Số điện thoại";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_user);
        btnGioiThieu=findViewById(R.id.btnGioithieu);
        btnDangXuat = findViewById(R.id.btnDangxuat);
        btnCapNhat = findViewById(R.id.btnThongtincanhan);
        btnHotline = findViewById(R.id.btnHotline);
        btnlichsuKham = findViewById(R.id.btnLichsudatkham);
        navigationView = findViewById(R.id.navigation);
        navigationView.setSelectedItemId(R.id.action_taikhoan);
        txtHovaTen = findViewById(R.id.txtHovaTen);
        txtSoDienThoai = findViewById(R.id.txtSoDienThoai);
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
                        break;
                    case R.id.action_thongbao:
                        startActivity(new Intent(getApplicationContext(),ThongBao_Activity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_taikhoan:
                        break;
                }
            }
        });
        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        String sdt = sharedPreferences.getString(SDT,null);
        if(hoten != null || sdt != null){
            txtHovaTen.setText(hoten);
            txtSoDienThoai.setText(sdt);

        }
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangUser.this,capnhatthongtin.class);
                startActivity(intent);
            }
        });
        btnlichsuKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TrangUser.this, Lichsukham.class);
                startActivity(intent);
            }
        });

       dialog = new Dialog(TrangUser.this);
        dialog.setContentView(R.layout.dialog_dangxuat);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_dialog));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        Button btnOK = dialog.findViewById(R.id.btnOK);
        Button btnHuyDangXuat = dialog.findViewById(R.id.btnHuyDangXuat);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrangUser.this,"Xác nhận",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = new Intent(TrangUser.this,Login_Activity.class);
                startActivity(intent);
            }
        });
        btnHuyDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrangUser.this,"Hủy",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
// ........DIALOG....HOTLINE
        dialog_hotline = new Dialog(TrangUser.this);
        dialog_hotline.setContentView(R.layout.dialog_hotline);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog_hotline.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_dialog));
        }
        dialog_hotline.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog_hotline.setCancelable(false);
        Button btn_cancel = dialog_hotline.findViewById(R.id.btn_cancel);
        Button btn_call = dialog_hotline.findViewById(R.id.btn_call);
        TextView txtHotline = dialog_hotline.findViewById(R.id.txtHotLine);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_DIAL);
                Uri uri=Uri.parse("tel:" + txtHotline.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangUser.this,TrangUser.class);
                startActivity(intent);
            }
        });
        btnHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_hotline.show();
            }
        });

        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this, GioithieuveHepat.class);
                startActivity(intent);
            }
        });

        btnHuyDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this,TrangUser.class);
                startActivity(intent);
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
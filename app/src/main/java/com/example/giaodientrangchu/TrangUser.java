package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TrangUser extends AppCompatActivity {
    ImageButton imbtnHomePage, imbtnLichKham, imbtnThongBao, imbtnTaiKhoan;
    Button btnDangXuat,btnCapNhat,btnGioiThieu,btnHotline;
    Dialog dialog_hotline,dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_user);
        imbtnHomePage = findViewById(R.id.imbtnHomePage);
        imbtnLichKham = findViewById(R.id.imbtnLichKham);
        imbtnThongBao = findViewById(R.id.imbtnThongBao);
        imbtnTaiKhoan = findViewById(R.id.imbtnTaikhoan);
        btnGioiThieu=findViewById(R.id.btnGioithieu);
        btnDangXuat = findViewById(R.id.btnDangxuat);
        btnCapNhat = findViewById(R.id.btnThongtincanhan);
        btnHotline = findViewById(R.id.btnHotline);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangUser.this,capnhatthongtin.class);
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

        imbtnLichKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this, LichKham.class);
                startActivity(intent);
            }
        });
        imbtnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this, ThongBao_Activity.class);
                startActivity(intent);
            }
        });
        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this, GioithieuveHepat.class);
                startActivity(intent);
            }
        });

        imbtnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangUser.this, MainActivity.class);
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
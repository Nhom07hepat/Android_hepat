package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
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
    String strTen, strNgay, strGioiTinh,strSdt,strDiaChi;
    Dialog dialog;
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
        edtNgaySinh.setInputType(InputType.TYPE_CLASS_DATETIME
                | InputType.TYPE_DATETIME_VARIATION_DATE);
        edtSDT = findViewById(R.id.edtSDT);
        edtSDT.setInputType(InputType.TYPE_CLASS_PHONE);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtDiaChi.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_NORMAL);
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

               strTen= edtHoTen.getText().toString();
               strNgay= edtNgaySinh.getText().toString();
               strGioiTinh= spinnerGT.getSelectedItem().toString();
               strSdt= edtSDT.getText().toString();
               strDiaChi=edtDiaChi.getText().toString();
                if(strTen.matches("")) {
                    Toast.makeText(capnhatthongtin.this, "⚠️Không được bỏ trống Tên!", Toast.LENGTH_LONG).show();}
                else if (strNgay.matches("__/__/____")) {
                    Toast.makeText(capnhatthongtin.this, "⚠️Không được bỏ trống Ngày sinh! ", Toast.LENGTH_LONG).show();}
                           else if (strSdt.matches("")) {
                    Toast.makeText(capnhatthongtin.this, "⚠️Không được bỏ trống Số điện thoại! ", Toast.LENGTH_LONG).show();}
                           else if (strDiaChi.matches("")) {
                    Toast.makeText(capnhatthongtin.this, "⚠️Không được bỏ trống Địa chỉ! ", Toast.LENGTH_LONG).show();}
                else if (strTen.matches("")||strNgay.matches("")||strGioiTinh.matches("")||strSdt.matches("")||strDiaChi.matches("")) {
                    Toast.makeText(capnhatthongtin.this, "⚠️Không được bỏ trống trường nào! ", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Hoten, edtHoTen.getText().toString());
                    editor.putString(NgaySinh, edtNgaySinh.getText().toString());
                    editor.putString(GT, spinnerGT.getSelectedItem().toString());
                    editor.putString(SDT, edtSDT.getText().toString());
                    editor.putString(DiaChi, edtDiaChi.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(capnhatthongtin.this, thongtincanhan.class);
                    startActivity(intent);
                    Toast.makeText(capnhatthongtin.this, "✔ Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                }
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

}
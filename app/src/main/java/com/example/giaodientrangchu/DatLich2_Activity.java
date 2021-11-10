package com.example.giaodientrangchu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.model.BenhVien;

public class DatLich2_Activity extends AppCompatActivity {
    private CalendarView calendarView;
    private TextView txtNgayDat, txtGioDat;
    private Button btnLich, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich2);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        BenhVien benhVien = (BenhVien) bundle.get("Benh vien");
        ImageButton imbtnBenhVien = findViewById(R.id.imbtnBenhVien);
        imbtnBenhVien.setImageResource(benhVien.getImvBenhVien());
        TextView txtNameBV = findViewById(R.id.txtNameBV);
        txtNameBV.setText(benhVien.getTxtName());
        TextView txtAddressBV = findViewById(R.id.txtAddressBV);
        txtAddressBV.setText(benhVien.getTxtAddress());

        calendarView = findViewById(R.id.calendarView);
        txtNgayDat = findViewById(R.id.txtNgayDat);
        txtGioDat = findViewById(R.id.txtGioDat);
        btnLich = findViewById(R.id.btnLich);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/"+ year;
                txtNgayDat.setText(date);
            }
        });
        

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("7h - 8h");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("9h - 10h");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("13h - 14h");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("15h - 16h");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("8h - 9h");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("10h - 11h");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("14h - 15h");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtGioDat.setText("16h - 17h");
            }
        });
        dialog = new Dialog(DatLich2_Activity.this);
        dialog.setContentView(R.layout.custom_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_dialog));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        Button btnXacNhan = dialog.findViewById(R.id.btnXacNhan);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatLich2_Activity.this,"Xác nhận",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                Intent intent = new Intent(DatLich2_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatLich2_Activity.this,"Hủy",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}
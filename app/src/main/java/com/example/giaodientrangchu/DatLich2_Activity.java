package com.example.giaodientrangchu;

import android.app.Dialog;
import android.content.Intent;
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
    CalendarView calendarView;
    TextView txtNgayDat;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btnDatLich;
    TextView txtGioDat;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich2);
        dialog = new Dialog(DatLich2_Activity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_dialog));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        Button btnXacNhan = dialog.findViewById(R.id.btnXacNhan);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);
        TextView txtXacNhan = dialog.findViewById(R.id.txtXacNhan);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtXacNhan.setText("Bạn đã đặt lịch hẹn thành công");
                Toast.makeText(DatLich2_Activity.this,"Xác nhận",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatLich2_Activity.this,"Hủy",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

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

        calendarView = findViewById(R.id.clendarView);
        txtNgayDat = findViewById(R.id.txtNgayDat);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayofMonth) {
                String date = dayofMonth + "/"+ month+"/"+year;
                txtNgayDat.setText(date);
            }
        });
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        txtGioDat = findViewById(R.id.txtGioDat);
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
                txtGioDat.setText("13h -14h");
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
                txtGioDat.setText("16h - 17h ");
            }
        });
        btnDatLich = findViewById(R.id.btnDatLich);
        btnDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

    }
}
package com.example.giaodientrangchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.LichKhamht;

public class ChinhSuaLK extends AppCompatActivity {
    private CalendarView calendarView;
    int id;
    private TextView txtName, txtNgayDat, txtGioDat;
    private Button btnCS, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    Dialog dialog;
    public static final String Bv = "Bệnh viện ";
    public static final String Ngaydat = "Ngày đặt";
    public static final String Giodat = "Giờ đặt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_lk);
        calendarView = findViewById(R.id.calendarView);
        txtName = findViewById(R.id.txtNameBV);
        txtNgayDat = findViewById(R.id.txtNgayDat);
        txtGioDat = findViewById(R.id.txtGioDat);
        btnCS = findViewById(R.id.btnChinhSuaLK);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        LichKhamht l = (LichKhamht) getIntent().getExtras().getSerializable("LichKham");
        id = l.getId();
        txtName.setText(l.getName());
        txtNgayDat.setText(l.getDate());
        txtGioDat.setText(l.getTime());

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
        dialog = new Dialog(ChinhSuaLK.this);
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
                String name = txtName.getText().toString().trim();
                String date = txtNgayDat.getText().toString().trim();
                String time = txtGioDat.getText().toString().trim();
                LichKhamht l = new LichKhamht(id, name,date,time);

                DBBooking dbBooking = new DBBooking(ChinhSuaLK.this);
                int result = dbBooking.updateLK(l);
                if(result >0){
                    Toast.makeText(ChinhSuaLK.this,"Updated",Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(ChinhSuaLK.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChinhSuaLK.this,"Hủy",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

            }
        });
    }


}

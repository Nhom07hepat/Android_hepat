package com.example.giaodientrangchu;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.model.BenhVien;

public class DatLich2_Activity extends AppCompatActivity {

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
    }
}
package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GioithieuveHepat extends AppCompatActivity {
    ImageButton imbtnBackHepat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioithieuve_hepat);

        linkView();
        addEvents();
    }

    private void addEvents() {
        imbtnBackHepat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GioithieuveHepat.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void linkView() {
        imbtnBackHepat=findViewById(R.id.imbtnBackVeHepat);
    }
}
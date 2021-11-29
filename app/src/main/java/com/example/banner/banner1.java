package com.example.banner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.giaodientrangchu.MainActivity;
import com.example.giaodientrangchu.R;

public class banner1 extends AppCompatActivity {
    ImageButton imbtnBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner1);
        imbtnBack= findViewById(R.id.imbtnBack);
        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(banner1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import com.example.adapter.TrieuChung1Adapter;
import com.example.giaodientrangchu.R;
import com.example.model.TrieuChung;

import java.util.ArrayList;
import java.util.List;

public class TuVan1_Activity extends AppCompatActivity {
    ImageButton imbtnBackTuVan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imbtnBackTuVan = findViewById(R.id.imbtnBackTuVan);
        imbtnBackTuVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TuVan1_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoTrieuChung);
        String [] trieuChungS = getResources().getStringArray(R.array.trieuChungS);
        TrieuChung1Adapter trieuChungAdapter = new TrieuChung1Adapter(this, R.layout.trieuchung1_layout_custom, getListTrieuChungS());
        autoCompleteTextView.setAdapter(trieuChungAdapter);

    }

    private List<TrieuChung> getListTrieuChungS() {
        List<TrieuChung> list = new ArrayList<>();
        list.add(new TrieuChung("Buồn nôn"));
        list.add(new TrieuChung("Bị đau cơ khi căng người"));
        list.add(new TrieuChung("Bị choáng khi đứng lên đột ngột"));
        list.add(new TrieuChung("Đau thắt ngực trái"));
        list.add(new TrieuChung("Đau vùng thượng vị"));
        list.add(new TrieuChung("Đau vai"));
        list.add(new TrieuChung("Đau đầu"));


        return  list;
    }
}
package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.BlankFragment;
import com.example.fragment.tuvan_fragment;
import com.example.fragment.tuvan_fragment1;
import com.example.fragment.tuvan_fragment2;
import com.example.fragment.tuvan_fragment3;
import com.example.fragment.tuvan_fragment4;
import com.example.fragment.tuvan_fragment5;


public class activity_tu_van extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinSearch;
    String[] TrieuChungs = new String[]{
            "Buồn nôn", "Bị đau cơ khi căng người", "Bị choáng khi đứng lên đột ngột",
            "Đau thắt ngực trái", "Đau vùng thuợng vị", "Choáng váng"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_van);

        spinSearch = findViewById(R.id.spinSearch);
        spinSearch.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TrieuChungs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSearch.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Fragment fragment;
        if(text.equals("Buồn nôn")){
            fragment = new tuvan_fragment();
        }
        else if(text.equals("Bị đau cơ khi căng người")){
            fragment = new tuvan_fragment1();

        }
        else if(text.equals("Bị choáng khi đứng lên đột ngột")){
            fragment = new tuvan_fragment2();
        }
        else if(text.equals("Đau thắt ngực trái")){
            fragment = new tuvan_fragment3();
        }
        else if(text.equals("Đau vùng thuợng vị")){
            fragment = new tuvan_fragment4();
        }
        else if(text.equals("Choáng váng")){
            fragment = new tuvan_fragment5();
        }
        else {
            fragment = new BlankFragment();
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,fragment);
        transaction.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

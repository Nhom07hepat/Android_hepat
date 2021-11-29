package com.example.giaodientrangchu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import android.widget.ImageButton;
import android.widget.ListView;
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


public class activity_tu_van extends AppCompatActivity {
    ImageButton imbtnBack;
    SearchView svSearch;
    ListView lvTC;
    String[] trieuchungs = {"Buồn nôn", "Bị đau cơ khi căng người", "Bị choáng khi đứng lên đột ngột", "Đau thắt ngực trái",
            "Đau vùng thuợng vị", "Choáng váng"};
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_van);
        svSearch = findViewById(R.id.svSearch);
        lvTC = findViewById(R.id.lvTC);
        imbtnBack=findViewById(R.id.imbtnBack);
        imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_tu_van.this,MainActivity.class);
                startActivity(intent);
            }
        });


        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter = new ArrayAdapter<String>(activity_tu_van.this, android.R.layout.simple_list_item_activated_1, trieuchungs);
                lvTC.setAdapter(adapter);
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        lvTC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Fragment fragment;
                if (text.equals("Buồn nôn")) {
                    fragment = new tuvan_fragment();
                } else if (text.equals("Bị đau cơ khi căng người")) {
                    fragment = new tuvan_fragment1();

                } else if (text.equals("Bị choáng khi đứng lên đột ngột")) {
                    fragment = new tuvan_fragment2();
                } else if (text.equals("Đau thắt ngực trái")) {
                    fragment = new tuvan_fragment3();
                } else if (text.equals("Đau vùng thuợng vị")) {
                    fragment = new tuvan_fragment4();
                } else if (text.equals("Choáng váng")) {
                    fragment = new tuvan_fragment5();
                } else {
                    fragment = new BlankFragment();
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();
            }
        });

    }
}
package com.example.giaodientrangchu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.AdapterBanner;
import com.example.adapter.RecyclerOnItemClick;
import com.example.banner.banner0;
import com.example.banner.banner1;
import com.example.banner.banner2;
import com.example.banner.banner3;
import com.example.fragment.BlankFragment;
import com.example.fragment.tuvan_fragment;
import com.example.fragment.tuvan_fragment1;
import com.example.fragment.tuvan_fragment2;
import com.example.fragment.tuvan_fragment3;
import com.example.fragment.tuvan_fragment4;
import com.example.fragment.tuvan_fragment5;
import com.example.model.Banner;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerOnItemClick {
    ImageButton imbtnDatlich,imbtnTuVan,imbtnBenhAn,imbtnDienDan,imbtnUser;
    Button btnXemthem;
    RecyclerView recycler_banner;
    List<Banner> bannerList;
    BottomNavigationView navigationView;
    SearchView svSearch;
    ListView lvTK;

    String[] chucnangs = {"Đặt lịch", "Tư vấn", "Diễn đàn", "Bệnh án",
             "Lịch khám","Thông báo","Tài khoản"};
    ArrayAdapter<String> adapter;

    TextView txtNameUser;
    SharedPreferences sharedPreferences;
    public static final String SHARE_PREFERENCES = "share_preferences";
    public  static final String Hoten ="Họ tên";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkView();
        addEvents();
        bannerList = new ArrayList<>();
        bannerList.add(new Banner(R.drawable.banner_main));
        bannerList.add(new Banner(R.drawable.banner_first));
        bannerList.add(new Banner(R.drawable.banner_second2));
        bannerList.add(new Banner(R.drawable.banner_third));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_banner.setLayoutManager(manager);

        AdapterBanner adapterBanner = new AdapterBanner(this,bannerList,this);
        recycler_banner.setAdapter(adapterBanner);

        navigationView.setSelectedItemId(R.id.action_home);

    }

    @Override
    public void onItemClick(int position) {
        if (position == 0) {
            Intent intent = new Intent(MainActivity.this, banner0.class);
           startActivity(intent);
        }
        else if (position == 1) {
            Intent intent = new Intent(MainActivity.this, banner2.class);
           startActivity(intent);
        }
        else if (position == 2){
            Intent intent = new Intent(MainActivity.this, banner3.class);
            startActivity(intent);
        }
        else if (position == 3){
            Intent intent = new Intent(MainActivity.this, banner1.class);
            startActivity(intent);
        }

    }
    private void addEvents() {
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_activated_1, chucnangs);
                lvTK.setAdapter(adapter);
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        lvTK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                if (text.equals("Đặt lịch")) {
                    Intent intent = new Intent(MainActivity.this, Booking_Activity.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                } else if (text.equals("Tư vấn")) {
                    Intent intent = new Intent(MainActivity.this, activity_tu_van.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                } else if (text.equals("Diễn đàn")) {
                    Intent intent = new Intent(MainActivity.this, DienDan.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                } else if (text.equals("Bệnh án")) {
                    Intent intent = new Intent(MainActivity.this, HoSo_Activity.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                } else if (text.equals("Lịch khám")) {
                    Intent intent = new Intent(MainActivity.this, LichKham.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                }else if (text.equals("Thông báo")) {
                    Intent intent = new Intent(MainActivity.this, ThongBao_Activity.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                }
                else if (text.equals("Tài khoản")){
                    Intent intent = new Intent(MainActivity.this, TrangUser.class);
                    startActivity(intent);
                    lvTK.setAdapter(null);
                }
                else {
                    lvTK.setAdapter(null);
                }
            }
        });

        sharedPreferences = getSharedPreferences(SHARE_PREFERENCES,MODE_PRIVATE);
        String hoten = sharedPreferences.getString(Hoten, null);
        if(hoten != null ){
            txtNameUser.setText(hoten);

        }
        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        break;
                    case R.id.action_lich:
                        startActivity(new Intent(getApplicationContext(),LichKham.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_qr:
                        break;
                    case R.id.action_thongbao:
                        startActivity(new Intent(getApplicationContext(),ThongBao_Activity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.action_taikhoan:
                        startActivity(new Intent(getApplicationContext(),TrangUser.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
       imbtnDatlich.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,Booking_Activity.class);
               startActivity(intent);
           }
       });

        imbtnDienDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DienDan.class);
                startActivity(intent);
            }
        });
        imbtnBenhAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HoSo_Activity.class);
                startActivity(intent);
            }
        });

        imbtnTuVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_tu_van.class);
                startActivity(intent);
            }
        });
        btnXemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GioithieuveHepat.class);
                startActivity(intent);
            }
        });
    }


    private void linkView() {
        txtNameUser = findViewById(R.id.txtNameUser);
        svSearch = findViewById(R.id.svSearch);
        lvTK = findViewById(R.id.lvTK);
        imbtnDatlich=findViewById(R.id.imbtnDatLich);
        imbtnTuVan=findViewById(R.id.imbtnTuVan);
        imbtnBenhAn=findViewById(R.id.imbtnBenhAn);
        imbtnDienDan=findViewById(R.id.imbtnDienDan);
        imbtnUser=findViewById(R.id.imbtnUser);
        btnXemthem=findViewById(R.id.btnXemthem);
        recycler_banner=findViewById(R.id.recycler_banner);
        navigationView = findViewById(R.id.navigation);

    }

}
package com.example.giaodientrangchu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.adapter.ViewPageAdapter;
import com.example.giaodientrangchu.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mNavigationView = findViewById(R.id.bottom_nav);
        mViewPaper = findViewById(R.id.view_paper);
        setUpViewPaper();

        mNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.action_home:
                        mViewPaper.setCurrentItem(0);
                        break;
                    case R.id.action_lich:
                        mViewPaper.setCurrentItem(1);
                        break;
                    case R.id.action_qr:
                        mViewPaper.setCurrentItem(2);
                        break;
                    case R.id.action_thongbao:
                        mViewPaper.setCurrentItem(3);
                        break;
                    case R.id.action_taikhoan:
                        mViewPaper.setCurrentItem(4);
                        break;

                }
                return true;
            }
        });
    }
    private void setUpViewPaper(){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPaper.setAdapter(viewPageAdapter);

        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.action_lich).setChecked(true);
                        break;
                    case 2:
                        mNavigationView.getMenu().findItem(R.id.action_qr).setChecked(true);
                        break;
                    case 3:
                        mNavigationView.getMenu().findItem(R.id.action_thongbao).setChecked(true);
                        break;
                    case 4:
                        mNavigationView.getMenu().findItem(R.id.action_taikhoan).setChecked(true);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}

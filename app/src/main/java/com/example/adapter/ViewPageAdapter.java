package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.fragment.Home_Fragment;
import com.example.fragment.LichKham_Fragment;

import java.util.Objects;

public class ViewPageAdapter extends FragmentStatePagerAdapter{


    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new  Home_Fragment();
            case 1:
                return new LichKham_Fragment();
            default:
                return new  Home_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}

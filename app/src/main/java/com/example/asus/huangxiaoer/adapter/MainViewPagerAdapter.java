package com.example.asus.huangxiaoer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.huangxiaoer.fragment.WoDeFragment;
import com.example.asus.huangxiaoer.fragment.YuYueFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter{

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position)
        {
            case 0:
                fragment=new YuYueFragment();
                break;
            case 1:

                fragment=new WoDeFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

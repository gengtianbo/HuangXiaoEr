package com.example.asus.huangxiaoer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.activity.XiangQingActivity;
import com.example.asus.huangxiaoer.homeFragment.FuShiFragment;
import com.example.asus.huangxiaoer.homeFragment.ReXiaoFragment;
import com.example.asus.huangxiaoer.homeFragment.XiaoChiFragment;
import com.example.asus.huangxiaoer.homeFragment.YinPinFragment;
import com.example.asus.huangxiaoer.homeFragment.ZhaoPaiFragment;
import com.example.asus.huangxiaoer.homeFragment.ZhushiFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/6.
 */
public class SaoMaFragment extends Fragment {
    private TabLayout tab_layout;
    private ViewPager vp;
    private List<String> tab_list;
    private List<Fragment> list_fragment;
    private ImageView image_xiangqing;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.saomafragment, container, false );

        tab_layout = (TabLayout) view.findViewById( R.id.tab_layout );
        vp = (ViewPager) view.findViewById( R.id.vp );
        image_xiangqing = view.findViewById( R.id.image_xiangqing );
        image_xiangqing.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), XiangQingActivity.class );
                startActivity( intent );
            }
        } );
        //设置tab的值
        initTab();

        return view;
    }

    private void initTab() {


        tab_list = new ArrayList<>();
        tab_list.add( "热销" );
        tab_list.add( "招牌" );
        tab_list.add( "主食" );
        tab_list.add( "小吃" );
        tab_list.add( "饮品" );
        tab_list.add( "副食" );
        list_fragment = new ArrayList<>();

        list_fragment.add( new ReXiaoFragment() );
        list_fragment.add( new ZhaoPaiFragment() );
        list_fragment.add( new ZhushiFragment() );
        list_fragment.add( new XiaoChiFragment() );
        list_fragment.add( new YinPinFragment() );
        list_fragment.add( new FuShiFragment() );


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        vp.setAdapter( new TabAdapter( getChildFragmentManager() ) );

        tab_layout.setupWithViewPager( vp );
        vp.setOffscreenPageLimit( list_fragment.size() );

    }

    public  class TabAdapter extends FragmentPagerAdapter {


        public TabAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return tab_list.get( position );
        }

        @Override
        public Fragment getItem(int position) {

            return list_fragment.get( position );
        }

        @Override
        public int getCount() {


            return list_fragment.size();
        }
    }

}

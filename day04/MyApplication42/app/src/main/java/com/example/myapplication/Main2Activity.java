package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.fagment.JingFragment6;
import com.example.myapplication.fagment.QianFragment6;
import com.example.myapplication.fagment.TuFragment6;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tab1;
    private ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );
        initView ();
    }

    private void initView() {
        tab1 = (TabLayout) findViewById ( R.id.tab1 );
        vp1 = (ViewPager) findViewById ( R.id.vp1 );
        final List<Fragment> list=new ArrayList<> (  );
        list.add ( new JingFragment6 () );
        list.add ( new TuFragment6 () );
        list.add ( new QianFragment6 () );
        vp1.setAdapter ( new FragmentPagerAdapter (getSupportFragmentManager ()) {
            @Override
            public Fragment getItem(int position) {
                return list.get ( position );
            }

            @Override
            public int getCount() {
                return list.size ();
            }
        } );
        tab1.setupWithViewPager ( vp1 );
        tab1.getTabAt ( 0 ).setText ( "经验榜" );
        tab1.getTabAt ( 1 ).setText ( "土豪榜" );
        tab1.getTabAt ( 2 ).setText ( "签到榜" );

    }
}

package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.fagment.BlankFragment;
import com.example.myapplication.fagment.BlankFragment2;
import com.example.myapplication.fagment.BlankFragment3;
import com.example.myapplication.fagment.BlankFragment4;
import com.example.myapplication.fagment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initView ();
    }

    private void initView() {
        vp = (ViewPager) findViewById ( R.id.vp );
        tab = (TabLayout) findViewById ( R.id.tab );
        final List<Fragment> list=new ArrayList<> (  );
        list.add ( new BlankFragment () );
        list.add ( new BlankFragment2 () );
        list.add ( new BlankFragment3 () );
        list.add ( new BlankFragment4 () );
        list.add ( new BlankFragment5 () );
        vp.setAdapter ( new FragmentPagerAdapter (getSupportFragmentManager ()) {
            @Override
            public Fragment getItem(int position) {
                return list.get ( position );
            }

            @Override
            public int getCount() {
                return list.size ();
            }
        } );
        tab.setupWithViewPager ( vp );
        tab.getTabAt ( 0 ).setText ( "首页" ).setIcon ( R.drawable.icon_tab_home );
        tab.getTabAt ( 1 ).setText ( "发现" ).setIcon ( R.drawable.icon_tab_mine );
        tab.getTabAt ( 2 ).setIcon ( R.drawable.icon_tab_publish );
        tab.getTabAt ( 3 ).setText ( "商城" ).setIcon ( R.drawable.icon_tab_find );
        tab.getTabAt ( 4 ).setText ( "我的" ).setIcon ( R.drawable.icon_tab_sofa );

    }
}

package com.example.mvp.mvp.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvp.R;
import com.example.mvp.mvp.ui.fragment.HomeFragment;
import com.example.mvp.mvp.ui.fragment.WoDeFragment;
import com.example.mvp.mvp.ui.fragment.XuanKeFragment;
import com.example.mvp.mvp.ui.fragment.ZhiBoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home1Activity extends AppCompatActivity {


    private BottomNavigationView bottoms;
    private Fragment[] fragments=new Fragment[4];
    private int count;
    private FrameLayout fra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        fra = findViewById(R.id.fra);

        bottoms = (BottomNavigationView) findViewById(R.id.bottoms);
        bottoms.setItemIconTintList(null);
        fragments[0]=new HomeFragment();
        fragments[1]=new XuanKeFragment();
        fragments[2]=new ZhiBoFragment();
        fragments[3]=new WoDeFragment();
        bottoms.setSelectedItemId(R.id.itme1);
        initZhanshi(0,R.id.fra);

        bottoms.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.itme1:
                        initFragment(fragments[0],fragments[count]);
                        count=0;
                        break;
                    case R.id.itme2:
                        initFragment(fragments[1],fragments[count]);
                        count=1;
                        break;
                    case R.id.itme3:
                        initFragment(fragments[2],fragments[count]);
                        count=2;
                        break;
                    case R.id.itme4:
                        initFragment(fragments[3],fragments[count]);
                        count=3;
                        break;
                }
            }
        });

    }


    private void initZhanshi(int cos, int fras) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i <fragments.length ; i++) {
            ft.add(fras,fragments[i],fragments[i].getClass().getSimpleName());
            if (i!=cos){
                ft.hide(fragments[i]);
            }

        }
        ft.commitAllowingStateLoss();


    }

    private void initFragment(Fragment fragment, Fragment fragment1) {
        FragmentTransaction bts = getSupportFragmentManager().beginTransaction();
       if (fragment!=fragment1){
           bts.hide(fragment1).show(fragment);
       }
       bts.commitAllowingStateLoss();
    }
}

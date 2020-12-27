package com.example.map.baiduditu.activty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.map.R;
import com.example.map.baiduditu.adapter.VpApret;
import com.example.map.daohang.DaoHangFragment;
import com.example.map.dianjuhu.DianJuHeFragment;
import com.example.map.luxianguihua.LuXianGuiHuaFragment;
import com.example.map.baiduditu.fragment.POIFragment;
import com.example.map.xianshiditu.XianShiDiTuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tl)
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new XianShiDiTuFragment());
        list.add(new DianJuHeFragment());
        list.add(new POIFragment());
        list.add(new LuXianGuiHuaFragment());
        list.add(new DaoHangFragment());
        VpApret vpApret = new VpApret(getSupportFragmentManager(),list);
        vp.setAdapter(vpApret);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("显示地图");
        tl.getTabAt(1).setText("点聚合");
        tl.getTabAt(2).setText("POI检索");
        tl.getTabAt(3).setText("路线规划");
        tl.getTabAt(4).setText("导航");
    }
}

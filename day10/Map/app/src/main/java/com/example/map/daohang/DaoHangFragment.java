package com.example.map.daohang;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.map.R;
import com.example.map.baiduditu.adapter.VpApret;
import com.example.map.baiduditu.fragment.POIFragment;
import com.example.map.dianjuhu.DianJuHeFragment;
import com.example.map.luxianguihua.LuXianGuiHuaFragment;
import com.example.map.xianshiditu.XianShiDiTuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaoHangFragment extends Fragment {


    @BindView(R.id.tl_dao_hang)
    TabLayout tlDaoHang;
    @BindView(R.id.vp_dao_hang)
    ViewPager vpDaoHang;
    private Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dao_hang, container, false);

        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
//        list.add(new BuFragment());
        list.add(new QiXingFragment());

        VpApret vpApret = new VpApret(getChildFragmentManager(),list);
        vpDaoHang.setAdapter(vpApret);
        tlDaoHang.setupWithViewPager(vpDaoHang);
//        tlDaoHang.getTabAt(0).setText("步行导航");
        tlDaoHang.getTabAt(1).setText("骑行导航");

    }

}

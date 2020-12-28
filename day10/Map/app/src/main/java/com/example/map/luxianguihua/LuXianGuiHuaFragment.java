package com.example.map.luxianguihua;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.map.R;
import com.example.map.baiduditu.adapter.VpApret;
import com.example.map.luxianguihua.biking.BikingFragment;
import com.example.map.luxianguihua.driving.DirvingFragment;
import com.example.map.luxianguihua.walk.WalkFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuXianGuiHuaFragment extends Fragment {


    @BindView(R.id.tl_gui_hua)
    TabLayout tlGuiHua;
    @BindView(R.id.vp_gui_hua)
    ViewPager vpGuiHua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lu_xian_gui_hua, container, false);
        ButterKnife.bind(this, view);
    initView();
        return view;
    }

    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new WalkFragment());
        list.add(new BikingFragment());
        list.add(new DirvingFragment());

        VpApret vpApret = new VpApret(getChildFragmentManager(),list);
        vpGuiHua.setAdapter(vpApret);
        tlGuiHua.setupWithViewPager(vpGuiHua);
        tlGuiHua.getTabAt(0).setText("步行路线规划");
        tlGuiHua.getTabAt(1).setText("骑行路线规划");
        tlGuiHua.getTabAt(2).setText("驾车路线规划");

    }

}

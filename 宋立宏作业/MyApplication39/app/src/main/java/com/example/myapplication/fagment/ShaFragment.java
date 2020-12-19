package com.example.myapplication.fagment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.fagment.fagment1.ShiFragment;
import com.example.myapplication.fagment.fagment1.TuFragment;
import com.example.myapplication.fagment.fagment1.WenFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShaFragment extends Fragment {


    private ViewPager vp1;
    private TabLayout tab1;

    public ShaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_sha, container, false );
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initView(view);
    }

    private void initView(View view) {
        vp1 = view.findViewById ( R.id.vp1 );
        tab1 = view.findViewById ( R.id.tab1 );
        final List<Fragment> list=new ArrayList<> (  );
        list.add ( new TuFragment () );
        list.add ( new ShiFragment () );
        list.add ( new WenFragment () );
        vp1.setAdapter ( new FragmentPagerAdapter (getChildFragmentManager ()) {
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
        tab1.getTabAt ( 0 ).setText ( "图片" );
        tab1.getTabAt ( 1 ).setText ( "视屏" );
        tab1.getTabAt ( 2 ).setText ( "文本" );
    }
}

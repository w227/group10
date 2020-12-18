package com.example.myapplication.fagment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.fagment.fagment1.GuanFragment;
import com.example.myapplication.fagment.fagment1.TuiFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WokFragment extends Fragment {


    private TabLayout tab2;
    private ViewPager vp2;

    public WokFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_wok, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initView(view);
    }

    private void initView(View view) {
        tab2 = view.findViewById ( R.id.tab2 );
        vp2 = view.findViewById ( R.id.vp2 );
        List<Fragment> list=new ArrayList<> (  );
        list.add ( new GuanFragment () );
        list.add ( new TuiFragment () );
        vp2.setAdapter ( new FragmentPagerAdapter (getChildFragmentManager ()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get ( position );
            }

            @Override
            public int getCount() {
                return list.size ();
            }
        } );
        tab2.setupWithViewPager ( vp2 );
        tab2.getTabAt ( 0 ).setText ( "关注" );
        tab2.getTabAt ( 1 ).setText ( "推荐" );
    }
}

package com.example.myapplication.fagment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.HomeApader;
import com.example.myapplication.bean.ListBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment implements IView {


    private RecyclerView rec;
    private HomeApader homeApader;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_blank_fragment2, container, false );
        return inflate;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initView(view);
        initDiew();
    }

    private void initDiew() {
        HomePers homePers = new HomePers ( this );
        homePers.start2();
    }

    private void initView(View view) {
        rec = view.findViewById ( R.id.rec );

        rec.setLayoutManager ( new LinearLayoutManager ( getContext () ) );

        homeApader = new HomeApader (getContext ());
        rec.setAdapter ( homeApader );
    }

    @Override
    public void getChen1(Object object) {
        if (object instanceof List){
            List<ListBean.DataBean> list= (List<ListBean.DataBean>) object;
            homeApader.addlist ( list );
            homeApader.notifyDataSetChanged ();
        }

    }

    @Override
    public void getChen2(Object object) {

    }

    @Override
    public void getChen3(Object object) {

    }

    @Override
    public void getChen4(Object object) {

    }

    @Override
    public void getChen5(Object object) {

    }
}

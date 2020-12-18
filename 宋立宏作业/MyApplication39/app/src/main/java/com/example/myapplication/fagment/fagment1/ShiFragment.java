package com.example.myapplication.fagment.fagment1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.ShiApader;
import com.example.myapplication.bean.ShiBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShiFragment extends Fragment implements IView {


    private RecyclerView rec1;
    private ShiApader shiApader;

    public ShiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_shi, container, false );
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
        homePers.stact2 ();
    }

    private void initView(View view) {
        rec1 = view.findViewById ( R.id.rec1 );
        rec1.setLayoutManager ( new LinearLayoutManager ( getContext () ) );
        shiApader = new ShiApader (getActivity ());

        rec1.setAdapter ( shiApader );
    }

    @Override
    public void getChen1(Object object) {

    }

    @Override
    public void getChen2(Object object) {
        if (object instanceof List){
            List<ShiBean.DataBeanX.DataBean> list= (List<ShiBean.DataBeanX.DataBean>) object;
            shiApader.addslist ( list );
            shiApader.notifyDataSetChanged ();

        }

    }

    @Override
    public void getChen3(Object object) {

    }

    @Override
    public void getChen4(Object object) {

    }
}

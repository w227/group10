package com.example.wangyumeng.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wangyumeng.R;
import com.example.wangyumeng.adapter.RvApret;
import com.example.wangyumeng.adapter.RvShiApret;
import com.example.wangyumeng.bean.ShiBean;
import com.example.wangyumeng.perstrn.HomePerstr;
import com.example.wangyumeng.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShiFragment extends Fragment implements IView {


    @BindView(R.id.rv_shi)
    RecyclerView rvShi;
    private FragmentActivity activity;

    private ArrayList<ShiBean.DataBeanX.DataBean> list;
    private RvShiApret rvApret;


    public ShiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shi, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);

        initView();
        initData();
        return view;
    }

    private void initData() {
        HomePerstr homePerstr = new HomePerstr(this);
        homePerstr.Shistart();
    }

    private void initView() {

        rvShi.setLayoutManager(new LinearLayoutManager(activity));
        list = new ArrayList<>();
        rvApret = new RvShiApret(list,  activity);
        rvShi.setAdapter(rvApret);

    }

    @Override
    public void onNextUi(Object o) {



        if (o instanceof ShiBean){
            ShiBean shiBean = (ShiBean) o;
            List<ShiBean.DataBeanX.DataBean> data = shiBean.getData().getData();
           list.addAll(data);
        }

        rvApret.notifyDataSetChanged();
    }

    @Override
    public void onErrorUi(String smg) {

    }
}

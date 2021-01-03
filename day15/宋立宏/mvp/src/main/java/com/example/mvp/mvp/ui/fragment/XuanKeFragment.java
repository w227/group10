package com.example.mvp.mvp.ui.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.R;
import com.example.mvp.apader.XuanKeApader;
import com.example.mvp.bena.ListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class XuanKeFragment extends Fragment {


    private RecyclerView rec;
    private XuanKeApader xuanKeApader;

    public XuanKeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_xuan_ke, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        initView(view);
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);
        List<ListBean> listBeans=new ArrayList<>();
        listBeans.add(new ListBean("热门课堂"));
        listBeans.add(new ListBean("金融学院"));
        listBeans.add(new ListBean("才会学院"));
        listBeans.add(new ListBean("国际证书"));
        listBeans.add(new ListBean("职业资格"));
        listBeans.add(new ListBean("建筑工程"));
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        xuanKeApader = new XuanKeApader(getActivity(),listBeans);
        rec.setAdapter(xuanKeApader);


    }
}

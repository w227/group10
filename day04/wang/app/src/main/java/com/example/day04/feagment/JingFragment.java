package com.example.day04.feagment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;
import com.example.day04.adapter.RvJingApret;
import com.example.day04.bean.YanBean;
import com.example.day04.perstr.HomePertent;
import com.example.day04.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingFragment extends Fragment implements IView {


    @BindView(R.id.rv_jing)
    RecyclerView rvJing;
    private FragmentActivity activity;
    private ArrayList<YanBean.DataBean.ExpTopBean.ListBean> list;
    private RvJingApret rvJingApret;

    public JingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jing, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        HomePertent homePertent = new HomePertent(this);
        homePertent.start();
    }

    private void initView() {

        rvJing.setLayoutManager(new LinearLayoutManager(activity));
        list = new ArrayList<>();
        rvJingApret = new RvJingApret(list,activity);
        rvJing.setAdapter(rvJingApret);
        rvJing.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNextUi(Object o) {
        if (o instanceof  YanBean){
            YanBean bean = (YanBean) o;
            List<YanBean.DataBean.ExpTopBean.ListBean> listBeans = bean.getData().getExpTop().getList();
            list.addAll(listBeans);
        }
      rvJingApret.notifyDataSetChanged();
    }

    @Override
    public void onErrorUi(String smg) {

    }
}

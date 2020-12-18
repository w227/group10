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
import com.example.day04.adapter.RvQianApret;
import com.example.day04.adapter.RvTuApret;
import com.example.day04.bean.QianBean;
import com.example.day04.bean.TuBean;
import com.example.day04.perstr.HomePertent;
import com.example.day04.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class QianFragment extends Fragment implements IView {



    @BindView(R.id.rv_qian)
    RecyclerView rvQian;
    private FragmentActivity activity;
    private ArrayList<QianBean.DataBean.SignTopBean.ListBean> list;
    private RvQianApret rvQianApret;

    public QianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qian, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        HomePertent homePertent = new HomePertent(this);
        homePertent.Qianstart();
    }

    private void initView() {

        rvQian.setLayoutManager(new LinearLayoutManager(activity));
        list = new ArrayList<>();
        rvQianApret = new RvQianApret(list, activity);
        rvQian.setAdapter(rvQianApret);
        rvQian.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNextUi(Object o) {
        if (o instanceof QianBean) {
            QianBean bean = (QianBean) o;
            List<QianBean.DataBean.SignTopBean.ListBean> listBeans = bean.getData().getSignTop().getList();
            this.list.addAll(listBeans);
        }
        rvQianApret.notifyDataSetChanged();
    }

    @Override
    public void onErrorUi(String smg) {

    }
}

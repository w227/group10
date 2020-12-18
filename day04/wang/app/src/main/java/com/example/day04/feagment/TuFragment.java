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
import com.example.day04.adapter.RvTuApret;
import com.example.day04.bean.TuBean;
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
public class TuFragment extends Fragment implements IView {



    @BindView(R.id.rv_tu)
    RecyclerView rvTu;
    private FragmentActivity activity;
    private ArrayList<TuBean.DataBean.TongQianTopBean.ListBean> list;
    private RvTuApret rvTuApret;

    public TuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tu, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        HomePertent homePertent = new HomePertent(this);
        homePertent.Tustart();
    }

    private void initView() {

        rvTu.setLayoutManager(new LinearLayoutManager(activity));
        list = new ArrayList<>();
        rvTuApret = new RvTuApret(list, activity);
        rvTu.setAdapter(rvTuApret);
        rvTu.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNextUi(Object o) {
        if (o instanceof TuBean) {
            TuBean bean = (TuBean) o;
            List<TuBean.DataBean.TongQianTopBean.ListBean> listBeans = bean.getData().getTongQianTop().getList();
            list.addAll(listBeans);
        }
        rvTuApret.notifyDataSetChanged();
    }

    @Override
    public void onErrorUi(String smg) {

    }
}

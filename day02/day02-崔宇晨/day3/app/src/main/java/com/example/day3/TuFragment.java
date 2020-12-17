package com.example.day3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.model.bean.DataInfo;
import com.example.day3.view.Viem;

import java.util.ArrayList;
import java.util.List;

public class TuFragment extends Fragment implements Viem {

    private RecyclerView mRel;
    private ArrayList<DataInfo.DataBeanX.DataBean> mBean;
    private TuAdpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.tu_item, null);
        mRel = view.findViewById(R.id.tu_rel);
        mBean = new ArrayList<>();
        adpter = new TuAdpter(mBean,getContext());
        mRel.setAdapter(adpter);
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        mRel.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        initData();
        return view;
    }

    private void initData() {
        Persenter persenter = new Persenter(this);
        persenter.start();
    }

    @Override
    public void showSucess(Object object) {
        if (object instanceof DataInfo){
            DataInfo info=(DataInfo)object;
            List<DataInfo.DataBeanX.DataBean> data = info.getData().getData();
            mBean.addAll(data);
            adpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }
}

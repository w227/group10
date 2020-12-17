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

import com.example.day3.model.bean.DataInfo2;
import com.example.day3.view.Viem;

import java.util.ArrayList;
import java.util.List;

public class SpFragment extends Fragment implements Viem {

    private RecyclerView mRel;
    private ArrayList<DataInfo2.DataBeanX.DataBean> mBean;
    private SpAdpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.sp_item, null);
        mRel = view.findViewById(R.id.sp_rel);
        mBean = new ArrayList<>();
        adpter = new SpAdpter(mBean,getContext());
        mRel.setAdapter(adpter);
        mRel.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        initData();
        return view;
    }

    private void initData() {
        SpPresenter spPresenter = new SpPresenter(this);
        spPresenter.start();
    }

    @Override
    public void showSucess(Object object) {
        if (object instanceof DataInfo2){
            DataInfo2 info2=(DataInfo2)object;
            List<DataInfo2.DataBeanX.DataBean> data = info2.getData().getData();
            mBean.addAll(data);
            adpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }
}

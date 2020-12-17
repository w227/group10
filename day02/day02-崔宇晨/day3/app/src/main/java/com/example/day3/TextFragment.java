package com.example.day3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.model.bean.DataInfo3;
import com.example.day3.view.Viem;

import java.util.ArrayList;
import java.util.List;

public class TextFragment extends Fragment implements Viem {

    private RecyclerView mRel;
    private ArrayList<DataInfo3.DataBeanX.DataBean> mBean;
    private TextAdpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.text_item, null);
        mRel = view.findViewById(R.id.text_rel);
        mBean = new ArrayList<>();
        adpter = new TextAdpter(mBean,getContext());
        mRel.setAdapter(adpter);
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        initData();
        return view;
    }

    private void initData() {
        Presenter3 presenter3 = new Presenter3(this);
        presenter3.start();
    }

    @Override
    public void showSucess(Object object) {
        if (object instanceof DataInfo3){
            DataInfo3 info3=(DataInfo3)object;
            List<DataInfo3.DataBeanX.DataBean> data = info3.getData().getData();
            mBean.addAll(data);
            adpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }
}

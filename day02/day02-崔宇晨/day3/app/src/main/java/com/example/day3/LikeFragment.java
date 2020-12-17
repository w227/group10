package com.example.day3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day3.model.bean.DataInfo4;
import com.example.day3.view.Viem;

import java.util.ArrayList;
import java.util.List;

public class LikeFragment extends Fragment implements Viem {

    private RecyclerView mRel;
    private ArrayList<DataInfo4.DataBeanX.DataBean> mBean;
    private LikeAdpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.like2_item, null);
        mRel = view.findViewById(R.id.like_rel);
        mBean = new ArrayList<>();
        adpter = new LikeAdpter(mBean,getContext());
        mRel.setAdapter(adpter);
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        initData();
        return view;
    }

    private void initData() {
        Presenter4 presenter4 = new Presenter4(this);
        presenter4.start();
    }

    @Override
    public void showSucess(Object object) {
        if (object instanceof DataInfo4){
            DataInfo4 info4=(DataInfo4)object;
            List<DataInfo4.DataBeanX.DataBean> data = info4.getData().getData();
            mBean.addAll(data);
            adpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }

}

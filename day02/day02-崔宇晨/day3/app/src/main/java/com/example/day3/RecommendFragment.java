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

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment{

    private RecyclerView mRel;
    private ArrayList<User> mBena;
    private RecommendAdpter adpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.recommend_item, null);
        mRel = view.findViewById(R.id.recommend_rel);
        initData();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            mBena.clear();
            initData();
        }
    }

    private void initData() {
        List<User> users = App.getDaoSession().getUserDao().loadAll();
        mBena = new ArrayList<>();
        mBena.addAll(users);
        adpter = new RecommendAdpter(mBena,getContext());
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        mRel.setAdapter(adpter);
        adpter.notifyDataSetChanged();
    }
}

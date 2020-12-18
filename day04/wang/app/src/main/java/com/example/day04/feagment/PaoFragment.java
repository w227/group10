package com.example.day04.feagment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;
import com.example.day04.adapter.RvPaoApret;
import com.example.day04.bean.FenBean;
import com.example.day04.bean.HuoBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaoFragment extends Fragment {

    @BindView(R.id.rv_pao)
    RecyclerView rvPao;
    @BindView(R.id.tl_pao)
    TabLayout tlPao;
    @BindView(R.id.fl_pao)
    FrameLayout flPao;
    private FragmentActivity activity;
    private ArrayList<String> list;

    public PaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pao, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

       rvPao.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true));

        list = new ArrayList<>();
        RvPaoApret rvPaoApret = new RvPaoApret(list,activity);
        rvPao.setAdapter(rvPaoApret);

    }

}

package com.example.day04.feagment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04.R;
import com.example.day04.activity.HomeActivity;
import com.example.day04.adapter.RvSanApret;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaFragment extends Fragment {


    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentActivity activity;

    public FaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fa, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

       rv.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true));
//        ArrayList<Integer> list = new ArrayList<>();

        RvSanApret rvSanApret = new RvSanApret(activity);
        rv.setAdapter(rvSanApret);


        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl,new PaoFragment()).commit();
    }

}

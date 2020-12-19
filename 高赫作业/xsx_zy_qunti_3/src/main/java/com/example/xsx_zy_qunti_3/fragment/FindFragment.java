package com.example.xsx_zy_qunti_3.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xsx_zy_qunti_3.IView;
import com.example.xsx_zy_qunti_3.R;
import com.example.xsx_zy_qunti_3.adapter.FindFreAdapter;
import com.example.xsx_zy_qunti_3.adapter.FindHengAdapter;
import com.example.xsx_zy_qunti_3.bean.HotBean;
import com.example.xsx_zy_qunti_3.mvp.presenter.FindPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment implements IView {

    private RecyclerView rec_fre_find;
    private FindPresenter findPresenter = new FindPresenter(this);
    private FindFreAdapter findFreAdapter;
    private List<HotBean.DataBean> list = new ArrayList<>();
    private RecyclerView rec_fre_find_heng;
    private FindHengAdapter findHengAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
    }

    private void initData() {
        findPresenter.start();
    }

    private void initView(View view) {
        rec_fre_find = view.findViewById(R.id.rec_fre_find);
        rec_fre_find_heng = view.findViewById(R.id.rec_fre_find_heng);
        rec_fre_find.setLayoutManager(new LinearLayoutManager(getContext()));
        rec_fre_find.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        findFreAdapter = new FindFreAdapter(getContext(),list);
        rec_fre_find.setAdapter(findFreAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rec_fre_find_heng.setLayoutManager(manager);
        rec_fre_find_heng.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        findHengAdapter = new FindHengAdapter(getContext(),list);
        rec_fre_find_heng.setAdapter(findHengAdapter);
    }

    @Override
    public void getSuccessData(Object object) {
        if(object instanceof HotBean){
            HotBean hotBean = (HotBean) object;
            List<HotBean.DataBean> data = hotBean.getData();
            list.addAll(data);
            findHengAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getFaileMeg(String meg) {

    }
}

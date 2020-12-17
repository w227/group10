package com.example.wangyumeng.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wangyumeng.R;
import com.example.wangyumeng.adapter.RvApret;
import com.example.wangyumeng.bean.JavaBean;
import com.example.wangyumeng.perstrn.HomePerstr;
import com.example.wangyumeng.view.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickFragment extends Fragment implements IView {


    @BindView(R.id.rv_pick)
    RecyclerView rvPick;
    private FragmentActivity activity;
    private ArrayList<JavaBean.DataBeanX.DataBean.AuthorBean> list1;
    private RvApret rvApret;
    private ArrayList<JavaBean.DataBeanX.DataBean> str;

    public PickFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);

        initView();
        initData();
        return view;
    }

    private void initData() {

        HomePerstr homePerstr = new HomePerstr(this);
        homePerstr.start();
    }

    private void initView() {
        rvPick.setLayoutManager(new LinearLayoutManager(activity));
        list1 = new ArrayList<>();
        str = new ArrayList<>();
        rvApret = new RvApret(list1,str,activity);
        rvPick.setAdapter(rvApret);

    }

    @Override
    public void onNextUi(Object o) {
        if (o instanceof JavaBean){
            JavaBean javaBean = (JavaBean) o;
            List<JavaBean.DataBeanX.DataBean> data = javaBean.getData().getData();
            for (int i = 0; i <data.size() ; i++) {
                JavaBean.DataBeanX.DataBean.AuthorBean author = data.get(i).getAuthor();
                list1.add(author);
            }

        }

        if (o instanceof JavaBean){
            JavaBean javaBean = (JavaBean) o;
            List<JavaBean.DataBeanX.DataBean> data = javaBean.getData().getData();
            str.addAll(data);
        }

        rvApret.notifyDataSetChanged();
    }

    @Override
    public void onErrorUi(String smg) {

    }
}

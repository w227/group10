package com.example.dp7_12_18_zy.fragment;

import com.example.dp7_12_18_zy.calback.Cll;
import com.example.dp7_12_18_zy.model.Model;
import com.example.dp7_12_18_zy.view.Viem;

public class LookPresenter {
    private Viem mview;
    private Model model;

    public LookPresenter(Viem mview) {
        this.mview = mview;
        model=new Model();
    }

    public void start() {
        model.request(new Cll() {
            @Override
            public void onSucess(Object object) {
                mview.showSucess(object);
            }

            @Override
            public void onFaile(String msg) {
                mview.showFaile(msg);
            }
        });
    }
}

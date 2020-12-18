package com.example.dp7_12_18_zy;

import com.example.dp7_12_18_zy.calback.Cll;
import com.example.dp7_12_18_zy.model.Model;
import com.example.dp7_12_18_zy.view.Viem;

public class AocPresenter {
    private Viem mview;
    private Model model;

    public AocPresenter(Viem mview) {
        this.mview = mview;
        model=new Model();
    }


    public void start() {
        model.request2(new Cll() {
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

package com.example.day3;

import com.example.day3.callback.Cll;
import com.example.day3.model.Model;
import com.example.day3.view.Viem;

public class Persenter {
    private Viem mview;
    private Model model;

    public Persenter(Viem mview) {
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

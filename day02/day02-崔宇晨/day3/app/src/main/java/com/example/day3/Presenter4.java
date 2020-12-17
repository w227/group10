package com.example.day3;

import com.example.day3.callback.Cll;
import com.example.day3.model.Model;
import com.example.day3.view.Viem;

import java.util.PropertyPermission;

import retrofit2.http.POST;

public class Presenter4 {
    private Viem mvie;
    private Model model;

    public Presenter4(Viem mvie) {
        this.mvie = mvie;
        model=new Model();
    }

    public void start() {
        model.request4(new Cll() {
            @Override
            public void onSucess(Object object) {
                mvie.showSucess(object);
            }

            @Override
            public void onFaile(String msg) {
                mvie.showFaile(msg);
            }
        });
    }
}

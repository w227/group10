package com.example.day04.perstr;

import com.example.day04.call.CallBack;
import com.example.day04.mode.HomeMode;
import com.example.day04.view.IView;

public class HomePertent {
    private IView iView;
    private final HomeMode homeMode;

    public HomePertent(IView iView) {
        this.iView = iView;
        homeMode = new HomeMode();

    }

    public void start() {
        homeMode.request(new CallBack() {
            @Override
            public void onNextData(Object o) {
                iView.onNextUi(o);
            }

            @Override
            public void onErrorData(String smg) {

                iView.onErrorUi(smg);
            }
        });
    }

    public void Tustart() {
        homeMode.turequest(new CallBack() {
            @Override
            public void onNextData(Object o) {
                iView.onNextUi(o);
            }

            @Override
            public void onErrorData(String smg) {

                iView.onErrorUi(smg);
            }
        });
    }

    public void Qianstart() {
        homeMode.Qianrequest(new CallBack() {
            @Override
            public void onNextData(Object o) {
                iView.onNextUi(o);
            }

            @Override
            public void onErrorData(String smg) {

                iView.onErrorUi(smg);
            }
        });
    }

    public void show() {
        homeMode.showData(new CallBack() {
            @Override
            public void onNextData(Object o) {
                iView.onNextUi(o);
            }

            @Override
            public void onErrorData(String smg) {

                iView.onErrorUi(smg);
            }
        });
    }
}

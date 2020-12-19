package com.example.wangyumeng.perstrn;

import com.example.wangyumeng.call.CallBack;
import com.example.wangyumeng.mode.HomeMode;
import com.example.wangyumeng.view.IView;

public class HomePerstr {
    private IView iView;
    private final HomeMode homeMode;

    public HomePerstr(IView iView) {
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

    public void Shistart() {
        homeMode.shiRequest(new CallBack() {
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

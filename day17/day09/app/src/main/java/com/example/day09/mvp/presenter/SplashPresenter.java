package com.example.day09.mvp.presenter;

import android.util.Log;

import com.example.day09.base.BasePresenter;
import com.example.day09.base.GsonUtil;
import com.example.day09.base.IBaseView;
import com.example.day09.callback.RxObserverCallBack;
import com.example.day09.mvp.model.RxOpretorImpl;
import com.example.day09.mvp.model.bean.DecodeBean;
import com.example.day09.mvp.model.constants.ApiConstants;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;

public class SplashPresenter extends BasePresenter {
    private IBaseView mView;
    private final RxOpretorImpl mImpi;

    public SplashPresenter(IBaseView view) {
        this.mView = view;
        mImpi = new RxOpretorImpl();
    }

    @Override
    public void start(Object[] t) {
        super.start(t);


        HashMap<String, String> map =  new HashMap<>();
        map.put("device", (String) t[0]);
        mImpi.repostRequest(ApiConstants.DECODE, map, new RxObserverCallBack() {
            @Override
            public void onSuccessData(Object o) {

                    ResponseBody body = (ResponseBody) o;
                try {
                    String string = body.string();
                    DecodeBean bean = GsonUtil.jsonBean(string, DecodeBean.class);

                    if (mView != null)
                        mView.onScuccess(bean);
                } catch (IOException e) {
                    e.printStackTrace();
                    if (mView != null)
                        mView.onError(e.getMessage());

                }
            }

            @Override
            public void onErrorMsg(String msg) {

                if (mView != null)
                    mView.onError(msg);

            }
        });


    }
}

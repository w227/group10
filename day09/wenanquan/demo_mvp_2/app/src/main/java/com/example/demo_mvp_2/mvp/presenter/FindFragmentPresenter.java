package com.example.demo_mvp_2.mvp.presenter;

import com.example.demo_mvp_2.base.BasePresenter;
import com.example.demo_mvp_2.base.IBaseView;
import com.example.demo_mvp_2.callback.RxObservableCallBack;
import com.example.demo_mvp_2.mvp.module.RxPoretorImpl;
import com.example.demo_mvp_2.mvp.module.constants.ApiConstants;
import com.example.demo_mvp_2.mvp.module.entity.Hot_ActivityBean;
import com.example.demo_mvp_2.mvp.ui.fragment.FindFragment;
import com.example.demo_mvp_2.mvp.ui.fragment.HomeFragment;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class FindFragmentPresenter extends BasePresenter {


    private static final String TAG = HomeFragment.class.getSimpleName();

    private RxPoretorImpl mImpl;
    private FindFragment mFindFragment;

    public FindFragmentPresenter(FindFragment mFindFragment) {
        this.mFindFragment = mFindFragment;
        mImpl = new RxPoretorImpl();

    }

    //2向M层进行数据请求，请求数据后将数据返回V层
    @Override
    public void start() {

        mImpl.rxGetRequest(ApiConstants.HOT_ACTIVITY, new RxObservableCallBack<Object>() {

            @Override
            public void onSucceed(Object obj) {
                if (mFindFragment != null) {
                    ResponseBody responseBody = (ResponseBody) obj;
                    try {
                        String string = responseBody.string();
                        //TODO GSON解析
                        Hot_ActivityBean hot_activityBean = new Gson().fromJson(string, Hot_ActivityBean.class);

                        mFindFragment.onSucceed(hot_activityBean);

                    } catch (IOException e) {
                        e.printStackTrace();

                        mFindFragment.onFiled(e.getMessage());
                    }

                }
            }

            @Override
            public void onFiled(String errorMsg) {
                if (mView != null) {
                    mFindFragment.onFiled(errorMsg);
                }
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                if (disposable != null) {
                    addDisposable(disposable);
                }
            }
        });
    }
}

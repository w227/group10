package com.example.xsx_zy_qunti_3.mvp.presenter;

import android.util.Log;

import com.example.xsx_zy_qunti_3.ApiService;
import com.example.xsx_zy_qunti_3.IView;
import com.example.xsx_zy_qunti_3.bean.TuanBean;
import com.example.xsx_zy_qunti_3.callback.ResultCallBack;
import com.example.xsx_zy_qunti_3.mvp.model.FindModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FindPresenter {
    private IView iView;
    private FindModel findModel;

    public FindPresenter(IView iView) {
        this.iView = iView;
        findModel = new FindModel();
    }

    public void start() {
        findModel.getData(new ResultCallBack() {
            @Override
            public void getSuccessData(Object object) {
                if(iView != null){
                    iView.getSuccessData(object);
                }
            }

            @Override
            public void getFaileMeg(String meg) {
                if(iView != null){
                    iView.getFaileMeg(meg);
                }
            }
        });
    }

    public void startTuan() {
        findModel.getTuanData(new ResultCallBack() {
            @Override
            public void getSuccessData(Object object) {
                if(iView != null){
                    iView.getSuccessData(object);
                }
            }

            @Override
            public void getFaileMeg(String meg) {
                if(iView != null){
                    iView.getFaileMeg(meg);
                }
            }
        });
    }
}

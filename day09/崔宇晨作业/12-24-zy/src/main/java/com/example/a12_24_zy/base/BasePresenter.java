package com.example.a12_24_zy.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>,T> implements IBasePresenter<T> {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    private WeakReference<BaseActivity> mView;

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }


    public  void attachView(BaseActivity ptBaseActivity) {
        mView = new WeakReference<>(ptBaseActivity);
    }

    protected void detachView(){
        if (mView!=null){
            mView=null;
        }
        detachView();
    }

    private void deleteDisposable(){
        if (compositeDisposable!=null&&compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable.clear();
            compositeDisposable=null;
        }
    }

    protected void addDisposable(Disposable disposable){
        if (compositeDisposable!=null){
            compositeDisposable.add(disposable);
        }
    }
}

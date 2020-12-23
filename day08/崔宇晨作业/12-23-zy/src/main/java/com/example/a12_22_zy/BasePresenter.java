package com.example.a12_22_zy;

import java.lang.ref.WeakReference;



public class BasePresenter<V extends IBaseView<T> ,T> implements IBasePresenter<T>{
    protected WeakReference<V> mView;
    private CompositeDisposable mComposite =
            new CompositeDisposable();


    //添加网络开关
    protected <Disposable> void addDisposable(Disposable disposable) {
        if (mComposite != null)
            mComposite.add(disposable);
    }


    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }


    //2.释放V层资源的同时断开网络开关
    protected void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }

    //断开网络开关
    private void deleteDisposable() {

    }


    @Override
    public void start() {
        //TODO 处理业务逻辑

    }

    @Override
    public void Start(T t) {

    }

    private class CompositeDisposable {
        public <Disposable> void add(Disposable disposable) {


        }
    }
}

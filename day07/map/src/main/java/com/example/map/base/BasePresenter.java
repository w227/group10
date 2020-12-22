package com.example.map.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

// TODO V 层
public class BasePresenter<V extends IView<T>,T> implements IPresenter<T> {

    private WeakReference<V> reference;
    private CompositeDisposable disposable = new CompositeDisposable();

    protected void addDtaposacle(Disposable dis) {

        if (disposable !=null)
            disposable.add(dis);
    }



//    1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    protected void attchView(V view){
        reference = new WeakReference<>(view);
    }

//    2.释放V层资源的同时断开网络开关
     protected void detchView(){
        if (reference != null){
            reference.clear();
            reference = null;
        }

        delectDtaposacle();
     }

    protected void delectDtaposacle() {
        if (disposable != null &&!disposable.isDisposed()){
            disposable.dispose();
            disposable.clear();
            disposable = null;
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }


}

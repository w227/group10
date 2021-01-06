package com.example.day09.mvp.presenter;

import com.example.day09.base.BasePresenter;
import com.example.day09.mvp.model.RxOpretorImpl;
import com.example.day09.mvp.ui.activity.SelectCourseActivity;
import com.example.day09.mvp.ui.fragment.CourseFragment;

public class SelCourseActPresenter extends BasePresenter {
    private SelectCourseActivity mView;
    private final RxOpretorImpl mImpi;

    public SelCourseActPresenter(SelectCourseActivity  activity) {
        this.mView = activity;
        mImpi = new RxOpretorImpl();
    }

    @Override
    public void start() {
        super.start();


    }
}

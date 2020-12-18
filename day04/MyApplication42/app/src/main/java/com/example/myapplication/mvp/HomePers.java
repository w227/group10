package com.example.myapplication.mvp;

public class HomePers {
    private IView iView;
    private HomeMolder homeMolder;

    public HomePers(IView iView) {
        this.iView = iView;
        homeMolder=new HomeMolder ();
    }

    public void start2() {
        homeMolder.requset1( new HomeColl () {
            @Override
            public void getData1(Object object) {
                iView.getChen1 ( object );

            }

            @Override
            public void getData2(Object object) {

            }

            @Override
            public void getData3(Object object) {

            }

            @Override
            public void getData4(Object object) {

            }

            @Override
            public void getData5(Object object) {

            }
        } );
    }

    public void start3() {
        homeMolder.requset2 ( new HomeColl () {
            @Override
            public void getData1(Object object) {

            }

            @Override
            public void getData2(Object object) {
                iView.getChen2 ( object );

            }

            @Override
            public void getData3(Object object) {

            }

            @Override
            public void getData4(Object object) {

            }

            @Override
            public void getData5(Object object) {

            }
        } );
    }

    public void start4() {
        homeMolder.requset3 ( new HomeColl () {
            @Override
            public void getData1(Object object) {

            }

            @Override
            public void getData2(Object object) {

            }

            @Override
            public void getData3(Object object) {
                iView.getChen3 ( object );

            }

            @Override
            public void getData4(Object object) {

            }

            @Override
            public void getData5(Object object) {

            }
        } );
    }

    public void start5() {
        homeMolder.requset4 ( new HomeColl () {
            @Override
            public void getData1(Object object) {

            }

            @Override
            public void getData2(Object object) {

            }

            @Override
            public void getData3(Object object) {

            }

            @Override
            public void getData4(Object object) {
                iView.getChen4 ( object );

            }

            @Override
            public void getData5(Object object) {

            }
        } );
    }
}

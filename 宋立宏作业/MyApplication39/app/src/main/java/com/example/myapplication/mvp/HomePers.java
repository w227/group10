package com.example.myapplication.mvp;

public class HomePers {
    private IView iView;
    private HomeMolder homeMolder;

    public HomePers(IView iView) {
        this.iView = iView;
        homeMolder=new HomeMolder ();
    }

    public void stact1() {
        homeMolder.requset1( new HomeCall () {
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
        } );
    }

    public void stact2() {
        homeMolder.requset2 ( new HomeCall () {
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
        } );
    }

    public void stact3() {
        homeMolder.requset3 ( new HomeCall () {
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
        } );
    }

    public void stact4() {
        homeMolder.requset4 ( new HomeCall () {
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
        } );
    }
}

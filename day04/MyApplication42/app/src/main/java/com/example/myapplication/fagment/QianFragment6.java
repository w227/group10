package com.example.myapplication.fagment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.QianApader;
import com.example.myapplication.bean.JingBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QianFragment6 extends Fragment implements IView {


    private RecyclerView recs2;
    private QianApader qianApader;

    public QianFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_qian_fragment6, container, false );
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initView(view);
        initDiew();
    }

    private void initDiew() {
        HomePers homePers = new HomePers ( this );
        homePers.start4 ();
    }

    private void initView(View view) {
        recs2 = view.findViewById ( R.id.recs2 );
        recs2.setLayoutManager ( new LinearLayoutManager ( getContext () ) );
        qianApader = new QianApader (getActivity ());
        recs2.setAdapter ( qianApader );

    }

    @Override
    public void getChen1(Object object) {

    }

    @Override
    public void getChen2(Object object) {

    }

    @Override
    public void getChen3(Object object) {
        if (object instanceof List){
            List<JingBean.DataBean.ExpTopBean.ListBean> list= (List<JingBean.DataBean.ExpTopBean.ListBean>) object;
            qianApader.addlist ( list );
            qianApader.notifyDataSetChanged ();

        }

    }

    @Override
    public void getChen4(Object object) {

    }

    @Override
    public void getChen5(Object object) {

    }
}

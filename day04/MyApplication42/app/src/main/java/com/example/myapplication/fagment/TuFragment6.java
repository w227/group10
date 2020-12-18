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
import com.example.myapplication.apader.TuApader;
import com.example.myapplication.bean.TuBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuFragment6 extends Fragment implements IView {


    private RecyclerView rec3;
    private TuApader tuApader;

    public TuFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_tu_fragment6, container, false );
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
        homePers.start5 ();
    }

    private void initView(View view) {
        rec3 = view.findViewById ( R.id.recs3 );
        rec3.setLayoutManager ( new LinearLayoutManager ( getContext () ) );
        tuApader = new TuApader (getContext ());
        rec3.setAdapter ( tuApader );
    }

    @Override
    public void getChen1(Object object) {

    }

    @Override
    public void getChen2(Object object) {

    }

    @Override
    public void getChen3(Object object) {

    }

    @Override
    public void getChen4(Object object) {
        if (object instanceof List){
            List<TuBean.DataBean.TongQianTopBean.ListBean> listBeans= (List<TuBean.DataBean.TongQianTopBean.ListBean>) object;
            tuApader.addlists ( listBeans );
            tuApader.notifyDataSetChanged ();

        }

    }

    @Override
    public void getChen5(Object object) {

    }
}

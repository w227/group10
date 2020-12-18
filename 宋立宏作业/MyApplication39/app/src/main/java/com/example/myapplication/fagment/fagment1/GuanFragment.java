package com.example.myapplication.fagment.fagment1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.GuanApader;
import com.example.myapplication.bean.GuanBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanFragment extends Fragment implements IView {


    private RecyclerView rec3;
    private GuanApader guanApader;

    public GuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_guan, container, false );
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
        homePers.stact4 ();
    }

    private void initView(View view) {
        rec3 = view.findViewById ( R.id.rec3 );
        rec3.setLayoutManager ( new LinearLayoutManager ( getContext () ) );
        guanApader = new GuanApader (getActivity ());
        rec3.setAdapter ( guanApader );
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
            List<GuanBean.DataBeanX.DataBean> list= (List<GuanBean.DataBeanX.DataBean>) object;
            guanApader.addlisys ( list );
            guanApader.notifyDataSetChanged ();

        }
    }
}

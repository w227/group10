package com.example.day04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;
import com.example.day04.bean.FenBean;
import com.example.day04.bean.HuoBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvPaoApret extends RecyclerView.Adapter {
    private ArrayList<String> list;
    private Context contextl;
    private ArrayList<HuoBean.DataBean> data;

    public RvPaoApret(ArrayList<String> list, Context contextl) {
        this.list = list;
        this.contextl = contextl;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextl).inflate(R.layout.item_rv, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.rvHuo.setLayoutManager(new LinearLayoutManager(contextl,LinearLayoutManager.HORIZONTAL,true));
        data = new ArrayList<>();
        RvHuoApret rvHuoApret = new RvHuoApret(data,contextl);
        viewHolder.rvHuo.setAdapter(rvHuoApret);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rv_huo)
        RecyclerView rvHuo;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

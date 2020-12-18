package com.example.day04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day04.R;
import com.example.day04.bean.QianBean;
import com.example.day04.bean.ShowBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvShowApret extends RecyclerView.Adapter {
    private ArrayList<ShowBean.DataBean.ListBean> list;
    private Context context;
    public RvShowApret(ArrayList<ShowBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv4, parent, false);

        return new ViewHolder5(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder5 viewHolder5 = (ViewHolder5) holder;
        ShowBean.DataBean.ListBean listBean = list.get(position);

        viewHolder5.tvRv4.setText(listBean.getFullName());
        viewHolder5.tv1Rv4.setText(listBean.getNote());

        Glide.with(context).load(listBean.getLogo())
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder5.ivRv4);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static
    class ViewHolder5 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_rv4)
        ImageView ivRv4;
        @BindView(R.id.tv_rv4)
        TextView tvRv4;
        @BindView(R.id.tv1_rv4)
        TextView tv1Rv4;

        ViewHolder5(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

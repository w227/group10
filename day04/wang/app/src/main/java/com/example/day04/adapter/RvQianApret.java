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
import com.example.day04.bean.YanBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvQianApret extends RecyclerView.Adapter {

    private ArrayList<QianBean.DataBean.SignTopBean.ListBean> list;
    private Context context;

    public RvQianApret(ArrayList<QianBean.DataBean.SignTopBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv3, parent, false);

        return new ViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder4 viewHolder3 = (ViewHolder4) holder;
        QianBean.DataBean.SignTopBean.ListBean listBean = list.get(position);

        viewHolder3.tv1Rv3.setText(listBean.getProvince());
        viewHolder3.tv2Rv3.setText(listBean.getCity());
        viewHolder3.tvRv3.setText(listBean.getNickName());

        Glide.with(context).load(listBean.getHeadUrl())
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder3.imgRv3);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        @BindView(R.id.img_rv3)
        ImageView imgRv3;
        @BindView(R.id.tv_rv3)
        TextView tvRv3;
        @BindView(R.id.tv1_rv3)
        TextView tv1Rv3;
        @BindView(R.id.tv2_rv3)
        TextView tv2Rv3;

        ViewHolder4(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

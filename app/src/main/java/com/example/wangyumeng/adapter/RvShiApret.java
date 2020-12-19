package com.example.wangyumeng.adapter;

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
import com.example.wangyumeng.R;
import com.example.wangyumeng.bean.ShiBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JzvdStd;

public class RvShiApret extends RecyclerView.Adapter {
    private ArrayList<ShiBean.DataBeanX.DataBean> list;
    private Context contextl;

    public RvShiApret(ArrayList<ShiBean.DataBeanX.DataBean> list, Context contextl) {
        this.list = list;
        this.contextl = contextl;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(contextl).inflate(R.layout.item_rv1, parent, false);
        return new ViewHolder2(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder2 viewHolder2 = (ViewHolder2) holder;
        ShiBean.DataBeanX.DataBean bean = list.get(position);

        viewHolder2.tvShiRv1.setText(bean.getItemType());
        Glide.with(contextl).load(bean.getCover())
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder2.imtShiRv1);

        viewHolder2.jz.setUp(bean.getUrl(), "视频");
        viewHolder2.jz.startVideo();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static
    class ViewHolder2 extends RvApret.ViewHolder {
        @BindView(R.id.imt_shi_rv1)
        ImageView imtShiRv1;
        @BindView(R.id.tv_shi_rv1)
        TextView tvShiRv1;
        @BindView(R.id.jz)
        JzvdStd jz;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

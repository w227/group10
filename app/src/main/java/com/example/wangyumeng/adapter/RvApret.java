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
import com.example.wangyumeng.bean.JavaBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvApret extends RecyclerView.Adapter {
    private ArrayList<JavaBean.DataBeanX.DataBean.AuthorBean> list;
    private ArrayList<JavaBean.DataBeanX.DataBean> str;
    private Context contextl;

    public RvApret(ArrayList<JavaBean.DataBeanX.DataBean.AuthorBean> list, ArrayList<JavaBean.DataBeanX.DataBean> str, Context contextl) {
        this.list = list;
        this.str = str;
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
        JavaBean.DataBeanX.DataBean.AuthorBean bean = list.get(position);

        viewHolder.tv.setText(bean.getName());
        Glide.with(contextl).load(bean.getAvatar())
                .apply(new RequestOptions().circleCrop()).into(viewHolder.img1);

        JavaBean.DataBeanX.DataBean dataBean = str.get(position);

        viewHolder.tv1.setText(dataBean.getFeeds_text());
        viewHolder.tv3.setText(dataBean.getActivityText());
        Glide.with(contextl).load(dataBean.getCover()).into(viewHolder.img2);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img1)
        ImageView img1;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.img2)
        ImageView img2;
        @BindView(R.id.tv3)
        TextView tv3;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

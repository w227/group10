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
import com.example.day04.R;
import com.example.day04.bean.HuoBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class RvHuoApret extends RecyclerView.Adapter {
    private ArrayList<HuoBean.DataBean> data;
    private Context context;

    public RvHuoApret(ArrayList<HuoBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv1, parent, false);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        HuoBean.DataBean dataBean = data.get(position);
        Glide.with(context).load(dataBean.getCover()).into(viewHolder1.imgRv1);
        viewHolder1.tv.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static
    class ViewHolder1 extends RvPaoApret.ViewHolder {
        @BindView(R.id.img_rv1)
        ImageView imgRv1;
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

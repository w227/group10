package com.example.data12_28activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.data12_28activity.R;
import com.example.data12_28activity.bean.HaiBean;

import java.util.ArrayList;

public class HomeRvHaiAdapter extends RecyclerView.Adapter {
    private ArrayList<HaiBean> list;
    private Context context;

    public HomeRvHaiAdapter(ArrayList<HaiBean> haiBeans, Context context) {
        list = haiBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        HaiBean haiBean = list.get(position);
        Glide.with(context).load(haiBean.getImage()).into(view.iv_hai);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_hai;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_hai = (ImageView) rootView.findViewById(R.id.iv_hai);
        }

    }
}

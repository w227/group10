package com.example.dptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dptext.R;

public class RvPoetryLoversAdapter extends RecyclerView.Adapter<RvPoetryLoversAdapter.ViewHolder> {
    private Context context;

    public RvPoetryLoversAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_poetrylover, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position){
            case 0:
                holder.tv_content_1.setText("青春是飞鸟");
                holder.tv_content_2.setText("日子每天鲜亮");
                holder.tv_content_3.setText("每个梦里有一千对翅膀");
                holder.tv_content_4.setText("《你是青春里最先照亮我的那束光》逸族网");
                break;
            case 1:
                holder.tv_content_1.setText("可我不想播");
                holder.tv_content_2.setText("对树");
                holder.tv_content_3.setText("那是寒露");
                holder.tv_content_4.setText("《写给秋的一首《你是青春里最先逸族网");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_content_1;
        public TextView tv_content_2;
        public TextView tv_content_3;
        public TextView tv_content_4;
        public ConstraintLayout cl_item;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_content_1 = (TextView) rootView.findViewById(R.id.tv_content_1);
            this.tv_content_2 = (TextView) rootView.findViewById(R.id.tv_content_2);
            this.tv_content_3 = (TextView) rootView.findViewById(R.id.tv_content_3);
            this.tv_content_4 = (TextView) rootView.findViewById(R.id.tv_content_4);
            this.cl_item = (ConstraintLayout) rootView.findViewById(R.id.cl_item);
        }

    }
}

package com.example.dptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dptext.R;

public class RvPoetAdapter extends RecyclerView.Adapter<RvPoetAdapter.ViewHolder> {
    private Context context;

    public RvPoetAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_rv_poet, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position%5){
            case 0:
                holder.iv_header.setImageResource(R.drawable.yeu1);
                holder.tv_name.setText("seaster");
                break;
            case 1:
                holder.iv_header.setImageResource(R.drawable.yue2);
                holder.tv_name.setText("风柒");
                break;
            case 2:
                holder.iv_header.setImageResource(R.drawable.yue3);
                holder.tv_name.setText("清芷");
                break;
            case 3:
                holder.iv_header.setImageResource(R.drawable.yue4);
                holder.tv_name.setText("花花娘子");
                break;
            case 4:
                holder.iv_header.setImageResource(R.drawable.yue5);
                holder.tv_name.setText("斜阳未冷");
                break;

        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_header;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_header = (ImageView) rootView.findViewById(R.id.iv_header);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}

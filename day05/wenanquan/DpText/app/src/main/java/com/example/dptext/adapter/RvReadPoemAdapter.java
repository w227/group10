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

public class RvReadPoemAdapter extends RecyclerView.Adapter<RvReadPoemAdapter.ViewHolder> {
    private Context context;

    public RvReadPoemAdapter(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_rv_readpoem, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.iv_header.setImageResource(R.drawable.shan);
                break;
            case 1:
                holder.iv_header.setImageResource(R.drawable.shu);
                break;
            case 2:
                holder.iv_header.setImageResource(R.drawable.zhou1);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_header;
        public TextView tv_title;
        public TextView tv_content;
        public TextView tv_author;
        public TextView tv_yidu;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_header = (ImageView) rootView.findViewById(R.id.iv_header);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_content = (TextView) rootView.findViewById(R.id.tv_content);
            this.tv_author = (TextView) rootView.findViewById(R.id.tv_author);
            this.tv_yidu = (TextView) rootView.findViewById(R.id.tv_yidu);
        }

    }
}

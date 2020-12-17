package com.example.day3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day3.model.bean.DataInfo3;

import java.util.ArrayList;

public class TextAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo3.DataBeanX.DataBean> mBean;
    private Context context;

    public TextAdpter(ArrayList<DataInfo3.DataBeanX.DataBean> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adpter3_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.txt.setText(mBean.get(position).getAuthor().getName());
        Glide.with(context).load(mBean.get(position).getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder1.img);
        holder1.txt2.setText(mBean.get(position).getFeeds_text()+"");
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txt2;
        ImageView img2;
        ImageView img3;
        ImageView img4;
        ImageView img5;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.text_img);
            txt=itemView.findViewById(R.id.text_txt);
            txt2=itemView.findViewById(R.id.text_txt2);
            img2=itemView.findViewById(R.id.ll_text_img);
            img3=itemView.findViewById(R.id.ll_text_img3);
            img4=itemView.findViewById(R.id.ll_text_img2);
            img5=itemView.findViewById(R.id.ll_text_img4);
        }
    }
}

package com.example.day3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day3.model.bean.DataInfo4;

import java.util.ArrayList;

public class LikeAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo4.DataBeanX.DataBean> mBean;
    private Context context;

    public LikeAdpter(ArrayList<DataInfo4.DataBeanX.DataBean> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.like_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.like_txt.setText(mBean.get(position).getIntro());
        holder1.like_txt2.setText(mBean.get(position).getTitle());
        Glide.with(context).load(mBean.get(position).getBackground()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder1.like_img);
        holder1.like_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setTitle(mBean.get(position).getTitle());
                user.setPic(mBean.get(position).getBackground());
                long insert = App.getDaoSession().getUserDao().insert(user);
                if (insert>0){
                    Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show();
                    holder1.like_btn.setText("已关注");
                }else{
                    Toast.makeText(context, "添加失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView like_img;
        public TextView like_txt;
        public TextView like_txt2;
        public Button like_btn;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.like_img = (ImageView) rootView.findViewById(R.id.like_img);
            this.like_txt = (TextView) rootView.findViewById(R.id.like_txt);
            this.like_txt2 = (TextView) rootView.findViewById(R.id.like_txt2);
            this.like_btn = (Button) rootView.findViewById(R.id.like_btn);
        }

    }
}

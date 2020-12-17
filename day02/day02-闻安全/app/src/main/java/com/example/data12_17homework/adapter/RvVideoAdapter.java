package com.example.data12_17homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.data12_17homework.R;
import com.example.data12_17homework.bean.VideoBean;

import java.util.List;

public class RvVideoAdapter extends RecyclerView.Adapter<RvVideoAdapter.ViewHolder> {
    private final Context context;
    private final List<VideoBean.DataBeanX.DataBean> dataBeanList;

    public RvVideoAdapter(Context context, List<VideoBean.DataBeanX.DataBean> dataBeanList) {

        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoBean.DataBeanX.DataBean dataBean = dataBeanList.get(position);

        holder.tv_name.setText(dataBean.getAuthor().getName());
        String feeds_text = (String) dataBean.getFeeds_text();

        if(feeds_text!=null){
            holder.tv_feeds_text.setText(feeds_text);
        }

        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.iv_avatar);

        Glide.with(context).load(dataBean.getCover()).into(holder.iv_cover);
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_avatar;
        public TextView tv_name;
        public TextView tv_feeds_text;
        public ImageView iv_cover;
        public TextView tv_activityText;
        public ImageView iv_like;
        public TextView tv_like;
        public ImageView iv_diss;
        public TextView tv_diss;
        public ImageView iv_comment;
        public TextView tv_comment;
        public ImageView iv_share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_avatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_feeds_text = (TextView) rootView.findViewById(R.id.tv_feeds_text);
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.tv_activityText = (TextView) rootView.findViewById(R.id.tv_activityText);
            this.iv_like = (ImageView) rootView.findViewById(R.id.iv_like);
            this.tv_like = (TextView) rootView.findViewById(R.id.tv_like);
            this.iv_diss = (ImageView) rootView.findViewById(R.id.iv_diss);
            this.tv_diss = (TextView) rootView.findViewById(R.id.tv_diss);
            this.iv_comment = (ImageView) rootView.findViewById(R.id.iv_comment);
            this.tv_comment = (TextView) rootView.findViewById(R.id.tv_comment);
            this.iv_share = (ImageView) rootView.findViewById(R.id.iv_share);
        }

    }
}

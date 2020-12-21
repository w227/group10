package com.example.xsx_shipei_dp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xsx_shipei_dp.R;
import com.example.xsx_shipei_dp.bean.ShirenBean;

import java.util.ArrayList;
import java.util.List;

public class RecDushiAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ShirenBean> list = new ArrayList<>();

    public RecDushiAdapter(Context context, List<ShirenBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_rec_dushi, parent, false);
        return new RecDushiViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class RecDushiViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_rec_dushi;
        public TextView tv_dushi_title;
        public TextView tv_dushi_desc;
        public TextView tv_dushi_content;

        public RecDushiViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_rec_dushi = (ImageView) rootView.findViewById(R.id.img_rec_dushi);
            this.tv_dushi_title = (TextView) rootView.findViewById(R.id.tv_dushi_title);
            this.tv_dushi_desc = (TextView) rootView.findViewById(R.id.tv_dushi_desc);
            this.tv_dushi_content = (TextView) rootView.findViewById(R.id.tv_dushi_content);
        }

    }
}

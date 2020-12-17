package com.example.day3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecommendAdpter extends RecyclerView.Adapter {
    private ArrayList<User> mBena;
    private Context context;

    public RecommendAdpter(ArrayList<User> mBena, Context context) {
        this.mBena = mBena;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adpter4_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.txt.setText(mBena.get(position).getTitle());
        Glide.with(context).load(mBena.get(position).getPic()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return mBena.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.recommend_img);
            txt=itemView.findViewById(R.id.recommend_txt);
        }
    }
}

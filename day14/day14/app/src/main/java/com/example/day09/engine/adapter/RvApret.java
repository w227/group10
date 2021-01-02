package com.example.day09.engine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvApret extends RecyclerView.Adapter {
    private static final int RV1 = 0;
    private static final int RV2 = 1;
    private Context context;

    public RvApret(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return RV1;
        } else if (position % 2 == 1) {
            return RV2;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case RV1:
                View view = LayoutInflater.from(context).inflate(R.layout.rv1, parent, false);
                return new ViewHolder1(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.ban)
        Banner ban;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

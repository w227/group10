package com.example.day09.engine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvMyApret extends RecyclerView.Adapter {
    private static final int RV1 = 1;
    private static final int RV2 = 2;
    private static final int RV3 = 3;
    private static final int RV4 = 4;
    private static final int RV5 = 5;
    private static final int RV6 = 6;
    private Context context;

    public RvMyApret(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 6 == 0) {
            return RV1;
        } else if (position % 6 == 1) {
            return RV2;
        } else if (position % 6 == 2) {
            return RV3;
        } else if (position % 6 == 3) {
            return RV4;
        } else if (position % 6 == 4) {
            return RV5;
        } else if (position % 6 == 5) {
            return RV6;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case RV1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv1, parent, false);
                return new MyViewHolder_RV1(view1);

            case RV2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv2, parent, false);
                return new MyViewHolder_RV2(view2);

            case RV3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv3, parent, false);
                return new MyViewHolder_RV3(view3);


            case RV4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv4, parent, false);
                return new MyViewHolder_RV4(view4);


            case RV5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv5, parent, false);
                return new MyViewHolder_RV5(view5);


            case RV6:
                View view6 = LayoutInflater.from(context).inflate(R.layout.rvmyadapter_rv6, parent, false);
                return new MyViewHolder_RV6(view6);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    static
    class MyViewHolder_RV1 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv1)
        TextView MyRv1;

        MyViewHolder_RV1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
     static
    class MyViewHolder_RV2 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv2)
        TextView MyRv2;

        MyViewHolder_RV2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

     static
    class MyViewHolder_RV3 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv3)
        TextView MyRv3;

        MyViewHolder_RV3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
     static
    class MyViewHolder_RV4 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv4)
        TextView MyRv4;

        MyViewHolder_RV4(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
     static
    class MyViewHolder_RV5 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv5)
        TextView MyRv5;

        MyViewHolder_RV5(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
     static
    class MyViewHolder_RV6 extends RecyclerView.ViewHolder {
        @BindView(R.id.My_rv6)
        TextView MyRv6;

        MyViewHolder_RV6(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}

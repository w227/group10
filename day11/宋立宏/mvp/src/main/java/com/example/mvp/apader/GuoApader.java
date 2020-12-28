package com.example.mvp.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.bean.ListBean;

import java.util.List;

public class GuoApader extends RecyclerView.Adapter<GuoApader.ViewHolder> {
    private final Context context;
    private final List<ListBean> listBeans;

    public GuoApader(Context context, List<ListBean> listBeans) {

        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju6, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with ( context ).load ( listBeans.get ( position ).getImg () ).into ( holder.img );

    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img=itemView.findViewById ( R.id.img4 );
        }
    }
}

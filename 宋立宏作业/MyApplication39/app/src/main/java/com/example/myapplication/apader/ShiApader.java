package com.example.myapplication.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.ShiBean;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.ArrayList;
import java.util.List;

public class ShiApader extends RecyclerView.Adapter {
    private static final int TYPE_NOE = 1;
    private static final int TYPE_TWO = 2;
    private Context context;
    List<ShiBean.DataBeanX.DataBean> list = new ArrayList<> ();

    public ShiApader(Context context) {
        this.context = context;
    }

    public void addslist(List<ShiBean.DataBeanX.DataBean> list) {
        this.list.addAll ( list );
        notifyDataSetChanged ();

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_NOE;
        } else {
            return TYPE_TWO;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_NOE) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju4, null, false );
            return new Text4ViewHolder ( inflate );


        } else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju5, null, false );
            return new Text5ViewHolder ( inflate );

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType ( position )){
            case TYPE_NOE:
                Text4ViewHolder holder1= (Text4ViewHolder) holder;
                BasisVideoController basisVideoController = new BasisVideoController ( context );
                holder1.pvp.setUrl ( list.get ( position ).getUrl () );
                holder1.pvp.setController ( basisVideoController );
                holder1.pvp.postDelayed ( new Runnable () {
                    @Override
                    public void run() {
                        holder1.pvp.start ();

                    }
                },200 );
                break;
            case TYPE_TWO:
                Text5ViewHolder holder2= (Text5ViewHolder) holder;
                Glide.with ( context ).load ( R.drawable.icon_cell_like ).into ( holder2.img51 );
                Glide.with ( context ).load ( R.drawable.icon_cell_diss ).into ( holder2.img52 );
                Glide.with ( context ).load ( R.drawable.icon_cell_share ).into ( holder2.img53 );
                Glide.with ( context ).load ( R.drawable.icon_cell_comment ).into ( holder2.img54 );
                break;


        }


    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public static
    class Text4ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public VideoPlayer pvp;

        public Text4ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.pvp = (VideoPlayer) rootView.findViewById ( R.id.pvp );
        }

    }

    public static
    class Text5ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img51;
        public ImageView img52;
        public ImageView img53;
        public ImageView img54;

        public Text5ViewHolder(View rootView) {
            super (rootView);
            this.rootView = rootView;
            this.img51 = (ImageView) rootView.findViewById ( R.id.img51 );
            this.img52 = (ImageView) rootView.findViewById ( R.id.img52 );
            this.img53 = (ImageView) rootView.findViewById ( R.id.img53 );
            this.img54 = (ImageView) rootView.findViewById ( R.id.img54 );
        }

    }
}

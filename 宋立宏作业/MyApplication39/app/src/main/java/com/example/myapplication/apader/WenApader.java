package com.example.myapplication.apader;

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
import com.example.myapplication.R;
import com.example.myapplication.bean.WenBean;

import java.util.ArrayList;
import java.util.List;

public class WenApader extends RecyclerView.Adapter {
    private static final int YTPE_NOE = 1;
    private static final int YTPE_TWO = 2;
    List<WenBean.DataBeanX.DataBean> list = new ArrayList<> ();
    private Context context;

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return YTPE_NOE;
        } else {
            return YTPE_TWO;
        }
    }

    public void addlists(List<WenBean.DataBeanX.DataBean> list) {
        this.list.addAll ( list );
        notifyDataSetChanged ();

    }


    public WenApader(Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == YTPE_NOE) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju6, null, false );
            return new Text6ViewHolder ( inflate );

        } else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju7, null, false );
            return new Text7ViewHolder ( inflate );

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType ( position )){
            case YTPE_NOE:
                Text6ViewHolder holder1= (Text6ViewHolder) holder;
                holder1.ts6.setText ( list.get ( position ).getAuthor ().getName () );
                RequestOptions requestOptions = new RequestOptions ();
                requestOptions.transform ( new CircleCrop () );
                Glide.with ( context ).load ( list.get ( position ).getAuthor ().getAvatar () ).apply ( requestOptions ).into ( holder1.img6 );
                break;
            case YTPE_TWO:
                Text7ViewHolder holder2= (Text7ViewHolder) holder;
                Glide.with ( context ).load ( R.drawable.icon_cell_like ).into ( holder2.img71 );
                Glide.with ( context ).load ( R.drawable.icon_cell_diss ).into ( holder2.img72 );
                Glide.with ( context ).load ( R.drawable.icon_cell_share ).into ( holder2.img73 );
                Glide.with ( context ).load ( R.drawable.icon_cell_comment ).into ( holder2.img74 );
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public static
    class Text6ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img6;
        public TextView ts6;

        public Text6ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.img6 = (ImageView) rootView.findViewById ( R.id.img6 );
            this.ts6 = (TextView) rootView.findViewById ( R.id.ts6 );
        }

    }

    public static
    class Text7ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img71;
        public ImageView img72;
        public ImageView img73;
        public ImageView img74;

        public Text7ViewHolder(View rootView) {
            super (rootView);
            this.rootView = rootView;
            this.img71 = (ImageView) rootView.findViewById ( R.id.img71 );
            this.img72 = (ImageView) rootView.findViewById ( R.id.img72 );
            this.img73 = (ImageView) rootView.findViewById ( R.id.img73 );
            this.img74 = (ImageView) rootView.findViewById ( R.id.img74 );
        }

    }
}

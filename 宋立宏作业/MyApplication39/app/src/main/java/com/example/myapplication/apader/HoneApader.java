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
import com.example.myapplication.bean.ListBnea;

import java.util.ArrayList;
import java.util.List;

public class HoneApader extends RecyclerView.Adapter {
    private static final int TYPE_NOE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THERE = 3;
    private Context context;

    List<ListBnea.DataBeanX.DataBean> list1 = new ArrayList<> ();


    public HoneApader(Context context) {

        this.context = context;
    }


    public void addlist1(List<ListBnea.DataBeanX.DataBean> list1) {
        this.list1.addAll ( list1 );
        notifyDataSetChanged ();

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return TYPE_NOE;
        } else if (position % 2 == 0) {
            return TYPE_TWO;
        } else {
            return TYPE_THERE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_NOE) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju1, null, false );
            return new Text1ViewHolder ( inflate );

        } else if (viewType == TYPE_TWO) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju2, null, false );
            return new Text2ViewHolder ( inflate );


        } else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju3, null, false );
            return new Text3ViewHolder ( inflate );

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType ( position )){
            case TYPE_NOE:
                Text1ViewHolder holder1= (Text1ViewHolder) holder;
                holder1.ts1.setText ( list1.get ( position ).getAuthor ().getName () );
                RequestOptions requestOptions = new RequestOptions ();
                requestOptions.transform ( new CircleCrop () );
                Glide.with ( context ).load ( list1.get ( position ).getAuthor ().getAvatar () ).apply ( requestOptions ).into ( holder1.img1 );
                break;
            case TYPE_TWO:
                Text2ViewHolder holder2= (Text2ViewHolder) holder;
                holder2.ts2.setText ( list1.get ( position ).getFeeds_text () );
                Glide.with ( context ).load ( list1.get ( position ).getCover () ).into ( holder2.img2 );
                break;
            case TYPE_THERE:
                Text3ViewHolder holder3= (Text3ViewHolder) holder;
                Glide.with ( context ).load ( R.drawable.icon_cell_like ).into ( holder3.img31 );
                Glide.with ( context ).load ( R.drawable.icon_cell_diss ).into ( holder3.img32 );
                Glide.with ( context ).load ( R.drawable.icon_cell_share ).into ( holder3.img33 );
                Glide.with ( context ).load ( R.drawable.icon_cell_comment ).into ( holder3.img34 );
                break;
        }

    }

    @Override
    public int getItemCount() {

        return list1.size ();


    }

    public static
    class Text1ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img1;
        public TextView ts1;

        public Text1ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.img1 = (ImageView) rootView.findViewById ( R.id.img1 );
            this.ts1 = (TextView) rootView.findViewById ( R.id.ts1 );
        }

    }

    public static
    class Text2ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts2;
        public ImageView img2;

        public Text2ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.ts2 = (TextView) rootView.findViewById ( R.id.ts2 );
            this.img2 = (ImageView) rootView.findViewById ( R.id.img2 );
        }

    }

    public static
    class Text3ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img31;
        public ImageView img32;
        public ImageView img33;
        public ImageView img34;

        public Text3ViewHolder(View rootView) {
            super (rootView);
            this.rootView = rootView;
            this.img31 = (ImageView) rootView.findViewById ( R.id.img31 );
            this.img32 = (ImageView) rootView.findViewById ( R.id.img32 );
            this.img33 = (ImageView) rootView.findViewById ( R.id.img33 );
            this.img34 = (ImageView) rootView.findViewById ( R.id.img34 );
        }

    }
}

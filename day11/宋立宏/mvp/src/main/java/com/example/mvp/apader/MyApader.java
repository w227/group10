package com.example.mvp.apader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.bean.ListBean;
import com.example.mvp.mvp.ui.activity.Main2Activity;

import java.util.List;

public class MyApader extends RecyclerView.Adapter {
    private final Context context;
    private final List<ListBean> listBeans;
    private static final int TYPE_NOE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THERE = 3;
    private static final int TYPE_FING = 4;
    private static final int TYPE_TKS = 5;
    private static final int TYPE_SAIWEN = 6;
    private static final int TYPE_AT = 7;

    public MyApader(Context context, List<ListBean> listBeans) {

        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_NOE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position == 2) {
            return TYPE_THERE;
        } else if (position == 3) {
            return TYPE_FING;
        } else if (position == 4) {
            return TYPE_TKS;
        } else if (position == 5) {
            return TYPE_SAIWEN;
        } else {
            return TYPE_AT;
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
        } else if (viewType == TYPE_THERE) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju3, null, false );
            return new Text3ViewHolder ( inflate );
        } else if (viewType == TYPE_FING) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju5, null, false );
            return new Text5ViewHolder ( inflate );
        } else if (viewType == TYPE_TKS) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju7, null, false );
            return new Text6ViewHolder ( inflate );
        } else if (viewType == TYPE_SAIWEN) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju8, null, false );
            return new Text7ViewHolder ( inflate );
        } else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju9, null, false );
            return new Text8ViewHolder ( inflate );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType ( position )) {
            case TYPE_NOE:
                Text1ViewHolder holder1 = (Text1ViewHolder) holder;
                holder1.img1.setBackgroundResource ( R.drawable.qi );
                break;
            case TYPE_TWO:
                Text2ViewHolder holder2 = (Text2ViewHolder) holder;
                holder2.img2.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {

                    }
                } );
                holder2.img22.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {

                    }
                } );

                break;
            case TYPE_THERE:
                Text3ViewHolder holder3 = (Text3ViewHolder) holder;
                holder3.rec1.setLayoutManager ( new LinearLayoutManager ( context, LinearLayoutManager.HORIZONTAL, true ) );
                HomeApader homeApader = new HomeApader ( context, listBeans );
                holder3.rec1.setAdapter ( homeApader );
                break;
            case TYPE_FING:
                Text5ViewHolder holder4 = (Text5ViewHolder) holder;
                holder4.rec2.setLayoutManager ( new LinearLayoutManager ( context, LinearLayoutManager.HORIZONTAL, true ) );
                GuoApader guoApader = new GuoApader ( context, listBeans );
                holder4.rec2.setAdapter ( guoApader );
                break;
            case TYPE_TKS:
                Text6ViewHolder holder5 = (Text6ViewHolder) holder;
                holder5.img5.setBackgroundResource ( R.drawable.meilihaidao );
                break;
            case TYPE_SAIWEN:
                Text7ViewHolder holder6 = (Text7ViewHolder) holder;
                holder6.imgs1.setBackgroundResource ( R.drawable.gu );
                break;
            case TYPE_AT:
                Text8ViewHolder holder7= (Text8ViewHolder) holder;
                holder7.imgsa.setBackgroundResource ( R.drawable.mei );
                holder7.imgsa.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        context.startActivity ( new Intent ( context, Main2Activity.class ) );
                    }
                } );
                break;

        }

    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public static
    class Text1ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img1;

        public Text1ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.img1 = (ImageView) rootView.findViewById ( R.id.img1 );
        }

    }

    public static
    class Text2ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Button img2;
        public Button img22;

        public Text2ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.img2 = (Button) rootView.findViewById ( R.id.bt1 );
            this.img22 = (Button) rootView.findViewById ( R.id.bt2 );
        }

    }

    public static
    class Text3ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rec1;

        public Text3ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.rec1 = (RecyclerView) rootView.findViewById ( R.id.rec1 );
        }

    }

    public static
    class Text5ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rec2;

        public Text5ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.rec2 = (RecyclerView) rootView.findViewById ( R.id.rec2 );
        }

    }

    public static
    class Text6ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img5;

        public Text6ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.img5 = (ImageView) rootView.findViewById ( R.id.img5 );
        }

    }

    public static
    class Text7ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView imgs1;

        public Text7ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.imgs1 = (ImageView) rootView.findViewById ( R.id.imgs1 );
        }

    }

    public static
    class Text8ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView imgsa;

        public Text8ViewHolder(View rootView) {
            super (rootView);
            this.rootView = rootView;
            this.imgsa = (ImageView) rootView.findViewById ( R.id.imgsa );
        }

    }
}

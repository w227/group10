package com.example.myapplication.apader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class HomeApader extends RecyclerView.Adapter {
    private static final int TYPE_NOE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THERE = 3;


    List<ListBean.DataBean> list = new ArrayList<> ();
    private PaoApader paoApader;
    private HuoApader huoApader;
    private Context context;


    public HomeApader(Context context) {

        this.context = context;
    }

    public void addlist(List<ListBean.DataBean> list) {
        this.list.addAll ( list );
        notifyDataSetChanged ();

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_NOE;

        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position==2){
            return TYPE_THERE;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_NOE) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju1, null, false );
            return new Text1ViewHolder ( inflate );

        } else if (viewType == TYPE_TWO) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.bujus, null, false );
            return new TextsViewHolder ( inflate );

        } else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju2, null, false );
            return new Text2ViewHolder ( inflate );

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType ( position )) {
            case TYPE_NOE:
                Text1ViewHolder holder1 = (Text1ViewHolder) holder;
                holder1.tst1.setText ( "袍子" );
                Glide.with ( context ).load ( R.drawable.a3).into ( holder1.imgs1 );
                holder1.tst2.setText ( "社团" );
                Glide.with ( context ).load ( R.drawable.a4).into ( holder1.imgs2 );
                holder1.tst3.setText ( "排行榜" );
                Glide.with ( context ).load ( R.drawable.a6).into ( holder1.imgs3 );

                holder.itemView.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ( context, Main2Activity.class );

                        context.startActivity ( intent );
                    }
                } );
                break;
            case TYPE_TWO:
                TextsViewHolder holder2= (TextsViewHolder) holder;
                holder2.tss1.setText ( "热门活动" );
                holder2.tss2.setText ( "更多活动" );

                break;
            case TYPE_THERE:
                Text2ViewHolder holder3 = (Text2ViewHolder) holder;
                holder3.rec2.setLayoutManager ( new LinearLayoutManager ( context, LinearLayoutManager.HORIZONTAL, true ) );
                huoApader = new HuoApader ( context, list );
                holder3.rec2.setAdapter ( huoApader );

                break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public static
    class Text1ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgs1;
        private TextView tst1;
        private ImageView imgs2;
        private TextView tst2;
        private ImageView imgs3;
        private TextView tst3;

        public Text1ViewHolder(View rootView) {
            super ( rootView );
            imgs1=itemView.findViewById ( R.id.imgs1 );
            imgs2=itemView.findViewById ( R.id.imgs2 );
            imgs3=itemView.findViewById ( R.id.imgs3 );
            tst1=itemView.findViewById ( R.id.tst1 );
            tst2=itemView.findViewById ( R.id.tst2 );
            tst3=itemView.findViewById ( R.id.tst3 );
        }

    }

    public static
    class Text2ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rec2;

        public Text2ViewHolder(View rootView) {
            super ( rootView );
            this.rootView = rootView;
            this.rec2 = (RecyclerView) rootView.findViewById ( R.id.rec2 );
        }

    }

    public static
    class TextsViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tss1;
        public TextView tss2;

        public TextsViewHolder(View rootView) {
            super (rootView);
            this.rootView = rootView;
            this.tss1 = (TextView) rootView.findViewById ( R.id.tss1 );
            this.tss2 = (TextView) rootView.findViewById ( R.id.tss2 );
        }

    }
}

package com.example.mvp.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.bena.ListBean;

import java.util.List;

public class XuanKeApader extends RecyclerView.Adapter {
    private static final int TYPE_NOE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THERE = 3;
    private static final int TYPE_FLDE = 4;
    private static final int TYPE_FLOEW = 5;
    private static final int TYPE_CKS = 6;
    private final Context context;
    private final List<ListBean> listBeans;

    public XuanKeApader(Context context, List<ListBean> listBeans) {

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
            return TYPE_FLDE;
        } else if (position == 4) {
            return TYPE_FLOEW;

        } else {
            return TYPE_CKS;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_NOE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju1, null, false);
            return new Text1ViewHolder(inflate);

        } else if (viewType == TYPE_TWO) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju2, null, false);
            return new Text2ViewHolder(inflate);


        } else if (viewType == TYPE_THERE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju3, null, false);
            return new Text3ViewHolder(inflate);

        } else if (viewType == TYPE_FLDE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju4, null, false);
            return new Text4ViewHolder(inflate);

        } else if (viewType == TYPE_FLOEW) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju5, null, false);
            return new Text5ViewHolder(inflate);

        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.buju6, null, false);
            return new Text6ViewHolder(inflate);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_NOE:
                Text1ViewHolder holder1= (Text1ViewHolder) holder;
                holder1.ts.setText(listBeans.get(position).getName());
                holder1.bt11.setText("经济从业");
                holder1.bt12.setText("银行从业");
                holder1.bt13.setText("期货从业");
                holder1.bt14.setText("证券从业");
                break;
            case TYPE_TWO:
                Text2ViewHolder holder2= (Text2ViewHolder) holder;
                holder2.ts1.setText(listBeans.get(position).getName());
                holder2.bt21.setText("经济从业");
                holder2.bt22.setText("银行从业");
                holder2.bt23.setText("期货从业");
                holder2.bt24.setText("证券从业");
                break;
            case TYPE_THERE:
                Text3ViewHolder holder3= (Text3ViewHolder) holder;
                holder3.ts2.setText(listBeans.get(position).getName());
                holder3.bt21.setText("注册会计师");
                holder3.bt22.setText("会计职称");
                holder3.bt23.setText("经济师考试");
                break;
            case TYPE_FLDE:
                Text4ViewHolder holder4= (Text4ViewHolder) holder;
                holder4.ts3.setText(listBeans.get(position).getName());
                holder4.bt31.setText("CMA");
                break;
            case TYPE_FLOEW:
                Text5ViewHolder holder5= (Text5ViewHolder) holder;
                holder5.ts4.setText(listBeans.get(position).getName());
                holder5.bt41.setText("教师资格");
                break;
            case TYPE_CKS:
                Text6ViewHolder holder6= (Text6ViewHolder) holder;
                holder6.ts5.setText(listBeans.get(position).getName());
                holder6.bt51.setText("建造师");
                break;




        }

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public static
    class Text1ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts;
        public Button bt11;
        public Button bt12;
        public Button bt13;
        public Button bt14;

        public Text1ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts = (TextView) rootView.findViewById(R.id.ts);
            this.bt11 = (Button) rootView.findViewById(R.id.bt11);
            this.bt12 = (Button) rootView.findViewById(R.id.bt12);
            this.bt13 = (Button) rootView.findViewById(R.id.bt13);
            this.bt14 = (Button) rootView.findViewById(R.id.bt14);
        }

    }

    public static
    class Text2ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts1;
        public Button bt21;
        public Button bt22;
        public Button bt23;
        public Button bt24;

        public Text2ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts1 = (TextView) rootView.findViewById(R.id.ts1);
            this.bt21 = (Button) rootView.findViewById(R.id.bt21);
            this.bt22 = (Button) rootView.findViewById(R.id.bt22);
            this.bt23 = (Button) rootView.findViewById(R.id.bt23);
            this.bt24 = (Button) rootView.findViewById(R.id.bt24);
        }

    }

    public static
    class Text3ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts2;
        public Button bt21;
        public Button bt22;
        public Button bt23;

        public Text3ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts2 = (TextView) rootView.findViewById(R.id.ts2);
            this.bt21 = (Button) rootView.findViewById(R.id.bt21);
            this.bt22 = (Button) rootView.findViewById(R.id.bt22);
            this.bt23 = (Button) rootView.findViewById(R.id.bt23);
        }

    }

    public static
    class Text4ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts3;
        public Button bt31;

        public Text4ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts3 = (TextView) rootView.findViewById(R.id.ts3);
            this.bt31 = (Button) rootView.findViewById(R.id.bt31);
        }

    }

    public static
    class Text5ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView ts4;
        public Button bt41;

        public Text5ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts4 = (TextView) rootView.findViewById(R.id.ts4);
            this.bt41 = (Button) rootView.findViewById(R.id.bt41);
        }

    }

    public static
    class Text6ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView ts5;
        public Button bt51;

        public Text6ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ts5 = (TextView) rootView.findViewById(R.id.ts5);
            this.bt51 = (Button) rootView.findViewById(R.id.bt51);
        }

    }
}

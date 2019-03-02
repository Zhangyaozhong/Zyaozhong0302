package com.bwie.android.zyaozhong0302.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.android.zyaozhong0302.R;
import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private List<CartBean.ResultBean> list;

    public CartAdapter(Context context, List<CartBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart_layout, viewGroup, false);
        CartViewHolder holder = new CartViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int i) {
        CartBean.ResultBean resultBean = list.get(i);

        holder.mcb.setChecked(resultBean.flag);
        holder.ivCartIcon.setImageURI(Uri.parse(resultBean.pic));
        holder.tvCartTitle.setText(resultBean.commodityName);
        holder.tvCartPrice.setText(resultBean.price + "");

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mcb)
        CheckBox mcb;
        @BindView(R.id.iv_cart_icon)
        SimpleDraweeView ivCartIcon;
        @BindView(R.id.tv_cart_title)
        TextView tvCartTitle;
        @BindView(R.id.tv_cart_price)
        TextView tvCartPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

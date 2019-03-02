package com.bwie.android.zyaozhong0302;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bwie.android.zyaozhong0302.activity.SubmitOrderActivity;
import com.bwie.android.zyaozhong0302.adapter.CartAdapter;
import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.contract.CartContract;
import com.bwie.android.zyaozhong0302.presenter.CartPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CartContract.ICartView {

    @BindView(R.id.rv_cart)
    RecyclerView rvCart;
    @BindView(R.id.cb_checkAll)
    CheckBox cbCheckAll;
    @BindView(R.id.tv_cart_price)
    TextView tvCartPrice;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    private CartPresenter cartPresenter;
    private List<CartBean.ResultBean> result;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        cartPresenter = new CartPresenter(this);
        cartPresenter.cart(new HashMap<String, String>());
    }

    private void initView() {
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result != null && result.size() > 0) {
                    for (CartBean.ResultBean resultBean : result) {
                        if (!resultBean.flag) {
                            ToastUtils.showShort("请选择要购买的商品");
                            return;
                        } else {
                            EventBus.getDefault().postSticky(result);
                            startActivity(new Intent(MainActivity.this, SubmitOrderActivity.class));

                        }
                    }
                }
            }
        });
        rvCart.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        cbCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (CartBean.ResultBean resultBean : result) {
                    resultBean.flag = cbCheckAll.isChecked();
                }
                getTotalPrice();
                cartAdapter.notifyDataSetChanged();
            }
        });
    }

    private void getTotalPrice() {
        double totalPrice = 0;
        if (result != null && result.size() > 0) {
            for (CartBean.ResultBean resultBean : result) {
                totalPrice += resultBean.price * resultBean.count;
            }
        }
        tvCartPrice.setText(totalPrice + "");
//        cartAdapter.notifyDataSetChanged();
    }

    /**
     * 成功的回调
     *
     * @param cartBean
     */
    @Override
    public void success(CartBean cartBean) {
        ToastUtils.showShort(cartBean.message);
        if (cartBean != null) {
            result = cartBean.result;
            cartAdapter = new CartAdapter(MainActivity.this, result);
            rvCart.setAdapter(cartAdapter);
        }
    }

    @Override
    public void error(String msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cartPresenter.destroy();
    }
}

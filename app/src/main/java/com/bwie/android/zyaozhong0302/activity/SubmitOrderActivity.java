package com.bwie.android.zyaozhong0302.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bwie.android.zyaozhong0302.R;
import com.bwie.android.zyaozhong0302.bean.AddressListBean;
import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.bean.CreateOrderBean;
import com.bwie.android.zyaozhong0302.bean.OrderInfoBean;
import com.bwie.android.zyaozhong0302.contract.CreateOrderContract;
import com.bwie.android.zyaozhong0302.presenter.CreateOrderPresenter;
import com.bwie.android.zyaozhong0302.utils.PopWindowUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubmitOrderActivity extends AppCompatActivity implements CreateOrderContract.ICreateOrderView {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.rv_affirm_order)
    RecyclerView rvAffirmOrder;
    @BindView(R.id.submit)
    TextView submit;
    private List<OrderInfoBean> infoBeanList = new ArrayList<>();
    private String orderInfo;
    private double totalPrice = 0;
    private CreateOrderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    private void initData() {
        presenter = new CreateOrderPresenter(this);
    }

    private void initView() {
        ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popView = View.inflate(SubmitOrderActivity.this, R.layout.pop_layout, null);
                PopWindowUtil popWindowUtil = PopWindowUtil.getInstance().makePopupWindow(SubmitOrderActivity.this, v, popView, R.color.color1);
                popWindowUtil.showLocationWithAnimation(SubmitOrderActivity.this, v, 0, 0, 0);
                RecyclerView rvPop = popView.findViewById(R.id.rv_pop);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> params = new HashMap<>();
                params.put("orderInfo", orderInfo);
                params.put("totalPrice", totalPrice + "");
                params.put("addressId", "223");
                presenter.createOrder(params);
            }
        });
    }

    @Subscribe(sticky = true)
    public void accept(List<CartBean.ResultBean> result) {

        Gson gson = new Gson();
        if (result != null && result.size() > 0) {
            for (CartBean.ResultBean resultBean : result) {
                OrderInfoBean orderInfoBean = new OrderInfoBean(resultBean.commodityId, resultBean.count);
                infoBeanList.add(orderInfoBean);
                totalPrice += resultBean.price * resultBean.count;
            }
        }
        orderInfo = gson.toJson(infoBeanList);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void success(CreateOrderBean createOrderBean) {
        if (createOrderBean != null) {
            ToastUtils.showShort(createOrderBean.message);
        }
    }

    @Override
    public void addressSuccess(AddressListBean addressListBean) {
        if (addressListBean != null) {
            List<AddressListBean.ResultBean> result = addressListBean.result;
            for (AddressListBean.ResultBean resultBean : result) {

            }
        }
    }

    @Override
    public void error(String msg) {
        ToastUtils.showShort(msg);
    }
}

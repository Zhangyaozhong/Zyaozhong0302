package com.bwie.android.zyaozhong0302.contract;

import com.bwie.android.zyaozhong0302.bean.AddressListBean;
import com.bwie.android.zyaozhong0302.bean.CreateOrderBean;
import com.bwie.android.zyaozhong0302.model.ModelCallback;

import java.util.HashMap;

public interface CreateOrderContract {
    abstract class CreateOrderPresenter {
        public abstract void createOrder(HashMap<String, String> params);

        public abstract void addressList(HashMap<String, String> params);
    }

    interface ICreateOrderModel {
        void createOrder(HashMap<String, String> params, ModelCallback callback);

        void addressList(HashMap<String, String> params, ModelCallback callback);
    }

    interface ICreateOrderView {
        void success(CreateOrderBean createOrderBean);
        void addressSuccess(AddressListBean createOrderBean);

        void error(String msg);
    }
}

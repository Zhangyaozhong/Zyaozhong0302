package com.bwie.android.zyaozhong0302.presenter;

import com.bwie.android.zyaozhong0302.bean.AddressListBean;
import com.bwie.android.zyaozhong0302.bean.CreateOrderBean;
import com.bwie.android.zyaozhong0302.contract.CreateOrderContract;
import com.bwie.android.zyaozhong0302.model.CreateOrderModel;
import com.bwie.android.zyaozhong0302.model.ModelCallback;

import java.util.HashMap;

public class CreateOrderPresenter extends CreateOrderContract.CreateOrderPresenter {
    private CreateOrderContract.ICreateOrderView iCreateOrderView;
    private CreateOrderModel createOrderModel;

    public CreateOrderPresenter(CreateOrderContract.ICreateOrderView iCreateOrderView) {
        createOrderModel = new CreateOrderModel();
        this.iCreateOrderView = iCreateOrderView;
    }

    @Override
    public void createOrder(HashMap<String, String> params) {
        if (createOrderModel != null) {
            createOrderModel.createOrder(params, new ModelCallback() {
                @Override
                public void listSuccess(Object o) {
                    if (iCreateOrderView != null) {
                        iCreateOrderView.success((CreateOrderBean) o);
                    }
                }

                @Override
                public void error(String msg) {
                    if (iCreateOrderView != null) {
                        iCreateOrderView.error(msg);
                    }
                }
            });
        }
    }

    @Override
    public void addressList(HashMap<String, String> params) {
        if (createOrderModel != null) {
            createOrderModel.addressList(params, new ModelCallback() {
                @Override
                public void listSuccess(Object o) {
                    if (iCreateOrderView != null) {
                        iCreateOrderView.addressSuccess((AddressListBean) o);
                    }
                }

                @Override
                public void error(String msg) {
                    if (iCreateOrderView != null) {
                        iCreateOrderView.error(msg);
                    }
                }
            });
        }
    }
}

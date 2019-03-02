package com.bwie.android.zyaozhong0302.model;

import com.blankj.utilcode.util.LogUtils;
import com.bwie.android.zyaozhong0302.api.ApiService;
import com.bwie.android.zyaozhong0302.bean.AddressListBean;
import com.bwie.android.zyaozhong0302.bean.CreateOrderBean;
import com.bwie.android.zyaozhong0302.contract.CreateOrderContract;
import com.bwie.android.zyaozhong0302.network.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.bwie.android.zyaozhong0302.common.CommonStr.ERROR_HINT;

public class CreateOrderModel implements CreateOrderContract.ICreateOrderModel {

    @Override
    public void createOrder(HashMap<String, String> params, final ModelCallback callback) {
        RetrofitUtils.getInstance().create(ApiService.class)
                .createOrder(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CreateOrderBean>() {
                    @Override
                    public void accept(CreateOrderBean createOrderBean) throws Exception {
                        if (callback != null) {
                            callback.listSuccess(createOrderBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (throwable.getMessage() != null) {
                            LogUtils.d(throwable.getMessage());
                            if (callback != null) {
                                callback.error(ERROR_HINT);
                            }
                        }
                    }
                });
    }

    @Override
    public void addressList(HashMap<String, String> params, final ModelCallback callback) {
        RetrofitUtils.getInstance().create(ApiService.class)
                .addressList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddressListBean>() {
                    @Override
                    public void accept(AddressListBean addressListBean) throws Exception {
                        if (callback != null) {
                            callback.listSuccess(addressListBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (throwable.getMessage() != null) {
                            LogUtils.d(throwable.getMessage());
                            if (callback != null) {
                                callback.error(ERROR_HINT);
                            }
                        }
                    }
                });
    }
}

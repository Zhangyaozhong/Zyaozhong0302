package com.bwie.android.zyaozhong0302.model;

import com.blankj.utilcode.util.LogUtils;
import com.bwie.android.zyaozhong0302.api.ApiService;
import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.contract.CartContract;
import com.bwie.android.zyaozhong0302.network.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.bwie.android.zyaozhong0302.common.CommonStr.ERROR_HINT;

public class CartModel implements CartContract.ICartModel {
    @Override
    public void cart(HashMap<String, String> params, final ModelCallback callback) {
        RetrofitUtils.getInstance().create(ApiService.class)
                .cart(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        if (callback!=null){
                            callback.listSuccess(cartBean);
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

package com.bwie.android.zyaozhong0302.presenter;

import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.contract.CartContract;
import com.bwie.android.zyaozhong0302.model.CartModel;
import com.bwie.android.zyaozhong0302.model.ModelCallback;

import java.util.HashMap;

public class CartPresenter extends CartContract.CartPresenter {
    private CartModel cartModel;
    private CartContract.ICartView iCartView;

    public CartPresenter(CartContract.ICartView iCartView) {
        cartModel = new CartModel();
        this.iCartView = iCartView;
    }

    @Override
    public void cart(HashMap<String, String> params) {
        if (cartModel != null) {
            cartModel.cart(params, new ModelCallback() {
                @Override
                public void listSuccess(Object o) {
                    if (iCartView != null) {
                        iCartView.success((CartBean) o);
                    }
                }

                @Override
                public void error(String msg) {
                    if (iCartView != null) {
                        iCartView.error(msg);
                    }
                }
            });
        }
    }

    public void destroy() {
        if (iCartView != null) {
            iCartView = null;
        }
    }

}

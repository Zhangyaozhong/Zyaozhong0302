package com.bwie.android.zyaozhong0302.contract;

import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.model.ModelCallback;

import java.util.HashMap;

public interface CartContract {
    abstract class CartPresenter {
        public abstract void cart(HashMap<String, String> params);
    }

    interface ICartModel {
        void cart(HashMap<String, String> params, ModelCallback callback);
    }

    interface ICartView {
        void success(CartBean cartBean);

        void error(String msg);
    }
}

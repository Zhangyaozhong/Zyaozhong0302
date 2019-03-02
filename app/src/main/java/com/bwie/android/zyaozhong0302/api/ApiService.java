package com.bwie.android.zyaozhong0302.api;

import com.bwie.android.zyaozhong0302.bean.AddressListBean;
import com.bwie.android.zyaozhong0302.bean.CartBean;
import com.bwie.android.zyaozhong0302.bean.CreateOrderBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {
    @GET(AllApi.CART_URL)
    @Headers({
            "sessionId: 15514918246383",
            "userId: 3"})
    Observable<CartBean> cart(@QueryMap HashMap<String, String> params);

    @GET(AllApi.ADDRESS_LIST_URL)
    @Headers({
            "sessionId: 15514918246383",
            "userId: 3"})
    Observable<AddressListBean> addressList(@QueryMap HashMap<String, String> params);

    @POST(AllApi.CREATE_ORDER_URL)
    @FormUrlEncoded
    @Headers({
            "sessionId: 15514918246383",
            "userId: 3"})
    Observable<CreateOrderBean> createOrder(@FieldMap HashMap<String, String> params);
}

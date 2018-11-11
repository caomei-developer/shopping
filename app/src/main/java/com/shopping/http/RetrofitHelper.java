package com.shopping.http;


import com.dou361.retrofit2.converter.fastjson.FastJsonConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper retrofitHelper;


    public RetrofitHelper getRetrofitHelper() {
        if (retrofitHelper == null){
            synchronized (RetrofitHelper.class){
                retrofitHelper = new RetrofitHelper();
            }
        }
        return retrofitHelper;
    }

    public static Retrofit retrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url == null ? "" : url)
                .client(OkHttpHelper.getOkhttpHelper().okHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        return retrofit;
    }
}

package com.shopping.http;


import okhttp3.OkHttpClient;

public class OkHttpHelper {
    private static OkHttpHelper okhttpHelper;

    public static OkHttpHelper getOkhttpHelper() {
        if (okhttpHelper == null){
            synchronized (OkHttpHelper.class){
                okhttpHelper = new OkHttpHelper();
            }
        }
        return okhttpHelper;
    }


    public OkHttpClient okHttpClient (){
       return new OkHttpClient.Builder().build();
    }
}

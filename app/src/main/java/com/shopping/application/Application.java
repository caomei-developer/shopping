package com.shopping.application;

public class Application extends android.app.Application {
    public static Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}

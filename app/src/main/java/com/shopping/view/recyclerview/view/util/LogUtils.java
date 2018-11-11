package com.shopping.view.recyclerview.view.util;

import android.util.Log;
public class LogUtils {

    private static boolean DEBUG = false;

    public static void setLogEnale(boolean b){
        DEBUG = b;
    }

    public static void log(String tag, String content) {
        if (DEBUG) {
            Log.i(tag, content);
        }
    }
}

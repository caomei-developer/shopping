package com.shopping.util;

public class StringUtils {
    public static boolean isEmpty(String value){
        if (value == null || "".equals(value) || "null".equals(value) || value.length() == 0){
            return true;
        }
        return  false;
    }



}

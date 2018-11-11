package com.shopping.util;

import android.os.StatFs;

import java.io.File;

public class Utils {
    public static long calculateDiskCacheSize(File paramFile) {
        long l1 = 20000000L;
        try {
            StatFs statFs = new StatFs(paramFile.getAbsolutePath());
            long l2 = statFs.getBlockCount() * statFs.getBlockSize() / 50L;
            l1 = l2;
        } catch (IllegalArgumentException e) {
        }
        return Math.max(Math.min(l1, 200000000L), 20000000L);
    }

}

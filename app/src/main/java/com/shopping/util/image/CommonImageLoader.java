package com.shopping.util.image;

import android.content.Context;

import com.shopping.util.image.builder.ImageLoaderBuilder;
import com.shopping.util.image.impl.PicassoImageLibImpl;
import com.shopping.util.image.listener.ImageLibInterface;


public class CommonImageLoader {

	private static ImageLibInterface loader = new PicassoImageLibImpl();

	public static ImageLoaderBuilder load(String url) {
		return new ImageLoaderBuilder(loader, url);
	}

	public static ImageLoaderBuilder load(int resourceId) {
		if (resourceId == 0) {
			throw new IllegalArgumentException("Resource ID must not be zero.");
		} else {
			return new ImageLoaderBuilder(loader, resourceId);
		}
	}

	public static void clearMemoryCache() {
		if (loader != null) {
			loader.clearMemoryCache();
		}
	}

	public static void clearDiskCache(Context paramContext) {
		if (loader != null) {
			loader.clearDiskCache(paramContext);
		}
	}

}

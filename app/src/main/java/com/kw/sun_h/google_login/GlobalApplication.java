package com.kw.sun_h.google_login;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.Display;

import com.kakao.auth.KakaoSDK;
//import com.android.volley.*;

/**
 * Created by SUN_h on 2018-03-18.
 */

public class GlobalApplication extends Application {
    private static volatile GlobalApplication instance = null;
    private static volatile Activity currentActivity = null;
    //private ImageLoader imageLoader;

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        GlobalApplication.currentActivity = currentActivity;
    }

    public static GlobalApplication getGlobalApplicationContext() {
        if(instance == null) {
            throw new IllegalStateException("this application does not ingerit com.kakao.GlobalApplication");
        }
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        /*instance = this;

        KakaoSDK.init(new KakaoSDKAdapter());

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            final LruCache<String, Bitmap> imageCache = new LruCache<String, Bitmap>(3);

            @Override
            public void putBitmap(String key, Bitmap value) {
                imageCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return imageCache.get(key);
            }
        };

        imageLoader = new ImageLoader(requestQueue, imageCache);*/
    }

    /*public ImageLoader getImageLoader() {
        return imageLoader;
    }*/

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
    public static Display mDisplay;

    public static void setDisplay(Display display) {
        mDisplay = display;
    }

    public static int getDisplayWidth() {
        return mDisplay.getWidth();
    }

    public static int getDisplayHeight() {
        return mDisplay.getHeight();
    }

    public int resize_Height(int width, int height, int resize_width) {
        return (this.getDisplayHeight()*resize_width)/getDisplayWidth();
    }
}

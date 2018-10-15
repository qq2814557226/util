package com.example.administrator.util.screen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils {

    /**
     * 获取屏幕相关参数
     *
     * @param context
     * @return DisplayMetrics   屏幕宽高
     */
    public static DisplayMetrics getScreenSize(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     * @return density  屏幕密度
     */
    public static float getDeviceDensity(Context context) {
        return getScreenSize(context).density;
    }
}
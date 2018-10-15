package com.example.administrator.util.log;

import android.support.annotation.StringDef;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LogUtils {
    public static final String i = "i", d = "d", e = "e", v = "v", w = "w", wtf = "wtf";

    @StringDef({i, d, e, v, w, wtf})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogType{}

    public static void showLongLog(@LogType  String type, String tag, String log, int showCount){
        if(log.length() >showCount){
            String s = log.substring(0, showCount);
            show(type, tag, s);
            if((log.length() - showCount)>showCount){//剩下的文本还是大于规定长度
                String partLog = log.substring(showCount,log.length());
                showLongLog(type, tag, partLog, showCount);
            }else{
                String surplusLog = log.substring(showCount, log.length());
                show(type, tag, surplusLog);
            }
        }else{
            Log.i(tag, log+"");
        }
    }

    private static void show(String type, String tag, String s){
        switch (type){
            case i :
                Log.i(tag, s + "");
                break;
            case d :
                Log.d(tag, s + "");
                break;
            case e :
                Log.e(tag, s + "");
                break;
            case v :
                Log.v(tag, s + "");
                break;
            case w :
                Log.w(tag, s + "");
                break;
            case wtf :
                Log.wtf(tag, s + "");
                break;
        }
    }
}
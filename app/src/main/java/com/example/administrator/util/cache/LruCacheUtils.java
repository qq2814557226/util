package com.example.administrator.util.cache;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.IntDef;
import android.util.LruCache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LruCacheUtils {
    public final static int LARGE = 4, MIDDLE = 8, SMALL = 16;

    @IntDef({LARGE, MIDDLE, SMALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheSize{}

    public static LruCache getBitmapCache(@CacheSize int size){
        return new LruCache<String, Bitmap>(CacheUtils.getMemory() / size){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {    //API 19
                    return value.getAllocationByteCount();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {//API 12
                    return value.getByteCount();
                }
                // 在低版本中用一行的字节x高度
                return value.getRowBytes() * value.getHeight();//Since API Level 1
            }

            /**
             * 1.当被回收或者删掉时调用。该方法当value被回收释放存储空间时被remove调用或者替换条目值时put调用，默认实现什么都没做。
             * 2.该方法没用同步调用，如果其他线程访问缓存时，该方法也会执行。
             * 3.evicted=true：如果该条目被删除空间 （表示进行了trimToSize or remove）
             *   evicted=false：put冲突后 或 get里成功create后导致
             * 4.newValue!=null，那么则被put()或get()调用。
             *
             * 1.进行资源的回收
             * 2.用于实现二级缓存，把删掉的item放入另一个LinkedHashMap<String, SoftWeakReference<Bitmap>>中
             *   每次获得图片的时候，先判断LruCache中是否缓存，没有的话，再判断这个二级缓存中是否有，如果都没有再从sdcard上获取。sdcard上也没有的话，就从网络服务器上拉取。
             */
            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {

            }
        };
    }
}
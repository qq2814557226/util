package com.example.administrator.util.cache;

public class CacheUtils {
    public static int getMemory(){
        return (int) (Runtime.getRuntime().totalMemory() / 1024);
    }
}
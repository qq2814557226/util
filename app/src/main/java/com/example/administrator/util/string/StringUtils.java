package com.example.administrator.util.string;

public class StringUtils {
    /**
     * String is not black or empty?
     * @param s
     * @return
     */
    public static boolean isNotBlank(String s){
        return s != null && s.equals("");
    }

}
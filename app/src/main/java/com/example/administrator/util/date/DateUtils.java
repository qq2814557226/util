package com.example.administrator.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String parseLongDate(String sFormat, Long t){
        return new SimpleDateFormat(sFormat).format(new Date(t));
    }
}
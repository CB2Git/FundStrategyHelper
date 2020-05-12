package com.fund.strategy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.Nullable;

public class DateUtils {

    /**
     * 2020-05-08
     *
     * @param str
     */
    @Nullable
    public static Date str2Date(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间转换为string
     *
     * @param date
     * @param format "yyyy.MM.dd G 'at' HH:mm:ss z"   2001.07.04 AD at 12:08:56 PDT
     * @return
     */
    public static String date2str(@Nullable Date date, String format) {

        if (date == null) {
            return "";
        }

        java.text.SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}

package com.fund.strategy.utils;


import java.text.DecimalFormat;

public class FontUtils {

    public static String number2String(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(number);
    }

    public static String number2String(double number,String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
}

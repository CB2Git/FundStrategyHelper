package com.fund.strategy.utils;


import java.text.DecimalFormat;

public class FontUtils {

    public static String number2String(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(number);
    }
}

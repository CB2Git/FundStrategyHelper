package com.fund.strategy.utils;


import java.text.DecimalFormat;

public class FontUtils {

    public static String number2String(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(number);
    }

    public static String number2String(double number, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }

    public static double str2Double(String str) {
        try {
            return Double.parseDouble(str);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }
}

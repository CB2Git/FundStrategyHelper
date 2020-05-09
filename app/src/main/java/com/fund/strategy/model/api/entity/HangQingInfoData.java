package com.fund.strategy.model.api.entity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HangQingInfoData {

    /**
     * data : [{"symbol":"SH000001","chg":23.82,"fd_code":"470007","current":2895.34,"percentage":0.83,"name":"上证指数"},{"symbol":"SZ399001","chg":138.29,"fd_code":"202017","current":11001.58,"percentage":1.27,"name":"深证成指"},{"symbol":"SZ399006","chg":18.4,"fd_code":"004394","current":2125.24,"percentage":0.87,"name":"创业板指"},{"symbol":"SH000016","chg":18.59,"fd_code":"399001","current":2873.01,"percentage":0.65,"name":"上证50"},{"symbol":"SH000300","chg":38.73,"fd_code":"000311","current":3963.62,"percentage":0.99,"name":"沪深300"},{"symbol":"SH000905","chg":61.95,"fd_code":"460009","current":5507.7,"percentage":1.14,"name":"中证500"},{"symbol":"HKHSI","chg":249.54,"fd_code":"164705","current":24230.17,"percentage":1.04,"name":"恒生指数"},{"symbol":"HKHSCEI","chg":104.08,"fd_code":"160717","current":9868.34,"percentage":1.07,"name":"国企指数"},{"symbol":".INX","chg":48.61,"fd_code":"096001","current":2929.8,"percentage":1.69,"name":"标普500指数"}]
     * result_code : 0
     */

    private int result_code;
    private List<HangQingInfo> data;

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    @NotNull
    public List<HangQingInfo> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }

    public void setData(List<HangQingInfo> data) {
        this.data = data;
    }
}

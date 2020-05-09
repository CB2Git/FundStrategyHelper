package com.fund.strategy.model.api.entity;

public  class HangQingInfo {
    /**
     * symbol : SH000001
     * chg : 23.82
     * fd_code : 470007
     * current : 2895.34
     * percentage : 0.83
     * name : 上证指数
     */

    private String symbol;
    private double chg;
    private String fd_code;
    private double current;
    private double percentage;
    private String name;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getChg() {
        return chg;
    }

    public void setChg(double chg) {
        this.chg = chg;
    }

    public String getFd_code() {
        return fd_code;
    }

    public void setFd_code(String fd_code) {
        this.fd_code = fd_code;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

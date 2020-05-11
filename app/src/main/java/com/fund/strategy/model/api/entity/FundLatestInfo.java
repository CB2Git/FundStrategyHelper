package com.fund.strategy.model.api.entity;

public class FundLatestInfo {
    /**
     * FCODE : 005919
     * SHORTNAME : 天弘中证500指数C
     * PDATE : 2020-04-29
     * NAV : 0.9214
     * ACCNAV : 0.9214
     * NAVCHGRT : 0.01
     * GSZ : 0.9427
     * GSZZL : 2.31
     * GZTIME : 2020-04-30 15:00
     * NEWPRICE : --
     * CHANGERATIO : --
     * ZJL : --
     * HQDATE : --
     * ISHAVEREDPACKET : false
     */

    private String FCODE;
    private String SHORTNAME;
    private String PDATE;
    private float NAV;
    private float ACCNAV;
    private float NAVCHGRT;
    private float GSZ;
    private float GSZZL;
    private String GZTIME;
    private String NEWPRICE;
    private String CHANGERATIO;
    private String ZJL;
    private String HQDATE;
    private boolean ISHAVEREDPACKET;

    public String getFCODE() {
        return FCODE;
    }

    public void setFCODE(String FCODE) {
        this.FCODE = FCODE;
    }

    public String getSHORTNAME() {
        return SHORTNAME;
    }

    public void setSHORTNAME(String SHORTNAME) {
        this.SHORTNAME = SHORTNAME;
    }

    public String getPDATE() {
        return PDATE;
    }

    public void setPDATE(String PDATE) {
        this.PDATE = PDATE;
    }

    public float getNAV() {
        return NAV;
    }

    public void setNAV(float NAV) {
        this.NAV = NAV;
    }

    public float getACCNAV() {
        return ACCNAV;
    }

    public void setACCNAV(float ACCNAV) {
        this.ACCNAV = ACCNAV;
    }

    public float getNAVCHGRT() {
        return NAVCHGRT;
    }

    public void setNAVCHGRT(float NAVCHGRT) {
        this.NAVCHGRT = NAVCHGRT;
    }

    public float getGSZ() {
        return GSZ;
    }

    public void setGSZ(float GSZ) {
        this.GSZ = GSZ;
    }

    public float getGSZZL() {
        return GSZZL;
    }

    public void setGSZZL(float GSZZL) {
        this.GSZZL = GSZZL;
    }

    public String getGZTIME() {
        return GZTIME;
    }

    public void setGZTIME(String GZTIME) {
        this.GZTIME = GZTIME;
    }

    public String getNEWPRICE() {
        return NEWPRICE;
    }

    public void setNEWPRICE(String NEWPRICE) {
        this.NEWPRICE = NEWPRICE;
    }

    public String getCHANGERATIO() {
        return CHANGERATIO;
    }

    public void setCHANGERATIO(String CHANGERATIO) {
        this.CHANGERATIO = CHANGERATIO;
    }

    public String getZJL() {
        return ZJL;
    }

    public void setZJL(String ZJL) {
        this.ZJL = ZJL;
    }

    public String getHQDATE() {
        return HQDATE;
    }

    public void setHQDATE(String HQDATE) {
        this.HQDATE = HQDATE;
    }

    public boolean isISHAVEREDPACKET() {
        return ISHAVEREDPACKET;
    }

    public void setISHAVEREDPACKET(boolean ISHAVEREDPACKET) {
        this.ISHAVEREDPACKET = ISHAVEREDPACKET;
    }
}

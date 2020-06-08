package com.fund.strategy.model.api.entity;

import java.util.List;

public class TodayFundChangeBean {


    /**
     * Datas : ["1,09:30,-0.0790","2,09:31,-0.2470","3,09:32,-0.3515","4,09:33,-0.3230","5,09:34,-0.1805","6,09:35,-0.1425","7,09:36,-0.1140","8,09:37,-0.1615","9,09:38,-0.1900","10,09:39,-0.1995","11,09:40,-0.1425","12,09:41,-0.1805","13,09:42,-0.1615","14,09:43,-0.1710","15,09:44,-0.1690","16,09:45,-0.1520","17,09:46,-0.1900","18,09:47,-0.2185","19,09:48,-0.1520","20,09:49,-0.1510","21,09:50,-0.1900","22,09:51,-0.1615","23,09:52,-0.1425","24,09:53,-0.1805","25,09:54,-0.2090","26,09:55,-0.2470","27,09:56,-0.2945","28,09:57,-0.2850","29,09:58,-0.2755","30,09:59,-0.2470","31,10:00,-0.2380","32,10:01,-0.2755","33,10:02,-0.2470","34,10:03,-0.2090","35,10:04,-0.1900","36,10:05,-0.1995","37,10:06,-0.2280","38,10:07,-0.2565","39,10:08,-0.2660","40,10:09,-0.2610","41,10:10,-0.2090","42,10:11,-0.2375","43,10:12,-0.2470"]
     * ErrCode : 0
     * ErrMsg : null
     * TotalCount : 242
     * Expansion : {"FCODE":"005918","SHORTNAME":"天弘沪深300ETF联接C","GZTIME":"2020-05-20 10:08","GZ":"1.0690","GSZZL":"-0.27","GZZF":"-0.0029","SGZT":"开放申购","SHZT":"开放赎回","SOURCERATE":"","rate":"0.00%","DTZT":"1","ISBUY":"1","JZRQ":"2020-05-19","DWJZ":"1.0719","BUY":true,"Market":"CN"}
     */

    private int ErrCode;
    private Object ErrMsg;
    private int TotalCount;
    private ExpansionBean Expansion;
    private List<String> Datas;

    public int getErrCode() {
        return ErrCode;
    }

    public void setErrCode(int ErrCode) {
        this.ErrCode = ErrCode;
    }

    public Object getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(Object ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public ExpansionBean getExpansion() {
        return Expansion;
    }

    public void setExpansion(ExpansionBean Expansion) {
        this.Expansion = Expansion;
    }

    public List<String> getDatas() {
        return Datas;
    }

    public void setDatas(List<String> Datas) {
        this.Datas = Datas;
    }

    public static class ExpansionBean {
        /**
         * FCODE : 005918
         * SHORTNAME : 天弘沪深300ETF联接C
         * GZTIME : 2020-05-20 10:08
         * GZ : 1.0690
         * GSZZL : -0.27
         * GZZF : -0.0029
         * SGZT : 开放申购
         * SHZT : 开放赎回
         * SOURCERATE :
         * rate : 0.00%
         * DTZT : 1
         * ISBUY : 1
         * JZRQ : 2020-05-19
         * DWJZ : 1.0719
         * BUY : true
         * Market : CN
         */

        private String FCODE;
        private String SHORTNAME;
        private String GZTIME;
        private float GZ;//最新净值
        private float GSZZL;//最新百分比
        private String GZZF;
        private String SGZT;
        private String SHZT;
        private String SOURCERATE;
        private String rate;
        private String DTZT;
        private String ISBUY;
        private String JZRQ;
        private String DWJZ;
        private boolean BUY;
        private String Market;

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

        public String getGZTIME() {
            return GZTIME;
        }

        public void setGZTIME(String GZTIME) {
            this.GZTIME = GZTIME;
        }

        public float getGZ() {
            return GZ;
        }

        public void setGZ(float GZ) {
            this.GZ = GZ;
        }

        public float getGSZZL() {
            return GSZZL;
        }

        public void setGSZZL(float GSZZL) {
            this.GSZZL = GSZZL;
        }

        public String getGZZF() {
            return GZZF;
        }

        public void setGZZF(String GZZF) {
            this.GZZF = GZZF;
        }

        public String getSGZT() {
            return SGZT;
        }

        public void setSGZT(String SGZT) {
            this.SGZT = SGZT;
        }

        public String getSHZT() {
            return SHZT;
        }

        public void setSHZT(String SHZT) {
            this.SHZT = SHZT;
        }

        public String getSOURCERATE() {
            return SOURCERATE;
        }

        public void setSOURCERATE(String SOURCERATE) {
            this.SOURCERATE = SOURCERATE;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDTZT() {
            return DTZT;
        }

        public void setDTZT(String DTZT) {
            this.DTZT = DTZT;
        }

        public String getISBUY() {
            return ISBUY;
        }

        public void setISBUY(String ISBUY) {
            this.ISBUY = ISBUY;
        }

        public String getJZRQ() {
            return JZRQ;
        }

        public void setJZRQ(String JZRQ) {
            this.JZRQ = JZRQ;
        }

        public String getDWJZ() {
            return DWJZ;
        }

        public void setDWJZ(String DWJZ) {
            this.DWJZ = DWJZ;
        }

        public boolean isBUY() {
            return BUY;
        }

        public void setBUY(boolean BUY) {
            this.BUY = BUY;
        }

        public String getMarket() {
            return Market;
        }

        public void setMarket(String Market) {
            this.Market = Market;
        }
    }
}

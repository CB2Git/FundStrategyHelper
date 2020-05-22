package com.fund.strategy.model.api.entity;

import java.util.List;

public class HistoryFundChangeBean {

    /**
     * Datas : [{"Diagram":["2020-04-20,1.9136,0.8963","2020-04-21,1.8914,-1.1601","2020-04-22,1.9432,2.7387","2020-04-23,1.9489,0.2933","2020-04-24,1.9551,0.3181","2020-04-27,1.9584,0.1688","2020-04-28,1.9937,1.8025","2020-04-29,1.9525,-2.0665","2020-04-30,1.9441,-0.4302","2020-05-06,1.9729,1.4814","2020-05-07,1.9991,1.328","2020-05-08,2.0206,1.0755","2020-05-11,2.0077,-0.6384","2020-05-12,2.0344,1.3299","2020-05-13,2.079,2.1923","2020-05-14,2.0645,-0.6975","2020-05-15,2.0531,-0.5522","2020-05-18,2.102,2.3818","2020-05-19,2.1171,0.7184"],"FCODE":"001632","FSRQ":"2020-05-19","DWJZ":"2.1171","JZZZL":"0.7184"}]
     * ErrCode : 0
     * ErrMsg : null
     * TotalCount : 1
     * Expansion : null
     */

    private int ErrCode;
    private Object ErrMsg;
    private int TotalCount;
    private Object Expansion;
    private List<DatasBean> Datas;

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

    public Object getExpansion() {
        return Expansion;
    }

    public void setExpansion(Object Expansion) {
        this.Expansion = Expansion;
    }

    public List<DatasBean> getDatas() {
        return Datas;
    }

    public void setDatas(List<DatasBean> Datas) {
        this.Datas = Datas;
    }

    public static class DatasBean {
        /**
         * Diagram : ["2020-04-20,1.9136,0.8963","2020-04-21,1.8914,-1.1601","2020-04-22,1.9432,2.7387","2020-04-23,1.9489,0.2933","2020-04-24,1.9551,0.3181","2020-04-27,1.9584,0.1688","2020-04-28,1.9937,1.8025","2020-04-29,1.9525,-2.0665","2020-04-30,1.9441,-0.4302","2020-05-06,1.9729,1.4814","2020-05-07,1.9991,1.328","2020-05-08,2.0206,1.0755","2020-05-11,2.0077,-0.6384","2020-05-12,2.0344,1.3299","2020-05-13,2.079,2.1923","2020-05-14,2.0645,-0.6975","2020-05-15,2.0531,-0.5522","2020-05-18,2.102,2.3818","2020-05-19,2.1171,0.7184"]
         * FCODE : 001632
         * FSRQ : 2020-05-19
         * DWJZ : 2.1171
         * JZZZL : 0.7184
         */

        private String FCODE;
        private String FSRQ;
        private String DWJZ;
        private String JZZZL;
        private List<String> Diagram;

        public String getFCODE() {
            return FCODE;
        }

        public void setFCODE(String FCODE) {
            this.FCODE = FCODE;
        }

        public String getFSRQ() {
            return FSRQ;
        }

        public void setFSRQ(String FSRQ) {
            this.FSRQ = FSRQ;
        }

        public String getDWJZ() {
            return DWJZ;
        }

        public void setDWJZ(String DWJZ) {
            this.DWJZ = DWJZ;
        }

        public String getJZZZL() {
            return JZZZL;
        }

        public void setJZZZL(String JZZZL) {
            this.JZZZL = JZZZL;
        }

        public List<String> getDiagram() {
            return Diagram;
        }

        public void setDiagram(List<String> Diagram) {
            this.Diagram = Diagram;
        }
    }
}

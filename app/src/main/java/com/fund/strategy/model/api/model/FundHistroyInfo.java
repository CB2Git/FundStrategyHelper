package com.fund.strategy.model.api.model;

import java.util.List;

public class FundHistroyInfo {

    /**
     * Datas : [{"FSRQ":"2020-05-07","DWJZ":"0.9584","JZZZL":"-0.0938","LJJZ":"0.9584","NAVTYPE":"1","RATE":"--","MUI":"--","SYI":"--"},{"FSRQ":"2020-05-06","DWJZ":"0.9593","JZZZL":"1.7393","LJJZ":"0.9593","NAVTYPE":"1","RATE":"--","MUI":"--","SYI":"--"}]
     * ErrCode : 0
     * Success : true
     * ErrMsg : null
     * Message : null
     * ErrorCode : 0
     * ErrorMessage : null
     * ErrorMsgLst : null
     * TotalCount : 498
     * Expansion : null
     */

    private int ErrCode;
    private boolean Success;
    private Object ErrMsg;
    private Object Message;
    private String ErrorCode;
    private Object ErrorMessage;
    private Object ErrorMsgLst;
    private int TotalCount;
    private Object Expansion;
    private List<DatasBean> Datas;

    public int getErrCode() {
        return ErrCode;
    }

    public void setErrCode(int ErrCode) {
        this.ErrCode = ErrCode;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public Object getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(Object ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public Object getMessage() {
        return Message;
    }

    public void setMessage(Object Message) {
        this.Message = Message;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public Object getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(Object ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public Object getErrorMsgLst() {
        return ErrorMsgLst;
    }

    public void setErrorMsgLst(Object ErrorMsgLst) {
        this.ErrorMsgLst = ErrorMsgLst;
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
         * FSRQ : 2020-05-07
         * DWJZ : 0.9584
         * JZZZL : -0.0938
         * LJJZ : 0.9584
         * NAVTYPE : 1
         * RATE : --
         * MUI : --
         * SYI : --
         */

        private String FSRQ;
        private String DWJZ;
        private String JZZZL;
        private String LJJZ;
        private String NAVTYPE;
        private String RATE;
        private String MUI;
        private String SYI;

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

        public String getLJJZ() {
            return LJJZ;
        }

        public void setLJJZ(String LJJZ) {
            this.LJJZ = LJJZ;
        }

        public String getNAVTYPE() {
            return NAVTYPE;
        }

        public void setNAVTYPE(String NAVTYPE) {
            this.NAVTYPE = NAVTYPE;
        }

        public String getRATE() {
            return RATE;
        }

        public void setRATE(String RATE) {
            this.RATE = RATE;
        }

        public String getMUI() {
            return MUI;
        }

        public void setMUI(String MUI) {
            this.MUI = MUI;
        }

        public String getSYI() {
            return SYI;
        }

        public void setSYI(String SYI) {
            this.SYI = SYI;
        }
    }
}

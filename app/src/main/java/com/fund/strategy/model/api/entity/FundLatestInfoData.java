package com.fund.strategy.model.api.entity;

import java.util.ArrayList;
import java.util.List;

public class FundLatestInfoData {


    /**
     * Datas : [{"FCODE":"005919","SHORTNAME":"天弘中证500指数C","PDATE":"2020-04-29","NAV":"0.9214","ACCNAV":"0.9214","NAVCHGRT":"0.01","GSZ":"0.9427","GSZZL":"2.31","GZTIME":"2020-04-30 15:00","NEWPRICE":"--","CHANGERATIO":"--","ZJL":"--","HQDATE":"--","ISHAVEREDPACKET":false}]
     * ErrCode : 0
     * Success : true
     * ErrMsg : null
     * Message : null
     * ErrorCode : 0
     * ErrorMessage : null
     * ErrorMsgLst : null
     * TotalCount : 8
     * Expansion : {"GZTIME":"2020-04-30","FSRQ":"2020-04-29"}
     */

    private int ErrCode;
    private boolean Success;
    private Object ErrMsg;
    private Object Message;
    private String ErrorCode;
    private Object ErrorMessage;
    private Object ErrorMsgLst;
    private int TotalCount;
    private ExpansionBean Expansion;
    private List<FundLatestInfo> Datas;

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

    public ExpansionBean getExpansion() {
        return Expansion;
    }

    public void setExpansion(ExpansionBean Expansion) {
        this.Expansion = Expansion;
    }

    public List<FundLatestInfo> getDatas() {
        if (Datas == null) {
            return new ArrayList<>();
        }
        return Datas;
    }

    public void setDatas(List<FundLatestInfo> Datas) {
        this.Datas = Datas;
    }

    public static class ExpansionBean {
        /**
         * GZTIME : 2020-04-30
         * FSRQ : 2020-04-29
         */

        private String GZTIME;
        private String FSRQ;

        public String getGZTIME() {
            return GZTIME;
        }

        public void setGZTIME(String GZTIME) {
            this.GZTIME = GZTIME;
        }

        public String getFSRQ() {
            return FSRQ;
        }

        public void setFSRQ(String FSRQ) {
            this.FSRQ = FSRQ;
        }
    }
}

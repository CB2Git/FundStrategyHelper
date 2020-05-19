package com.fund.strategy.model.api.entity;

import java.util.List;

public class FundInfo2Data {

    /**
     * Datas : [{"FCODE":"290010","ShowFCode":"290010","T":"X","FTYPE":"股票指数","SHORTNAME":"泰信中证200指数","P":"F","HIGHTLIGHT":"290010_泰信<font color='#ff4400'>中<\/font><font color='#ff4400'>证<\/font><font color='#ff4400'>2<\/font>00指数","DEBUGFIELD":null,"SYL":"5.57","SYLTYPE":"近1月","IsDelisting":false,"FCodeType":0,"SecondFCodeType":0,"ABBNAME":"TXZZ200ZS","ABBTNAME":"TAIXINZHONGZHENG200ZHISHU","EsScore":null,"ForeShortName":"泰信中证200指数","NEWTEXCH":null,"OrderISBUY":0,"OrderSYL_Y":""},{"FCODE":"160808","ShowFCode":"160808","T":"X","FTYPE":"股票指数","SHORTNAME":"长盛同瑞中证200分级","P":"F","HIGHTLIGHT":"160808_长盛同瑞<font color='#ff4400'>中<\/font><font color='#ff4400'>证<\/font><font color='#ff4400'>2<\/font>00分级","DEBUGFIELD":null,"SYL":"7.22","SYLTYPE":"近1月","IsDelisting":false,"FCodeType":0,"SecondFCodeType":0,"ABBNAME":"CSTRZZ200FJ","ABBTNAME":"CHANGSHENGTONGRUIZHONGZHENG200FENJI","EsScore":null,"ForeShortName":"长盛同瑞中证200分级","NEWTEXCH":null,"OrderISBUY":0,"OrderSYL_Y":""}]
     * ErrCode : 0
     * Success : true
     * ErrMsg : null
     * Message : null
     * ErrorCode : 0
     * ErrorMessage : null
     * ErrorMsgLst : null
     * TotalCount : 2
     * Expansion : 模糊搜索
     */

    private int ErrCode;
    private boolean Success;
    private Object ErrMsg;
    private Object Message;
    private String ErrorCode;
    private Object ErrorMessage;
    private Object ErrorMsgLst;
    private int TotalCount;
    private String Expansion;
    private List<FundInfo2> Datas;

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

    public String getExpansion() {
        return Expansion;
    }

    public void setExpansion(String Expansion) {
        this.Expansion = Expansion;
    }

    public List<FundInfo2> getDatas() {
        return Datas;
    }

    public void setDatas(List<FundInfo2> Datas) {
        this.Datas = Datas;
    }

    public static class FundInfo2 {
        /**
         * FCODE : 290010
         * ShowFCode : 290010
         * T : X
         * FTYPE : 股票指数
         * SHORTNAME : 泰信中证200指数
         * P : F
         * HIGHTLIGHT : 290010_泰信<font color='#ff4400'>中</font><font color='#ff4400'>证</font><font color='#ff4400'>2</font>00指数
         * DEBUGFIELD : null
         * SYL : 5.57
         * SYLTYPE : 近1月
         * IsDelisting : false
         * FCodeType : 0
         * SecondFCodeType : 0
         * ABBNAME : TXZZ200ZS
         * ABBTNAME : TAIXINZHONGZHENG200ZHISHU
         * EsScore : null
         * ForeShortName : 泰信中证200指数
         * NEWTEXCH : null
         * OrderISBUY : 0
         * OrderSYL_Y :
         */

        private String FCODE;
        private String ShowFCode;
        private String T;
        private String FTYPE;
        private String SHORTNAME;
        private String P;
        private String HIGHTLIGHT;
        private Object DEBUGFIELD;
        private float SYL;
        private String SYLTYPE;
        private boolean IsDelisting;
        private int FCodeType;
        private int SecondFCodeType;
        private String ABBNAME;
        private String ABBTNAME;
        private Object EsScore;
        private String ForeShortName;
        private Object NEWTEXCH;
        private int OrderISBUY;
        private String OrderSYL_Y;

        public String getFCODE() {
            return FCODE;
        }

        public void setFCODE(String FCODE) {
            this.FCODE = FCODE;
        }

        public String getShowFCode() {
            return ShowFCode;
        }

        public void setShowFCode(String ShowFCode) {
            this.ShowFCode = ShowFCode;
        }

        public String getT() {
            return T;
        }

        public void setT(String T) {
            this.T = T;
        }

        public String getFTYPE() {
            return FTYPE;
        }

        public void setFTYPE(String FTYPE) {
            this.FTYPE = FTYPE;
        }

        public String getSHORTNAME() {
            return SHORTNAME;
        }

        public void setSHORTNAME(String SHORTNAME) {
            this.SHORTNAME = SHORTNAME;
        }

        public String getP() {
            return P;
        }

        public void setP(String P) {
            this.P = P;
        }

        public String getHIGHTLIGHT() {
            return HIGHTLIGHT;
        }

        public void setHIGHTLIGHT(String HIGHTLIGHT) {
            this.HIGHTLIGHT = HIGHTLIGHT;
        }

        public Object getDEBUGFIELD() {
            return DEBUGFIELD;
        }

        public void setDEBUGFIELD(Object DEBUGFIELD) {
            this.DEBUGFIELD = DEBUGFIELD;
        }

        public float getSYL() {
            return SYL;
        }

        public void setSYL(float SYL) {
            this.SYL = SYL;
        }

        public String getSYLTYPE() {
            return SYLTYPE;
        }

        public void setSYLTYPE(String SYLTYPE) {
            this.SYLTYPE = SYLTYPE;
        }

        public boolean isIsDelisting() {
            return IsDelisting;
        }

        public void setIsDelisting(boolean IsDelisting) {
            this.IsDelisting = IsDelisting;
        }

        public int getFCodeType() {
            return FCodeType;
        }

        public void setFCodeType(int FCodeType) {
            this.FCodeType = FCodeType;
        }

        public int getSecondFCodeType() {
            return SecondFCodeType;
        }

        public void setSecondFCodeType(int SecondFCodeType) {
            this.SecondFCodeType = SecondFCodeType;
        }

        public String getABBNAME() {
            return ABBNAME;
        }

        public void setABBNAME(String ABBNAME) {
            this.ABBNAME = ABBNAME;
        }

        public String getABBTNAME() {
            return ABBTNAME;
        }

        public void setABBTNAME(String ABBTNAME) {
            this.ABBTNAME = ABBTNAME;
        }

        public Object getEsScore() {
            return EsScore;
        }

        public void setEsScore(Object EsScore) {
            this.EsScore = EsScore;
        }

        public String getForeShortName() {
            return ForeShortName;
        }

        public void setForeShortName(String ForeShortName) {
            this.ForeShortName = ForeShortName;
        }

        public Object getNEWTEXCH() {
            return NEWTEXCH;
        }

        public void setNEWTEXCH(Object NEWTEXCH) {
            this.NEWTEXCH = NEWTEXCH;
        }

        public int getOrderISBUY() {
            return OrderISBUY;
        }

        public void setOrderISBUY(int OrderISBUY) {
            this.OrderISBUY = OrderISBUY;
        }

        public String getOrderSYL_Y() {
            return OrderSYL_Y;
        }

        public void setOrderSYL_Y(String OrderSYL_Y) {
            this.OrderSYL_Y = OrderSYL_Y;
        }
    }
}

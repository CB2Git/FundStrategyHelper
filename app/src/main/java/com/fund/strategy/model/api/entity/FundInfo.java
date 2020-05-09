package com.fund.strategy.model.api.entity;

public class FundInfo {

    /**
     * Datas : {"FCODE":"005919","SHORTNAME":"天弘中证500指数C","FTYPE":"股票指数","FEATURE":"050,051,053,080","BFUNDTYPE":"001","FUNDTYPE":"001","RZDF":"-0.09","DWJZ":"0.9584","LJJZ":"0.9584","SGZT":"开放申购","SHZT":"开放赎回","SOURCERATE":"0.00%","RATE":"0.00%","MINSG":"100","MAXSG":"100000000000","SUBSCRIBETIME":"--","RISKLEVEL":"5","BAGTYPE":"--","CASHBUY":"1","SALETOCASH":"1","STKTOCASH":"1","STKEXCHG":"1","BUY":true,"ISSALES":"1","SALEMARK":"","MINDT":"10","DTZT":"1","REALSGCODE":"--","QDTCODE":"--","BACKCODE":"--","ESTABDATE":"2018-04-24","INDEXCODE":"000905","INDEXNAME":"中证500指数","INDEXTEXCH":"1","NEWINDEXTEXCH":"1","RLEVEL_SZ":"--","SHARP1":"0.0086","MAXRETRA1":"-14.61","STDDEV1":"2.7223","SSBCFMDATA":"1","SSBCFDAY":"2020-05-12","CURRENTDAYMARK":"今日15点后","BUYMARK":"--","JJGS":"天弘基金","JJGSID":"80041198","TSRQ":"--","TTYPENAME":"中证500","TTYPE":"16019b02c4652a48","FSRQ":"2020-05-07","ISSBDATE":"--","ISSEDATE":"--","LISTTEXCH":"--","NEWTEXCH":"--","ISLIST":"0","ISLISTTRADE":"0","MINSBSG":"100","MINSBRG":"100","ENDNAV":"943147949.08","FEGMRQ":"2020-03-31","ISFNEW":"0","ISAPPOINT":"0","MINRG":"100","CYCLE":"--","OPESTART":"--","OPEEND":"--","OPEYIELD":"--","FIXINCOME":"--","APPOINTMENT":"","APPOINTMENTURL":"","ISABNORMAL":"0","YZBA":"7个交易日左右","FBYZQ":"一般3个月内","KFSGSH":"基金公司公告为准","LINKZSB":"1","LISTTEXCHMARK":"--","ISHAREBONUS":false,"FundSubjectURL":"https://appunit.1234567.com.cn/FundTheme/home/detail/T|?isin=ttjj&ref=search","PTDT_Y":"--","PTDT_TWY":"--","PTDT_TRY":"--","PTDT_FY":"--","MBDT_Y":"--","MBDT_TWY":"--","MBDT_TRY":"--","MBDT_FY":"--","YDDT_Y":"--","YDDT_TWY":"--","YDDT_TRY":"--","YDDT_FY":"--","DWDT_Y":"--","DWDT_TWY":"--","DWDT_TRY":"--","DWDT_FY":"--","ISYYDT":"0","SYL_Z":"1.64","SYRQ":"2020-05-07","COMETHOD":"--","MCOVERDATE":"--","MCOVERDETAIL":"--","COMMENTS":"--","TRKERROR":"0.1073","ESTDIFF":"0.0156","HRGRT":"--","HSGRT":"0.00%"}
     * ErrCode : 0
     * Success : true
     * ErrMsg : null
     * Message : null
     * ErrorCode : 0
     * ErrorMessage : null
     * ErrorMsgLst : null
     * TotalCount : 1
     * Expansion : {"INDEXINFO":{"INDEXCODE":"000905","INDEXNAME":"中证500","FULLINDEXNAME":"中证500指数","PDATE":"2020-05-07T16:00:00Z","Q":"3.39","W":"2.87","M":"4.47","HY":"10.41","Y":"11.32","TWY":"-8.84","SY":"4.56","STDDEV_W":"0.9745","STDDEV_M":"1.2089","STDDEV_Q":"1.8902","STDDEV_HY":"1.7594","STDDEV_Y":"1.5266","STDDEV_TWY":"1.6176","STDDEV_SY":"2.032","PETTM":"32.05","PEP100":"58.33","INDEXVALUA":"0","PB":"1.834","PBP100":"16.7742","GXL":"1.18","ROE":"5.7645","PERCENTPRICE":"5507.6965","BKNAME":"中证500","MAKERNAME":"中证指数有限公司","REAPROFILE":"综合反映了沪深证券市场内小市值公司的整体状况，其行业分布广泛均匀，其中不乏医药生物、电子、计算机、传媒、机械设备等新兴产业，具有巨大的长期投资价值。","ISUSEPBP":"0"}}
     */

    private DatasBean Datas;
    private int ErrCode;
    private boolean Success;
    private Object ErrMsg;
    private Object Message;
    private String ErrorCode;
    private Object ErrorMessage;
    private Object ErrorMsgLst;
    private int TotalCount;
    private ExpansionBean Expansion;

    public DatasBean getDatas() {
        return Datas;
    }

    public void setDatas(DatasBean Datas) {
        this.Datas = Datas;
    }

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

    public static class DatasBean {
        /**
         * FCODE : 005919
         * SHORTNAME : 天弘中证500指数C
         * FTYPE : 股票指数
         * FEATURE : 050,051,053,080
         * BFUNDTYPE : 001
         * FUNDTYPE : 001
         * RZDF : -0.09
         * DWJZ : 0.9584
         * LJJZ : 0.9584
         * SGZT : 开放申购
         * SHZT : 开放赎回
         * SOURCERATE : 0.00%
         * RATE : 0.00%
         * MINSG : 100
         * MAXSG : 100000000000
         * SUBSCRIBETIME : --
         * RISKLEVEL : 5
         * BAGTYPE : --
         * CASHBUY : 1
         * SALETOCASH : 1
         * STKTOCASH : 1
         * STKEXCHG : 1
         * BUY : true
         * ISSALES : 1
         * SALEMARK :
         * MINDT : 10
         * DTZT : 1
         * REALSGCODE : --
         * QDTCODE : --
         * BACKCODE : --
         * ESTABDATE : 2018-04-24
         * INDEXCODE : 000905
         * INDEXNAME : 中证500指数
         * INDEXTEXCH : 1
         * NEWINDEXTEXCH : 1
         * RLEVEL_SZ : --
         * SHARP1 : 0.0086
         * MAXRETRA1 : -14.61
         * STDDEV1 : 2.7223
         * SSBCFMDATA : 1
         * SSBCFDAY : 2020-05-12
         * CURRENTDAYMARK : 今日15点后
         * BUYMARK : --
         * JJGS : 天弘基金
         * JJGSID : 80041198
         * TSRQ : --
         * TTYPENAME : 中证500
         * TTYPE : 16019b02c4652a48
         * FSRQ : 2020-05-07
         * ISSBDATE : --
         * ISSEDATE : --
         * LISTTEXCH : --
         * NEWTEXCH : --
         * ISLIST : 0
         * ISLISTTRADE : 0
         * MINSBSG : 100
         * MINSBRG : 100
         * ENDNAV : 943147949.08
         * FEGMRQ : 2020-03-31
         * ISFNEW : 0
         * ISAPPOINT : 0
         * MINRG : 100
         * CYCLE : --
         * OPESTART : --
         * OPEEND : --
         * OPEYIELD : --
         * FIXINCOME : --
         * APPOINTMENT :
         * APPOINTMENTURL :
         * ISABNORMAL : 0
         * YZBA : 7个交易日左右
         * FBYZQ : 一般3个月内
         * KFSGSH : 基金公司公告为准
         * LINKZSB : 1
         * LISTTEXCHMARK : --
         * ISHAREBONUS : false
         * FundSubjectURL : https://appunit.1234567.com.cn/FundTheme/home/detail/T|?isin=ttjj&ref=search
         * PTDT_Y : --
         * PTDT_TWY : --
         * PTDT_TRY : --
         * PTDT_FY : --
         * MBDT_Y : --
         * MBDT_TWY : --
         * MBDT_TRY : --
         * MBDT_FY : --
         * YDDT_Y : --
         * YDDT_TWY : --
         * YDDT_TRY : --
         * YDDT_FY : --
         * DWDT_Y : --
         * DWDT_TWY : --
         * DWDT_TRY : --
         * DWDT_FY : --
         * ISYYDT : 0
         * SYL_Z : 1.64
         * SYRQ : 2020-05-07
         * COMETHOD : --
         * MCOVERDATE : --
         * MCOVERDETAIL : --
         * COMMENTS : --
         * TRKERROR : 0.1073
         * ESTDIFF : 0.0156
         * HRGRT : --
         * HSGRT : 0.00%
         */

        private String FCODE;
        private String SHORTNAME;
        private String FTYPE;
        private String FEATURE;
        private String BFUNDTYPE;
        private String FUNDTYPE;
        private String RZDF;
        private String DWJZ;
        private String LJJZ;
        private String SGZT;
        private String SHZT;
        private String SOURCERATE;
        private String RATE;
        private String MINSG;
        private String MAXSG;
        private String SUBSCRIBETIME;
        private String RISKLEVEL;
        private String BAGTYPE;
        private String CASHBUY;
        private String SALETOCASH;
        private String STKTOCASH;
        private String STKEXCHG;
        private boolean BUY;
        private String ISSALES;
        private String SALEMARK;
        private String MINDT;
        private String DTZT;
        private String REALSGCODE;
        private String QDTCODE;
        private String BACKCODE;
        private String ESTABDATE;
        private String INDEXCODE;
        private String INDEXNAME;
        private String INDEXTEXCH;
        private String NEWINDEXTEXCH;
        private String RLEVEL_SZ;
        private String SHARP1;
        private String MAXRETRA1;
        private String STDDEV1;
        private String SSBCFMDATA;
        private String SSBCFDAY;
        private String CURRENTDAYMARK;
        private String BUYMARK;
        private String JJGS;
        private String JJGSID;
        private String TSRQ;
        private String TTYPENAME;
        private String TTYPE;
        private String FSRQ;
        private String ISSBDATE;
        private String ISSEDATE;
        private String LISTTEXCH;
        private String NEWTEXCH;
        private String ISLIST;
        private String ISLISTTRADE;
        private String MINSBSG;
        private String MINSBRG;
        private String ENDNAV;
        private String FEGMRQ;
        private String ISFNEW;
        private String ISAPPOINT;
        private String MINRG;
        private String CYCLE;
        private String OPESTART;
        private String OPEEND;
        private String OPEYIELD;
        private String FIXINCOME;
        private String APPOINTMENT;
        private String APPOINTMENTURL;
        private String ISABNORMAL;
        private String YZBA;
        private String FBYZQ;
        private String KFSGSH;
        private String LINKZSB;
        private String LISTTEXCHMARK;
        private boolean ISHAREBONUS;
        private String FundSubjectURL;
        private String PTDT_Y;
        private String PTDT_TWY;
        private String PTDT_TRY;
        private String PTDT_FY;
        private String MBDT_Y;
        private String MBDT_TWY;
        private String MBDT_TRY;
        private String MBDT_FY;
        private String YDDT_Y;
        private String YDDT_TWY;
        private String YDDT_TRY;
        private String YDDT_FY;
        private String DWDT_Y;
        private String DWDT_TWY;
        private String DWDT_TRY;
        private String DWDT_FY;
        private String ISYYDT;
        private String SYL_Z;
        private String SYRQ;
        private String COMETHOD;
        private String MCOVERDATE;
        private String MCOVERDETAIL;
        private String COMMENTS;
        private String TRKERROR;
        private String ESTDIFF;
        private String HRGRT;
        private String HSGRT;

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

        public String getFTYPE() {
            return FTYPE;
        }

        public void setFTYPE(String FTYPE) {
            this.FTYPE = FTYPE;
        }

        public String getFEATURE() {
            return FEATURE;
        }

        public void setFEATURE(String FEATURE) {
            this.FEATURE = FEATURE;
        }

        public String getBFUNDTYPE() {
            return BFUNDTYPE;
        }

        public void setBFUNDTYPE(String BFUNDTYPE) {
            this.BFUNDTYPE = BFUNDTYPE;
        }

        public String getFUNDTYPE() {
            return FUNDTYPE;
        }

        public void setFUNDTYPE(String FUNDTYPE) {
            this.FUNDTYPE = FUNDTYPE;
        }

        public String getRZDF() {
            return RZDF;
        }

        public void setRZDF(String RZDF) {
            this.RZDF = RZDF;
        }

        public String getDWJZ() {
            return DWJZ;
        }

        public void setDWJZ(String DWJZ) {
            this.DWJZ = DWJZ;
        }

        public String getLJJZ() {
            return LJJZ;
        }

        public void setLJJZ(String LJJZ) {
            this.LJJZ = LJJZ;
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

        public String getRATE() {
            return RATE;
        }

        public void setRATE(String RATE) {
            this.RATE = RATE;
        }

        public String getMINSG() {
            return MINSG;
        }

        public void setMINSG(String MINSG) {
            this.MINSG = MINSG;
        }

        public String getMAXSG() {
            return MAXSG;
        }

        public void setMAXSG(String MAXSG) {
            this.MAXSG = MAXSG;
        }

        public String getSUBSCRIBETIME() {
            return SUBSCRIBETIME;
        }

        public void setSUBSCRIBETIME(String SUBSCRIBETIME) {
            this.SUBSCRIBETIME = SUBSCRIBETIME;
        }

        public String getRISKLEVEL() {
            return RISKLEVEL;
        }

        public void setRISKLEVEL(String RISKLEVEL) {
            this.RISKLEVEL = RISKLEVEL;
        }

        public String getBAGTYPE() {
            return BAGTYPE;
        }

        public void setBAGTYPE(String BAGTYPE) {
            this.BAGTYPE = BAGTYPE;
        }

        public String getCASHBUY() {
            return CASHBUY;
        }

        public void setCASHBUY(String CASHBUY) {
            this.CASHBUY = CASHBUY;
        }

        public String getSALETOCASH() {
            return SALETOCASH;
        }

        public void setSALETOCASH(String SALETOCASH) {
            this.SALETOCASH = SALETOCASH;
        }

        public String getSTKTOCASH() {
            return STKTOCASH;
        }

        public void setSTKTOCASH(String STKTOCASH) {
            this.STKTOCASH = STKTOCASH;
        }

        public String getSTKEXCHG() {
            return STKEXCHG;
        }

        public void setSTKEXCHG(String STKEXCHG) {
            this.STKEXCHG = STKEXCHG;
        }

        public boolean isBUY() {
            return BUY;
        }

        public void setBUY(boolean BUY) {
            this.BUY = BUY;
        }

        public String getISSALES() {
            return ISSALES;
        }

        public void setISSALES(String ISSALES) {
            this.ISSALES = ISSALES;
        }

        public String getSALEMARK() {
            return SALEMARK;
        }

        public void setSALEMARK(String SALEMARK) {
            this.SALEMARK = SALEMARK;
        }

        public String getMINDT() {
            return MINDT;
        }

        public void setMINDT(String MINDT) {
            this.MINDT = MINDT;
        }

        public String getDTZT() {
            return DTZT;
        }

        public void setDTZT(String DTZT) {
            this.DTZT = DTZT;
        }

        public String getREALSGCODE() {
            return REALSGCODE;
        }

        public void setREALSGCODE(String REALSGCODE) {
            this.REALSGCODE = REALSGCODE;
        }

        public String getQDTCODE() {
            return QDTCODE;
        }

        public void setQDTCODE(String QDTCODE) {
            this.QDTCODE = QDTCODE;
        }

        public String getBACKCODE() {
            return BACKCODE;
        }

        public void setBACKCODE(String BACKCODE) {
            this.BACKCODE = BACKCODE;
        }

        public String getESTABDATE() {
            return ESTABDATE;
        }

        public void setESTABDATE(String ESTABDATE) {
            this.ESTABDATE = ESTABDATE;
        }

        public String getINDEXCODE() {
            return INDEXCODE;
        }

        public void setINDEXCODE(String INDEXCODE) {
            this.INDEXCODE = INDEXCODE;
        }

        public String getINDEXNAME() {
            return INDEXNAME;
        }

        public void setINDEXNAME(String INDEXNAME) {
            this.INDEXNAME = INDEXNAME;
        }

        public String getINDEXTEXCH() {
            return INDEXTEXCH;
        }

        public void setINDEXTEXCH(String INDEXTEXCH) {
            this.INDEXTEXCH = INDEXTEXCH;
        }

        public String getNEWINDEXTEXCH() {
            return NEWINDEXTEXCH;
        }

        public void setNEWINDEXTEXCH(String NEWINDEXTEXCH) {
            this.NEWINDEXTEXCH = NEWINDEXTEXCH;
        }

        public String getRLEVEL_SZ() {
            return RLEVEL_SZ;
        }

        public void setRLEVEL_SZ(String RLEVEL_SZ) {
            this.RLEVEL_SZ = RLEVEL_SZ;
        }

        public String getSHARP1() {
            return SHARP1;
        }

        public void setSHARP1(String SHARP1) {
            this.SHARP1 = SHARP1;
        }

        public String getMAXRETRA1() {
            return MAXRETRA1;
        }

        public void setMAXRETRA1(String MAXRETRA1) {
            this.MAXRETRA1 = MAXRETRA1;
        }

        public String getSTDDEV1() {
            return STDDEV1;
        }

        public void setSTDDEV1(String STDDEV1) {
            this.STDDEV1 = STDDEV1;
        }

        public String getSSBCFMDATA() {
            return SSBCFMDATA;
        }

        public void setSSBCFMDATA(String SSBCFMDATA) {
            this.SSBCFMDATA = SSBCFMDATA;
        }

        public String getSSBCFDAY() {
            return SSBCFDAY;
        }

        public void setSSBCFDAY(String SSBCFDAY) {
            this.SSBCFDAY = SSBCFDAY;
        }

        public String getCURRENTDAYMARK() {
            return CURRENTDAYMARK;
        }

        public void setCURRENTDAYMARK(String CURRENTDAYMARK) {
            this.CURRENTDAYMARK = CURRENTDAYMARK;
        }

        public String getBUYMARK() {
            return BUYMARK;
        }

        public void setBUYMARK(String BUYMARK) {
            this.BUYMARK = BUYMARK;
        }

        public String getJJGS() {
            return JJGS;
        }

        public void setJJGS(String JJGS) {
            this.JJGS = JJGS;
        }

        public String getJJGSID() {
            return JJGSID;
        }

        public void setJJGSID(String JJGSID) {
            this.JJGSID = JJGSID;
        }

        public String getTSRQ() {
            return TSRQ;
        }

        public void setTSRQ(String TSRQ) {
            this.TSRQ = TSRQ;
        }

        public String getTTYPENAME() {
            return TTYPENAME;
        }

        public void setTTYPENAME(String TTYPENAME) {
            this.TTYPENAME = TTYPENAME;
        }

        public String getTTYPE() {
            return TTYPE;
        }

        public void setTTYPE(String TTYPE) {
            this.TTYPE = TTYPE;
        }

        public String getFSRQ() {
            return FSRQ;
        }

        public void setFSRQ(String FSRQ) {
            this.FSRQ = FSRQ;
        }

        public String getISSBDATE() {
            return ISSBDATE;
        }

        public void setISSBDATE(String ISSBDATE) {
            this.ISSBDATE = ISSBDATE;
        }

        public String getISSEDATE() {
            return ISSEDATE;
        }

        public void setISSEDATE(String ISSEDATE) {
            this.ISSEDATE = ISSEDATE;
        }

        public String getLISTTEXCH() {
            return LISTTEXCH;
        }

        public void setLISTTEXCH(String LISTTEXCH) {
            this.LISTTEXCH = LISTTEXCH;
        }

        public String getNEWTEXCH() {
            return NEWTEXCH;
        }

        public void setNEWTEXCH(String NEWTEXCH) {
            this.NEWTEXCH = NEWTEXCH;
        }

        public String getISLIST() {
            return ISLIST;
        }

        public void setISLIST(String ISLIST) {
            this.ISLIST = ISLIST;
        }

        public String getISLISTTRADE() {
            return ISLISTTRADE;
        }

        public void setISLISTTRADE(String ISLISTTRADE) {
            this.ISLISTTRADE = ISLISTTRADE;
        }

        public String getMINSBSG() {
            return MINSBSG;
        }

        public void setMINSBSG(String MINSBSG) {
            this.MINSBSG = MINSBSG;
        }

        public String getMINSBRG() {
            return MINSBRG;
        }

        public void setMINSBRG(String MINSBRG) {
            this.MINSBRG = MINSBRG;
        }

        public String getENDNAV() {
            return ENDNAV;
        }

        public void setENDNAV(String ENDNAV) {
            this.ENDNAV = ENDNAV;
        }

        public String getFEGMRQ() {
            return FEGMRQ;
        }

        public void setFEGMRQ(String FEGMRQ) {
            this.FEGMRQ = FEGMRQ;
        }

        public String getISFNEW() {
            return ISFNEW;
        }

        public void setISFNEW(String ISFNEW) {
            this.ISFNEW = ISFNEW;
        }

        public String getISAPPOINT() {
            return ISAPPOINT;
        }

        public void setISAPPOINT(String ISAPPOINT) {
            this.ISAPPOINT = ISAPPOINT;
        }

        public String getMINRG() {
            return MINRG;
        }

        public void setMINRG(String MINRG) {
            this.MINRG = MINRG;
        }

        public String getCYCLE() {
            return CYCLE;
        }

        public void setCYCLE(String CYCLE) {
            this.CYCLE = CYCLE;
        }

        public String getOPESTART() {
            return OPESTART;
        }

        public void setOPESTART(String OPESTART) {
            this.OPESTART = OPESTART;
        }

        public String getOPEEND() {
            return OPEEND;
        }

        public void setOPEEND(String OPEEND) {
            this.OPEEND = OPEEND;
        }

        public String getOPEYIELD() {
            return OPEYIELD;
        }

        public void setOPEYIELD(String OPEYIELD) {
            this.OPEYIELD = OPEYIELD;
        }

        public String getFIXINCOME() {
            return FIXINCOME;
        }

        public void setFIXINCOME(String FIXINCOME) {
            this.FIXINCOME = FIXINCOME;
        }

        public String getAPPOINTMENT() {
            return APPOINTMENT;
        }

        public void setAPPOINTMENT(String APPOINTMENT) {
            this.APPOINTMENT = APPOINTMENT;
        }

        public String getAPPOINTMENTURL() {
            return APPOINTMENTURL;
        }

        public void setAPPOINTMENTURL(String APPOINTMENTURL) {
            this.APPOINTMENTURL = APPOINTMENTURL;
        }

        public String getISABNORMAL() {
            return ISABNORMAL;
        }

        public void setISABNORMAL(String ISABNORMAL) {
            this.ISABNORMAL = ISABNORMAL;
        }

        public String getYZBA() {
            return YZBA;
        }

        public void setYZBA(String YZBA) {
            this.YZBA = YZBA;
        }

        public String getFBYZQ() {
            return FBYZQ;
        }

        public void setFBYZQ(String FBYZQ) {
            this.FBYZQ = FBYZQ;
        }

        public String getKFSGSH() {
            return KFSGSH;
        }

        public void setKFSGSH(String KFSGSH) {
            this.KFSGSH = KFSGSH;
        }

        public String getLINKZSB() {
            return LINKZSB;
        }

        public void setLINKZSB(String LINKZSB) {
            this.LINKZSB = LINKZSB;
        }

        public String getLISTTEXCHMARK() {
            return LISTTEXCHMARK;
        }

        public void setLISTTEXCHMARK(String LISTTEXCHMARK) {
            this.LISTTEXCHMARK = LISTTEXCHMARK;
        }

        public boolean isISHAREBONUS() {
            return ISHAREBONUS;
        }

        public void setISHAREBONUS(boolean ISHAREBONUS) {
            this.ISHAREBONUS = ISHAREBONUS;
        }

        public String getFundSubjectURL() {
            return FundSubjectURL;
        }

        public void setFundSubjectURL(String FundSubjectURL) {
            this.FundSubjectURL = FundSubjectURL;
        }

        public String getPTDT_Y() {
            return PTDT_Y;
        }

        public void setPTDT_Y(String PTDT_Y) {
            this.PTDT_Y = PTDT_Y;
        }

        public String getPTDT_TWY() {
            return PTDT_TWY;
        }

        public void setPTDT_TWY(String PTDT_TWY) {
            this.PTDT_TWY = PTDT_TWY;
        }

        public String getPTDT_TRY() {
            return PTDT_TRY;
        }

        public void setPTDT_TRY(String PTDT_TRY) {
            this.PTDT_TRY = PTDT_TRY;
        }

        public String getPTDT_FY() {
            return PTDT_FY;
        }

        public void setPTDT_FY(String PTDT_FY) {
            this.PTDT_FY = PTDT_FY;
        }

        public String getMBDT_Y() {
            return MBDT_Y;
        }

        public void setMBDT_Y(String MBDT_Y) {
            this.MBDT_Y = MBDT_Y;
        }

        public String getMBDT_TWY() {
            return MBDT_TWY;
        }

        public void setMBDT_TWY(String MBDT_TWY) {
            this.MBDT_TWY = MBDT_TWY;
        }

        public String getMBDT_TRY() {
            return MBDT_TRY;
        }

        public void setMBDT_TRY(String MBDT_TRY) {
            this.MBDT_TRY = MBDT_TRY;
        }

        public String getMBDT_FY() {
            return MBDT_FY;
        }

        public void setMBDT_FY(String MBDT_FY) {
            this.MBDT_FY = MBDT_FY;
        }

        public String getYDDT_Y() {
            return YDDT_Y;
        }

        public void setYDDT_Y(String YDDT_Y) {
            this.YDDT_Y = YDDT_Y;
        }

        public String getYDDT_TWY() {
            return YDDT_TWY;
        }

        public void setYDDT_TWY(String YDDT_TWY) {
            this.YDDT_TWY = YDDT_TWY;
        }

        public String getYDDT_TRY() {
            return YDDT_TRY;
        }

        public void setYDDT_TRY(String YDDT_TRY) {
            this.YDDT_TRY = YDDT_TRY;
        }

        public String getYDDT_FY() {
            return YDDT_FY;
        }

        public void setYDDT_FY(String YDDT_FY) {
            this.YDDT_FY = YDDT_FY;
        }

        public String getDWDT_Y() {
            return DWDT_Y;
        }

        public void setDWDT_Y(String DWDT_Y) {
            this.DWDT_Y = DWDT_Y;
        }

        public String getDWDT_TWY() {
            return DWDT_TWY;
        }

        public void setDWDT_TWY(String DWDT_TWY) {
            this.DWDT_TWY = DWDT_TWY;
        }

        public String getDWDT_TRY() {
            return DWDT_TRY;
        }

        public void setDWDT_TRY(String DWDT_TRY) {
            this.DWDT_TRY = DWDT_TRY;
        }

        public String getDWDT_FY() {
            return DWDT_FY;
        }

        public void setDWDT_FY(String DWDT_FY) {
            this.DWDT_FY = DWDT_FY;
        }

        public String getISYYDT() {
            return ISYYDT;
        }

        public void setISYYDT(String ISYYDT) {
            this.ISYYDT = ISYYDT;
        }

        public String getSYL_Z() {
            return SYL_Z;
        }

        public void setSYL_Z(String SYL_Z) {
            this.SYL_Z = SYL_Z;
        }

        public String getSYRQ() {
            return SYRQ;
        }

        public void setSYRQ(String SYRQ) {
            this.SYRQ = SYRQ;
        }

        public String getCOMETHOD() {
            return COMETHOD;
        }

        public void setCOMETHOD(String COMETHOD) {
            this.COMETHOD = COMETHOD;
        }

        public String getMCOVERDATE() {
            return MCOVERDATE;
        }

        public void setMCOVERDATE(String MCOVERDATE) {
            this.MCOVERDATE = MCOVERDATE;
        }

        public String getMCOVERDETAIL() {
            return MCOVERDETAIL;
        }

        public void setMCOVERDETAIL(String MCOVERDETAIL) {
            this.MCOVERDETAIL = MCOVERDETAIL;
        }

        public String getCOMMENTS() {
            return COMMENTS;
        }

        public void setCOMMENTS(String COMMENTS) {
            this.COMMENTS = COMMENTS;
        }

        public String getTRKERROR() {
            return TRKERROR;
        }

        public void setTRKERROR(String TRKERROR) {
            this.TRKERROR = TRKERROR;
        }

        public String getESTDIFF() {
            return ESTDIFF;
        }

        public void setESTDIFF(String ESTDIFF) {
            this.ESTDIFF = ESTDIFF;
        }

        public String getHRGRT() {
            return HRGRT;
        }

        public void setHRGRT(String HRGRT) {
            this.HRGRT = HRGRT;
        }

        public String getHSGRT() {
            return HSGRT;
        }

        public void setHSGRT(String HSGRT) {
            this.HSGRT = HSGRT;
        }
    }

    public static class ExpansionBean {
        /**
         * INDEXINFO : {"INDEXCODE":"000905","INDEXNAME":"中证500","FULLINDEXNAME":"中证500指数","PDATE":"2020-05-07T16:00:00Z","Q":"3.39","W":"2.87","M":"4.47","HY":"10.41","Y":"11.32","TWY":"-8.84","SY":"4.56","STDDEV_W":"0.9745","STDDEV_M":"1.2089","STDDEV_Q":"1.8902","STDDEV_HY":"1.7594","STDDEV_Y":"1.5266","STDDEV_TWY":"1.6176","STDDEV_SY":"2.032","PETTM":"32.05","PEP100":"58.33","INDEXVALUA":"0","PB":"1.834","PBP100":"16.7742","GXL":"1.18","ROE":"5.7645","PERCENTPRICE":"5507.6965","BKNAME":"中证500","MAKERNAME":"中证指数有限公司","REAPROFILE":"综合反映了沪深证券市场内小市值公司的整体状况，其行业分布广泛均匀，其中不乏医药生物、电子、计算机、传媒、机械设备等新兴产业，具有巨大的长期投资价值。","ISUSEPBP":"0"}
         */

        private INDEXINFOBean INDEXINFO;

        public INDEXINFOBean getINDEXINFO() {
            return INDEXINFO;
        }

        public void setINDEXINFO(INDEXINFOBean INDEXINFO) {
            this.INDEXINFO = INDEXINFO;
        }

        public static class INDEXINFOBean {
            /**
             * INDEXCODE : 000905
             * INDEXNAME : 中证500
             * FULLINDEXNAME : 中证500指数
             * PDATE : 2020-05-07T16:00:00Z
             * Q : 3.39
             * W : 2.87
             * M : 4.47
             * HY : 10.41
             * Y : 11.32
             * TWY : -8.84
             * SY : 4.56
             * STDDEV_W : 0.9745
             * STDDEV_M : 1.2089
             * STDDEV_Q : 1.8902
             * STDDEV_HY : 1.7594
             * STDDEV_Y : 1.5266
             * STDDEV_TWY : 1.6176
             * STDDEV_SY : 2.032
             * PETTM : 32.05
             * PEP100 : 58.33
             * INDEXVALUA : 0
             * PB : 1.834
             * PBP100 : 16.7742
             * GXL : 1.18
             * ROE : 5.7645
             * PERCENTPRICE : 5507.6965
             * BKNAME : 中证500
             * MAKERNAME : 中证指数有限公司
             * REAPROFILE : 综合反映了沪深证券市场内小市值公司的整体状况，其行业分布广泛均匀，其中不乏医药生物、电子、计算机、传媒、机械设备等新兴产业，具有巨大的长期投资价值。
             * ISUSEPBP : 0
             */

            private String INDEXCODE;
            private String INDEXNAME;
            private String FULLINDEXNAME;
            private String PDATE;
            private String Q;
            private String W;
            private String M;
            private String HY;
            private String Y;
            private String TWY;
            private String SY;
            private String STDDEV_W;
            private String STDDEV_M;
            private String STDDEV_Q;
            private String STDDEV_HY;
            private String STDDEV_Y;
            private String STDDEV_TWY;
            private String STDDEV_SY;
            private String PETTM;
            private String PEP100;
            private String INDEXVALUA;
            private String PB;
            private String PBP100;
            private String GXL;
            private String ROE;
            private String PERCENTPRICE;
            private String BKNAME;
            private String MAKERNAME;
            private String REAPROFILE;
            private String ISUSEPBP;

            public String getINDEXCODE() {
                return INDEXCODE;
            }

            public void setINDEXCODE(String INDEXCODE) {
                this.INDEXCODE = INDEXCODE;
            }

            public String getINDEXNAME() {
                return INDEXNAME;
            }

            public void setINDEXNAME(String INDEXNAME) {
                this.INDEXNAME = INDEXNAME;
            }

            public String getFULLINDEXNAME() {
                return FULLINDEXNAME;
            }

            public void setFULLINDEXNAME(String FULLINDEXNAME) {
                this.FULLINDEXNAME = FULLINDEXNAME;
            }

            public String getPDATE() {
                return PDATE;
            }

            public void setPDATE(String PDATE) {
                this.PDATE = PDATE;
            }

            public String getQ() {
                return Q;
            }

            public void setQ(String Q) {
                this.Q = Q;
            }

            public String getW() {
                return W;
            }

            public void setW(String W) {
                this.W = W;
            }

            public String getM() {
                return M;
            }

            public void setM(String M) {
                this.M = M;
            }

            public String getHY() {
                return HY;
            }

            public void setHY(String HY) {
                this.HY = HY;
            }

            public String getY() {
                return Y;
            }

            public void setY(String Y) {
                this.Y = Y;
            }

            public String getTWY() {
                return TWY;
            }

            public void setTWY(String TWY) {
                this.TWY = TWY;
            }

            public String getSY() {
                return SY;
            }

            public void setSY(String SY) {
                this.SY = SY;
            }

            public String getSTDDEV_W() {
                return STDDEV_W;
            }

            public void setSTDDEV_W(String STDDEV_W) {
                this.STDDEV_W = STDDEV_W;
            }

            public String getSTDDEV_M() {
                return STDDEV_M;
            }

            public void setSTDDEV_M(String STDDEV_M) {
                this.STDDEV_M = STDDEV_M;
            }

            public String getSTDDEV_Q() {
                return STDDEV_Q;
            }

            public void setSTDDEV_Q(String STDDEV_Q) {
                this.STDDEV_Q = STDDEV_Q;
            }

            public String getSTDDEV_HY() {
                return STDDEV_HY;
            }

            public void setSTDDEV_HY(String STDDEV_HY) {
                this.STDDEV_HY = STDDEV_HY;
            }

            public String getSTDDEV_Y() {
                return STDDEV_Y;
            }

            public void setSTDDEV_Y(String STDDEV_Y) {
                this.STDDEV_Y = STDDEV_Y;
            }

            public String getSTDDEV_TWY() {
                return STDDEV_TWY;
            }

            public void setSTDDEV_TWY(String STDDEV_TWY) {
                this.STDDEV_TWY = STDDEV_TWY;
            }

            public String getSTDDEV_SY() {
                return STDDEV_SY;
            }

            public void setSTDDEV_SY(String STDDEV_SY) {
                this.STDDEV_SY = STDDEV_SY;
            }

            public String getPETTM() {
                return PETTM;
            }

            public void setPETTM(String PETTM) {
                this.PETTM = PETTM;
            }

            public String getPEP100() {
                return PEP100;
            }

            public void setPEP100(String PEP100) {
                this.PEP100 = PEP100;
            }

            public String getINDEXVALUA() {
                return INDEXVALUA;
            }

            public void setINDEXVALUA(String INDEXVALUA) {
                this.INDEXVALUA = INDEXVALUA;
            }

            public String getPB() {
                return PB;
            }

            public void setPB(String PB) {
                this.PB = PB;
            }

            public String getPBP100() {
                return PBP100;
            }

            public void setPBP100(String PBP100) {
                this.PBP100 = PBP100;
            }

            public String getGXL() {
                return GXL;
            }

            public void setGXL(String GXL) {
                this.GXL = GXL;
            }

            public String getROE() {
                return ROE;
            }

            public void setROE(String ROE) {
                this.ROE = ROE;
            }

            public String getPERCENTPRICE() {
                return PERCENTPRICE;
            }

            public void setPERCENTPRICE(String PERCENTPRICE) {
                this.PERCENTPRICE = PERCENTPRICE;
            }

            public String getBKNAME() {
                return BKNAME;
            }

            public void setBKNAME(String BKNAME) {
                this.BKNAME = BKNAME;
            }

            public String getMAKERNAME() {
                return MAKERNAME;
            }

            public void setMAKERNAME(String MAKERNAME) {
                this.MAKERNAME = MAKERNAME;
            }

            public String getREAPROFILE() {
                return REAPROFILE;
            }

            public void setREAPROFILE(String REAPROFILE) {
                this.REAPROFILE = REAPROFILE;
            }

            public String getISUSEPBP() {
                return ISUSEPBP;
            }

            public void setISUSEPBP(String ISUSEPBP) {
                this.ISUSEPBP = ISUSEPBP;
            }
        }
    }
}

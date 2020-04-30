# 基金接口

标签（空格分隔）： 个人项目

---

#### 数据接口

> 数据来源 蛋卷基金&天天基金

- 获取基金净值

地址:https://fundmobapi.eastmoney.com/FundMNewApi/FundMNFInfo

请求方式:POST

参数列表
| 参数名  | 参数类型  |默认值|
| ------------ | ------------ |--|
|  plat |  String |Android|
| deviceid  |  String ||
| product  |  String |EFund|
| Version  |  String |6.2.4|
| Fcodes  |  String |基金编码,多个使用,隔开|
|appType|String|ttjj|

返回值

``` json
{
    "Datas": [
        {
            "FCODE": "005919",
            "SHORTNAME": "天弘中证500指数C",
            "PDATE": "2020-04-29",
            "NAV": "0.9214",
            "ACCNAV": "0.9214",
            "NAVCHGRT": "0.01",
            "GSZ": "0.9427",
            "GSZZL": "2.31",
            "GZTIME": "2020-04-30 15:00",
            "NEWPRICE": "--",
            "CHANGERATIO": "--",
            "ZJL": "--",
            "HQDATE": "--",
            "ISHAVEREDPACKET": false
        }
    ],
    "ErrCode": 0,
    "Success": true,
    "ErrMsg": null,
    "Message": null,
    "ErrorCode": "0",
    "ErrorMessage": null,
    "ErrorMsgLst": null,
    "TotalCount": 8,
    "Expansion": {
        "GZTIME": "2020-04-30",
        "FSRQ": "2020-04-29"
    }
}
```

返回值含义
|字段名|含义|
|-|-|
|PDATE|最新的净值日期|
|NAV|最新净值|
|NAVCHGRT|最新的净值涨了多少|
|GSZ|估值|
|GSZZL|估值涨了多少|
|GZTIME|估值的日期|



- 获取基金历史净值

地址:https://fundmobapi.eastmoney.com/FundMNewApi/FundMNHisNetList

请求方式:POST

参数列表
| 参数名  | 参数类型  |默认值|
| ------------ | ------------ |--|
|FCODE|String|基金编码|
|pageSize|int|数据一页多少个|
|deviceid|String|设备id|
|version|String|版本名|
|pageIndex|int|页码 从1开始|
|plat|String|Android|

返回值

```
{
    "Datas": [
        {
            "FSRQ": "2020-04-29",
            "DWJZ": "0.9214",
            "JZZZL": "0.0109",
            "LJJZ": "0.9214",
            "NAVTYPE": "1",
            "RATE": "--",
            "MUI": "--",
            "SYI": "--"
        }
    ],
    "ErrCode": 0,
    "Success": true,
    "ErrMsg": null,
    "Message": null,
    "ErrorCode": "0",
    "ErrorMessage": null,
    "ErrorMsgLst": null,
    "TotalCount": 495,
    "Expansion": null
}
```

||||
|-|-|
|FSRQ|净值日期|
|DWJZ|单位净值|
|LJJZ|累计净值|
|JZZZL|日增长率|

- 查询基金基本信息

地址:https://fundmobapi.eastmoney.com/FundMNewApi/FundMNNBasicInformation

请求方式:POST

参数列表:version=6.2.4&plat=Android&appType=ttjj&FCODE=005919&onFundCache=3&keeeeeyparam=FCODE&deviceid=656c09923c567b89bb44801020bc59ab%7C%7Ciemi_tluafed_me&igggggnoreburst=true&product=EFund&MobileKey=656c09923c567b89bb44801020bc59ab%7C%7Ciemi_tluafed_me


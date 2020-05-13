package com.fund.strategy.model.api;

import com.fund.strategy.model.api.entity.FundHistroyInfo;
import com.fund.strategy.model.api.entity.FundInfo;
import com.fund.strategy.model.api.entity.FundInfo2;
import com.fund.strategy.model.api.entity.FundLatestInfoData;
import com.fund.strategy.model.api.entity.HangQingInfoData;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    /**
     * 查询基金最新的净值
     *
     * @param fcodes
     * @return
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNFInfo")
    Single<FundLatestInfoData> queryFundLastestInfo(@Field("Fcodes") String fcodes);

    /**
     * 查询基金信息
     *
     * @param code
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNNBasicInformation")
    Single<FundInfo> queryFundInfo(@Field("FCODE") String code);

    @GET("FundMSearchApi/FundSearchNewFunds")
    @Headers({"url:https://appsuggest.1234567.com.cn/"})
    Single<FundInfo2> searchFunds(@Query("KEY") String key);

    /**
     * 查询基金历史净值信息
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNHisNetList")
    Single<FundHistroyInfo> queryHistroyInfo(@Field("FCODE") String code, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    /**
     * @param category 主要指数 zyzs  行业指数  hyzs
     * @return
     */
    @GET("djapi/v3/index/quotes")
    @Headers({"url:https://danjuanfunds.com/"})
    Single<HangQingInfoData> hangQingInfo(@Query("category") String category);
}

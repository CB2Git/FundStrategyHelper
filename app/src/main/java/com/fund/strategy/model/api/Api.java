package com.fund.strategy.model.api;

import com.fund.strategy.model.api.model.FundHistroyInfo;
import com.fund.strategy.model.api.model.FundInfo;
import com.fund.strategy.model.api.model.FundLatestInfo;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    /**
     * 查询基金最新的净值
     *
     * @param fcodes
     * @return
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNFInfo")
    Single<FundLatestInfo> queryFundLastestInfo(@Field("Fcodes") String fcodes);

    /**
     * 查询基金信息
     *
     * @param code
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNNBasicInformation")
    Single<FundInfo> queryFundInfo(@Field("FCODE") String code);

    /**
     * 查询基金历史净值信息
     */
    @FormUrlEncoded
    @POST("FundMNewApi/FundMNHisNetList")
    Single<FundHistroyInfo> queryHistroyInfo(@Field("FCODE") String code, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);
}

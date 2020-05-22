package com.fund.strategy.model.data;

import com.fund.strategy.model.api.entity.ZhiShuChangeBean;

import java.util.ArrayList;
import java.util.List;

public class ZhiShuChangeWrapper {

    //2020-05-20 09:30,24462.90

    private ZhiShuChangeBean mZhiShuChangeBean;

    private List<Float> mData = new ArrayList<>();

    //title
    private String mTitle;

    //一共有多少个数据点
    private int mMaxCount;

    //前一天的点数
    private double mTarget;

    //变动的点数
    private double mDiffPoints;

    //变化的百分比
    private double mDiffPercentage;

    //最新的点数
    private double mNewPoints;

    public ZhiShuChangeWrapper(ZhiShuChangeBean zhiShuChangeBean) {
        mZhiShuChangeBean = zhiShuChangeBean;
        ZhiShuChangeBean.DataBean data = zhiShuChangeBean.getData();
        if (data == null) {
            return;
        }

        List<String> trends = data.getTrends();

        for (int i = 0; i < trends.size(); i++) {
            String trend = trends.get(i);

            String[] split = trend.split(",");

            mData.add(Float.valueOf(split[1]));
        }

        mMaxCount = data.getTrendsTotal();
        mTitle = data.getName();
        mTarget = data.getPrePrice();
        mNewPoints = mData.get(trends.size() - 1);
        mDiffPoints = mNewPoints - mTarget;
        mDiffPercentage = mDiffPoints / mTarget;
    }

    public List<Float> getData() {
        return mData;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getMaxCount() {
        return mMaxCount;
    }

    public double getTarget() {
        return mTarget;
    }

    public double getDiffPoints() {
        return mDiffPoints;
    }

    public double getDiffPercentage() {
        return mDiffPercentage;
    }

    public double getNewPoints() {
        return mNewPoints;
    }
}

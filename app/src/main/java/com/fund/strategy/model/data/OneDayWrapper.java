package com.fund.strategy.model.data;

import com.fund.strategy.model.api.entity.TodayFundChangeBean;
import com.fund.strategy.model.db.entity.ChiYouEntity;

import java.util.ArrayList;
import java.util.List;

public class OneDayWrapper {

    private ChiYouEntity mChiYouEntity;

    private TodayFundChangeBean mTodayFundChangeBean;

    public OneDayWrapper(ChiYouEntity chiYouEntity, TodayFundChangeBean todayFundChangeBean) {
        mChiYouEntity = chiYouEntity;
        mTodayFundChangeBean = todayFundChangeBean;
    }


    public String getFundName() {
        return mTodayFundChangeBean.getExpansion().getSHORTNAME();
    }

    public String getFundCode() {
        return mTodayFundChangeBean.getExpansion().getFCODE();
    }

    public int getPointCount() {
        return mTodayFundChangeBean.getTotalCount();
    }

    public List<Float> getPoints() {
        //1,09:30,0.6135
        List<String> datas = mTodayFundChangeBean.getDatas();

        List<Float> points = new ArrayList<>();

        for (String data : datas) {
            String[] split = data.split(",");
            points.add(Float.valueOf(split[2]));
        }

        return points;
    }

    public float getTodayChange() {
        List<String> datas = mTodayFundChangeBean.getDatas();
        if (datas.size() <= 0) {
            return 0;
        }
        String s = datas.get(datas.size() - 1);
        String[] split = s.split(",");
        return Float.valueOf(split[2]);

    }

    public float getNowGZ() {
        return mTodayFundChangeBean.getExpansion().getGZ();
    }

    public float getTarget() {
        return 0;
    }
}

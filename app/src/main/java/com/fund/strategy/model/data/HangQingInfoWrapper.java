package com.fund.strategy.model.data;

import com.fund.strategy.model.api.entity.HangQingInfo;

import java.util.List;

public class HangQingInfoWrapper {

    private List<HangQingInfo> zyzsHangQingInfos;

    private List<HangQingInfo> hyzsHangQingInfos;

    public HangQingInfoWrapper(List<HangQingInfo> zyzsHangQingInfos, List<HangQingInfo> hyzsHangQingInfos) {
        this.zyzsHangQingInfos = zyzsHangQingInfos;
        this.hyzsHangQingInfos = hyzsHangQingInfos;
    }

    public List<HangQingInfo> getZyzsHangQingInfos() {
        return zyzsHangQingInfos;
    }

    public void setZyzsHangQingInfos(List<HangQingInfo> zyzsHangQingInfos) {
        this.zyzsHangQingInfos = zyzsHangQingInfos;
    }

    public List<HangQingInfo> getHyzsHangQingInfos() {
        return hyzsHangQingInfos;
    }

    public void setHyzsHangQingInfos(List<HangQingInfo> hyzsHangQingInfos) {
        this.hyzsHangQingInfos = hyzsHangQingInfos;
    }
}

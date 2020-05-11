package com.fund.strategy.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemChiyouBinding;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.utils.FontUtils;

import org.jetbrains.annotations.NotNull;

public class ChiYouAdapter extends BaseQuickAdapter<FundLatestInfo, BaseDataBindingHolder<ItemChiyouBinding>> {
    public ChiYouAdapter() {
        super(R.layout.item_chiyou);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemChiyouBinding> holder, FundLatestInfo fundLatestInfo) {
        ItemChiyouBinding dataBinding = holder.getDataBinding();

        if (dataBinding == null) {
            return;
        }

        dataBinding.title.setText(fundLatestInfo.getSHORTNAME());
        dataBinding.tvCode.setText(fundLatestInfo.getFCODE());

        dataBinding.tvPriceToday.setText(FontUtils.number2String(fundLatestInfo.getGSZ(), "0.0000"));
        dataBinding.tvPercentageToday.setText(FontUtils.number2String(fundLatestInfo.getGSZZL(), "0.00") + "%");
        dataBinding.tvPriceDayBefore.setText(FontUtils.number2String(fundLatestInfo.getNAV(), "0.0000"));
        dataBinding.tvPercentageDayBefore.setText(FontUtils.number2String(fundLatestInfo.getNAVCHGRT(), "0.00") + "%");


        if (fundLatestInfo.getGSZZL() > 0) {
            dataBinding.tvPriceToday.setTextColor(getContext().getResources().getColor(R.color.rise_color));
            dataBinding.tvPercentageToday.setTextColor(getContext().getResources().getColor(R.color.rise_color));
        } else if (fundLatestInfo.getGSZZL() < 0) {
            dataBinding.tvPriceToday.setTextColor(getContext().getResources().getColor(R.color.fall_color));
            dataBinding.tvPercentageToday.setTextColor(getContext().getResources().getColor(R.color.fall_color));
        } else {
            dataBinding.tvPriceToday.setTextColor(getContext().getResources().getColor(R.color.default_color));
            dataBinding.tvPercentageToday.setTextColor(getContext().getResources().getColor(R.color.default_color));
        }


        if (fundLatestInfo.getNAVCHGRT() > 0) {
            dataBinding.tvPriceDayBefore.setTextColor(getContext().getResources().getColor(R.color.rise_color));
            dataBinding.tvPercentageDayBefore.setTextColor(getContext().getResources().getColor(R.color.rise_color));
        } else if (fundLatestInfo.getNAVCHGRT() < 0) {
            dataBinding.tvPriceDayBefore.setTextColor(getContext().getResources().getColor(R.color.fall_color));
            dataBinding.tvPercentageDayBefore.setTextColor(getContext().getResources().getColor(R.color.fall_color));
        } else {
            dataBinding.tvPriceDayBefore.setTextColor(getContext().getResources().getColor(R.color.default_color));
            dataBinding.tvPercentageDayBefore.setTextColor(getContext().getResources().getColor(R.color.default_color));
        }
    }
}

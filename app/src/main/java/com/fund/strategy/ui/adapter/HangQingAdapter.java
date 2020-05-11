package com.fund.strategy.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemHangqingBinding;
import com.fund.strategy.model.api.entity.HangQingInfo;
import com.fund.strategy.utils.FontUtils;

import org.jetbrains.annotations.NotNull;

public class HangQingAdapter extends BaseQuickAdapter<HangQingInfo, BaseDataBindingHolder<ItemHangqingBinding>> {
    public HangQingAdapter() {
        super(R.layout.item_hangqing);
    }


    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemHangqingBinding> bindingHolder, HangQingInfo hangQingInfo) {
        ItemHangqingBinding dataBinding = bindingHolder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        dataBinding.zsTitle.setText(hangQingInfo.getName());

        dataBinding.zsNumber.setText(FontUtils.number2String(hangQingInfo.getCurrent()));
        dataBinding.zsChange.setText(FontUtils.number2String(hangQingInfo.getChg()));
        dataBinding.zsPercentage.setText(FontUtils.number2String(hangQingInfo.getPercentage()) + "%");

        if (hangQingInfo.getChg() < 0) {
            dataBinding.zsNumber.setTextColor(getContext().getResources().getColor(R.color.fall_color));
            dataBinding.zsChange.setTextColor(getContext().getResources().getColor(R.color.fall_color));
            dataBinding.zsPercentage.setTextColor(getContext().getResources().getColor(R.color.fall_color));
        } else if (hangQingInfo.getChg() > 0) {
            dataBinding.zsNumber.setTextColor(getContext().getResources().getColor(R.color.rise_color));
            dataBinding.zsChange.setTextColor(getContext().getResources().getColor(R.color.rise_color));
            dataBinding.zsPercentage.setTextColor(getContext().getResources().getColor(R.color.rise_color));
        } else {
            dataBinding.zsNumber.setTextColor(getContext().getResources().getColor(R.color.default_color));
            dataBinding.zsChange.setTextColor(getContext().getResources().getColor(R.color.default_color));
            dataBinding.zsPercentage.setTextColor(getContext().getResources().getColor(R.color.default_color));
        }
    }
}

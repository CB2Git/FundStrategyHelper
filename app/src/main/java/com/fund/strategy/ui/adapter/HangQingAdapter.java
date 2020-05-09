package com.fund.strategy.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemHangqingBinding;
import com.fund.strategy.model.api.entity.HangQingInfo;

import org.jetbrains.annotations.NotNull;

public class HangQingAdapter extends BaseQuickAdapter<HangQingInfo, BaseDataBindingHolder<ItemHangqingBinding>> {
    public HangQingAdapter() {
        super(R.layout.item_hangqing);
    }


    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemHangqingBinding> bindingHolder, HangQingInfo hangQingInfo) {
    }
}

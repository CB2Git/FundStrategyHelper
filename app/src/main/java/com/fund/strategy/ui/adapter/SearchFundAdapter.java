package com.fund.strategy.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemSearchFundBinding;
import com.fund.strategy.model.api.entity.FundInfo2Data;

import org.jetbrains.annotations.NotNull;

public class SearchFundAdapter extends BaseQuickAdapter<FundInfo2Data.FundInfo2, BaseDataBindingHolder<ItemSearchFundBinding>> {
    public SearchFundAdapter() {
        super(R.layout.item_search_fund);
        addChildClickViewIds(R.id.fund_add);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemSearchFundBinding> bindingHolder, FundInfo2Data.FundInfo2 fundInfo2) {
        ItemSearchFundBinding dataBinding = bindingHolder.getDataBinding();

        if (dataBinding == null) {
            return;
        }

        dataBinding.fundTitle.setText(fundInfo2.getForeShortName());
        dataBinding.fundNo.setText(fundInfo2.getFCODE());
        dataBinding.fundChange.setText(String.format("%s%%", fundInfo2.getSYL()));

        int riseColor = getContext().getResources().getColor(R.color.rise_color);
        int fallColor = getContext().getResources().getColor(R.color.fall_color);
        int defaultColor = getContext().getResources().getColor(R.color.default_color);

        if (fundInfo2.getSYL() > 0) {
            dataBinding.fundChange.setTextColor(riseColor);
        } else if (fundInfo2.getSYL() < 0) {
            dataBinding.fundChange.setTextColor(fallColor);
        } else {
            dataBinding.fundChange.setTextColor(defaultColor);
        }
    }
}

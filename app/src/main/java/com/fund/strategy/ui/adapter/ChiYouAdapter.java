package com.fund.strategy.ui.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemChiyouBinding;
import com.fund.strategy.databinding.ItemChiyouTitleBinding;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.utils.DateUtils;
import com.fund.strategy.utils.FontUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import androidx.databinding.DataBindingUtil;

public class ChiYouAdapter extends BaseMultiItemQuickAdapter<FundLatestInfo, BaseViewHolder> {
    public ChiYouAdapter() {
        super();
        addItemType(FundLatestInfo.TYPE_TOP, R.layout.item_chiyou_title);
        addItemType(FundLatestInfo.TYPE_NORMAL, R.layout.item_chiyou);
        addChildClickViewIds(R.id.lv_switch);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, FundLatestInfo fundLatestInfo) {

        if (holder.getItemViewType() == FundLatestInfo.TYPE_NORMAL) {
            bindToNormal(holder, fundLatestInfo);
        }

        if (holder.getItemViewType() == FundLatestInfo.TYPE_TOP) {
            bindToTitle(holder, fundLatestInfo);
        }
    }

    private void bindToTitle(BaseViewHolder holder, FundLatestInfo fundLatestInfo) {
        ItemChiyouTitleBinding binding = DataBindingUtil.bind(holder.itemView);

        if (binding == null) {
            return;
        }

        Date date1 = DateUtils.str2Date(fundLatestInfo.getExpansionBean().getGZTIME());
        Date date2 = DateUtils.str2Date(fundLatestInfo.getExpansionBean().getFSRQ());

        binding.tvToday.setText(DateUtils.date2str(date1, "MM-dd"));
        binding.tvDayBefore.setText(DateUtils.date2str(date2, "MM-dd"));
    }

    private void bindToNormal(BaseViewHolder holder, FundLatestInfo fundLatestInfo) {

        ItemChiyouBinding dataBinding = DataBindingUtil.bind(holder.itemView);

        if (dataBinding == null) {
            return;
        }

        dataBinding.title.setText(fundLatestInfo.getSHORTNAME());
        dataBinding.tvCode.setText(fundLatestInfo.getFCODE());


        dataBinding.tvPriceToday.setText(FontUtils.number2String(FontUtils.str2Double(fundLatestInfo.getGSZ()), "0.0000"));
        dataBinding.tvPercentageToday.setText(FontUtils.number2String(FontUtils.str2Double(fundLatestInfo.getGSZZL()), "0.00") + "%");
        dataBinding.tvPriceDayBefore.setText(FontUtils.number2String(fundLatestInfo.getNAV(), "0.0000"));
        dataBinding.tvPercentageDayBefore.setText(FontUtils.number2String(fundLatestInfo.getNAVCHGRT(), "0.00") + "%");

        int riseColor = getContext().getResources().getColor(R.color.rise_color);
        int fallColor = getContext().getResources().getColor(R.color.fall_color);
        int defaultColor = getContext().getResources().getColor(R.color.default_color);

        if (FontUtils.str2Double(fundLatestInfo.getGSZZL()) > 0) {
            dataBinding.tvPriceToday.setTextColor(riseColor);
            dataBinding.tvPercentageToday.setTextColor(riseColor);
        } else if (FontUtils.str2Double(fundLatestInfo.getGSZZL()) < 0) {
            dataBinding.tvPriceToday.setTextColor(fallColor);
            dataBinding.tvPercentageToday.setTextColor(fallColor);
        } else {
            dataBinding.tvPriceToday.setTextColor(defaultColor);
            dataBinding.tvPercentageToday.setTextColor(defaultColor);
        }

        int color = defaultColor;

        if (fundLatestInfo.getNAVCHGRT() > 0) {
            color = riseColor;
            dataBinding.tvPriceDayBefore.setTextColor(riseColor);
            dataBinding.tvPercentageDayBefore.setTextColor(riseColor);
        } else if (fundLatestInfo.getNAVCHGRT() < 0) {
            color = fallColor;
            dataBinding.tvPriceDayBefore.setTextColor(fallColor);
            dataBinding.tvPercentageDayBefore.setTextColor(fallColor);
        } else {
            dataBinding.tvPriceDayBefore.setTextColor(defaultColor);
            dataBinding.tvPercentageDayBefore.setTextColor(defaultColor);
        }

        //最新交易日
        String gztime = fundLatestInfo.getGZTIME();
        //前一个交易日
        String pdate = fundLatestInfo.getPDATE();

        boolean isUpdateToday = gztime.startsWith(pdate);
        dataBinding.lvIcon.setVisibility(isUpdateToday ? View.VISIBLE : View.INVISIBLE);
        if (isUpdateToday) {
            Drawable drawable = generateBg(color);
            dataBinding.lvIcon.setBackground(drawable);
        }

        dataBinding.isTop.setVisibility(fundLatestInfo.isTop() ? View.VISIBLE : View.GONE);
    }

    private Drawable generateBg(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(500);
        drawable.setColor(color);
        return drawable;
    }
}

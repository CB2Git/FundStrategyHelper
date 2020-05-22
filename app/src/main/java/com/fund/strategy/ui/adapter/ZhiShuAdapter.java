package com.fund.strategy.ui.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemZhishuBinding;
import com.fund.strategy.model.data.ZhiShuChangeWrapper;
import com.fund.strategy.utils.FontUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ZhiShuAdapter extends BaseQuickAdapter<ZhiShuChangeWrapper, BaseDataBindingHolder<ItemZhishuBinding>> {
    public ZhiShuAdapter() {
        super(R.layout.item_zhishu);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemZhishuBinding> bindingHolder, ZhiShuChangeWrapper zhiShuChangeWrapper) {
        ItemZhishuBinding binding = bindingHolder.getDataBinding();

        if (binding == null) {
            return;
        }

        binding.fundTitle.setText(zhiShuChangeWrapper.getTitle());
        binding.fundPoints.setText(FontUtils.number2String(zhiShuChangeWrapper.getNewPoints()));
        binding.fundChange.setText(FontUtils.number2String(zhiShuChangeWrapper.getDiffPercentage(), "0.00%"));


        int color;
        if (zhiShuChangeWrapper.getDiffPercentage() >= 0) {
            color = getContext().getResources().getColor(R.color.rise_color);
            binding.fundPoints.setTextColor(color);
            binding.fundChange.setTextColor(color);
        } else {
            color = getContext().getResources().getColor(R.color.fall_color);
            binding.fundPoints.setTextColor(color);
            binding.fundChange.setTextColor(color);
        }
        LineData lineData = parseLineData(zhiShuChangeWrapper, color);
        setupChart(binding.fundChart, lineData, zhiShuChangeWrapper);
    }

    private LineData parseLineData(ZhiShuChangeWrapper zhiShuChangeWrapper, int color) {
        List<Float> data = zhiShuChangeWrapper.getData();
        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            values.add(new Entry(i, data.get(i)));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, null);
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        set1.setLineWidth(1f);
        set1.setColor(color);
        set1.setDrawCircles(false);
        //set1.setCircleRadius(5f);
        //set1.setCircleHoleRadius(2.5f);
        //set1.setCircleColor(Color.RED);
        //set1.setHighLightColor(Color.RED);
        set1.setDrawValues(false);

        return new LineData(set1);

    }

    private void setupChart(LineChart chart, LineData data, ZhiShuChangeWrapper wrapper) {

        // no description text
        chart.getDescription().setEnabled(false);

        // chart.setDrawHorizontalGrid(false);
        //
        // enable / disable grid background
        chart.setDrawGridBackground(false);
//        chart.getRenderer().getGridPaint().setGridColor(Color.WHITE & 0x70FFFFFF);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        // set custom chart offsets (automatic offset calculation is hereby disabled)
        //chart.setViewPortOffsets(10, 0, 10, 0);

        // add data
        chart.setData(data);

        //不显示label
        chart.getDescription().setEnabled(false);
        //手势操作关闭
        chart.setTouchEnabled(false);

        //隐藏掉lable
        chart.getLegend().setEnabled(false);

        //X轴
        XAxis xAxis = chart.getXAxis();
        //左边Y轴
        YAxis axisLeft = chart.getAxisLeft();

        //X轴最大值
        xAxis.setAxisMaximum(wrapper.getMaxCount());

        LimitLine llXAxis = new LimitLine((float) wrapper.getTarget(), "");
        //设置基准线
        axisLeft.removeAllLimitLines();
        llXAxis.setLineWidth(1f);
        llXAxis.setLineColor(Color.parseColor("#737373"));
        llXAxis.enableDashedLine(10f, 10f, 0f);
        llXAxis.setLineWidth(1);
        axisLeft.addLimitLine(llXAxis);

        //不绘制网格线
        xAxis.setDrawGridLines(false);
        axisLeft.setDrawGridLines(false);

        //禁用右侧Y轴
        chart.getAxisRight().setEnabled(false);

        //允许绘制XY轴
        xAxis.setDrawAxisLine(true);
        axisLeft.setDrawAxisLine(true);

        //X轴刻度
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(3, true);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == 0) {
                    return "9:00";
                } else if (value == 256) {
                    return "15:00";
                } else {
                    return "11:30/13:00";
                }
            }
        });


        //Y轴刻度
        axisLeft.setTextColor(Color.BLACK);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        axisLeft.setLabelCount(2, true);
        axisLeft.setDrawLabels(true);
        axisLeft.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.format(Locale.CHINA, "%.2f", value);
            }
        });

    }
}

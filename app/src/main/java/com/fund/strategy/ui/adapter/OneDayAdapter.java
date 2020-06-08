package com.fund.strategy.ui.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemOneDayBinding;
import com.fund.strategy.model.data.OneDayWrapper;
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

public class OneDayAdapter extends BaseQuickAdapter<OneDayWrapper, BaseDataBindingHolder<ItemOneDayBinding>> {
    public OneDayAdapter() {
        super(R.layout.item_one_day);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemOneDayBinding> dataBindingHolder, OneDayWrapper oneDayWrapper) {
        ItemOneDayBinding dataBinding = dataBindingHolder.getDataBinding();

        if (dataBinding == null) {
            return;
        }

        dataBinding.fundTitle.setText(oneDayWrapper.getFundName());
        dataBinding.fundCode.setText(oneDayWrapper.getFundCode());
        dataBinding.fundChange.setText(String.format(Locale.CHINA, "%.2f%%", oneDayWrapper.getTodayChange()));
        dataBinding.fundPoints.setText(FontUtils.number2String(oneDayWrapper.getNowGZ(), "0.0000"));

        int riseColor = getContext().getResources().getColor(R.color.rise_color);
        int fallColor = getContext().getResources().getColor(R.color.fall_color);
        int defaultColor = getContext().getResources().getColor(R.color.default_color);

        int color;
        if (oneDayWrapper.getTodayChange() > 0) {
            color = riseColor;
        } else if (oneDayWrapper.getTodayChange() < 0) {
            color = fallColor;
        } else {
            color = defaultColor;
        }
        dataBinding.fundChange.setTextColor(color);

        LineData lineData = parseLineData(oneDayWrapper.getPoints(), color);

        setupChart(dataBinding.fundChart, lineData, oneDayWrapper);
    }

    private void setupChart(LineChart chart, LineData data, OneDayWrapper oneDayWrapper) {
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
        axisLeft.resetAxisMinimum();
        axisLeft.resetAxisMaximum();

        //X轴最大值
        xAxis.setAxisMaximum(oneDayWrapper.getPointCount());

        // add data
        chart.setData(data);

        LimitLine llXAxis = new LimitLine(oneDayWrapper.getTarget(), "");
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
                return String.format(Locale.CHINA, "%.2f%%", value);
            }
        });

        float axisMinimum = axisLeft.getAxisMinimum();
        float axisMaximum = axisLeft.getAxisMaximum();

        if (Math.abs(axisMinimum) > Math.abs(axisMaximum)) {
            axisLeft.setAxisMaximum(Math.abs(axisMinimum));
        } else {
            axisLeft.setAxisMinimum(-Math.abs(axisMaximum));
        }

        chart.invalidate();
    }

    private LineData parseLineData(List<Float> points, int color) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            values.add(new Entry(i, points.get(i)));
        }

        LineDataSet set1 = new LineDataSet(values, null);
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        set1.setLineWidth(1f);
        set1.setColor(color);
        set1.setDrawCircles(false);
        //set1.setCircleRadius(5f);
        //set1.setCircleHoleRadius(2.5f);
        //set1.setCircleColor(Color.RED);
        set1.setHighLightColor(Color.RED);
        set1.setDrawValues(false);

        return new LineData(set1);
    }
}

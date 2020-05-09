package com.fund.strategy.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentHangqingBinding;
import com.fund.strategy.mv.hangqing.HangQingViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class HangQingFragment extends BaseMVVMFragment<MainFragmentHangqingBinding, HangQingViewModel> {

    private static final String TAG = "HangQingFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_hangqing;
    }

    @NonNull
    @Override
    protected HangQingViewModel createViewModel() {
        return new ViewModelProvider(this).get(HangQingViewModel.class);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    public static HangQingFragment newInstance() {
        Bundle args = new Bundle();
        HangQingFragment fragment = new HangQingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

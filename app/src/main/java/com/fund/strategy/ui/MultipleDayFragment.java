package com.fund.strategy.ui;

import android.os.Bundle;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.fund.strategy.R;
import com.fund.strategy.databinding.FragmentMultipleDayBinding;
import com.fund.strategy.mv.collect.CollectViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class MultipleDayFragment extends BaseMVVMFragment<FragmentMultipleDayBinding, CollectViewModel> {
    @NonNull
    @Override
    protected CollectViewModel createViewModel() {
        return new ViewModelProvider(this).get(CollectViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_multiple_day;
    }

    public static MultipleDayFragment newInstance() {
        Bundle args = new Bundle();
        MultipleDayFragment fragment = new MultipleDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

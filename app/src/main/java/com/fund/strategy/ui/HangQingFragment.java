package com.fund.strategy.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentHangqingBinding;
import com.fund.strategy.model.api.entity.HangQingInfo;
import com.fund.strategy.mv.hangqing.HangQingViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.getZyZs().observe(this, listResource -> {
            if (listResource.status == Resource.Status.SUCCESS) {
            }
        });

        mViewModel.getHyZs().observe(this, listResource -> {
            if (listResource.status == Resource.Status.SUCCESS) {

            }
        });
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

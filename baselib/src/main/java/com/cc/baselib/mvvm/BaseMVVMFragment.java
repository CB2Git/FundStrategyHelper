package com.cc.baselib.mvvm;

import android.os.Bundle;

import com.cc.baselib.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

public abstract class BaseMVVMFragment<T extends ViewDataBinding, VM extends BaseViewModel> extends BaseFragment<T> {

    protected VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = createViewModel();
    }

    /**
     * 创建ViewModel
     */
    @NonNull
    protected abstract VM createViewModel();
}

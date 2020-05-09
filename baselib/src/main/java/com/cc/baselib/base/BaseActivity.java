package com.cc.baselib.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected T mBinding;

    /**
     * 获取布局id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化布局的时机,此时已经可以直接使用mBinding以及mViewModel 在onViewCreated中被调用
     */
    protected void initView() {

    }

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initView();
    }
}

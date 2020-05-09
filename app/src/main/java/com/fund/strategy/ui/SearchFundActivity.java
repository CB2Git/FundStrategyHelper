package com.fund.strategy.ui;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.cc.baselib.mvvm.BaseMVVMActivity;
import com.cc.baselib.mvvm.BaseViewModel;
import com.fund.strategy.R;
import com.fund.strategy.databinding.SearchFundBinding;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.FundInfo;
import com.fund.strategy.utils.RxUtils;

import androidx.annotation.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class SearchFundActivity extends BaseMVVMActivity<SearchFundBinding, BaseViewModel> implements View.OnClickListener {

    @Override
    protected int getLayoutId() {
        return R.layout.search_fund;
    }

    @NonNull
    @Override
    protected BaseViewModel createViewModel() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.searchFund.setOnClickListener(this);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, SearchFundActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (mBinding.searchFund.equals(v)) {
            doSearch(mBinding.searchCode.getText().toString());
        }
    }

    private void doSearch(String code) {
        Disposable disposable = RetrofitManager.getApiService().queryFundInfo(code)
                .compose(RxUtils.singleSchedulers())
                .subscribe(new Consumer<FundInfo>() {
                    @Override
                    public void accept(FundInfo fundInfo) throws Exception {
                        mBinding.searchResult.setText(fundInfo.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
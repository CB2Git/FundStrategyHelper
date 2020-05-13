package com.fund.strategy.mv.search;

import android.app.Application;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.FundInfo;
import com.fund.strategy.model.api.entity.FundInfo2;
import com.fund.strategy.utils.RxUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class SearchViewModel extends BaseViewModel {

    private MutableLiveData<Resource<FundInfo2>> mFundInfo = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<FundInfo2>> getFundInfo() {
        return mFundInfo;
    }

    public void searchFund(String code) {
        Disposable disposable = RetrofitManager.getApiService().searchFunds(code)
                .compose(RxUtils.singleSchedulers())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mFundInfo.postValue(Resource.loading());
                    }
                })
                .subscribe(new Consumer<FundInfo2>() {
                    @Override
                    public void accept(FundInfo2 fundInfo) throws Exception {
                        if (fundInfo.getDatas() == null) {
                            mFundInfo.postValue(Resource.error("没有搜索到指定基金"));
                        } else {
                            mFundInfo.postValue(Resource.success(fundInfo));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mFundInfo.postValue(Resource.error("网络错误，请重试"));
                    }
                });
        addDisposable(disposable);
    }
}

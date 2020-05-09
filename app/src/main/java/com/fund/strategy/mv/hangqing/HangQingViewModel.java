package com.fund.strategy.mv.hangqing;

import android.app.Application;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.HangQingInfo;
import com.fund.strategy.model.api.entity.HangQingInfoData;
import com.fund.strategy.utils.RxUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;

public class HangQingViewModel extends BaseViewModel {

    private MutableLiveData<Resource<List<HangQingInfo>>> mZyZs = new MutableLiveData<>();

    private MutableLiveData<Resource<List<HangQingInfo>>> mHyZs = new MutableLiveData<>();

    public HangQingViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<HangQingInfo>>> getZyZs() {
        return mZyZs;
    }

    public LiveData<Resource<List<HangQingInfo>>> getHyZs() {
        return mHyZs;
    }

    public void reqHangQingInfo() {
        Disposable subscribe = RetrofitManager.getApiService()
                .hangQingInfo("zyzs")
                .compose(RxUtils.singleSchedulers())
                .map(HangQingInfoData::getData)
                .subscribe(hangQingInfo -> {
                    mZyZs.postValue(Resource.success(hangQingInfo));
                }, throwable -> {
                    mZyZs.postValue(Resource.error("请求主要指数失败"));
                });
        addDisposable(subscribe);
    }

    public void reqHangYe() {
        Disposable subscribe = RetrofitManager.getApiService()
                .hangQingInfo("hyzs")
                .compose(RxUtils.singleSchedulers())
                .map(HangQingInfoData::getData)
                .subscribe(hangQingInfo -> {
                    mHyZs.postValue(Resource.success(hangQingInfo));
                }, throwable -> {
                    mHyZs.postValue(Resource.error("请求行业指数失败"));
                });
        addDisposable(subscribe);
    }
}

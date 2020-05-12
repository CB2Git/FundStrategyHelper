package com.fund.strategy.mv.chiyou;

import android.app.Application;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.ExpansionBean;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.model.api.entity.FundLatestInfoData;
import com.fund.strategy.utils.RxUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class ChiYouModel extends BaseViewModel {

    private MutableLiveData<Resource<List<FundLatestInfo>>> mFundLatestInfo = new MutableLiveData<>();

    public ChiYouModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<FundLatestInfo>>> getFundLatestInfo() {
        return mFundLatestInfo;
    }

    public void reqChiYouInfo() {
        Disposable subscribe = RetrofitManager.getApiService()
                .queryFundLastestInfo("005919,005918,001618,001595")
                .map(new Function<FundLatestInfoData, List<FundLatestInfo>>() {
                    @Override
                    public List<FundLatestInfo> apply(FundLatestInfoData fundLatestInfoData) throws Exception {
                        List<FundLatestInfo> datas = fundLatestInfoData.getDatas();

                        ExpansionBean expansion = fundLatestInfoData.getExpansion();
                        FundLatestInfo titleBean = new FundLatestInfo();
                        titleBean.setType(FundLatestInfo.TYPE_TOP);
                        datas.add(0, titleBean);

                        for (FundLatestInfo info : datas) {
                            info.setExpansionBean(expansion);
                        }
                        return datas;
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mFundLatestInfo.postValue(Resource.loading());
                    }
                })
                .compose(RxUtils.singleSchedulers())
                .subscribe(new Consumer<List<FundLatestInfo>>() {
                    @Override
                    public void accept(List<FundLatestInfo> fundLatestInfos) throws Exception {
                        mFundLatestInfo.postValue(Resource.success(fundLatestInfos));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mFundLatestInfo.postValue(Resource.error(""));
                    }
                });
        addDisposable(subscribe);
    }
}

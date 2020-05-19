package com.fund.strategy.mv.search;

import android.app.Application;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.FundInfo2Data;
import com.fund.strategy.model.db.DB;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.fund.strategy.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class SearchViewModel extends BaseViewModel {

    private MutableLiveData<Resource<FundInfo2Data>> mFundInfo = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<FundInfo2Data>> getFundInfo() {
        return mFundInfo;
    }

    public void searchFund(String code) {

        if ("123456".equals(code)) {

            String[] codes = new String[]{"001549", "005919", "005918", "001595", "001632", "001618", "007301"};
            List<ChiYouEntity> entities = new ArrayList<>();

            for (String item : codes) {
                ChiYouEntity chiYouEntity = new ChiYouEntity();
                chiYouEntity.fundNo = item;
                chiYouEntity.fundName = "default";
                entities.add(chiYouEntity);
            }

            DB.getInstance().chiyouDao().insertFunds(entities);
            Toast.makeText(getApplication(), "添加成功", Toast.LENGTH_SHORT).show();
            return;
        }

        Disposable disposable = RetrofitManager.getApiService().searchFunds(code)
                .compose(RxUtils.singleSchedulers())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mFundInfo.postValue(Resource.loading());
                    }
                })
                .subscribe(new Consumer<FundInfo2Data>() {
                    @Override
                    public void accept(FundInfo2Data fundInfo) throws Exception {
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

    public void addCollection(FundInfo2Data.FundInfo2 fundInfo2) {
        ChiYouEntity chiYouEntity = new ChiYouEntity();
        chiYouEntity.fundNo = fundInfo2.getFCODE();
        chiYouEntity.fundName = fundInfo2.getSHORTNAME();

        DB.getInstance().chiyouDao().insertFund(chiYouEntity);

        Toast.makeText(getApplication(), "添加成功", Toast.LENGTH_SHORT).show();
    }
}

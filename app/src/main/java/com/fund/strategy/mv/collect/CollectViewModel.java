package com.fund.strategy.mv.collect;

import android.app.Application;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.TodayFundChangeBean;
import com.fund.strategy.model.data.OneDayWrapper;
import com.fund.strategy.model.db.DB;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.fund.strategy.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class CollectViewModel extends BaseViewModel {

    private MutableLiveData<Resource<List<OneDayWrapper>>> mOneDayWrapper = new MutableLiveData<>();

    public CollectViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<OneDayWrapper>>> getOneDayWrapper() {
        return mOneDayWrapper;
    }

    public void reqOneDayInfo() {
        List<ChiYouEntity> chiYopuTuples = DB.getInstance().chiyouDao().queryAllFund();

        List<Single<OneDayWrapper>> oneDays = new ArrayList<>();

        for (ChiYouEntity entity : chiYopuTuples) {
            Single<TodayFundChangeBean> todayFundChangeBeanSingle = RetrofitManager.getApiService().queryTodayChange(entity.fundNo);

            Single<OneDayWrapper> wrapperSingle = Single.zip(Single.just(entity), todayFundChangeBeanSingle, new BiFunction<ChiYouEntity, TodayFundChangeBean, OneDayWrapper>() {
                @Override
                public OneDayWrapper apply(ChiYouEntity entity, TodayFundChangeBean todayFundChangeBean) throws Exception {
                    return new OneDayWrapper(entity, todayFundChangeBean);
                }
            });

            oneDays.add(wrapperSingle);
        }


        Disposable disposable = Single
                .zip(oneDays, new Function<Object[], List<OneDayWrapper>>() {
                    @Override
                    public List<OneDayWrapper> apply(Object[] objects) throws Exception {
                        ArrayList<OneDayWrapper> arrayList = new ArrayList<>();

                        for (Object obj : objects) {
                            if (obj instanceof OneDayWrapper) {
                                arrayList.add((OneDayWrapper) obj);
                            }
                        }

                        return arrayList;
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mOneDayWrapper.postValue(Resource.loading());
                    }
                })
                .compose(RxUtils.singleSchedulers())
                .subscribe(new Consumer<List<OneDayWrapper>>() {
                    @Override
                    public void accept(List<OneDayWrapper> oneDayWrappers) throws Exception {
                        mOneDayWrapper.postValue(Resource.success(oneDayWrappers));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mOneDayWrapper.postValue(Resource.error(throwable.getMessage()));
                    }
                });
        addDisposable(disposable);
    }

}

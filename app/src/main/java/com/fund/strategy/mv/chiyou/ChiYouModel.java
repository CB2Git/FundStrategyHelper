package com.fund.strategy.mv.chiyou;

import android.app.Application;
import android.text.TextUtils;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.api.entity.ExpansionBean;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.model.api.entity.FundLatestInfoData;
import com.fund.strategy.model.db.DB;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.fund.strategy.model.db.entity.ChiYouTuple;
import com.fund.strategy.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import io.reactivex.SingleSource;
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

    public ChiYouEntity queryChiYouInfo(String fundNo) {
        return DB.getInstance().chiyouDao().queryChiYouInfo(fundNo);
    }

    public void delete(String fundNo) {
        DB.getInstance().chiyouDao().deleteChiYouInfo(fundNo);
    }

    public void changeTop(String fundNo, boolean isTop) {
        if (isTop) {
            DB.getInstance().chiyouDao().changeIsTop(fundNo);
        } else {
            DB.getInstance().chiyouDao().changeNotTop(fundNo);
        }
    }

    public void reqChiYouInfo() {
        List<ChiYouTuple> chiYopuTuples = DB.getInstance().chiyouDao().queryAllFundNo();
        Disposable subscribe = Single.just(chiYopuTuples)
                .map(new Function<List<ChiYouTuple>, String>() {
                    @Override
                    public String apply(List<ChiYouTuple> chiYopuTuples) throws Exception {

                        StringBuilder stringBuffer = new StringBuilder();

                        for (int i = 0; i < chiYopuTuples.size(); i++) {
                            stringBuffer.append(chiYopuTuples.get(i).fundNo);

                            if (i < chiYopuTuples.size() - 1) {
                                stringBuffer.append(",");
                            }
                        }

                        return stringBuffer.toString();
                    }
                })
                .flatMap(new Function<String, SingleSource<FundLatestInfoData>>() {
                    @Override
                    public SingleSource<FundLatestInfoData> apply(String s) throws Exception {

                        if (TextUtils.isEmpty(s)) {
                            throw new IllegalArgumentException("没有数据哦");
                        }

                        return RetrofitManager.getApiService()
                                .queryFundLastestInfo(s);
                    }
                })
                .map(new Function<FundLatestInfoData, List<FundLatestInfo>>() {
                    @Override
                    public List<FundLatestInfo> apply(FundLatestInfoData fundLatestInfoData) throws Exception {
                        List<FundLatestInfo> datas = fundLatestInfoData.getDatas();

                        if (datas == null || datas.size() <= 0) {
                            throw new IllegalArgumentException("没有数据哦");
                        }

                        ExpansionBean expansion = fundLatestInfoData.getExpansion();
                        FundLatestInfo titleBean = new FundLatestInfo();
                        titleBean.setType(FundLatestInfo.TYPE_TOP);
                        datas.add(0, titleBean);

                        List<String> topNo = DB.getInstance().chiyouDao().queryAllTop();

                        if (topNo == null) {
                            topNo = new ArrayList<>();
                        }

                        for (FundLatestInfo info : datas) {
                            for (int i = 0; i < topNo.size(); i++) {
                                if (topNo.get(i).equals(info.getFCODE())) {
                                    info.setTop(true);
                                }
                            }
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
                        mFundLatestInfo.postValue(Resource.error(throwable.getMessage()));
                    }
                });
        addDisposable(subscribe);
    }
}

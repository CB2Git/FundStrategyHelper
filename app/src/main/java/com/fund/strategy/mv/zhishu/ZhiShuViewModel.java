package com.fund.strategy.mv.zhishu;

import android.app.Application;

import com.cc.baselib.mvvm.BaseViewModel;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.model.api.RetrofitManager;
import com.fund.strategy.model.data.ZhiShuChangeWrapper;
import com.fund.strategy.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function6;

public class ZhiShuViewModel extends BaseViewModel {

    private static final String[] m = new String[]{"1.000001", "0.399001", "0.399006", "0.000016", "0.000300", "0.000905"};

    private MutableLiveData<Resource<List<ZhiShuChangeWrapper>>> mZhiShuChange = new MutableLiveData<>();

    public ZhiShuViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<ZhiShuChangeWrapper>>> getZhiShuChange() {
        return mZhiShuChange;
    }

    public void reqZhiShuChange() {

        Single<ZhiShuChangeWrapper> _000001 = requestCodeInfo("1.000001");
        Single<ZhiShuChangeWrapper> _399001 = requestCodeInfo("0.399001");
        Single<ZhiShuChangeWrapper> _399006 = requestCodeInfo("0.399006");
        Single<ZhiShuChangeWrapper> _000016 = requestCodeInfo("1.000016");
        Single<ZhiShuChangeWrapper> _000300 = requestCodeInfo("1.000300");
        Single<ZhiShuChangeWrapper> _000905 = requestCodeInfo("1.000905");


        Disposable disposable = Single.zip(_000001, _399001, _399006, _000016, _000300, _000905,
                (Function6<ZhiShuChangeWrapper, ZhiShuChangeWrapper, ZhiShuChangeWrapper, ZhiShuChangeWrapper, ZhiShuChangeWrapper, ZhiShuChangeWrapper, List<ZhiShuChangeWrapper>>) (wrapper, wrapper2, wrapper3, wrapper4, wrapper5, wrapper6) -> {
                    ArrayList<ZhiShuChangeWrapper> objects = new ArrayList<>();
                    objects.add(wrapper);
                    objects.add(wrapper2);
                    objects.add(wrapper3);
                    objects.add(wrapper4);
                    objects.add(wrapper5);
                    objects.add(wrapper6);
                    return objects;
                })
                .compose(RxUtils.singleSchedulers())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mZhiShuChange.postValue(Resource.loading());
                    }
                })
                .subscribe(new Consumer<List<ZhiShuChangeWrapper>>() {
                    @Override
                    public void accept(List<ZhiShuChangeWrapper> zhiShuChangeWrappers) throws Exception {
                        mZhiShuChange.postValue(Resource.success(zhiShuChangeWrappers));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mZhiShuChange.postValue(Resource.error(throwable.getMessage()));
                    }
                });


        addDisposable(disposable);
    }


    private Single<ZhiShuChangeWrapper> requestCodeInfo(String code) {
        return RetrofitManager.getApiService()
                .queryZhiShuChange(code, "f1,f2,f9,f10,f13,f5", "f51,f53")
                .map(ZhiShuChangeWrapper::new);
    }
}

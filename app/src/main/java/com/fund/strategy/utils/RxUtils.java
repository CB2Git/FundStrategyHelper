package com.fund.strategy.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {

    /**
     * 指定观察在主线程，处理在io线程
     *
     *
     * <code>
     * compose(RxUtils.<T>singleSchedulers())
     * </code>
     *
     * @return
     */
    public static <T> SingleTransformer<T, T> singleSchedulers() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(Single<T> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io());
            }
        };
    }


    public static <T> ObservableTransformer<T, T> observableSchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io());
            }
        };
    }
}

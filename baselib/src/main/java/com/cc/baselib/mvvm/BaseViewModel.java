package com.cc.baselib.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends AndroidViewModel {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }
}

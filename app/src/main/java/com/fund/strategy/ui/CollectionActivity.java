package com.fund.strategy.ui;

import android.content.Context;
import android.content.Intent;

import com.cc.baselib.mvvm.BaseMVVMActivity;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ActivityColllectLayoutBinding;
import com.fund.strategy.mv.collect.CollectViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

public class CollectionActivity extends BaseMVVMActivity<ActivityColllectLayoutBinding, CollectViewModel> {
    @NonNull
    @Override
    protected CollectViewModel createViewModel() {
        return new ViewModelProvider(this).get(CollectViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_colllect_layout;
    }

    @Override
    protected void initView() {
        super.initView();

        mBinding.tabLayout.setupWithViewPager(mBinding.vpMain);

        mBinding.vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return OneDayFragment.newInstance();
                } else {
                    return MultipleDayFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "日线";
                } else {
                    return "多日线";
                }
            }
        });
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, CollectionActivity.class);
        context.startActivity(intent);
    }
}

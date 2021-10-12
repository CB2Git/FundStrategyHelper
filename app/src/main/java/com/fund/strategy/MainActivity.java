package com.fund.strategy;

import android.net.Uri;
import android.os.Bundle;

import com.cc.baselib.base.BaseActivity;
import com.fund.strategy.databinding.MainActivityBinding;
import com.fund.strategy.ui.HangQingFragment;
import com.fund.strategy.ui.ChiYouFragment;
import com.fund.strategy.ui.ZhiShuChangeFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class MainActivity extends BaseActivity<MainActivityBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected void initView() {
        super.initView();

        setupViewPager();

        Uri data = getIntent().getData();
        if (data != null && data.getPathSegments() != null && data.getPathSegments().size() > 0) {
            String s = data.getPathSegments().get(0);
            try {
                mBinding.mainViewPager.setCurrentItem(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupViewPager() {
        mBinding.mainTabLayout.setupWithViewPager(mBinding.mainViewPager);
        mBinding.mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            private String[] mTitle = new String[]{"持有", "行情", "趋势"};

            @NonNull
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return ChiYouFragment.newInstance();
                } else if (position == 1) {
                    return HangQingFragment.newInstance();
                } else {
                    return ZhiShuChangeFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position];
            }
        });
    }
}

package com.fund.strategy;

import android.os.Bundle;

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


public class MainActivity extends AppCompatActivity {

    private MainActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        setupViewPager();
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

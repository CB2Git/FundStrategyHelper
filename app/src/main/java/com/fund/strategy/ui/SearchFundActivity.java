package com.fund.strategy.ui;


import android.os.Bundle;

import com.fund.strategy.R;
import com.fund.strategy.databinding.SearchFundBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SearchFundActivity extends AppCompatActivity {

    private SearchFundBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.search_fund);
    }

}

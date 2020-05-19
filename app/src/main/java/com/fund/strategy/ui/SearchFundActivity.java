package com.fund.strategy.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.cc.baselib.mvvm.BaseMVVMActivity;
import com.cc.baselib.mvvm.data.Resource;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.fund.strategy.R;
import com.fund.strategy.databinding.ItemSearchFundBinding;
import com.fund.strategy.databinding.SearchFundBinding;
import com.fund.strategy.model.api.entity.FundInfo2Data;
import com.fund.strategy.mv.search.SearchViewModel;
import com.fund.strategy.ui.adapter.SearchFundAdapter;
import com.jingewenku.abrahamcaijin.commonutil.AppKeyBoardMgr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SearchFundActivity extends BaseMVVMActivity<SearchFundBinding, SearchViewModel> implements TextView.OnEditorActionListener {

    private SearchFundAdapter mSearchFundAdapter = new SearchFundAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.search_fund;
    }

    @NonNull
    @Override
    protected SearchViewModel createViewModel() {
        return new ViewModelProvider(this).get(SearchViewModel.class);
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.searchCode.setOnEditorActionListener(this);
        mBinding.searchCode.post(() -> AppKeyBoardMgr.openKeybord(mBinding.searchCode, SearchFundActivity.this));

        mBinding.searchResultRoot.fundRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.searchResultRoot.fundRecycleView.setAdapter(mSearchFundAdapter);

        mSearchFundAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                Object item = adapter.getItem(position);

                if (item instanceof FundInfo2Data.FundInfo2) {
                    FundInfo2Data.FundInfo2 fundInfo2 = (FundInfo2Data.FundInfo2) item;
                    mViewModel.addCollection(fundInfo2);
                }

            }
        });

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, SearchFundActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.getFundInfo().observe(this, new Observer<Resource<FundInfo2Data>>() {
            @Override
            public void onChanged(Resource<FundInfo2Data> fundInfoResource) {
                if (fundInfoResource.status == Resource.Status.SUCCESS) {
                    mSearchFundAdapter.setList(fundInfoResource.data.getDatas());
                    mBinding.searchResult.showVisibilityById(R.id.search_result_root);
                } else if (fundInfoResource.status == Resource.Status.LOADING) {
                    mBinding.searchResult.showVisibilityByView(mBinding.searchLoading);
                } else {
                    mBinding.searchResult.showVisibilityByView(mBinding.searchInfo);
                    mBinding.searchInfo.setText(fundInfoResource.message);
                }
            }
        });
    }

    private void doSearch(String code) {
        mViewModel.searchFund(code);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            doSearch(mBinding.searchCode.getText().toString());
            AppKeyBoardMgr.hideInputMethod(this);
            return true;
        }
        return false;
    }
}
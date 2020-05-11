package com.fund.strategy.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentChiyouBinding;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.mv.chiyou.ChiYouModel;
import com.fund.strategy.ui.adapter.ChiYouAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ChiYouFragment extends BaseMVVMFragment<MainFragmentChiyouBinding, ChiYouModel> implements View.OnClickListener {

    private static final String TAG = "ChiYouFragment";

    private ChiYouAdapter mChiYouAdapter = new ChiYouAdapter();

    public static ChiYouFragment newInstance() {
        Bundle args = new Bundle();
        ChiYouFragment fragment = new ChiYouFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    protected ChiYouModel createViewModel() {
        return new ViewModelProvider(this).get(ChiYouModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_chiyou;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.getFundLatestInfo().observe(this, new Observer<Resource<List<FundLatestInfo>>>() {
            @Override
            public void onChanged(Resource<List<FundLatestInfo>> listResource) {
                if (listResource.status == Resource.Status.LOADING) {
                    mBinding.mainRefreshLayout.setRefreshing(true);
                } else if (listResource.status == Resource.Status.ERROR) {
                    mBinding.mainRefreshLayout.setRefreshing(false);
                    Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                } else {
                    mBinding.mainRefreshLayout.setRefreshing(false);
                    mChiYouAdapter.setNewInstance(listResource.data);
                }
            }
        });
    }

    @Override
    protected void initView() {
        mBinding.mainAdd.setOnClickListener(this);

        mBinding.mainRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mBinding.mainRefreshLayout.setOnRefreshListener(() -> mViewModel.reqChiYouInfo());

        mBinding.mainChiyouList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.mainChiyouList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mBinding.mainChiyouList.setAdapter(mChiYouAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.reqChiYouInfo();
    }

    @Override
    public void onClick(View v) {
        if (mBinding.mainAdd.equals(v)) {
            SearchFundActivity.start(getActivity());
        }
    }

}

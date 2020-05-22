package com.fund.strategy.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentZhishuBinding;
import com.fund.strategy.model.data.ZhiShuChangeWrapper;
import com.fund.strategy.mv.zhishu.ZhiShuViewModel;
import com.fund.strategy.ui.adapter.ZhiShuAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ZhiShuChangeFragment extends BaseMVVMFragment<MainFragmentZhishuBinding, ZhiShuViewModel> {

    private ZhiShuAdapter mZhiShuAdapter = new ZhiShuAdapter();

    @NonNull
    @Override
    protected ZhiShuViewModel createViewModel() {
        return new ViewModelProvider(this).get(ZhiShuViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_zhishu;
    }

    public static ZhiShuChangeFragment newInstance() {

        Bundle args = new Bundle();

        ZhiShuChangeFragment fragment = new ZhiShuChangeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.getZhiShuChange().observe(this, new Observer<Resource<List<ZhiShuChangeWrapper>>>() {
            @Override
            public void onChanged(Resource<List<ZhiShuChangeWrapper>> listResource) {
                if (listResource.status == Resource.Status.SUCCESS) {
                    mBinding.mainRefreshLayout.setRefreshing(false);
                    mZhiShuAdapter.setNewInstance(listResource.data);
                } else if (listResource.status == Resource.Status.LOADING) {
                    mBinding.mainRefreshLayout.setRefreshing(true);
                } else {
                    mBinding.mainRefreshLayout.setRefreshing(false);
                    Toast.makeText(getContext(), listResource.message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.reqZhiShuChange();
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.mainList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.mainList.setAdapter(mZhiShuAdapter);

        mBinding.mainRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mBinding.mainRefreshLayout.setOnRefreshListener(() -> mViewModel.reqZhiShuChange());
    }
}

package com.fund.strategy.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentHangqingBinding;
import com.fund.strategy.model.api.entity.HangQingInfo;
import com.fund.strategy.mv.hangqing.HangQingViewModel;
import com.fund.strategy.ui.adapter.HangQingAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class HangQingFragment extends BaseMVVMFragment<MainFragmentHangqingBinding, HangQingViewModel> {

    private static final String TAG = "HangQingFragment";

    private HangQingAdapter mZyzsAdapter = new HangQingAdapter();

    private HangQingAdapter mHyzsAdapter = new HangQingAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_hangqing;
    }

    @NonNull
    @Override
    protected HangQingViewModel createViewModel() {
        return new ViewModelProvider(this).get(HangQingViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.getHangQing().observe(this, resource -> {
            if (resource.status == Resource.Status.SUCCESS) {
                mBinding.mainRefreshLayout.setRefreshing(false);
                mZyzsAdapter.setNewInstance(resource.data.getZyzsHangQingInfos());
                mHyzsAdapter.setNewInstance(resource.data.getHyzsHangQingInfos());
            } else if (resource.status == Resource.Status.LOADING) {
                mBinding.mainRefreshLayout.setRefreshing(true);
            } else {
                Toast.makeText(getContext(), "刷新失败", Toast.LENGTH_SHORT).show();
                mBinding.mainRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();

        mBinding.mainZyzsList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mBinding.mainHyzsList.setLayoutManager(new GridLayoutManager(getContext(), 3));

        mBinding.mainZyzsList.setAdapter(mZyzsAdapter);
        mBinding.mainHyzsList.setAdapter(mHyzsAdapter);

        mBinding.mainRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mBinding.mainRefreshLayout.setOnRefreshListener(() -> mViewModel.reqHangQing());
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.reqHangQing();
    }

    public static HangQingFragment newInstance() {
        Bundle args = new Bundle();
        HangQingFragment fragment = new HangQingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

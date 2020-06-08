package com.fund.strategy.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.fund.strategy.R;
import com.fund.strategy.databinding.FragmentOneDayBinding;
import com.fund.strategy.model.data.OneDayWrapper;
import com.fund.strategy.mv.collect.CollectViewModel;
import com.fund.strategy.ui.adapter.OneDayAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class OneDayFragment extends BaseMVVMFragment<FragmentOneDayBinding, CollectViewModel> {

    private OneDayAdapter mOneDayAdapter = new OneDayAdapter();

    @NonNull
    @Override
    protected CollectViewModel createViewModel() {
        return new ViewModelProvider(this).get(CollectViewModel.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_day;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel.getOneDayWrapper().observe(this, new Observer<Resource<List<OneDayWrapper>>>() {
            @Override
            public void onChanged(Resource<List<OneDayWrapper>> listResource) {
                if (listResource.status == Resource.Status.SUCCESS) {
                    mOneDayAdapter.setNewInstance(listResource.data);
                    mBinding.refreshLayout.setRefreshing(false);
                } else if (listResource.status == Resource.Status.LOADING) {
                    mBinding.refreshLayout.setRefreshing(true);
                } else {
                    mBinding.refreshLayout.setRefreshing(false);
                    Toast.makeText(getContext(), listResource.message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.refreshLayout.setColorSchemeResources(R.color.colorAccent);

        mBinding.refreshLayout.setOnRefreshListener(() -> mViewModel.reqOneDayInfo());
        mBinding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvList.setAdapter(mOneDayAdapter);

        mViewModel.reqOneDayInfo();
    }


    public static OneDayFragment newInstance() {
        Bundle args = new Bundle();
        OneDayFragment fragment = new OneDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

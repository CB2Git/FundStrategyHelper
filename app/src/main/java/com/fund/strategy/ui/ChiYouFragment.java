package com.fund.strategy.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentChiyouBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ChiYouFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "ChiYouFragment";

    private MainFragmentChiyouBinding mBinding;

    public static ChiYouFragment newInstance() {
        Bundle args = new Bundle();
        ChiYouFragment fragment = new ChiYouFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment_chiyou, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mBinding.mainAdd.setOnClickListener(this);

        mBinding.mainRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mBinding.mainRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mBinding.mainAdd.equals(v)) {
            Toast.makeText(getActivity(), "新增", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRefresh() {
        mBinding.mainRefreshLayout.setRefreshing(false);
    }
}

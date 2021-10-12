package com.fund.strategy.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cc.baselib.mvvm.BaseMVVMFragment;
import com.cc.baselib.mvvm.data.Resource;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.fund.strategy.R;
import com.fund.strategy.databinding.MainFragmentChiyouBinding;
import com.fund.strategy.model.api.entity.FundLatestInfo;
import com.fund.strategy.model.db.entity.ChiYouEntity;
import com.fund.strategy.mv.chiyou.ChiYouModel;
import com.fund.strategy.ui.adapter.ChiYouAdapter;
import com.fund.strategy.ui.widget.SwipeItemLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
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
                    Toast.makeText(getContext(), listResource.message, Toast.LENGTH_SHORT).show();
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

        mBinding.mainChiyouList.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(getActivity()));

        mChiYouAdapter.setOnItemChildClickListener((adapter, view, position) -> {

            if (view.getId() == R.id.lv_switch) {
                CollectionActivity.start(getActivity());
            }
        });

        mChiYouAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                showMenu(view, position);
                return true;
            }
        });
    }

    private void showMenu(@NonNull View view, int position) {
        FundLatestInfo fundLatestInfo = mChiYouAdapter.getData().get(position);
        ChiYouEntity chiYouEntity = mViewModel.queryChiYouInfo(fundLatestInfo.getFCODE());

        PopupMenu popupMenu = new PopupMenu(getActivity(), view, Gravity.END);
        Menu menu = popupMenu.getMenu();

        if (chiYouEntity.isTop == ChiYouEntity.IS_TOP) {
            menu.add(Menu.NONE, Menu.FIRST + 2, 2, "取消置顶");
        } else {
            menu.add(Menu.NONE, Menu.FIRST + 1, 1, "置顶");
        }
        menu.add(Menu.NONE, Menu.FIRST + 3, 3, "删除");

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    //置顶
                    case Menu.FIRST + 1:
                        mViewModel.changeTop(fundLatestInfo.getFCODE(), true);
                        break;
                    //取消置顶
                    case Menu.FIRST + 2:
                        mViewModel.changeTop(fundLatestInfo.getFCODE(), false);
                        break;
                    //删除
                    case Menu.FIRST + 3:
                        mViewModel.delete(fundLatestInfo.getFCODE());
                        break;
                }
                mViewModel.reqChiYouInfo();
                return true;
            }
        });
        popupMenu.show();
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

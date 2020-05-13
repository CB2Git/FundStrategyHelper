package com.fund.strategy.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.fund.strategy.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 自动切换子View可见的布局
 */
public class AutoSwitchVisibilityLayout extends FrameLayout {

    private static final String TAG_ERROR = "auto_default_error";

    private static final String TAG_LOADING = "auto_default_loading";

    private static final String TAG_EMPTY = "auto_default_empty";

    private static final int UN_ID = -1;

    private int mDefaultShowId = UN_ID;

    private int mErrorLayout = UN_ID;

    private int mLoadingLayout = UN_ID;

    private int mEmptyLayout = UN_ID;

    private OnErrorClickListener mOnErrorClickListener;

    private OnEmptyClickListener mOnEmptyClickListener;

    public AutoSwitchVisibilityLayout(@NonNull Context context) {
        this(context, null);
    }

    public AutoSwitchVisibilityLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoSwitchVisibilityLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoSwitchVisibilityLayout, defStyleAttr, 0);
        mDefaultShowId = typedArray.getResourceId(R.styleable.AutoSwitchVisibilityLayout_defaultShowId, mDefaultShowId);
        mErrorLayout = typedArray.getResourceId(R.styleable.AutoSwitchVisibilityLayout_errorLayout, mErrorLayout);
        mLoadingLayout = typedArray.getResourceId(R.styleable.AutoSwitchVisibilityLayout_loadingLayout, mLoadingLayout);
        mEmptyLayout = typedArray.getResourceId(R.styleable.AutoSwitchVisibilityLayout_emptyLayout, mEmptyLayout);
        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        showDefault();
    }

    public void setOnErrorClickListener(OnErrorClickListener onErrorClickListener) {
        mOnErrorClickListener = onErrorClickListener;
        View errorView = findViewWithTag(TAG_ERROR);
        if (errorView != null) {
            errorView.setOnClickListener(mOnClickListener);
        }
    }

    public void setOnEmptyClickListener(OnEmptyClickListener onEmptyClickListener) {
        mOnEmptyClickListener = onEmptyClickListener;
        View emptyView = findViewWithTag(TAG_EMPTY);
        if (emptyView != null) {
            emptyView.setOnClickListener(mOnClickListener);
        }
    }

    /**
     * 显示指定id的布局
     *
     * @param id
     */
    public void showVisibilityById(int id) {
        showViewAndHideOther(findViewById(id));
    }

    /**
     * 显示指定tag的布局
     *
     * @param tag
     */
    public void showVisibilityByTag(String tag) {
        showViewAndHideOther(findViewWithTag(tag));
    }

    /**
     * 显示指定View
     *
     * @param view
     */
    public void showVisibilityByView(View view) {
        showViewAndHideOther(view);
    }

    /**
     * 显示默认的布局
     */
    public void showDefault() {
        if (UN_ID != mDefaultShowId) {
            showVisibilityById(mDefaultShowId);
        } else {
            //默认一个布局都不显示
            showViewAndHideOther(null);
        }
    }

    /**
     * 显示加载中视图
     */
    public void showLoading() {
        if (mLoadingLayout != UN_ID) {
            View loadingView = findViewWithTag(TAG_LOADING);
            if (loadingView == null) {
                loadingView = View.inflate(getContext(), mLoadingLayout, null);
                LayoutParams layoutParams = generateLayoutParams();
                loadingView.setTag(TAG_LOADING);
                addView(loadingView, layoutParams);
            }
            showVisibilityByView(loadingView);
        }
    }

    public void showEmpty() {
        if (mEmptyLayout != UN_ID) {
            View emptyView = findViewWithTag(TAG_EMPTY);
            if (emptyView == null) {
                emptyView = View.inflate(getContext(), mEmptyLayout, null);
                LayoutParams layoutParams = generateLayoutParams();
                emptyView.setTag(TAG_LOADING);
                addView(emptyView, layoutParams);
                emptyView.setOnClickListener(mOnClickListener);
            }
            showVisibilityByView(emptyView);
        }
    }

    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (TAG_ERROR.equals(v.getTag())) {
                if (mOnErrorClickListener != null) {
                    mOnErrorClickListener.onErrorClick();
                }
            }
            if (TAG_EMPTY.equals(v.getTag())) {
                if (mOnEmptyClickListener != null) {
                    mOnEmptyClickListener.onEmptyClick();
                }
            }
        }
    };


    /**
     * 显示Error视图
     */
    public void showError() {
        if (mErrorLayout != UN_ID) {
            View errorView = findViewWithTag(TAG_ERROR);
            if (errorView == null) {
                errorView = View.inflate(getContext(), mErrorLayout, null);
                LayoutParams layoutParams = generateLayoutParams();
                errorView.setTag(TAG_ERROR);
                addView(errorView, layoutParams);
                errorView.setOnClickListener(mOnClickListener);
            }
            showVisibilityByView(errorView);
        }
    }

    private LayoutParams generateLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        return layoutParams;
    }

    private void showViewAndHideOther(@Nullable View view) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }

        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.equals(view)) {
                childAt.setVisibility(View.VISIBLE);
            } else {
                childAt.setVisibility(View.GONE);
            }
        }
    }

    public interface OnErrorClickListener {
        void onErrorClick();
    }

    public interface OnEmptyClickListener {
        void onEmptyClick();
    }
}
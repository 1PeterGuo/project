package com.example.guolei.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created on 2019/6/18 15:51
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public abstract class BaseFragment extends Fragment {


    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 获取要显示的页面布局
        View view = inflater.inflate(getFragmentLayoutId(), container, false);

        // ButterKnife 绑定当前Fragment
        mUnbinder = ButterKnife.bind(this, view);
        init(view);
        initListener();
        initData();

        return view;
    }

    protected abstract void init(View view);


    // 销毁当前Fragment页面时，ButterKnife 解除绑定
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    // 加载数据的抽象方法
    protected abstract void initData();

    // 加载点击事件的抽象方法
    protected abstract void initListener();

    // 加载布局ID 的抽象方法
    protected abstract int getFragmentLayoutId();
}

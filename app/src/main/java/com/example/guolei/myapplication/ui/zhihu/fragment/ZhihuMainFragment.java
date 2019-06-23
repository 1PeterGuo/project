package com.example.guolei.myapplication.ui.zhihu.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseFragment;
import com.example.guolei.myapplication.base.IView;
import com.example.guolei.myapplication.ui.zhihu.adapter.ZhihuPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuMainFragment extends BaseFragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private List<ZhihuMainSubFragment> mList;
    private String[] mStrTitle = {"日报", "主题", "专栏", "热门"};

    @Override
    protected void init(View view) {

        mList = new ArrayList<>();

        for (int i = 0; i < mStrTitle.length; i++) {
            ZhihuMainSubFragment subFragment = ZhihuMainSubFragment.getFragmentInstance(i, "");
            mList.add(subFragment);
        }

        ZhihuPagerAdapter pagerAdapter = new ZhihuPagerAdapter(getChildFragmentManager(), mList, mStrTitle);
        vp.setAdapter(pagerAdapter);
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_zhihu_main;
    }


}

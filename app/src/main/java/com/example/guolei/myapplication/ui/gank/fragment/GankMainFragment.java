package com.example.guolei.myapplication.ui.gank.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseFragment;
import com.example.guolei.myapplication.base.IView;
import com.example.guolei.myapplication.ui.gank.adapter.GankPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankMainFragment extends BaseFragment {


    @BindView(R.id.tabLayout_gank)
    TabLayout tabLayoutGank;
    @BindView(R.id.viewPager_gank)
    ViewPager viewPagerGank;
    private List<GankMainSubFragment> mList;
    public static String[] mStTitle = {"Android", "iOS", "前端", "福利"};

    @Override
    protected void init(View view) {

        mList = new ArrayList<>();

        // 通过for循环添加子项Fragment对象到集合中
        for (int i = 0; i < mStTitle.length; i++) {
            GankMainSubFragment subFragment = GankMainSubFragment.getFragmentInstance(i, "");
            mList.add(subFragment);
        }

        // viewpager设置适配器并且与tablayout关联
        GankPagerAdapter pagerAdapter = new GankPagerAdapter(getChildFragmentManager(), mList, mStTitle);
        viewPagerGank.setAdapter(pagerAdapter);
        tabLayoutGank.setupWithViewPager(viewPagerGank);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_gank_main;
    }


}

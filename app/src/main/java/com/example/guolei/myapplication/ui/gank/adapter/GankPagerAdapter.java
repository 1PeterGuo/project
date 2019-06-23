package com.example.guolei.myapplication.ui.gank.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guolei.myapplication.ui.gank.fragment.GankMainSubFragment;

import java.util.List;

/**
 * Created on 2019/6/20 19:35
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class GankPagerAdapter extends FragmentPagerAdapter {

    private List<GankMainSubFragment> mList;
    private String[] mStrTitles;

    public GankPagerAdapter(FragmentManager fm, List<GankMainSubFragment> list, String[] strTitles) {
        super(fm);
        mList = list;
        mStrTitles = strTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStrTitles[position];
    }
}

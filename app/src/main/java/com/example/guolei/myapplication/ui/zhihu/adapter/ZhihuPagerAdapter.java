package com.example.guolei.myapplication.ui.zhihu.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guolei.myapplication.ui.zhihu.fragment.ZhihuMainSubFragment;

import java.util.List;

/**
 * Created on 2019/6/19 09:54
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class ZhihuPagerAdapter extends FragmentPagerAdapter {

    private List<ZhihuMainSubFragment> mList;
    private String[] mStrTitles;

    public ZhihuPagerAdapter(FragmentManager fm, List<ZhihuMainSubFragment> list, String[] strTitles) {
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

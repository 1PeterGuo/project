package com.example.guolei.myapplication.ui.zhihu.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseFragment;
import com.example.guolei.myapplication.base.IView;
import com.example.guolei.myapplication.model.entity.zhihu.ReMenInfo;
import com.example.guolei.myapplication.model.entity.zhihu.RiBaoInfo;
import com.example.guolei.myapplication.model.entity.zhihu.ZhuTiInfo;
import com.example.guolei.myapplication.model.entity.zhihu.ZhuanLanInfo;
import com.example.guolei.myapplication.presenter.zhihu.ZhihuSubPresenter;
import com.example.guolei.myapplication.ui.zhihu.adapter.ZhiHuSubRecyclerAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ZhihuMainSubFragment extends BaseFragment implements IView {

    public static final int SUB_RIBAO_FRAGMENT = 0;
    public static final int SUB_ZHUTI_FRAGMENT = 1;
    public static final int SUB_ZHUANLAN_FRAGMENT = 2;
    public static final int SUB_REMEN_FRAGMENT = 3;
    private static final String TAG = "ZhihuMainSubFragment";
    private int mType;
    private RecyclerView mRecyclerView;
    private ZhihuSubPresenter mZhihuSubPresenter;
    private ProgressBar mProgress;


    public ZhihuMainSubFragment(int i) {
        super();
        this.mType = i;
    }

    // 通过type 判断要使用哪个页面的布局
    @Override
    protected void init(View view) {

        mProgress = view.findViewById(R.id.progressbar);
        mRecyclerView = view.findViewById(R.id.sub_ribao_rlv);
        switch (mType) {
            case SUB_RIBAO_FRAGMENT:
                initRiBaoView(view);
                break;
            case SUB_ZHUTI_FRAGMENT:
                initZhuTiView(view);
                break;
            case SUB_ZHUANLAN_FRAGMENT:
                initZhuanLanView(view);
                break;
            case SUB_REMEN_FRAGMENT:
                initReMenView(view);
                break;
        }
    }

    private void initReMenView(View view) {
        initRiBaoView(view);
    }

    private void initZhuanLanView(View view) {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(manager);
    }

    private void initZhuTiView(View view) {
    }

    private void initRiBaoView(View view) {
        Log.d(TAG, "initRiBaoView: " + "开始加载日报");
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }

    // 通过type 设置加载的数据
    @Override
    protected void initData() {
        mZhihuSubPresenter = new ZhihuSubPresenter(this);
        mZhihuSubPresenter.start(mType);
    }

    @Override
    protected void initListener() {

    }

    public static ZhihuMainSubFragment getFragmentInstance(int i, String strValue) {
        ZhihuMainSubFragment fragment = new ZhihuMainSubFragment(i);
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(strValue))
            bundle.putString(ZhihuMainSubFragment.class.getSimpleName(), "");
        else
            bundle.putString(ZhihuMainSubFragment.class.getSimpleName(), strValue);
        fragment.setArguments(bundle);

        return fragment;

    }


    @Override
    protected int getFragmentLayoutId() {

        switch (mType) {
            case SUB_RIBAO_FRAGMENT:
                return R.layout.fragment_zhihu_main_sub_ribao;
            case SUB_ZHUTI_FRAGMENT:
                return R.layout.fragment_zhihu_main_sub_zhuti;
            case SUB_ZHUANLAN_FRAGMENT:
                return R.layout.fragment_zhihu_main_sub_zhuanlan;
            case SUB_REMEN_FRAGMENT:
                return R.layout.fragment_zhihu_main_sub_remen;
        }

        return 0;
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object o) {

        if (o instanceof RiBaoInfo) {

            RiBaoInfo riBaoInfo = (RiBaoInfo) o;
            Log.d(TAG, "onSuccess: " + riBaoInfo.toString());

            List<RiBaoInfo.StoriesBean> stories = riBaoInfo.getStories();
            List<RiBaoInfo.TopStoriesBean> top_stories = riBaoInfo.getTop_stories();

            ZhiHuSubRecyclerAdapter adapter = new ZhiHuSubRecyclerAdapter(getContext(), stories, top_stories, mType);
            mRecyclerView.setAdapter(adapter);


        } else if (o instanceof ZhuTiInfo) {

            ZhuTiInfo zhuTiInfo = (ZhuTiInfo) o;

        } else if (o instanceof ZhuanLanInfo) {

            ZhuanLanInfo zhuanLanInfo = (ZhuanLanInfo) o;
            List<ZhuanLanInfo.DataBean> data = zhuanLanInfo.getData();
            Log.d(TAG, "onSuccess: "+data.toString());

            ZhiHuSubRecyclerAdapter adapter = new ZhiHuSubRecyclerAdapter(getContext(),
                    data, mType);
            mRecyclerView.setAdapter(adapter);


        } else if (o instanceof ReMenInfo) {

            ReMenInfo reMenInfo = (ReMenInfo) o;
            List<ReMenInfo.RecentBean> recent = reMenInfo.getRecent();

            ZhiHuSubRecyclerAdapter adapter = new ZhiHuSubRecyclerAdapter(getContext(),
                    recent, mType, mType);
            mRecyclerView.setAdapter(adapter);


        }


    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), "加载失败" + msg
                , Toast.LENGTH_SHORT).show();
    }
}

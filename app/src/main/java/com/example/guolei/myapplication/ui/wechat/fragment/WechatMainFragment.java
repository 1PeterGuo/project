package com.example.guolei.myapplication.ui.wechat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseFragment;
import com.example.guolei.myapplication.base.IView;
import com.example.guolei.myapplication.model.entity.wechat.WeChatInfo;
import com.example.guolei.myapplication.presenter.wechat.WeChatPresenter;
import com.example.guolei.myapplication.ui.wechat.adapter.WeChatAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatMainFragment extends BaseFragment implements IView {

    RecyclerView recyclerWeChat;
    private int page = 1;
    private WeChatPresenter mWeChatPresenter;
    private RefreshLayout mRefreshLayout;
    private List<WeChatInfo.NewslistBean> mList;
    private WeChatAdapter mAdapter;


    @Override
    protected void init(View view) {

        // 获取当前页面的控件对象
        recyclerWeChat = view.findViewById(R.id.recycler_weChat);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        mList = new ArrayList<>();

        // 设置显示方式
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerWeChat.setLayoutManager(manager);

        // 设置适配器
        mAdapter = new WeChatAdapter(getActivity(), mList);
        recyclerWeChat.setAdapter(mAdapter);


        // 刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                initData();
                refreshlayout.finishRefresh();
            }
        });

        // 加载更多
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                initData();
                refreshlayout.finishLoadmore();
            }
        });

    }

    @Override
    protected void initData() {

        mWeChatPresenter = new WeChatPresenter(this);
        mWeChatPresenter.start(page);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_wechat_main;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(Object o) {

        if (page == 1) {
            mList.clear();
        }

        WeChatInfo weChatInfo = (WeChatInfo) o;

        List<WeChatInfo.NewslistBean> newslist = weChatInfo.getNewslist();
        mList.addAll(newslist);

        mAdapter.setNewsList(mList);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getActivity(), "加载失败" + msg
                , Toast.LENGTH_SHORT).show();
    }
}

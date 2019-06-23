package com.example.guolei.myapplication.ui.gank.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseFragment;
import com.example.guolei.myapplication.base.IView;
import com.example.guolei.myapplication.model.entity.gank.FuliInfo;
import com.example.guolei.myapplication.model.entity.gank.TechInfo;
import com.example.guolei.myapplication.presenter.gank.GankSubPresenter;
import com.example.guolei.myapplication.ui.gank.adapter.GankSubRecyclerAdapter;
import com.example.guolei.myapplication.utils.SystemUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created on 2019/6/20 19:26
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
@SuppressLint("ValidFragment")
public class GankMainSubFragment extends BaseFragment implements IView {

    public static final int SUB_ANDROID_FRAGMENT = 0;
    public static final int SUB_IOS_FRAGMENT = 1;
    public static final int SUB_QIANDUAN_FRAGMENT = 2;
    public static final int SUB_FULI_FRAGMENT = 3;


    private ImageView ivTechBlur;
    private ImageView ivTechOrigin;
    private TextView tvTechCopyright;
    private AppBarLayout techAppbar;


    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private int mType;
    private int page = 1;
    private Context mContext;
    private GankSubPresenter mGankSubPresenter;
    private List<FuliInfo.ResultsBean> mGrilList = new ArrayList<>();
    private List<TechInfo.ResultsBean> mTechList = new ArrayList<>();

    private static final String TAG = "GankMainSubFragment";
    private GankSubRecyclerAdapter mGrilAdapter;
    private GankSubRecyclerAdapter mTechAdapter;


    public GankMainSubFragment(int i) {
        super();
        this.mType = i;
    }

    // 获取Gank 子项Fragment的对象，并给Fragment传值
    public static GankMainSubFragment getFragmentInstance(int i, String strValue) {

        GankMainSubFragment fragment = new GankMainSubFragment(i);
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(strValue))
            bundle.putString(GankMainSubFragment.class.getSimpleName(), "");
        else
            bundle.putString(GankMainSubFragment.class.getSimpleName(), strValue);
        fragment.setArguments(bundle);

        return fragment;

    }


    @Override
    protected void init(View view) {

        mContext = getContext();
        mRecyclerView = view.findViewById(R.id.recycler_gank);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        switch (mType) {
            case SUB_ANDROID_FRAGMENT:
                initTech(view);
                break;
            case SUB_IOS_FRAGMENT:
                initTech(view);
                break;

            case SUB_QIANDUAN_FRAGMENT:
                initTech(view);
                break;

            case SUB_FULI_FRAGMENT:
                initGril(view);
                break;

        }


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

    private void initGril(View view) {

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(manager);

        mGrilAdapter = new GankSubRecyclerAdapter(mContext, mGrilList, mType, mType);
        mRecyclerView.setAdapter(mGrilAdapter);

    }


    private void initTech(View view) {

        ivTechBlur = view.findViewById(R.id.iv_tech_blur);
        ivTechOrigin = view.findViewById(R.id.iv_tech_origin);
        tvTechCopyright = view.findViewById(R.id.tv_tech_copyright);
        techAppbar = view.findViewById(R.id.tech_appbar);

        mTechAdapter = new GankSubRecyclerAdapter(mContext, mTechList, mType);
        mRecyclerView.setAdapter(mTechAdapter);


        techAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset >= 0) {

                } else {
                    float rate = (float) (SystemUtil.dp2px(mContext, 256) + verticalOffset * 2) / SystemUtil.dp2px(mContext, 256);
                    if (rate >= 0)
                        ivTechOrigin.setAlpha(rate);
                }


            }
        });


        Glide.with(mContext)
                .load("https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(mContext, 14, 3)))
                .into(ivTechBlur);

        tvTechCopyright.setText(String.format("by: %s", "lijinshanmx"));


        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);


    }

    @Override
    protected void initData() {
        mGankSubPresenter = new GankSubPresenter(this);
        mGankSubPresenter.start(mType, page);
    }

    @Override
    protected void initListener() {

    }

    // 通过type 类型设置要显示的fragment页面
    @Override
    protected int getFragmentLayoutId() {

        if (mType == GankMainSubFragment.SUB_ANDROID_FRAGMENT || mType == GankMainSubFragment.SUB_IOS_FRAGMENT || mType == GankMainSubFragment.SUB_QIANDUAN_FRAGMENT) {
            return R.layout.fragment_gank_main_sub_android;
        } else if (mType == GankMainSubFragment.SUB_FULI_FRAGMENT) {
            return R.layout.fragment_gank_main_sub_fuli;
        }

        return 0;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(Object o) {

        if (o instanceof TechInfo) {
            TechInfo techInfo = (TechInfo) o;

            List<TechInfo.ResultsBean> results = techInfo.getResults();

            mTechList.addAll(results);


            mTechAdapter.setTechList(mTechList);
            mTechAdapter.notifyDataSetChanged();


        } else if (o instanceof FuliInfo) {

            FuliInfo fuliInfo = (FuliInfo) o;

            List<FuliInfo.ResultsBean> results = fuliInfo.getResults();
            Log.d(TAG, "onSuccess: " + results.size());

            mGrilList.addAll(results);

            mGrilAdapter.setGrilList(mGrilList);
            mGrilAdapter.notifyDataSetChanged();


        }


    }

    @Override
    public void onFail(String msg) {

    }

}

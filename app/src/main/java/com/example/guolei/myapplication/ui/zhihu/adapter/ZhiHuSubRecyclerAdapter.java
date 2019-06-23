package com.example.guolei.myapplication.ui.zhihu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.model.entity.zhihu.ReMenInfo;
import com.example.guolei.myapplication.model.entity.zhihu.RiBaoInfo;
import com.example.guolei.myapplication.model.entity.zhihu.ZhuanLanInfo;
import com.example.guolei.myapplication.ui.zhihu.fragment.ZhihuMainSubFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/6/19 10:56
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class ZhiHuSubRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "ZhiHuSubRecyclerAdapter";
    private Context mContext;
    private List<RiBaoInfo.StoriesBean> mStories;
    private List<RiBaoInfo.TopStoriesBean> mTopStories;
    private List<ZhuanLanInfo.DataBean> mData;
    private List<ReMenInfo.RecentBean> mRecent;
    private int mType;
    private int ITEM_TYPE = 0;


    public ZhiHuSubRecyclerAdapter(Context context, List<RiBaoInfo.StoriesBean> stories, List<RiBaoInfo.TopStoriesBean> topStories, int type) {
        mContext = context;
        mStories = stories;
        mTopStories = topStories;
        mType = type;
    }


    public ZhiHuSubRecyclerAdapter(Context context, List<ZhuanLanInfo.DataBean> data, int type2) {
        mContext = context;
        mData = data;
        mType = type2;
    }

    public ZhiHuSubRecyclerAdapter(Context context, List<ReMenInfo.RecentBean> recent, int type3, int type) {
        mContext = context;
        mRecent = recent;
        mType = type3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder viewHolder = null;
        switch (mType) {
            // 日报
            case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:

                if (ITEM_TYPE == 0) {
                    View riBaoBannerView = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_main_sub_ribao_banner, parent, false);
                    viewHolder = new MyViewHolder(riBaoBannerView);
                } else {
                    View riBaoOtherView = LayoutInflater.from(mContext).inflate(R.layout.item_zhihu_main_sub_ribao, parent, false);
                    viewHolder = new MyViewHolder(riBaoOtherView);
                }

                break;
            // 主题
            case ZhihuMainSubFragment.SUB_ZHUTI_FRAGMENT:

                break;
            // 专栏
            case ZhihuMainSubFragment.SUB_ZHUANLAN_FRAGMENT:
                View zhuanLanView = View.inflate(mContext, R.layout.item_zhihu_main_sub_zhuanlan, null);
                viewHolder = new MyViewHolder(zhuanLanView);
                break;
            // 热门
            case ZhihuMainSubFragment.SUB_REMEN_FRAGMENT:
                View reMenView = View.inflate(mContext, R.layout.item_zhihu_main_sub_remen, null);
                viewHolder = new MyViewHolder(reMenView);
                break;
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (mType) {
            // 日报
            case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:


                MyViewHolder riBaoViewHolder = (MyViewHolder) holder;

                if (ITEM_TYPE == 0) {

                    List<String> mTitles = new ArrayList<>();
                    List<String> mImages = new ArrayList<>();

                    for (RiBaoInfo.TopStoriesBean bean : mTopStories) {
                        String title = bean.getTitle();
                        String image = bean.getImage();
                        mTitles.add(title);
                        mImages.add(image);
                    }

                    riBaoViewHolder.mBanner.setBannerTitles(mTitles);
                    riBaoViewHolder.mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                    riBaoViewHolder.mBanner.setImages(mImages).setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(mContext).load(path).into(imageView);
                        }
                    });
                    riBaoViewHolder.mBanner.start();

                    if (mStories.size() > 0) {
                        riBaoViewHolder.mTitle.setVisibility(View.GONE);

                    } else {
                        riBaoViewHolder.mTitle.setVisibility(View.VISIBLE);
                    }

                } else {

                    if (mStories.size() > 0) {

                        int newPosition = position;
                        if (mTopStories.size() > 0) {
                            newPosition = position - 1;
                        }
                        RiBaoInfo.StoriesBean storiesBean = mStories.get(newPosition);
                        Log.d(TAG, "onBindViewHolder: " + storiesBean.toString());


                        riBaoViewHolder.mContent.setText(storiesBean.getTitle());
                        Glide.with(mContext).load(storiesBean.getImages().get(0)).into(riBaoViewHolder.mIv);
                    }

                }


                break;
            // 主题
            case ZhihuMainSubFragment.SUB_ZHUTI_FRAGMENT:

                break;
            // 专栏
            case ZhihuMainSubFragment.SUB_ZHUANLAN_FRAGMENT:

                ZhuanLanInfo.DataBean dataBean = mData.get(position);

                MyViewHolder zhuanlanViewHolder = (MyViewHolder) holder;

                Glide.with(mContext).load(dataBean.getThumbnail()).into(zhuanlanViewHolder.mIv);
                zhuanlanViewHolder.mContent.setText(dataBean.getDescription());
                zhuanlanViewHolder.mTitle.setText(dataBean.getName());


                break;
            // 热门
            case ZhihuMainSubFragment.SUB_REMEN_FRAGMENT:

                ReMenInfo.RecentBean recentBean = mRecent.get(position);

                MyViewHolder reMenViewHolder = (MyViewHolder) holder;

                Glide.with(mContext).load(recentBean.getThumbnail()).into(reMenViewHolder.mIv);
                reMenViewHolder.mContent.setText(recentBean.getTitle());



                break;
        }

    }

    @Override
    public int getItemCount() {

        switch (mType) {
            // 日报
            case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:

                if (mTopStories.size() > 0) {
                    return mStories.size() + 1;
                } else {
                    return mStories.size();
                }

                // 主题
            case ZhihuMainSubFragment.SUB_ZHUTI_FRAGMENT:

                break;
            // 专栏
            case ZhihuMainSubFragment.SUB_ZHUANLAN_FRAGMENT:

                return mData.size();

            // 热门
            case ZhihuMainSubFragment.SUB_REMEN_FRAGMENT:

                return mRecent.size();

        }


        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private Banner mBanner;
        private ImageView mIv;
        private TextView mTitle;
        private TextView mContent;

        public MyViewHolder(View itemView) {
            super(itemView);

            switch (mType) {
                // 日报
                case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:

                    if (ITEM_TYPE == 0) {
                        mBanner = itemView.findViewById(R.id.banner_ribao_item);
                        mTitle = itemView.findViewById(R.id.title_ribao_item);
                    } else {
                        mIv = itemView.findViewById(R.id.iv_ribao_item);
                        mContent = itemView.findViewById(R.id.tv_ribao_item);
                    }
                    break;

                // 主题
                case ZhihuMainSubFragment.SUB_ZHUTI_FRAGMENT:

                    break;
                // 专栏
                case ZhihuMainSubFragment.SUB_ZHUANLAN_FRAGMENT:

                    mIv = itemView.findViewById(R.id.iv_zhuanlan_item);
                    mContent = itemView.findViewById(R.id.tv_description_zhuanlan_item);
                    mTitle = itemView.findViewById(R.id.tv_name_zhuanlan_item);

                    break;
                // 热门
                case ZhihuMainSubFragment.SUB_REMEN_FRAGMENT:

                    mIv = itemView.findViewById(R.id.iv_remen_item);
                    mContent = itemView.findViewById(R.id.tv_remen_item);

                    break;
            }


        }

    }


    @Override
    public int getItemViewType(int position) {

        switch (mType) {
            case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:
                if (position == 0) {
                    ITEM_TYPE = 0;
                    return ITEM_TYPE;
                } else {
                    ITEM_TYPE = 1;
                    return ITEM_TYPE;
                }
        }

        return position;
    }
}

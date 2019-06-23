package com.example.guolei.myapplication.ui.gank.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.model.entity.gank.FuliInfo;
import com.example.guolei.myapplication.model.entity.gank.TechInfo;
import com.example.guolei.myapplication.ui.gank.fragment.GankMainSubFragment;
import com.example.guolei.myapplication.utils.DisplayUtil;

import java.util.List;

/**
 * Created on 2019/6/20 20:05
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class GankSubRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<TechInfo.ResultsBean> mTechList;
    private List<FuliInfo.ResultsBean> mGrilList;
    private int mType;

    public GankSubRecyclerAdapter(Context context, List<FuliInfo.ResultsBean> grilList, int type, int type2) {
        mContext = context;
        mGrilList = grilList;
        mType = type;
    }

    public GankSubRecyclerAdapter(Context context, List<TechInfo.ResultsBean> techList, int type) {
        mContext = context;
        mTechList = techList;
        mType = type;
    }

    public void setGrilList(List<FuliInfo.ResultsBean> grilList) {
        mGrilList = grilList;
        setImageScale();
    }

    public void setTechList(List<TechInfo.ResultsBean> techList) {
        mTechList = techList;
    }

    private void setImageScale() {
        for (final FuliInfo.ResultsBean girlBean : mGrilList) {

            if (girlBean.getScale() == 0) {

                Glide.with(mContext).load(girlBean.getUrl()).into(new SimpleTarget<Drawable>() {

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition.Transition<? super Drawable> transition) {
                        float scale = resource.getIntrinsicWidth() / (float) resource.getIntrinsicHeight();
                        girlBean.setScale(scale);
                        notifyDataSetChanged();
                    }
                });

            } else {
                notifyDataSetChanged();
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder viewHolder = null;

        if (mType == GankMainSubFragment.SUB_ANDROID_FRAGMENT || mType==GankMainSubFragment.SUB_IOS_FRAGMENT || mType == GankMainSubFragment.SUB_QIANDUAN_FRAGMENT ){
            View techView = LayoutInflater.from(mContext).inflate(R.layout.item_gank_main_sub_tech, null, false);
            viewHolder = new MyViewHolder(techView);
        }else if (mType == GankMainSubFragment.SUB_FULI_FRAGMENT){
            View grilView = LayoutInflater.from(mContext).inflate(R.layout.item_gank_main_sub_gril, null, false);
            viewHolder = new MyViewHolder(grilView);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (mType == GankMainSubFragment.SUB_ANDROID_FRAGMENT || mType==GankMainSubFragment.SUB_IOS_FRAGMENT || mType == GankMainSubFragment.SUB_QIANDUAN_FRAGMENT ){
            MyViewHolder techViewHolder = (MyViewHolder) holder;

            TechInfo.ResultsBean resultsBean = mTechList.get(position);

            String publishedAt = resultsBean.getPublishedAt();
            String substring = publishedAt.substring(0, 10);

            techViewHolder.mTitle.setText(resultsBean.getDesc());
            techViewHolder.mAuthor.setText(resultsBean.getWho());
            techViewHolder.mTime.setText(substring);
        }else if (mType == GankMainSubFragment.SUB_FULI_FRAGMENT){
            MyViewHolder grilViewHolder = (MyViewHolder) holder;

            FuliInfo.ResultsBean resultsBean1 = mGrilList.get(position);

            final ViewGroup.LayoutParams layoutParams = grilViewHolder.mIv.getLayoutParams();
            layoutParams.width = DisplayUtil.getScreenWidth((Activity) mContext) / 2 - DisplayUtil.dp2px(mContext, 8);
            if (resultsBean1.getScale() != 0) {
                layoutParams.height = (int) (layoutParams.width / resultsBean1.getScale());
            }
            grilViewHolder.mIv.setBackgroundColor(Color.BLUE);

            Glide.with(mContext)
                    .load(resultsBean1.getUrl())
                    .transition(new DrawableTransitionOptions().crossFade())
                    .into(grilViewHolder.mIv);
        }

    }

    @Override
    public int getItemCount() {

        if (mType == GankMainSubFragment.SUB_ANDROID_FRAGMENT || mType==GankMainSubFragment.SUB_IOS_FRAGMENT || mType == GankMainSubFragment.SUB_QIANDUAN_FRAGMENT ){
            return mTechList.size();
        }else if (mType == GankMainSubFragment.SUB_FULI_FRAGMENT){
            return mGrilList.size();
        }

        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mAuthor;
        private TextView mTime;
        private ImageView mIv;

        public MyViewHolder(View itemView) {
            super(itemView);


            if (mType == GankMainSubFragment.SUB_ANDROID_FRAGMENT || mType==GankMainSubFragment.SUB_IOS_FRAGMENT || mType == GankMainSubFragment.SUB_QIANDUAN_FRAGMENT ){
                mTitle = itemView.findViewById(R.id.tv_tech_title);
                mAuthor = itemView.findViewById(R.id.tv_tech_author);
                mTime = itemView.findViewById(R.id.tv_tech_time);
            }else if (mType == GankMainSubFragment.SUB_FULI_FRAGMENT){
                mIv = itemView.findViewById(R.id.iv_gril_gank);
            }

        }

    }


}

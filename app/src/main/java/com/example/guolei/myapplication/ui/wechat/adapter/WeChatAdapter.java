package com.example.guolei.myapplication.ui.wechat.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.model.entity.wechat.WeChatInfo;

import java.util.List;

/**
 * Created on 2019/6/20 15:08
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.ViewHolder> {


    private Context mContext;
    private List<WeChatInfo.NewslistBean> mNewsList;

    public WeChatAdapter(Context context, List<WeChatInfo.NewslistBean> newsList) {
        mContext = context;
        mNewsList = newsList;
    }

    public void setNewsList(List<WeChatInfo.NewslistBean> newsList) {
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_wechat_main, null, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        WeChatInfo.NewslistBean newslistBean = mNewsList.get(position);

        Glide.with(mContext).load(newslistBean.getPicUrl()).into(holder.mIv);
        holder.mTitle.setText(newslistBean.getTitle());
        holder.mFrom.setText(newslistBean.getDescription());
        holder.mTime.setText(newslistBean.getCtime());

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTitle;
        private TextView mFrom;
        private TextView mTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_wechat_item_image);
            mFrom = itemView.findViewById(R.id.tv_wechat_item_from);
            mTime = itemView.findViewById(R.id.tv_wechat_item_time);
            mTitle = itemView.findViewById(R.id.tv_wechat_item_title);
        }

    }
}

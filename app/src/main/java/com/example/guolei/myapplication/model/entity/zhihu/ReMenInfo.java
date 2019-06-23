package com.example.guolei.myapplication.model.entity.zhihu;

import java.util.List;

public class ReMenInfo {

    private List<RecentBean> recent;

    public List<RecentBean> getRecent() {
        return recent;
    }

    public void setRecent(List<RecentBean> recent) {
        this.recent = recent;
    }

    public static class RecentBean {
        /**
         * news_id : 9712451
         * url : http://news-at.zhihu.com/api/2/news/9712451
         * thumbnail : https://pic2.zhimg.com/v2-12e079a78e53bbac30d4a4d91b5cef15.jpg
         * title : 羊的瞳孔为什么是长方形的？
         */

        private int news_id;
        private String url;
        private String thumbnail;
        private String title;

        public int getNews_id() {
            return news_id;
        }

        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

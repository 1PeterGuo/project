package com.example.guolei.myapplication.model.entity.zhihu;

import java.util.List;

public class RiBaoInfo {
    /**
     * date : 20190617
     * stories : [{"images":["https://pic4.zhimg.com/v2-aa3e6e4d30ebdf4c2090b7517d86219f.jpg"],"type":0,"id":9712467,"ga_prefix":"061709","title":"电子乐器会取代传统乐器吗？"},{"images":["https://pic4.zhimg.com/v2-ef18bdd48c97fd307c1ce067477acf47.jpg"],"type":0,"id":9712474,"ga_prefix":"061707","title":"地理条件对一个国家有多大影响？"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-c65db16f0112654dd468f31d6a688376.jpg","type":0,"id":9712517,"ga_prefix":"061320","title":"为什么《新闻联播》结束后总有播音员在收拾稿子的片段？"},{"image":"https://pic3.zhimg.com/v2-24c4a2bf686983e4df3c8d00bd019cd6.jpg","type":0,"id":9712380,"ga_prefix":"061120","title":"我发现了《X 战警：黑凤凰》最大的问题"},{"image":"https://pic1.zhimg.com/v2-af99447ded7fe236a2113bfae6f3aad8.jpg","type":0,"id":9712095,"ga_prefix":"060407","title":"Uniqlo x KAWS 的发售「乱象」，是怎么出现的？"},{"image":"https://pic1.zhimg.com/v2-cbc334204e7ffb639735367122eff48c.jpg","type":0,"id":9712142,"ga_prefix":"060408","title":"旗帜鲜明地反对断骨增高手术"},{"image":"https://pic1.zhimg.com/v2-96666b0894871ab0dbcf76dcccac6c40.jpg","type":0,"id":9712046,"ga_prefix":"060308","title":"结婚 5 年，双方父母没见面，过年各回各家，Papi 酱的婚姻模式适合你吗？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-aa3e6e4d30ebdf4c2090b7517d86219f.jpg"]
         * type : 0
         * id : 9712467
         * ga_prefix : 061709
         * title : 电子乐器会取代传统乐器吗？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic3.zhimg.com/v2-c65db16f0112654dd468f31d6a688376.jpg
         * type : 0
         * id : 9712517
         * ga_prefix : 061320
         * title : 为什么《新闻联播》结束后总有播音员在收拾稿子的片段？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        @Override
        public String toString() {
            return "TopStoriesBean{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RiBaoInfo{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}

package com.example.guolei.myapplication.model.entity.gank;

import java.util.List;

/**
 * Created on 2019/6/20 20:20
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class TechInfo {


    /**
     * error : false
     * results : [{"_id":"5d0214689d212203197e0f1e","createdAt":"2019-06-13T09:16:24.944Z","desc":"自定义红点控件，不用修改之前的代码，完全解耦，可以支持设置在TextView，Button，LinearLayout，RelativeLayout，TabLayout等等控件上\u2026\u2026","images":["http://img.gank.io/be00e66e-cb86-4f46-8e92-47609045a571"],"publishedAt":"2019-06-13T09:16:45.189Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCRedDotView","used":true,"who":"潇湘剑雨"},{"_id":"5d00fd349d2122031b798097","createdAt":"2019-06-12T13:25:08.262Z","desc":"🦌 Flutter 学习练手项目。包括完整UI设计图，更贴近真实项目的练习。","publishedAt":"2019-06-13T06:33:47.258Z","source":"web","type":"Android","url":"https://github.com/simplezhli/flutter_deer","used":true,"who":"潇湘剑雨"},{"_id":"5d01a2319d2122031ea521fc","createdAt":"2019-06-13T01:09:05.990Z","desc":"谁的Bug指给了我？害我损失5W奖金！","publishedAt":"2019-06-13T06:33:40.443Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/Jl-nSxn1LpSMe2rxxMxxHA","used":true,"who":"潇湘剑雨"},{"_id":"5cff1bb49d2122031b798092","createdAt":"2019-06-11T03:10:44.937Z","desc":"BaseUrlManager 主要用于开发时，有多个环境需要打包APK的场景，通过BaseUrlManager提供的BaseUrl动态设置入口，只需打一次包，即可轻松随意的切换不同的开发环境或测试环境。在打生产环境包时，关闭BaseUrl动态设置入口即可。","publishedAt":"2019-06-12T01:02:00.437Z","source":"web","type":"Android","url":"https://github.com/jenly1314/BaseUrlManager","used":true,"who":"潇湘剑雨"},{"_id":"5cfdf5d29d212203197e0f15","createdAt":"2019-06-10T06:16:50.467Z","desc":"Flutter 版本一系列设计简洁的 loading 动画","images":["http://img.gank.io/fb426ead-5bf4-497f-aacf-76c326d5081a"],"publishedAt":"2019-06-10T10:43:48.459Z","source":"web","type":"Android","url":"https://github.com/Hitomis/loading_indicator_view","used":true,"who":"潇湘剑雨"},{"_id":"5cf75b4a9d212203197e0f0d","createdAt":"2019-06-05T06:03:54.304Z","desc":"使用MotionLayout实现高德地图bottomSheets效果","publishedAt":"2019-06-06T06:07:46.28Z","source":"web","type":"Android","url":"https://juejin.im/post/5cf634405188253d271539be","used":true,"who":"lijinshanmx"},{"_id":"5cf63ef59d2122031b798082","createdAt":"2019-06-04T10:02:17.733Z","desc":"Flutter完整开发实战详解系列，本系列将完整讲述：如何快速从 0 开发一个完整的 Flutter APP，配套高完成度 Flutter 开源项目 GSYGithubAppFlutter ","publishedAt":"2019-06-04T10:02:20.444Z","source":"web","type":"Android","url":"https://github.com/CarGuo/GSYFlutterBook","used":true,"who":"潇湘剑雨"},{"_id":"5cab4c3b9d2122031fe2f24e","createdAt":"2019-04-08T13:27:23.724Z","desc":"高仿探探首页波纹扫描效果","publishedAt":"2019-05-29T01:31:18.861Z","source":"web","type":"Android","url":"https://github.com/hewking/TanTanRippleView","used":true,"who":"潇湘剑雨"},{"_id":"5ce691599d212239da9c6adc","createdAt":"2019-05-23T12:26:01.611Z","desc":"Google Jetpack 新组件 CameraX 使用，早用早享受，轻松开发 Camera 应用","publishedAt":"2019-05-25T02:05:04.204Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/geCmI9XovmxyaA437JIewg","used":true,"who":"lijinshanmx"},{"_id":"5ce52e419d212239d75618af","createdAt":"2019-05-22T11:10:57.722Z","desc":"基于 Kotlin+模块化+响应式+MVVM 实现的风格简约、代码优雅的WanAndroid客户端","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1g3dc66v192j30u01hc4b7","https://ww1.sinaimg.cn/large/0073sXn7gy1g3dc68iurdj30u01hcti9","https://ww1.sinaimg.cn/large/0073sXn7gy1g3dc69igm5j30u01hc763","https://ww1.sinaimg.cn/large/0073sXn7gy1g3dc6ah5exj30u01hc0ww"],"publishedAt":"2019-05-23T01:34:42.491Z","source":"web","type":"Android","url":"https://github.com/ITGungnir/KotlinWanAndroid","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5d0214689d212203197e0f1e
         * createdAt : 2019-06-13T09:16:24.944Z
         * desc : 自定义红点控件，不用修改之前的代码，完全解耦，可以支持设置在TextView，Button，LinearLayout，RelativeLayout，TabLayout等等控件上……
         * images : ["http://img.gank.io/be00e66e-cb86-4f46-8e92-47609045a571"]
         * publishedAt : 2019-06-13T09:16:45.189Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCRedDotView
         * used : true
         * who : 潇湘剑雨
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;


        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }


        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AndroidInfo{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}

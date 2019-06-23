package com.example.guolei.myapplication;

import com.example.guolei.myapplication.base.App;

/**
 * Created on 2019/6/18 16:01
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class Constants {

    public static final String BASE_URL = "http://www.wanandroid.com/";

    // ====================== 知乎日报 ========================

    public static final String RIBAO = "http://news-at.zhihu.com/api/4/news/latest";
    public static final String ZHUTI = "http://news-at.zhihu.com/api/4/themes";
    public static final String ZHUANLAN = "http://news-at.zhihu.com/api/4/sections";
    public static final String REMEN = "http://news-at.zhihu.com/api/4/news/hot";


    // ====================== 微信精选 ========================

    // http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1

    public static final String WECHAT = "http://api.tianapi.com/wxnew/";
    public static final String WECHAT_API_KEY = "52b7ec3471ac3bec6846577e79f20e4c";


    // ====================== 干货集中营 ========================

  /*http://gank.io/api/data/{tech}/{num}/{page}
    数据类型(tech)：Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App|all
    请求个数(num)： 数字，大于0
    第几页(page)：数字，大于0*/

    public static final String ANDROID = "http://gank.io/api/data/Android/10/";
    public static final String IOS = "http://gank.io/api/data/iOS/10/";
    public static final String QIDUAN = "http://gank.io/api/data/前端/10/";
    public static final String FULI = "http://gank.io/api/data/福利/10/";

    // ====================== 稀土掘金 ========================


    // ====================== V2EX ========================


}

package com.example.guolei.myapplication.model;

import com.example.guolei.myapplication.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 2019/6/18 15:59
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 * 1.把当前管理类RequestManager的实例 以单例的形式提供出去    懒汉式
 * 2.获取Retrofit对象和OKHttpClient对象
 * 3.把RequestInterface(ApiService)对象提供出去
 */
public class RequestManager {

    private RequestManager() {
        initRetrofit();
    }

    private Retrofit retrofit;

    // proxy(Proxy.NO_PROXY)  防止抓包工具抓到接口,保证接口安全性
    private void initRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .build();

    }

    private static RequestManager manager;

    public synchronized static RequestManager getInstance() {
        if (manager == null) {
            synchronized (RequestManager.class) {
                if (manager == null) {
                    manager = new RequestManager();
                }
            }
        }
        return manager;
    }

    public RequestInterface getInterface() {
        return retrofit.create(RequestInterface.class);
    }


}

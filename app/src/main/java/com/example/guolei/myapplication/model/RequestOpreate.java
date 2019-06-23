package com.example.guolei.myapplication.model;

import java.util.Map;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created on 2019/6/18 16:06
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description 关联RxJava+Retrofit+OKhttp 并封装其中相应的方法
 */
public class RequestOpreate {


    // =============================== get ==================================

    //  封装好的get请求
    public static void getData(String url, Observer<ResponseBody> observer) {
        RequestManager.getInstance().getInterface().
                getData(url).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    // 有参get请求
    public static void getData(String url, Map<String, Object> params, Observer<ResponseBody> observable) {

        if (params == null) {
            getData(url, observable);
        } else {
            RequestManager.getInstance().getInterface()
                    .getData(url, params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observable);
        }


    }


    // 干货集中营的tech 请求
    public static void getTech(String tech, int num, int page, Observer<ResponseBody> observable) {

        RequestManager.getInstance().getInterface()
                .getTechList(tech, num, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);

    }

    // 干货集中营的girl 请求
    public static void getGril(int page, Observer<ResponseBody> observable){

        RequestManager.getInstance().getInterface()
                .getGirlList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observable);

    }



    // =============================== post ==================================


    //  无参的post请求
    public static void postData(String url, Observer<ResponseBody> observer) {
        RequestManager.getInstance().getInterface().
                postData(url).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    //  无参带请求头的post请求
    public static void postData(Map<String, Object> headers, String url, Observer<ResponseBody> observer) {
        if (headers == null)
            postData(url, observer);
        else
            RequestManager.getInstance().getInterface().
                    postData(headers, url).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);

    }


    //  没有请求头但是有参数的post请求
    public static void postData(String url, Map<String, Object> params,
                                Observer<ResponseBody> observer) {
        if (params == null)
            postData(url, observer);
        else
            RequestManager.getInstance().getInterface().
                    postData(url, params).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }


    //  既有请求头也有参数的post请求
    public static void postData(Map<String, Object> headers, String url,
                                Map<String, Object> params, Observer<ResponseBody> observer) {
        if (headers == null)
            postData(url, params, observer);
        else if (params == null)
            postData(headers, url, observer);
        else if (headers == null && params == null)
            postData(url, observer);
        else
            RequestManager.getInstance().getInterface().
                    postData(headers, url, params).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }


    //  有请求头也有request的post请求
    public static void postData(Map<String, Object> headers, String url, RequestBody body,
                                Observer<ResponseBody> observer) {
        RequestManager.getInstance().getInterface().
                postData(headers, url, body).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    //  文件下载
    public static void downloadFile(String url, Observer<ResponseBody> observer) {
        RequestManager.getInstance().getInterface().
                downloadFile(url).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    //  文件上传
    public static void uploadFile(String url, MultipartBody.Part part, Observer<ResponseBody> observer) {
        RequestManager.getInstance().getInterface().
                uploadFile(url, part).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


}

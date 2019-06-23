package com.example.guolei.myapplication.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created on 2019/6/18 15:58
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public interface RequestInterface {

    // ================================ get ==========================

    @GET
    Observable<ResponseBody> getData(@Url String url);

    @GET
    Observable<ResponseBody> getData(@Url String url, @QueryMap Map<String, Object> map);

    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);

    /**
     * 技术文章列表
     */
    @GET("https://gank.io/api/data/{tech}/{num}/{page}")
    Observable<ResponseBody> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    /**
     * 妹纸列表
     */
    @GET("https://gank.io/api/data/福利/10/{page}")
    Observable<ResponseBody> getGirlList(@Path("page") int page);

    // ================================ post ==========================

    @POST
    Observable<ResponseBody> postData(@Url String url);

    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers, @Url String url);


    @POST
    Observable<ResponseBody> postData(@Url String url, @FieldMap Map<String, Object> params);


    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headerMap, @Url String url, @FieldMap Map<String, Object> params);

    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headerMap, @Url String url, @Body RequestBody body);


    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);

}

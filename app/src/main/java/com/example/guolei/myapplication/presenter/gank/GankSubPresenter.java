package com.example.guolei.myapplication.presenter.gank;

import android.util.Log;

import com.example.guolei.myapplication.base.IPresenter;
import com.example.guolei.myapplication.model.RequestOpreate;
import com.example.guolei.myapplication.model.entity.gank.FuliInfo;
import com.example.guolei.myapplication.model.entity.gank.TechInfo;
import com.example.guolei.myapplication.ui.gank.fragment.GankMainFragment;
import com.example.guolei.myapplication.ui.gank.fragment.GankMainSubFragment;
import com.example.guolei.myapplication.utils.GsonUtil;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created on 2019/6/20 20:34
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class GankSubPresenter implements IPresenter {

    private GankMainSubFragment mGankMainSubFragment;
    private static final String TAG = "GankSubPresenter";

    public GankSubPresenter(GankMainSubFragment gankMainSubFragment) {
        mGankMainSubFragment = gankMainSubFragment;
    }

    @Override
    public void start() {

    }

    // 通过type 类型，判断要解析哪个页面的接口
    public void start(int i, int page) {

        switch (i) {
            case GankMainSubFragment.SUB_ANDROID_FRAGMENT:
                Log.d(TAG, "start: "+"进行解析");
                getTech(GankMainFragment.mStTitle[0], 10, page, TechInfo.class);
                break;
            case GankMainSubFragment.SUB_IOS_FRAGMENT:
                getTech(GankMainFragment.mStTitle[1], 10, page, TechInfo.class);
                break;
            case GankMainSubFragment.SUB_QIANDUAN_FRAGMENT:
                getTech(GankMainFragment.mStTitle[2], 10, page, TechInfo.class);
                break;
            case GankMainSubFragment.SUB_FULI_FRAGMENT:
                getTech(GankMainFragment.mStTitle[3], 10, page, FuliInfo.class);
               // getGril(page, FuliInfo.class);
                break;
        }

    }

    private void getTech(String tech, int num, int page, final Class clazz) {

        RequestOpreate.getTech(tech, num, page, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    Object o = GsonUtil.gsonParseStr(dataStr, clazz);
                    mGankMainSubFragment.onSuccess(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                mGankMainSubFragment.onFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void getGril(int page, final Class clazz) {

        RequestOpreate.getGril(page, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    Object o = GsonUtil.gsonParseStr(dataStr, clazz);
                    mGankMainSubFragment.onSuccess(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                mGankMainSubFragment.onFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }


}

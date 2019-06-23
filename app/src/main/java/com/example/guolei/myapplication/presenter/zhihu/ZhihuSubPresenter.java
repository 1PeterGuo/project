package com.example.guolei.myapplication.presenter.zhihu;

import com.example.guolei.myapplication.Constants;
import com.example.guolei.myapplication.base.IPresenter;
import com.example.guolei.myapplication.model.RequestOpreate;
import com.example.guolei.myapplication.model.entity.zhihu.ReMenInfo;
import com.example.guolei.myapplication.model.entity.zhihu.RiBaoInfo;
import com.example.guolei.myapplication.model.entity.zhihu.ZhuTiInfo;
import com.example.guolei.myapplication.model.entity.zhihu.ZhuanLanInfo;
import com.example.guolei.myapplication.ui.zhihu.fragment.ZhihuMainSubFragment;
import com.example.guolei.myapplication.utils.GsonUtil;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created on 2019/6/19 10:22
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class ZhihuSubPresenter implements IPresenter {

    private ZhihuMainSubFragment mZhihuMainSubFragment;

    public ZhihuSubPresenter(ZhihuMainSubFragment zhihuMainSubFragment) {
        this.mZhihuMainSubFragment = zhihuMainSubFragment;
    }

    @Override
    public void start() {

    }

    public void start(int i) {
        switch (i) {
            case ZhihuMainSubFragment.SUB_RIBAO_FRAGMENT:
                getData(Constants.RIBAO, RiBaoInfo.class);
                break;
            case ZhihuMainSubFragment.SUB_ZHUTI_FRAGMENT:

                break;
            case ZhihuMainSubFragment.SUB_ZHUANLAN_FRAGMENT:
                getData(Constants.ZHUANLAN, ZhuanLanInfo.class);
                break;
            case ZhihuMainSubFragment.SUB_REMEN_FRAGMENT:
                getData(Constants.REMEN, ReMenInfo.class);
                break;
        }

    }

    private void getData(String url, final Class clazz) {

        mZhihuMainSubFragment.showProgress();
        RequestOpreate.getData(url, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    Object o = GsonUtil.gsonParseStr(dataStr, clazz);
                    mZhihuMainSubFragment.onSuccess(o);
                    mZhihuMainSubFragment.hideProgress();
                } catch (IOException e) {
                    e.printStackTrace();
                    mZhihuMainSubFragment.hideProgress();
                }
            }

            @Override
            public void onError(Throwable e) {
                mZhihuMainSubFragment.onFail(e.getMessage());
                mZhihuMainSubFragment.hideProgress();
            }

            @Override
            public void onComplete() {

            }
        });

    }


    /*private void getReMenSubData() {
        mZhihuMainSubFragment.showProgress();
        RequestOpreate.getData(Constants.REMEN, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    ReMenInfo reMenInfo = (ReMenInfo) GsonUtil.gsonParseStr(dataStr, ReMenInfo.class);
                    mZhihuMainSubFragment.onSuccess(reMenInfo);
                    mZhihuMainSubFragment.hideProgress();
                } catch (IOException e) {
                    e.printStackTrace();
                    mZhihuMainSubFragment.hideProgress();
                }
            }

            @Override
            public void onError(Throwable e) {
                mZhihuMainSubFragment.onFail(e.getMessage());
                mZhihuMainSubFragment.hideProgress();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void getZhuanLanSubData() {
        mZhihuMainSubFragment.showProgress();
        RequestOpreate.getData(Constants.ZHUANLAN, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    ZhuanLanInfo zhuanLanInfo = (ZhuanLanInfo) GsonUtil.gsonParseStr(dataStr, ZhuanLanInfo.class);
                    mZhihuMainSubFragment.onSuccess(zhuanLanInfo);
                    mZhihuMainSubFragment.hideProgress();
                } catch (IOException e) {
                    e.printStackTrace();
                    mZhihuMainSubFragment.hideProgress();
                }
            }

            @Override
            public void onError(Throwable e) {
                mZhihuMainSubFragment.onFail(e.getMessage());
                mZhihuMainSubFragment.hideProgress();
            }

            @Override
            public void onComplete() {

            }
        });
    }


    private void getRiBaoSubData() {

        mZhihuMainSubFragment.showProgress();
        RequestOpreate.getData(Constants.RIBAO, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    RiBaoInfo riBaoInfo = (RiBaoInfo) GsonUtil.gsonParseStr(dataStr, RiBaoInfo.class);
                    mZhihuMainSubFragment.onSuccess(riBaoInfo);
                    mZhihuMainSubFragment.hideProgress();
                } catch (IOException e) {
                    e.printStackTrace();
                    mZhihuMainSubFragment.hideProgress();
                }
            }

            @Override
            public void onError(Throwable e) {
                mZhihuMainSubFragment.onFail(e.getMessage());
                mZhihuMainSubFragment.hideProgress();
            }

            @Override
            public void onComplete() {

            }
        });
    }*/


}

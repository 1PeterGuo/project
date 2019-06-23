package com.example.guolei.myapplication.presenter.wechat;

import com.example.guolei.myapplication.Constants;
import com.example.guolei.myapplication.base.IPresenter;
import com.example.guolei.myapplication.model.RequestOpreate;
import com.example.guolei.myapplication.model.entity.wechat.WeChatInfo;
import com.example.guolei.myapplication.model.entity.zhihu.RiBaoInfo;
import com.example.guolei.myapplication.ui.wechat.fragment.WechatMainFragment;
import com.example.guolei.myapplication.utils.GsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * Created on 2019/6/20 14:07
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class WeChatPresenter implements IPresenter {

    private volatile WechatMainFragment mWechatMainFragment;

    public WeChatPresenter(WechatMainFragment wechatMainFragment) {
        mWechatMainFragment = wechatMainFragment;
    }


    @Override
    public void start() {
    }


    public void start(int page) {
        getData(Constants.WECHAT, WeChatInfo.class, page);
    }


    private void getData(String wechat, final Class weChatInfoClass, int page) {

        // key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1

        final Map<String, Object> map = new HashMap<>();
        map.put("key", Constants.WECHAT_API_KEY);
        map.put("num", 10);
        map.put("page", page);

        RequestOpreate.getData(wechat, map, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String dataStr = responseBody.string();
                    Object o = GsonUtil.gsonParseStr(dataStr, weChatInfoClass);
                    mWechatMainFragment.onSuccess(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                mWechatMainFragment.onFail(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }


}

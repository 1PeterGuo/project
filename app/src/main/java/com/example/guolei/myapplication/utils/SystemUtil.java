package com.example.guolei.myapplication.utils;

import android.content.Context;

import com.example.guolei.myapplication.base.App;

/**
 * Created on 2019/6/20 21:54
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class SystemUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}

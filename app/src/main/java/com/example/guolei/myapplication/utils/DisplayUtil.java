package com.example.guolei.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created on 2019/6/21 14:48
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class DisplayUtil {

    private DisplayUtil(){}

    public static int getScreenWidth(Activity activity){
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int dp2px(Context context, float dpValue) {

        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale +0.5f);

    }

}

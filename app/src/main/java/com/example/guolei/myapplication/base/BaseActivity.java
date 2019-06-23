package com.example.guolei.myapplication.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/6/18 15:41
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected List<Activity> mList = new ArrayList<>();
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getActivityLayoutId());
        mList.add(this);
        super.onCreate(savedInstanceState);
        init();
    }

    protected abstract void init();

    // 加载不同的Activity页面的布局
    protected abstract int getActivityLayoutId();

    // 相当于返回键
    @Override
    public void onBackPressed() {
        if (mList != null && mList.size() > 0) {
            for (Activity activity : mList) {
                activity.finish();
            }
        }
        super.onBackPressed();
    }
}

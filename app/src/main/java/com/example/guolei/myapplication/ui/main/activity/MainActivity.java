package com.example.guolei.myapplication.ui.main.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.guolei.myapplication.R;
import com.example.guolei.myapplication.base.BaseActivity;
import com.example.guolei.myapplication.ui.gank.fragment.GankMainFragment;
import com.example.guolei.myapplication.ui.gold.fragment.GoldMainFragment;
import com.example.guolei.myapplication.ui.main.fragment.AboutFragment;
import com.example.guolei.myapplication.ui.main.fragment.LikeFragment;
import com.example.guolei.myapplication.ui.main.fragment.SettingFragment;
import com.example.guolei.myapplication.ui.v2ex.fragment.V2exMainFragment;
import com.example.guolei.myapplication.ui.wechat.fragment.WechatMainFragment;
import com.example.guolei.myapplication.ui.zhihu.fragment.ZhihuMainFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private NavigationView nv;
    private DrawerLayout dl;
    private FragmentManager mManager;
    private MaterialSearchView searchView;
    private MenuItem mItem;

    @Override
    protected void init() {
        // 获取当前页面的控件对象
        toolbar = findViewById(R.id.toolbar);
        nv = findViewById(R.id.nv);
        dl = findViewById(R.id.dl);
        searchView = findViewById(R.id.searchview);

        // 设置ToolBar的标题颜色
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("知乎日报");
        setSupportActionBar(toolbar);

        // 设置抽屉栏的选项监听
        nv.setNavigationItemSelectedListener(listener);
        nv.setItemIconTintList(null);


        getSupportActionBar().setHomeButtonEnabled(true);       // 设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // 设置箭头可用

        // 侧滑栏的开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, dl, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        dl.addDrawerListener(toggle);

        // 获取碎片管理器
        mManager = getSupportFragmentManager();
        mManager.beginTransaction()
                .add(R.id.ll_container, new ZhihuMainFragment())
                .commit();


    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }


    private NavigationView.OnNavigationItemSelectedListener listener = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            toolbar.setTitle(item.getTitle());
            dl.closeDrawer(Gravity.LEFT);

            switch (item.getItemId()) {
                case R.id.item1:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new ZhihuMainFragment(), ZhihuMainFragment.class.getSimpleName())
                            .commit();
                    mItem.setVisible(false);
                    break;
                case R.id.item2:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new WechatMainFragment(), WechatMainFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(true);
                    break;
                case R.id.item3:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new GankMainFragment(), GankMainFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(true);
                    break;
                case R.id.item4:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new GoldMainFragment(), GoldMainFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(false);

                    break;
                case R.id.item5:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new V2exMainFragment(), V2exMainFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(false);

                    break;
                case R.id.navigation_item_like:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new LikeFragment(), LikeFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(false);

                    break;
                case R.id.navigation_item_setting:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new SettingFragment(), SettingFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(false);

                    break;
                case R.id.navigation_item_about:

                    mManager.beginTransaction()
                            .replace(R.id.ll_container, new AboutFragment(), AboutFragment.class.getSimpleName())
                            .commitAllowingStateLoss();
                    mItem.setVisible(false);

                    break;
            }


            return true;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        mItem = menu.findItem(R.id.searchitem);
        mItem.setVisible(false);
        searchView.setMenuItem(mItem);
        return true;
    }
}

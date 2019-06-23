package com.example.guolei.myapplication.base;

/**
 * Created on 2019/6/18 15:57
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public interface IView {

    void showProgress();

    void hideProgress();

    <T> void onSuccess(T t);

    void onFail(String msg);


}

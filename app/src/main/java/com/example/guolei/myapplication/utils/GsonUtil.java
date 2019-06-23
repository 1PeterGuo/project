package com.example.guolei.myapplication.utils;

import com.google.gson.Gson;

/**
 * Created on 2019/6/18 16:08
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class GsonUtil {

    public static Object gsonParseStr(String jsonStr, Class clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, clazz);
    }


}

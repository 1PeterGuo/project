package com.example.guolei.myapplication.model.entity.zhihu;

import java.util.List;

public class ZhuTiInfo {
    /**
     * limit : 1000
     * subscribed : []
     * others : []
     */

    private int limit;
    private List<?> subscribed;
    private List<?> others;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<?> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(List<?> subscribed) {
        this.subscribed = subscribed;
    }

    public List<?> getOthers() {
        return others;
    }

    public void setOthers(List<?> others) {
        this.others = others;
    }
}

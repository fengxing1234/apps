package com.zhyen.me;

import androidx.annotation.DrawableRes;

/**
 * author : fengxing
 * date : 2022/5/25 上午10:59
 * description :
 */
public class AdapterData {

    public @DrawableRes
    int res = R.mipmap.icon_task;
    public String titleName;
    public String des;
    public boolean showRight = true;

    public AdapterData() {
    }
    public AdapterData(String titleName) {
        this.titleName = titleName;
    }
    public AdapterData(String titleName, String des) {
        this.des = des;
        this.titleName = titleName;
    }
}

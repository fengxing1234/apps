package com.zhyen.map;

import android.app.Application;

import com.zhyen.common.InitARouter;

/**
 * author : fengxing
 * date : 2022/5/24 上午10:27
 * description :
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InitARouter initARouter = new InitARouter();
        initARouter.init(this, true);
    }
}

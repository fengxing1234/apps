package com.zhyen.map;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhyen.common.BaseActivity;

/**
 * author : fengxing
 * date : 2022/5/31 下午1:15
 * description :
 */
@Route(path = "/app/LoginActivity")
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_login_activity);
    }
}

package com.zhyen.map.aroute;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhyen.common.BaseActivity;

/**
 * author : fengxing
 * date : 2022/6/6 下午5:09
 * description :
 * 新建一个Activity用于监听Scheme事件,之后直接把url传递给ARouter即可
 */
public class SchemeFilterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        Uri uri = getIntent().getData();
        Toast.makeText(this, "uri=" + uri.toString(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate: fengxing" + uri.toString());
        ARouter.getInstance().build(uri).navigation(this, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                finish();
            }
        });
    }
}

package com.zhyen.map.aroute;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * author : fengxing
 * date : 2022/6/7 上午11:58
 * description : 拦截跳转过程
 * 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
 * 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
 */
@Interceptor(priority = 8, name = "测试用拦截器")
public class TestInterceptor implements IInterceptor {


    private static final String TAG = TestInterceptor.class.getSimpleName();

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Context context = postcard.getContext();
        Log.d(TAG, "process: " + context);

        if ("/app/MainActivity".equals(postcard.getPath())) {

            // 这里的弹窗仅做举例，代码写法不具有可参考价值
            final AlertDialog.Builder ab = new AlertDialog.Builder(postcard.getContext());
            ab.setCancelable(false);
            ab.setTitle("温馨提醒");
            ab.setMessage("想要跳转到Test4Activity么？(触发了\"/inter/test1\"拦截器，拦截了本次跳转)");
            ab.setNegativeButton("继续", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onContinue(postcard);
                }
            });
            ab.setNeutralButton("算了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onInterrupt(null);
                }
            });
            ab.setPositiveButton("加点料", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    postcard.withString("extra", "我是在拦截器中附加的参数");
                    callback.onContinue(postcard);
                }
            });
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    ab.create().show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }

    }

    @Override
    public void init(Context context) {
        Log.d(TAG, "init: ");
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
    }
}

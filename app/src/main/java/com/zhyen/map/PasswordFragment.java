package com.zhyen.map;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhyen.common.BaseActivity;
import com.zhyen.common.BaseFragment;

/**
 * author : fengxing
 * date : 2022/5/30 下午4:55
 * description :
 */
public class PasswordFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_test_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        TextView message = view.findViewById(R.id.app_tv_message);
        message.setText("忘记密码界面 arg = " + name);
        Button btn = view.findViewById(R.id.app_test_button);
        btn.setText("URI跳转");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri testUriMix = Uri.parse("ttt://sss.ddd.ccc/app/MainActivity");
                ARouter.getInstance().build(testUriMix)
                        .withString("key1", "value1")
                        .navigation();
            }
        });
    }
}

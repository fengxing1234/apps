package com.zhyen.map;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhyen.common.BaseFragment;
import com.zhyen.map.aroute.model.TestObj;
import com.zhyen.map.aroute.model.TestParcelable;
import com.zhyen.map.aroute.model.TestSerializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : fengxing
 * date : 2022/5/30 下午4:54
 * description :
 */
@Route(path = "/app/WelcomeFragment")
public class WelcomeFragment extends BaseFragment {

    private final Handler handler = new Handler();

    @Autowired
    String name;

    @Autowired(required = true)
    TestObj obj;

    @Autowired
    int age = 10;

    @Autowired
    int height = 175;

    @Autowired(name = "boy", required = true)
    boolean girl;

    @Autowired
    char ch = 'A';

    @Autowired
    float fl = 12.00f;

    @Autowired
    double dou = 12.01d;

    @Autowired
    TestSerializable ser;

    @Autowired
    TestParcelable pac;

    @Autowired
    List<TestObj> objList;

    @Autowired
    Map<String, List<TestObj>> map;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_test_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView message = view.findViewById(R.id.app_tv_message);
        String str = name + age + height + girl + ch + fl + dou + ser + pac + obj + objList + map;
        message.setText("欢迎界面 arg = " + str);
    }

    @Override
    public void onResume() {
        super.onResume();
        Context context = getContext();
        Log.d(TAG, "onResume: ");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //原生跳转
                //startActivity(new Intent(getContext(), MainActivity.class));
                //ARoute跳转
                //ARouter.getInstance().build("/app/MainActivity").navigation();
                // 2. 跳转并携带参数
                ArrayList<TestObj> list = new ArrayList<>();
                list.add(new TestObj("佳木斯", 1));
                list.add(new TestObj("燕郊", 2));
                list.add(new TestObj("通州", 3));
                HashMap<String, List<TestObj>> map = new HashMap<>();
                map.put("0", list);
                map.put("1", list);
                map.put("2", list);
                ARouter.getInstance().build("/app/MainActivity")
                        .withLong("age", 666L)
                        .withString("name", "冯星")
                        .withObject("obj", new TestObj("北京", 0))
//                        .withParcelableArrayList("list", list)
//                        .withObject("map", map)
                        .navigation(getActivity(), new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.d(TAG, "onArrival: ");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d(TAG, "onInterrupt: ");
                            }
                        });
            }
        }, 1000);
    }
}

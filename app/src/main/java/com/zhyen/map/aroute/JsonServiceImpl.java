package com.zhyen.map.aroute;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * author : fengxing
 * date : 2022/6/7 上午9:13
 * description :
 */
@Route(path = "/test/json")
public class JsonServiceImpl implements SerializationService {
    private static final String TAG = JsonServiceImpl.class.getSimpleName();
    private Gson gson;

    @Override
    public void init(Context context) {
        Log.d(TAG, "init: ");
        gson = new Gson();
    }

    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        Log.d(TAG, "json2Object: " + input);
        return gson.fromJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        Log.d(TAG, "object2Json: " + instance);
        return gson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        Log.d(TAG, "parseObject: " + input);
        return gson.fromJson(input,clazz);
    }
}

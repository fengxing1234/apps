package com.zhyen.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zhyen.common.BaseFragment;

/**
 * author : fengxing
 * date : 2022/5/27 下午1:06
 * description :
 */
public class HomeWeatherFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_weather_fragment,container,false);
    }
}

package com.map.base.garden;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zhyen.common.BaseFragment;

/**
 * author : fengxing
 * date : 2022/5/31 下午2:04
 * description :
 */
public class GardenMainFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.garden_main_fragment, container, false);
    }
}

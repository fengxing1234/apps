package com.zhyen.skill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zhyen.common.BaseFragment;

/**
 * author : fengxing
 * date : 2022/5/30 上午9:12
 * description :
 */
public class CourseMainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.course_main_fragment, container, false);
    }
}

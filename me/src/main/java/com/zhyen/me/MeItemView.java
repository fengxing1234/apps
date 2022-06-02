package com.zhyen.me;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

/**
 * author : fengxing
 * date : 2022/5/25 上午11:00
 * description : 组合控件
 */
public class MeItemView extends FrameLayout implements View.OnClickListener {

    private ImageView ivIcon;
    private TextView tvSubTitle;
    private ImageView ivRight;
    private TextView tvDes;

    public MeItemView(Context context) {
        this(context, null);
    }

    public MeItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MeItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(this);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_me_item, this, true);
        ivIcon = view.findViewById(R.id.me_iv_icon);
        tvSubTitle = view.findViewById(R.id.me_tv_subtitle);
        ivRight = view.findViewById(R.id.icon_right);
        tvDes = view.findViewById(R.id.me_tv_des);
    }

    public void setIcon(@DrawableRes int res) {
        ivIcon.setImageResource(res);
    }

    public void setTitleName(String name) {
        tvSubTitle.setText(name);
    }

    public void setDes(String des) {
        tvDes.setText(des);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "点击了：" + tvSubTitle.getText(), Toast.LENGTH_SHORT).show();
    }

    public void setViewData(AdapterData adapterData) {
        ivIcon.setImageResource(adapterData.res);
        tvSubTitle.setText(adapterData.titleName);
        if(!TextUtils.isEmpty(adapterData.des)){
            tvDes.setText(adapterData.des);
        }
    }
}

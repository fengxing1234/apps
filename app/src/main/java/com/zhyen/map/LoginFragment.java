package com.zhyen.map;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import com.zhyen.common.BaseFragment;

/**
 * author : fengxing
 * date : 2022/5/30 下午4:54
 * description :
 */
public class LoginFragment extends BaseFragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Toast.makeText(getContext(), "返回", Toast.LENGTH_SHORT).show();
                requireActivity().finish();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app_login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        Button loginBtn = view.findViewById(R.id.app_login_btn);
        TextView textView = view.findViewById(R.id.app_tv_arg);
        textView.setText(name);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "Login");
                NavOptions options = new NavOptions.Builder().build();
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_welcomeFragment, bundle, options);
            }
        });
        view.findViewById(R.id.app_password_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "Login");
                NavOptions options = new NavOptions.Builder().build();
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_passwordFragment, bundle, options);
            }
        });

        view.findViewById(R.id.app_register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("name", "Login");
                NavOptions options = new NavOptions.Builder().build();
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_registerFragment, bundle, options);
            }
        });
    }

}

package com.zhyen.map;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * author : fengxing
 * date : 2022/5/24 上午10:27
 * description :
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main_activity);

        BottomNavigationView bottomNav = findViewById(R.id.app_bottom_nav);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_container);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(bottomNav, navController);
        }
        //Activity com.zhyen.map.MainActivity@cc09327 does not have a NavController set on 2131231208
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_container);
//        NavigationUI.setupWithNavController(bottomNav, navController);

    }
}

package com.zhyen.map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhyen.common.BaseActivity;
import com.zhyen.map.aroute.model.TestObj;

import java.util.List;
import java.util.Map;

/**
 * author : fengxing
 * date : 2022/5/24 上午10:27
 * description :
 */
@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Autowired
    public String name;
    @Autowired
    long age;
    // 通过name来映射URL中的不同参数
    @Autowired(name = "girl")
    boolean boy;

    // 支持解析自定义对象，URL中使用json传递
    @Autowired
    TestObj obj;

    // 使用 withObject 传递 List 和 Map 的实现了
    // Serializable 接口的实现类(ArrayList/HashMap)
    // 的时候，接收该对象的地方不能标注具体的实现类类型
    // 应仅标注为 List 或 Map，否则会影响序列化中类型
    // 的判断, 其他类似情况需要同样处理
    @Autowired
    List<TestObj> list;
    @Autowired
    Map<String, List<TestObj>> map;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main_activity);
        ARouter.getInstance().inject(this);
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        String action = intent.getAction();
        Log.d(TAG, "onCreate: "+scheme);
        Log.d(TAG, "onCreate: "+action);
        Uri uri = intent.getData();
        if (uri != null) {
            Log.d(TAG, "onCreate: " + uri.toString());
        }

//        Intent intent = getIntent();f
//        if (intent != null) {
//            long key1 = intent.getLongExtra("key1", 0);
//            String key3 = intent.getStringExtra("key3");
//            Toast.makeText(this, "key1=" + key1 + " key3=" + key3, Toast.LENGTH_SHORT).show();
//        }
        Toast.makeText(this, "name=" + name + " age=" + age + "girl=" + boy, Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onCreate: " + obj);
        Log.d(TAG, "onCreate: " + list);
        Log.d(TAG, "onCreate: " + map);

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

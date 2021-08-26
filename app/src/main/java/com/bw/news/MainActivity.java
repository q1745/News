package com.bw.news;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bw.news.adapter.MainViewPagerAdapter;
import com.shuke.homepage.fragment.IndexFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragments;
    private ViewPager mainVp;
    private BottomNavigationBar mainBottombar;

    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //沉浸式
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        
        initBottomView();
    }

    /**
     * 初始化并设置底部导航栏
     */
    private void initBottomView() {
        mainBottombar.setMode(BottomNavigationBar.MODE_FIXED)
                .setInActiveColor("#939393")
                .setActiveColor("#FB575C")
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        mainBottombar.addItem(new BottomNavigationItem(R.drawable.index, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.video, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.more, "微头条"))
                .addItem(new BottomNavigationItem(R.drawable.mine, "我的"))
                .initialise();
        //BottomView 和 ViewPager联动
        fragments = new ArrayList<>();
        fragments.add(new IndexFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        mainVp.setAdapter(mainViewPagerAdapter);
    }


    private void initView() {
        mainVp = (ViewPager) findViewById(R.id.main_vp);
        mainBottombar = (BottomNavigationBar) findViewById(R.id.main_bottombar);
    }
}
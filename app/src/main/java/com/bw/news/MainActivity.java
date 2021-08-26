package com.bw.news;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainVp;
    private BottomNavigationBar mainBottombar;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        mainBottombar.setMode(BottomNavigationBar.MODE_DEFAULT)
//                .setInActiveColor("#623AB5")
//                .setActiveColor("#000000")
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
//
//        mainBottombar.addItem(new BottomNavigationItem(R.drawable.index,"首页"))
//                .addItem(new BottomNavigationItem(R.drawable.video,"视频"))
//                .addItem(new BottomNavigationItem(R.drawable.more,"微头条"))
//                .addItem(new BottomNavigationItem(R.drawable.mine,"我的"))
//                .initialise();
    }

    private void initView() {
        mainVp = (ViewPager) findViewById(R.id.main_vp);
        mainBottombar = (BottomNavigationBar) findViewById(R.id.main_bottombar);
    }
}
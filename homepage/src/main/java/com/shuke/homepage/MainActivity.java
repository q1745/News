package com.shuke.homepage;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainVp;
    private Button sure;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        fragments.add(new IndexFragment());

        mainVp.setAdapter(new MainVpAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments));

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainVp.setCurrentItem(0);
            }
        });
    }

    private void initView() {
        mainVp = (ViewPager) findViewById(R.id.main_vp);
        sure = (Button) findViewById(R.id.sure);
    }
}
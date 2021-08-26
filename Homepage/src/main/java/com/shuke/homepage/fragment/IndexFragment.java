package com.shuke.homepage.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.shuke.homepage.R;
import com.shuke.homepage.adapter.MainVpAdapter;
import com.shuke.homepage.custom.CustomHobbyType;
import com.shuke.homepage.news.view.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class IndexFragment extends Fragment {

    TabLayout tab;
    ViewPager vp;

    List<Fragment> fragments = new ArrayList<>();
    private int position = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);

        tab = inflate.findViewById(R.id.index_tab);
        vp = inflate.findViewById(R.id.index_vp);

        fragments.add(new NewsFragment());

        //将选中的数据循环添加到tablayout中
        for (int i = 0; i < CustomHobbyType.texts.size(); i++) {
            tab.addTab(tab.newTab().setText(CustomHobbyType.texts.get(i)));
        }

        //为tablayout里每一个子选项设置view视图。
        setupTabIcons();

        vp.setAdapter(new MainVpAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments));

        //tablayout选择监听
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab taa) {
                position = taa.getPosition();
                vp.setCurrentItem(0);
                changeTabSelect(taa);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab taa) {
                changeTabNormal(taa);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return inflate;
    }

    /**
     * 设置每个TabLayout的View
     */
    private void setupTabIcons() {
        for (int i = 0; i < CustomHobbyType.texts.size(); i++) {
            tab.getTabAt(i).setCustomView(getTabView(i));
        }
    }

    /**
     * 提供TabLayout的View
     * 根据index返回不同的View
     * 主意：默认选中的View要返回选中状态的样式
     */
    private View getTabView(int index) {
        //自定义View布局
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.tablayout_text, null);
        TextView title = (TextView) view.findViewById(R.id.tablayout_text_style);
        //将tablayout的子项设置到布局textview中
        title.setText(CustomHobbyType.texts.get(index));
        //当未选中时设置透明度、选中放大
        if (index != position) {
            view.setAlpha(0.5f);
        } else {
            view.setScaleX(1.1f);
            view.setScaleY(1.1f);
        }
        return view;
    }

    /**
     * 改变TabLayout的View到选中状态
     * 使用属性动画改编Tab中View的状态
     */
    private void changeTabSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view,"scaleY", 1.0F, 1.1F)
                .setDuration(200);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                Log.d("123", "change: " + cVal);
                view.setAlpha(0.5f + (cVal - 1f) * (0.5f / 0.1f));
                Log.d("123", "change: " + (0.5f + (cVal - 1f) * (0.5f / 0.1f)));
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }

    /**
     * 改变TabLayout的View到未选中状态
     */
    private void changeTabNormal(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "scaleY", 1.0F, 0.9F)
                .setDuration(200);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                Log.d("123", "no: " + cVal);
                view.setAlpha(1f - (1f - cVal) * (0.5f / 0.1f));
                Log.d("123", "no: " + (1f - (1f - cVal) * (0.5f / 0.1f)));
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }
}
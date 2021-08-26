package com.shuke.homepage.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

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

    private TabLayout tab;
    private ViewPager vp;
    private EditText indexSearch;


    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    private int position = 0;
    //获取输入框
    private InputMethodManager inputMethodManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_index, container, false);

        tab = inflate.findViewById(R.id.index_tab);
        vp = inflate.findViewById(R.id.index_vp);
        indexSearch = inflate.findViewById(R.id.index_search);

        //设置回车为完成
        indexSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //初始化输入框
        inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(indexSearch.getWindowToken(), 0);  //隐藏输入法

        //输入框点击监听
        indexSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexSearch.setFocusable(true);   //可聚焦
                indexSearch.setFocusableInTouchMode(true);   //触摸聚焦
                indexSearch.requestFocus();  //请求焦点
                indexSearch.findFocus();  //发现焦点
                inputMethodManager.showSoftInput(indexSearch,InputMethodManager.SHOW_FORCED);   //打开输入法
            }
        });

//        输入框回车监听
        indexSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    indexSearch.setFocusable(false);   //不可聚焦
                    inputMethodManager.hideSoftInputFromWindow(indexSearch.getWindowToken(), 0);  //隐藏输入法
                }
                return true;
            }
        });


//        indexSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if (b) {
//
//                } else {
//
//                }
//
//            }
//        });



        fragments.add(new NewsFragment());
        fragments.add(new ElseFragment());
        //接收选中的兴趣
        titles = CustomHobbyType.texts;

        titles.add("哈哈");
        titles.add("嘿嘿");
        titles.add("呼哈");

        //将选中的数据循环添加到tablayout中
        for (int i = 0; i < titles.size(); i++) {
            tab.addTab(tab.newTab().setText(titles.get(i)));

        }

        //为tablayout里每一个子选项设置view视图。
        setupTabIcons();

        vp.setAdapter(new MainVpAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments));

        //tablayout选择监听
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab taa) {
                position = taa.getPosition();
                if (position == 1) {
                    vp.setCurrentItem(0);
                } else {
                    vp.setCurrentItem(1);
                }

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
        for (int i = 0; i < titles.size(); i++) {
            tab.getTabAt(i).setCustomView(getTabView(i));
        }
        //默认第一个选中字体颜色为紫色
        TextView viewById = tab.getTabAt(0).getCustomView().findViewById(R.id.tablayout_text_style);
        viewById.setTextColor(Color.parseColor("#ff00ff"));
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
        TextView viewById = view.findViewById(R.id.tablayout_text_style);
        viewById.setTextColor(Color.parseColor("#ff00ff"));
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "scaleY", 1.0F, 1.1F)
                .setDuration(200);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(0.5f + (cVal - 1f) * (0.5f / 0.1f));
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
        TextView viewById = view.findViewById(R.id.tablayout_text_style);
        viewById.setTextColor(Color.parseColor("#56000000"));
        ObjectAnimator anim = ObjectAnimator
                .ofFloat(view, "scaleY", 1.0F, 0.9F)
                .setDuration(200);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(1f - (1f - cVal) * (0.5f / 0.1f));
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }
}
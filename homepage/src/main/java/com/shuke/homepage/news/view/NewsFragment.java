package com.shuke.homepage.news.view;

import com.shuke.homepage.R;
import com.shuke.homepage.databinding.MyNewsFragment;
import com.shuke.homepage.news.viewmodel.NewsViewModel;
import com.shuke.mvvmcore.BaseViewModel;
import com.shuke.mvvmcore.view.MVVMFragment;

import java.util.Map;

/**
 * @ClassName NewsFragment
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/20 20:02
 * @Version 1.0
 */
public class NewsFragment extends MVVMFragment {

    @Override
    public Map<Integer, Object> initVarMap(Map vars) {
        return null;
    }

    @Override
    public BaseViewModel<?> createViewModel() {
        return null;
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }
}

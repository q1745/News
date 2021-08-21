package com.shuke.homepage.news.view;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.shuke.homepage.BR;
import com.shuke.homepage.R;
import com.shuke.homepage.databinding.MyNewsFragment;
import com.shuke.homepage.news.viewmodel.NewsViewModel;
import com.shuke.mvvmcore.view.MVVMFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @ClassName NewsFragment
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/20 20:02
 * @Version 1.0
 */
public class NewsFragment extends MVVMFragment<MyNewsFragment, NewsViewModel> {

    @Override
    public Map<Integer, Object> initVarMap(Map vars) {
        vars.put(BR.mine, this);
        return vars;
    }

    @Override
    public NewsViewModel createViewModel() {
        return new NewsViewModel();
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

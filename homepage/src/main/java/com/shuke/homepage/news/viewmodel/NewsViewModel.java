package com.shuke.homepage.news.viewmodel;

import androidx.lifecycle.LiveData;

import com.shuke.homepage.entity.NewsEntity;
import com.shuke.homepage.news.repository.NewsRepository;
import com.shuke.mvvmcore.BaseRepository;
import com.shuke.mvvmcore.BaseViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * @ClassName NewsViewModel
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/20 20:19
 * @Version 1.0
 */
public class NewsViewModel extends BaseViewModel<NewsRepository> {


    @Override
    public void releaseResource() {

    }

    @Override
    public void initResource() {
        repo.injectModel();
    }

    public LiveData<NewsEntity.DataBean> getNews() {
        return repo.getNews();
    }


    @Override
    public void createRepository() {

    }
}

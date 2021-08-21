package com.shuke.homepage.news.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shuke.homepage.entity.NewsEntity;
import com.shuke.homepage.news.model.NewsModel;
import com.shuke.mvvmcore.BaseRepository;
import com.shuke.mvvmcore.annotation.Model;

/**
 * @ClassName NewsRepository
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/20 20:18
 * @Version 1.0
 */
public class NewsRepository extends BaseRepository{

    @Model
    private NewsModel mModel;

    public LiveData<NewsEntity.DataBean> getNews() {
        LiveData<NewsEntity.DataBean> news = mModel.getNews();
        return news;
    }

}

package com.shuke.homepage.news.model;

import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bw.zz.RetrofitFactory;
import com.shuke.homepage.api.Api;
import com.shuke.homepage.entity.NewsEntity;
import com.shuke.mvvmcore.BaseViewModel;
import com.shuke.mvvmcore.IModel;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @ClassName NewsModel
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/20 20:18
 * @Version 1.0
 */
public class NewsModel implements IModel {

    public LiveData<NewsEntity.DataBean> getNews() {

        MutableLiveData<NewsEntity.DataBean> liveData = new MutableLiveData<>();
        RetrofitFactory.getMyRetrofit().createRetrofit()
                .create(Api.class)
                .getNews(1,1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                            liveData.setValue((NewsEntity.DataBean) newsEntity.getData());
                        } else {
                            liveData.postValue((NewsEntity.DataBean) newsEntity.getData());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return liveData;
    }
}

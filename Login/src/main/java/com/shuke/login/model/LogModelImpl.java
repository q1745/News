package com.shuke.login.model;

import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shuke.login.pro.LogEntity;
import com.shuke.mvvmcore.IModel;

/**
 * @CreateDate: 2021/8/24 9:33
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: News
 * @Package: com.shuke.login.model
 * @ClassName: RegModelImpl
 */
public class LogModelImpl implements IModel {

    public LiveData<LogEntity> log(LogEntity entity){
        MutableLiveData<LogEntity> liveData = new MutableLiveData<>();
        if (Looper.myLooper()!=Looper.getMainLooper()){
            liveData.postValue(entity);
        }else{
            liveData.setValue(entity);
        }
        return liveData;

    }
}

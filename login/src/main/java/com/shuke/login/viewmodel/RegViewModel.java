package com.shuke.login.viewmodel;

import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shuke.common.LogUtil;
import com.shuke.login.model.pro.RegisterEntity;
import com.shuke.login.reposi.RegRepoImpl;
import com.shuke.mvvmcore.BaseViewModel;

/**
 * @CreateDate: 2021/8/24 9:56
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: News
 * @Package: com.shuke.login.viewmodel
 * @ClassName: RegViewModel
 */
public class RegViewModel extends BaseViewModel<RegRepoImpl> {
    public MutableLiveData<RegisterEntity> pageSource = new MutableLiveData<>();
    public RegViewModel(LifecycleOwner lifecycle) {
        super(lifecycle);
        RegisterEntity registerEntity = new RegisterEntity(1,"1111","11111","","");
        if (Looper.myLooper()!=Looper.getMainLooper()){
            pageSource.postValue(registerEntity);
        }else{
            pageSource.setValue(registerEntity);
        }
    }

    @Override
    public RegRepoImpl createRepository() {
        return new RegRepoImpl();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initResource() {

    }
    public LiveData<RegisterEntity> register(RegisterEntity entity){
        LogUtil.i("123","RegViewModel");
        return repo.register(entity);
    }
}

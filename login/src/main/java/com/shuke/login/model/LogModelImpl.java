package com.shuke.login.model;

import android.os.Looper;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.bw.zz.RetrofitFactory;
import com.bw.zz.protocol.BaseRespEntity;
import com.shuke.login.LogMainActivity;
import com.shuke.login.model.api.RegisterApi;
import com.shuke.login.model.pro.LogEntity;
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
    public String log(LogEntity entity){
        MutableLiveData<LogEntity> liveData = new MutableLiveData<>();
        if (Looper.myLooper()!=Looper.getMainLooper()){
            liveData.postValue(entity);
        }else{
            liveData.setValue(entity);
        }
        RetrofitFactory.getMyRetrofit()
                .createRetrofit()
                .create(RegisterApi.class)
                .log(entity)
                .observe(new LogMainActivity(), new Observer<BaseRespEntity<LogEntity>>() {
                    @Override
                    public void onChanged(BaseRespEntity<LogEntity> logEntityBaseRespEntity) {

                    }
                });
        return "";
    }
}

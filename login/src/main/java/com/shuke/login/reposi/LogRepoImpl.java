package com.shuke.login.reposi;

import androidx.lifecycle.LiveData;

import com.shuke.login.model.LogModelImpl;
import com.shuke.login.model.pro.LogEntity;
import com.shuke.mvvmcore.BaseRepository;
import com.shuke.mvvmcore.annotation.Model;

/**
 * @CreateDate: 2021/8/24 9:41
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: News
 * @Package: com.shuke.login.reposi
 * @ClassName: RegRepoImpl
 */
public class LogRepoImpl extends BaseRepository {
    @Model
    LogModelImpl logModel;
    public LiveData<LogEntity> log(LogEntity entity){
        return logModel.log(entity);
    }
}

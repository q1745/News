package com.shuke.login.model.api;

import androidx.lifecycle.LiveData;

import com.bw.zz.protocol.BaseRespEntity;
import com.shuke.login.model.pro.LogEntity;
import com.shuke.login.model.pro.RegisterEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @CreateDate: 2021/8/24 11:30
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: News
 * @Package: com.shuke.login.model.api
 * @ClassName: RegisterApi
 */
public interface RegisterApi {
    @POST("/api/User/register")
    LiveData<BaseRespEntity<RegisterEntity>> regis(@Body RegisterEntity entity);

    @POST("api/User/login")
    LiveData<BaseRespEntity<LogEntity>> log(@Body LogEntity entity);
}
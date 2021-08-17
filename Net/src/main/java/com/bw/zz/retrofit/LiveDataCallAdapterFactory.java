package com.bw.zz.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @ClassName LiveDataCallAdapterFactory
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/17 19:59
 * @Version 1.0
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {

    public static LiveDataCallAdapterFactory create() {
        return new LiveDataCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (!(returnType instanceof ParameterizedType)) {
//            throw new IllegalAccessException("要求返回值必须是可参数化的（支持泛型）");
        }
        return null;
    }
}

package com.shuke.mvvmcore

import androidx.lifecycle.*

/**
 *   @Author:YaPeng
 *   @Date:2021/8/17
 *   @Email:3536815334@qq.com
 */

abstract class BaseViewModel<Repo : BaseRepository>()  : ViewModel() , LifecycleObserver {

    private lateinit var owner: LifecycleOwner

    constructor(lifecycle: LifecycleOwner) : this(){
        owner = lifecycle
    }

    protected lateinit var repo: Repo

    init {
<<<<<<< HEAD
        createRepository()
=======
        repo = createRepository()
>>>>>>> 67d1e74f900b6073a9bfc53b1e195d8f6a5ee3de
    }

    /**
     * 创建并初始化Repository
     */
<<<<<<< HEAD
    abstract fun createRepository()
=======
    abstract fun createRepository() : Repo
>>>>>>> 67d1e74f900b6073a9bfc53b1e195d8f6a5ee3de

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun uiConnection(){
        initResource()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disConnection(){
        releaseResource()
        owner.lifecycle.removeObserver(this)
    }

    /**
     * 释放资源
     */
    abstract fun releaseResource()


    /**
     * 初始化资源
     */
    abstract fun initResource()


}
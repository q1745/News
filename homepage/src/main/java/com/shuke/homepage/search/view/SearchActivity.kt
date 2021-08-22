package com.shuke.homepage.search.view

import android.os.Looper
import android.util.Log
import android.view.View
import com.shuke.homepage.BR
import com.shuke.homepage.R
import com.shuke.homepage.customview.ChildViewClickLisenter
import com.shuke.homepage.customview.FluidViewAdapter
import com.shuke.homepage.customview.TextItem
import com.shuke.homepage.databinding.SearchActView
import com.shuke.homepage.search.db.SearchDBUtils
import com.shuke.homepage.search.db.SearchHistoryEntity
import com.shuke.homepage.search.viewmodel.SearchViewModel
import com.shuke.mvvmcore.view.MVVMActivity
import kotlinx.android.synthetic.main.search_activity_layout.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 *   @Author:YaPeng
 *   @Date:2021/8/20
 *   @Email:3536815334@qq.com
 */
class SearchActivity : MVVMActivity<SearchActView,SearchViewModel>(){

    override fun initEvent() {

    }

    override fun loadData() {
        var views:MutableList<TextItem> = mutableListOf()
        for (i in 0..10){
            var ite : TextItem = TextItem(this)
            ite.setT(i.toString())
            views.add(ite)
            var aa : SearchHistoryEntity = SearchHistoryEntity(i.toString())

        }
        Executors.newCachedThreadPool().submit(object : Runnable{
            override fun run() {
               var aa = SearchDBUtils.getSearchDB(this@SearchActivity).searchHistoryDao().queryAll()
                Log.i("TAG", "run: "+aa.size)
            }
        })
        FluidViewAdapter.Adaptive(fluidview,views)
        fluidview.setChildViewClickLisenter(object : ChildViewClickLisenter {
            override fun onClick(view:View) {
                fluidview.removeChildView(view)
            }
        })
    }

    override fun initVarMap(vars: MutableMap<Int, Any>): MutableMap<Int, Any> {
        vars.put(BR.myAct,this)
        return vars
    }

    override fun createViewModel(): SearchViewModel {
        return SearchViewModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.search_activity_layout
    }

    fun delAll(){
        fluidview.delall()
    }
}
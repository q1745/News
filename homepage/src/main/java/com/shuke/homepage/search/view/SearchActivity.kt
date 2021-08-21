package com.shuke.homepage.search.view

import android.util.Log
import com.shuke.homepage.BR
import com.shuke.homepage.R
import com.shuke.homepage.customview.ChildViewClickLisenter
import com.shuke.homepage.customview.FluidViewAdapter
import com.shuke.homepage.customview.TextItem
import com.shuke.homepage.databinding.SearchActView
import com.shuke.homepage.search.viewmodel.SearchViewModel
import com.shuke.mvvmcore.view.MVVMActivity
import kotlinx.android.synthetic.main.search_activity_layout.*

/**
 *   @Author:YaPeng
 *   @Date:2021/8/20
 *   @Email:3536815334@qq.com
 */
class SearchActivity : MVVMActivity<SearchActView,SearchViewModel>(){

    override fun initEvent() {

    }

    override fun loadData() {
//        var views:MutableList<TextItem> = mutableListOf()
//        var ite : TextItem = TextItem(this)
//        ite.setT("债看得完安娃娃多缴纳我电脑哦按我带你俩")
//        views.add(ite)
//        FluidViewAdapter.Adaptive(fluidview,views)
        fluidview.setChildViewClickLisenter(object : ChildViewClickLisenter {
            override fun onClick(position: Int) {
                Log.i("TAG", "onClick: "+position)
            }
        })
    }

    override fun initVarMap(vars: MutableMap<Int, Any>): MutableMap<Int, Any> {
        vars.put(BR.aaa,this)
        return vars
    }

    override fun createViewModel(): SearchViewModel {
        return SearchViewModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.search_activity_layout
    }
}
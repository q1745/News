package com.shuke.homepage.customview

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.shuke.common.ThreadUtil
import com.shuke.homepage.search.db.SearchDBUtils
import com.shuke.homepage.search.db.SearchHistoryEntity
import kotlinx.android.synthetic.main.search_activity_layout.*

/**
 *   @Author:YaPeng
 *   @Date:2021/8/20
 *   @Email:3536815334@qq.com
 */
object FluidViewUtils {

    fun Adaptive(fluidView: FluidView, entitys: MutableList<SearchHistoryEntity>, context: Context){
        entitys.forEach {
            var itemtext:TextItem = TextItem(context)
            itemtext.setT(it.name.toString())
            itemtext.item = it
            fluidView.addChildView(itemtext)
        }
        fluidView.setChildViewClickLisenter(object : ChildViewClickLisenter {
            override fun onClick(view: View) {
                fluidView.removeChildView(view)
                del(view,context)
            }
        })
    }

    fun InsertView(fluidView: FluidView, entity: SearchHistoryEntity, context: Context){
        var itemtext:TextItem = TextItem(context)
        itemtext.setT(entity.name.toString())
        itemtext.item = entity
        fluidView.addChildView(itemtext)
        itemtext.setChildViewLisenter(object : ChildViewLisenter{
            override fun onDel(view: View) {
                fluidView.removeChildView(view)
                del(view,context)
            }
        })
        ThreadUtil.doTaskAsync(object : Runnable{
            override fun run() {
                SearchDBUtils.getSearchDB(context).searchHistoryDao().insertEntity(entity)
            }
        })
    }


    fun del(view:View,context: Context){
        ThreadUtil.doTaskAsync(object : Runnable{
            override fun run() {
                SearchDBUtils.getSearchDB(context).searchHistoryDao().delOne((view as TextItem).item)
            }
        })
    }
}
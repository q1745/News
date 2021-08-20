package com.shuke.homepage.customview

/**
 *   @Author:YaPeng
 *   @Date:2021/8/20
 *   @Email:3536815334@qq.com
 */
object FluidViewAdapter {

    fun Adaptive(fluidView: FluidView,views:MutableList<TextItem>){
        views.forEach {
            fluidView.addChildView(it)
        }
    }

}
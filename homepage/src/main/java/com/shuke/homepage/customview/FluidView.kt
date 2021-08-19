package com.shuke.homepage.customview

import android.content.Context
import android.os.IInterface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import kotlin.properties.Delegates

/**
 *   @Author:YaPeng
 *   @Date:2021/8/19
 *   @Email:3536815334@qq.com
 *   自定义流式布局
 */
class FluidView : ViewGroup{

    var _left : Int = 0
    var _top : Int = 0

    var curlen : Int = 0

    var maxHeight : Int = 0


    constructor(context: Context?) : super(context){ init() }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){init()}

    private fun init() {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var count = childCount

        /**
         * 挨个测量
         */
        for (i in 0 .. (count - 1)){
            val childAt = getChildAt(i)
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        var count : Int = childCount

        for (i in 0 .. (count - 1)){
            val childView : View = getChildAt(i)

            if(i == 0){
                childView.layout(_left,_top,childView.measuredWidth,childView.measuredHeight)
                _left = childView.measuredWidth
                curlen += childView.measuredWidth
                maxHeight = childView.measuredHeight
                continue
            }

            curlen += childView.measuredWidth

            if (curlen <= measuredWidth){
                if (childView.measuredHeight > maxHeight){
                    maxHeight = childView.measuredHeight
                }
                childView.layout(_left,_top,childView.measuredWidth+_left,childView.measuredHeight+_top)
                _left += childView.measuredWidth
            }
            else{
                _left = 0
                curlen = childView.measuredWidth
                _top += maxHeight
                maxHeight = childView.measuredHeight
                childView.layout(_left,_top,childView.measuredWidth + _left,childView.measuredHeight + _top)
                _left +=childView.measuredWidth
            }

        }
    }

}
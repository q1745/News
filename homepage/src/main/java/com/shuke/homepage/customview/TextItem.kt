package com.shuke.homepage.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.shuke.homepage.R

/**
 *   @Author:YaPeng
 *   @Date:2021/8/19
 *   @Email:3536815334@qq.com
 */
class TextItem : View {
    //背景画笔
    lateinit var bgPaint : Paint
    //画text的画笔
    lateinit var textPaint : Paint
    //画X的画笔
    lateinit var XPaint : Paint

    var text : String = "你没给值"
    var IsHaveX : Boolean = false
    var color : Int = Color.WHITE

    /**
     * 设置默认宽高
     */
    var defaultHeight : Float = 0F
    var defaultWidth : Float = 0F

    lateinit var delBitmap : Bitmap

    lateinit var createBitmap : Bitmap

    constructor(context: Context?) : super(context){init()}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        getAttrsValues(context,attrs)
        init()
    }

    private fun getAttrsValues(context: Context?, attrs: AttributeSet?) {
        if (attrs == null){
            return
        }
        val Attris:TypedArray =
            context!!.obtainStyledAttributes(attrs, R.styleable.radios_textitem)
        text = Attris.getString(R.styleable.radios_textitem_text).toString()
        IsHaveX = Attris.getBoolean(R.styleable.radios_textitem_isHaveX, false)
        color = Attris.getColor(R.styleable.radios_textitem_bgColor, Color.WHITE)
        Attris.recycle()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun init() {
        //初始化画笔
        bgPaint = Paint()
        bgPaint.style = Paint.Style.FILL
        bgPaint.setColor(color)

        textPaint = Paint()
        textPaint.textSize = 28F
        textPaint.setColor(Color.BLACK)
        val textWidth : Float = textPaint.measureText(text)
        defaultWidth = textWidth + 70
        defaultHeight = 45F


        val drawable = resources.getDrawable(R.drawable.delete)

        delBitmap = BitmapFactory.decodeResource(resources, R.drawable.delete)

        //缩小Bitmap图
        var scaleWidth : Float = 45F/delBitmap.width
        var scaleHeight : Float = 45F/delBitmap.height
        var matrix:Matrix = Matrix()
        matrix.postScale(scaleWidth,scaleHeight)

        createBitmap =
            Bitmap.createBitmap(delBitmap, 0, 0, delBitmap.width, delBitmap.height, matrix, true)


        if (IsHaveX){
            XPaint = Paint()
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(defaultWidth.toInt(), defaultHeight.toInt())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.i("TAG", "onDraw: "+defaultWidth)
        canvas!!.drawRoundRect(RectF(0F,0F,defaultWidth,defaultHeight),22F,22F,bgPaint)
        if (IsHaveX){
            canvas!!.drawBitmap(createBitmap,defaultWidth - 45,0F,XPaint)
            canvas!!.drawText(text,20F,defaultHeight-13,textPaint)
        }else{
            canvas!!.drawText(text,35F,defaultHeight-13,textPaint)
        }
    }
}
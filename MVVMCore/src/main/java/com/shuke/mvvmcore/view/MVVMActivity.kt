package com.shuke.mvvmcore.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.shuke.mvvmcore.BaseViewModel

/**
 *   @Author:YaPeng
 *   @Date:2021/8/17
 *   @Email:3536815334@qq.com
 */
abstract class MVVMActivity<V : ViewDataBinding,VM : BaseViewModel<*>> : AppCompatActivity(){
    protected lateinit var binding : V
    protected lateinit var viewModel : VM
    private var vars : MutableMap<Int,Any> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutId())
        vars = initVarMap(vars)
        setVars(binding,vars)
        viewModel = createViewModel()

        loadData()
        initEvent()
    }

    /**
     * 初始化数据
     */
    abstract fun initEvent()

    /**
     * 加载数据
     */
    abstract fun loadData()

    /**
     * 设置变量
     */
    fun setVars(binding: V, vars: MutableMap<Int, Any>){
        if (vars.size == 0){
            throw IllegalStateException("没有设置变量")
        }
        vars.forEach{
            binding.setVariable(it.key,it.value)
        }
    }

    /**
     * 设置变量Map集合
     */
    abstract fun initVarMap(vars: MutableMap<Int, Any>): MutableMap<Int, Any>

    /**
     * 创建ViewModel
     */
    abstract fun createViewModel(): VM

    /**
     * 获取布局Id
     */
    abstract fun getLayoutId(): Int
}
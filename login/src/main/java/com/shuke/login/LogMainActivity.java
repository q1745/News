package com.shuke.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bw.zz.RetrofitFactory;
import com.bw.zz.protocol.BaseRespEntity;
import com.shuke.login.databinding.LogMain;
import com.shuke.login.model.api.RegisterApi;
import com.shuke.login.model.pro.LogEntity;
import com.shuke.login.viewmodel.LogViewModel;
import com.shuke.mvvmcore.view.MVVMActivity;

import java.util.Map;

public class LogMainActivity extends MVVMActivity<LogMain, LogViewModel> {

    @Override
    public  LogViewModel createViewModel() {
        return new LogViewModel(this);
    }

    @Override
    public Map<Integer, Object> initVarMap(Map<Integer, Object> vars) {
        vars.put(BR.datapage,viewModel);
        return vars;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_log_main;
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {
        binding.setSecond(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = viewModel.log(new LogEntity(0, "123963", "0099", "", ""));
                Toast.makeText(LogMainActivity.this, ""+log, Toast.LENGTH_SHORT).show();

                MutableLiveData<Object> objectMutableLiveData = new MutableLiveData<>();
            }
        });
    }
}
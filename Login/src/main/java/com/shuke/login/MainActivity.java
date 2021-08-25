package com.shuke.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bw.zz.RetrofitFactory;
import com.bw.zz.protocol.BaseRespEntity;
import com.shuke.common.LogUtil;
import com.shuke.login.databinding.ActivityMainBinding;
import com.shuke.login.model.api.RegisterApi;
import com.shuke.login.model.pro.RegisterEntity;
import com.shuke.login.viewmodel.RegViewModel;
import com.shuke.mvvmcore.view.MVVMActivity;

import java.util.Map;

public class MainActivity extends MVVMActivity<ActivityMainBinding, RegViewModel> {

    @Override
    public RegViewModel createViewModel() {
        return new RegViewModel(this);
    }

    @Override
    public Map<Integer, Object> initVarMap(Map<Integer, Object> vars) {
        vars.put(BR.datapage,viewModel);
        return vars;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {
        binding.setSpot(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitFactory.getMyRetrofit()
                        .createRetrofit()
                        .create(RegisterApi.class)
                        .regis(viewModel.pageSource.getValue())
                        .observe(MainActivity.this, new Observer<BaseRespEntity<RegisterEntity>>() {
                            @Override
                            public void onChanged(BaseRespEntity<RegisterEntity> registerEntityBaseRespEntity) {
                                Toast.makeText(MainActivity.this, ""+registerEntityBaseRespEntity.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
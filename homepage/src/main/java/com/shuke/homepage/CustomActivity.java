package com.shuke.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.shuke.homepage.custom.CustomHobbyType;

import java.util.ArrayList;
import java.util.List;

public class CustomActivity extends AppCompatActivity {

    private CustomHobbyType custom;
    private Button customNext;

    public static List<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        initView();

        for (int i = 0; i < 10; i++) {
            custom.addItem("自定义" + i);
        }

        customNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int j = 0; j < CustomHobbyType.texts.size(); j++) {
                    list.add(CustomHobbyType.texts.get(j));
                }
                startActivity(new Intent(CustomActivity.this, MainActivity.class));
            }
        });
    }

    private void initView() {
        custom = (CustomHobbyType) findViewById(R.id.custom);
        customNext = (Button) findViewById(R.id.custom_next);
    }
}
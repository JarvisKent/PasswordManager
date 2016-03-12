package com.hzh.passwordmanager.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hzh.passwordmanager.utils.ActivityCollector;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

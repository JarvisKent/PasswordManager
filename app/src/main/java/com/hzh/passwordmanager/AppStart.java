package com.hzh.passwordmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hzh.passwordmanager.ui.activity.MainActivity;
import com.hzh.passwordmanager.ui.activity.SplashActivity;
import com.hzh.passwordmanager.utils.PreferencesUtils;

/**
 * Created by JarvisHuang on 2016/3/9.
 */
public class AppStart extends AppCompatActivity {
    public static String TAG = "APP_START";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        redirectTo();
    }

    private void redirectTo() {
        Intent intent = new Intent();

        boolean isFirst = PreferencesUtils.getBoolean(this,"firstOpen",true);
        if(isFirst){
            PreferencesUtils.putBoolean(this,"firstOpen",false);
            intent.setClass(this, SplashActivity.class);
        }else{
            intent.setClass(this,MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}

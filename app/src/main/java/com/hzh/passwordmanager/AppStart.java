package com.hzh.passwordmanager;

import android.content.Intent;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.utils.PreferenceHelper;

/**
 * Created by JarvisHuang on 2016/3/9.
 * 进入首页判断
 */
public class AppStart extends KJActivity {
    public static String TAG = "appstart";
    @Override
    public void setRootView() {
        redirectTo();
    }

    private void redirectTo() {
        Intent intent = new Intent();
        boolean isFirst = PreferenceHelper.readBoolean(aty, TAG, "first_open",
                true);
        if(isFirst){
            PreferenceHelper.write(aty, TAG, "first_open", false);
            intent.setClass(aty, Splash.class);
        }else{
            intent.setClass(aty,MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}

package com.hzh.passwordmanager.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by JarvisHuang on 2016/3/12.
 * 沉浸式状态栏，setContentView()后使用
 */
public class Translucentbarstest {
    public static void initState(AppCompatActivity context){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}

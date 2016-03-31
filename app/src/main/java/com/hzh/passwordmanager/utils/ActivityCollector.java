package com.hzh.passwordmanager.utils;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/12.
 * Activity管理类
 */
public class ActivityCollector {
    public static List<AppCompatActivity> list = new ArrayList<AppCompatActivity>();
    public static void addActivity(AppCompatActivity activity){
        if(!list.contains(activity)) {
            list.add(activity);
        }
    }

    public static void removeActivity(AppCompatActivity activity){
        if(list.contains(activity)) {
            list.remove(activity);
        }
    }

    //关闭全部activity
    public static void finishAll(){
        for (AppCompatActivity activity:list){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

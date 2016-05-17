package com.hzh.passwordmanager.utils;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/12.
 * Activity管理类
 */
public class ActivityCollector {
    public static List<FragmentActivity> list = new ArrayList<FragmentActivity>();
    public static void addActivity(FragmentActivity activity){
        if(!list.contains(activity)) {
            list.add(activity);
        }
    }

    public static void removeActivity(FragmentActivity activity){
        if(list.contains(activity)) {
            list.remove(activity);
        }
    }

    //关闭全部activity
    public static void finishAll(){
        for (FragmentActivity activity:list){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

package com.hzh.passwordmanager.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hzh.passwordmanager.ui.activity.MainActivity;
import com.hzh.passwordmanager.ui.base.BaseActivity;
import com.hzh.passwordmanager.ui.fragment.AddDataFragment;
import com.hzh.passwordmanager.ui.fragment.MainListFragment;
import com.hzh.passwordmanager.ui.fragment.ModifyShowPassword;
import com.hzh.passwordmanager.ui.fragment.MotifyDataFragment;
import com.hzh.passwordmanager.ui.fragment.SearchDataFragment;
import com.hzh.passwordmanager.ui.fragment.SettingFragment;
import com.hzh.passwordmanager.ui.fragment.WriteAndRead;

/**
 * Created by JarvisHuang on 2016/4/5.
 * 页面跳转方法，主要用于页面跳转；
 * 在非Main页面时，按返回键是返回到Main页面；
 * 在Main页面下，按返回键是退出
 */
public class SwitchPage {
    public static int MAIN = 1;         //主页
    public static int MOTIFY = 2;       //修改页面
    public static int SETTING = 3;      //设置页面
    public static int MOTIFY_PASSWORD = 4; //修改查看密码
    public static int EXPORT_AND_IMPORT = 5; //导入导出
    public static int SEARCH = 6;       //搜索
    public static int ADD = 7;          //添加页面
    public static int CURRENT_PAGE = MAIN;
    public static FragmentManager mFM;
    public static  void toMain(Context context,int id){
        Fragment f = new MainListFragment();
        if (null == mFM)
            mFM = ((MainActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = MAIN;
    }
    public static  void toSetting(Context context,int id){
        Fragment f = new SettingFragment();
        if (null == mFM)
            mFM = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = SETTING;
    }

    public static  void toImportAndExport(Context context,int id){
        Fragment f = new WriteAndRead();
        if (null == mFM)
            mFM = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = EXPORT_AND_IMPORT;
    }
    public static  void toMotifyPassword(Context context,int id){

        Fragment f = new ModifyShowPassword();
        if (null == mFM)
            mFM = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = MOTIFY_PASSWORD;
    }

    public static void toAddData(Context context,int id){
        Fragment f = new AddDataFragment();
        if (null == mFM)
            mFM = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = ADD;
    }
    public static void toSearchData(Context context,int id){
        Fragment f = new SearchDataFragment();
        if (null == mFM)
            mFM = ((BaseActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(id, f);
        ft.commitAllowingStateLoss();
        CURRENT_PAGE = SEARCH;
    }

}

package com.hzh.passwordmanager.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.hzh.passwordmanager.R;

/**
 * Created by JarvisHuang on 2016/3/9.
 * 引导界面
 */
public class SplashActivity extends AppIntro2{
    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance("标题1","描述24", R.mipmap.cb0304yp17, Color.WHITE));
        addSlide(AppIntroFragment.newInstance("标题2","描述21",R.mipmap.cb0304yp07, Color.WHITE));
        addSlide(AppIntroFragment.newInstance("标题3","描述23",R.mipmap.cb0304yp11, Color.WHITE));
        addSlide(AppIntroFragment.newInstance("标题4","描述22",R.mipmap.cb0304yp11, Color.WHITE));
    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onNextPressed() {
    }

    @Override
    public void onSlideChanged() {
    }
}

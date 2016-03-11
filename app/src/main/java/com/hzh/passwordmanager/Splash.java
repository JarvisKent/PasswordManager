package com.hzh.passwordmanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by JarvisHuang on 2016/3/9.
 * 引导界面
 *
 */
public class Splash extends AppIntro2{
    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance("标题1","描述2",R.mipmap.cb0304yp17, Color.WHITE));
        addSlide(AppIntroFragment.newInstance("标题2","描述2",R.mipmap.cb0304yp07, Color.WHITE));
        addSlide(AppIntroFragment.newInstance("标题3","描述2",R.mipmap.cb0304yp11, Color.WHITE));
    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent();
        intent.setClass(Splash.this,MainActivity.class);
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

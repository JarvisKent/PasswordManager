package com.hzh.passwordmanager;

import android.content.Intent;
import android.os.Bundle;

import com.hzh.passwordmanager.ui.BaseActivity;
import com.hzh.passwordmanager.ui.MainActivity;
import com.hzh.passwordmanager.ui.Splash;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.utils.PreferenceHelper;

/**
 * Created by JarvisHuang on 2016/3/9.
 */
public class AppStart extends BaseActivity {
    public static String TAG = "APP_START";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        redirectTo();
    }

    private void redirectTo() {
        Intent intent = new Intent();
        boolean isFirst = PreferenceHelper.readBoolean(this, TAG, "first_open",
                true);
        if(isFirst){
            PreferenceHelper.write(this, TAG, "first_open", false);
            intent.setClass(this, Splash.class);
        }else{
            intent.setClass(this,MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
}

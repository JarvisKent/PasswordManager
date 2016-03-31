package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseFragment;
/**
 * Created by JarvisHuang on 2016/3/31.
 */
public class AddDataFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add,container,false);
        return v;
    }


}

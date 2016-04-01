package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseFragment;

public class ModifyShowPassword extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_modify_show_password, container, false);

        return v;
    }
}

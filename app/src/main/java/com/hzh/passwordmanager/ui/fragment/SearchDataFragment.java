package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseFragment;

/**
 * Created by JarvisHuang on 2016/4/1.
 */
public class SearchDataFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search,container,false);
        RadioGroup searchKind = (RadioGroup) v.findViewById(R.id.rg_search);
        searchKind.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}

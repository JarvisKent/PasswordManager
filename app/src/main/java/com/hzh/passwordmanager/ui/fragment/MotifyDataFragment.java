package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.ui.base.BaseFragment;

/**
 * Created by JarvisHuang on 2016/4/5.
 */
public class MotifyDataFragment extends BaseFragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motify_data,container,false);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        Bundle data =getArguments();
        DataBean datas = data.getParcelable("motifyData");
        tv.setText("传递:"+datas.toString());
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}

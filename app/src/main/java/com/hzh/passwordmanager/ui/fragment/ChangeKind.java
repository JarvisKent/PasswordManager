package com.hzh.passwordmanager.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseFragment;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class ChangeKind extends BaseFragment {


    public ChangeKind() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_kind, container, false);
    }

}

package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.adapter.MainListAdapter;
import com.hzh.passwordmanager.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class MainListFragment extends BaseFragment {
    private RecyclerView recyclerView;
    public MainListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FragmentManager mFM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        v.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new AddDataFragment();
                if (null == mFM)
                    mFM = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = mFM.beginTransaction();
                ft.replace(R.id.fl_content, f);
                ft.commit();
            }
        });
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        initData();
    }
    /**
     * 初始化数据
     */
    private void initData() {
        //创建并设置Adapter
        List<String> list = new ArrayList<String>();
        for(int i=0;i<100;i++)  list.add("第"+i+"个");
        MainListAdapter mAdapter = new MainListAdapter(list,getActivity());
        recyclerView.setAdapter(mAdapter);
    }
}

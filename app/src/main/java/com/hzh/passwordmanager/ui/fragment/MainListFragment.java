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

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.adapter.MainListAdapter;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;
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
    public void onResume() {
        //TODO 刷新数据

        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FragmentManager mFM;
    private boolean isInvisiable = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        final com.github.clans.fab.FloatingActionButton addData = (com.github.clans.fab.FloatingActionButton) v.findViewById(R.id.menu_add);
        final com.github.clans.fab.FloatingActionButton searchData = (com.github.clans.fab.FloatingActionButton) v.findViewById(R.id.menu_search);
        addData.setOnClickListener(new View.OnClickListener() {
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
        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new SearchDataFragment();
                if(null == mFM){
                    mFM = getActivity().getSupportFragmentManager();
                }
                FragmentTransaction ft = mFM.beginTransaction();
                ft.replace(R.id.fl_content,f);
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
        DataDao dao = new DataDao(getActivity());
        List<DataBean> data = new ArrayList<DataBean>();
        data = dao.queryAll();
        MainListAdapter mAdapter = new MainListAdapter(data,getActivity());
        recyclerView.setAdapter(mAdapter);
    }

}

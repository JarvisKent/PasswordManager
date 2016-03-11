package com.hzh.passwordmanager;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hzh.passwordmanager.adapter.RecycleViewAdapter;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends KJActivity {

    @BindView(id = R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_main);

    }

    @Override
    public void initWidget() {
        super.initWidget();
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        //创建并设置Adapter

        List<String> list = new ArrayList<String>();
        for(int i=0;i<100;i++)
            list.add("第"+i+"个");
        RecycleViewAdapter mAdapter = new RecycleViewAdapter(list,MainActivity.this);
        recyclerView.setAdapter(mAdapter);

    }


}
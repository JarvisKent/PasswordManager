package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.adapter.MainListAdapter;
import com.hzh.passwordmanager.ui.base.BaseFragment;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;

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
    //测试按钮
    private Button add,delete,motify,show;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        final DataDao dataDao = new DataDao(getActivity());

        add = (Button) v.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("------add start ------------");
                DataBean bean = new DataBean();
                bean.setAccount("123");
                bean.setName("银行账号");
                bean.setKind(2);
                bean.setDesc("不知道是谁的账号");
                bean.setPassword("ABCD");
                dataDao.add(bean);
                DataBean b = dataDao.queryByAccount("123");
                System.out.println("添加的数据 = "+b.toString());
                System.out.println("--------add end--------");
            }
        });
        delete = (Button) v.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataDao.deleteByAccount("123");
                System.out.println("---------删除成功------------");
            }
        });
        motify = (Button) v.findViewById(R.id.motify);
        motify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--------motify data----------");
                  DataBean bean =   dataDao.queryByAccount("123");
                    bean.setAccount("23456");
                bean.setDesc("修改后描述");
                bean.setName("修改后的名字");
                bean.setKind(4);
                bean.setPassword("什么");
                dataDao.update(bean);
                System.out.println("--------motify success-----------");
            }
        });
        show = (Button) v.findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            List<DataBean> list = dataDao.queryAll();
                for (int i=0;i<list.size();i++){
                    System.out.println("--------show All---------");
                    System.out.println("数据"+i+" = "+list.get(i).toString());
                }
                System.out.println("------------finish -----------");
            }
        });
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
        for(int i=0;i<100;i++)
            list.add("第"+i+"个");
        MainListAdapter mAdapter = new MainListAdapter(list,getActivity());
        recyclerView.setAdapter(mAdapter);
    }
}

package com.hzh.passwordmanager.impl;

import com.hzh.passwordmanager.bean.DataBean;

import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/10.
 */
public class DataUtils implements IDataUtils {
    @Override
    public void add(int id, String name, String account, int kind, String password, String desc) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(int id, String name, String account, int kind, String password, String desc) {

    }

    @Override
    public DataBean queryById(int id) {
        return null;
    }

    @Override
    public List<DataBean> queryByAccount(String account) {
        return null;
    }

    @Override
    public List<DataBean> queryByName(String name) {
        return null;
    }

    @Override
    public List<DataBean> queryByKind(String kind) {
        return null;
    }

    @Override
    public List<DataBean> queryAll() {
        return null;
    }
}

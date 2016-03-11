package com.hzh.passwordmanager.impl;

import com.hzh.passwordmanager.bean.DataBean;

import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/10.
*
 */
public interface IDataUtils {
    /**
     * 插入一条记录
     * @param id
     * @param name
     * @param account
     * @param kind
     * @param password
     * @param desc
     */
    void add(int id,String name,String account,int kind,String password,String desc);

    /**
     * 删除
     */
    void delete();

    /**
     * 清空数据
     */
    void deleteAll();

    /**
     * 更新某一条信息
     * @param id
     * @param name
     * @param account
     * @param kind
     * @param password
     * @param desc
     */
    void update(int id,String name,String account,int kind,String password,String desc);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    DataBean queryById(int id);

    /**
     * 通过账号查询
     * @param account
     * @return
     */
    List<DataBean> queryByAccount(String account);

    /**
     * 通过名称查询
     * @param name
     * @return
     */
    List<DataBean> queryByName(String name);

    /**
     * 通过类型查询
     * @param kind
     * @return
     */
    List<DataBean> queryByKind(String kind);

    /**
     * 查询所有信息
     * @return
     */
    List<DataBean> queryAll();

}

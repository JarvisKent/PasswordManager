package com.hzh.passwordmanager.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.SQLiteHelper;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/11.
 * DataBaseOperation
 */
public class DataDao {
    private SQLiteHelper helper;
    private SQLiteDatabase dataBase;

    public DataDao(Context context){
        helper = new SQLiteHelper(context);
    }

    public void open(){
        if(dataBase == null || !dataBase.isOpen()){
            dataBase = helper.getWritableDatabase();
        }
    }

    public void close(){
        dataBase.close();
        dataBase = null;
    }

    public boolean checkDb(){
        open();
        if (dataBase !=null && dataBase.isOpen()){
            return true;
        }
        return false;
    }

    public int add(DataBean data){
        ContentValues values = new ContentValues();

        values.put(SQLiteHelper.ACCOUNT,data.getAccount());
        values.put(SQLiteHelper.DESC,data.getDesc());
        values.put(SQLiteHelper.KIND,data.getKind());
        values.put(SQLiteHelper.NAME,data.getName());
        values.put(SQLiteHelper.PASSWORD,data.getPassword());
        if (checkDb()) {
            long position = dataBase.insert(SQLiteHelper.TABLE, SQLiteHelper.ID, values);
            return Integer.parseInt(position+"");
        }
        return -1;
    }

    public int delete(int id){
        if (checkDb()){
            return dataBase.delete(SQLiteHelper.TABLE,SQLiteHelper.ID+"=?",new String[]{id+""});
        }
        return -1;
    }

    public int update(DataBean data){
        if(data != null){
            if (checkDb()){
                ContentValues values = new ContentValues();

                values.put(SQLiteHelper.PASSWORD,data.getPassword());
                values.put(SQLiteHelper.NAME,data.getName());
                values.put(SQLiteHelper.KIND,data.getKind());
                values.put(SQLiteHelper.DESC,data.getDesc());
                values.put(SQLiteHelper.ACCOUNT,data.getAccount());

                return dataBase.update(SQLiteHelper.TABLE,values,SQLiteHelper.ID+"=?",new String[]{data.getId()+""});
            }
            return -1;
        }
        return -1;
    }

    public DataBean queryByAccount(String account){
        if (checkDb()){
            Cursor cursor = dataBase.query(SQLiteHelper.TABLE,null,SQLiteHelper.ACCOUNT+"=?",new String[]{account},null,null,null);
            DataBean bean =  new DataBean();
            if (cursor !=null && cursor.moveToFirst()){
                bean = new DataBean();
                bean.setPassword(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PASSWORD)));
                bean.setKind(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.KIND)));
                bean.setId(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.ID)));
                bean.setDesc(cursor.getString(cursor.getColumnIndex(SQLiteHelper.DESC)));
                bean.setAccount(cursor.getString(cursor.getColumnIndex(SQLiteHelper.ACCOUNT)));
                bean.setName(cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME)));

            }
            cursor.close();
            return  bean;
        }
        return null;
    }
    public List<DataBean> queryByKind(int kind){
        if (checkDb()){
            List<DataBean> list = new ArrayList<DataBean>();
            Cursor cursor = dataBase.query(SQLiteHelper.TABLE,null,SQLiteHelper.KIND+"=?",new String[]{kind+""},null,null,null);
            if(cursor !=null){
                while (cursor.moveToNext()){
                    DataBean dataBean = new DataBean();

                    dataBean.setAccount(cursor.getString(cursor.getColumnIndex(SQLiteHelper.ACCOUNT)));
                    dataBean.setName(cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME)));
                    dataBean.setDesc(cursor.getString(cursor.getColumnIndex(SQLiteHelper.DESC)));
                    dataBean.setId(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.ID)));
                    dataBean.setKind(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.KIND)));
                    dataBean.setPassword(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PASSWORD)));

                    list.add(dataBean);
                }

            }
            cursor.close();
            return list;
        }
        return null;
    }
    public List<DataBean> queryByName(String name){
        if (checkDb()){
            List<DataBean> list = new ArrayList<DataBean>();
            Cursor cursor = dataBase.query(SQLiteHelper.TABLE,null,SQLiteHelper.NAME+"=?",new String[]{name},null,null,null);
            if(cursor !=null){
                while (cursor.moveToNext()){
                    DataBean dataBean = new DataBean();

                    dataBean.setAccount(cursor.getString(cursor.getColumnIndex(SQLiteHelper.ACCOUNT)));
                    dataBean.setName(cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME)));
                    dataBean.setDesc(cursor.getString(cursor.getColumnIndex(SQLiteHelper.DESC)));
                    dataBean.setId(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.ID)));
                    dataBean.setKind(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.KIND)));
                    dataBean.setPassword(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PASSWORD)));

                    list.add(dataBean);
                }

            }
            cursor.close();
            return list;
        }
        return null;
    }
    public List<DataBean> queryAll(){
        if (checkDb()){
            List<DataBean> list = new ArrayList<DataBean>();
            Cursor cursor = dataBase.query(SQLiteHelper.TABLE,null,null,null,null,null,null);
            if(cursor !=null){
                while (cursor.moveToNext()){
                    DataBean dataBean = new DataBean();

                    dataBean.setAccount(cursor.getString(cursor.getColumnIndex(SQLiteHelper.ACCOUNT)));
                    dataBean.setName(cursor.getString(cursor.getColumnIndex(SQLiteHelper.NAME)));
                    dataBean.setDesc(cursor.getString(cursor.getColumnIndex(SQLiteHelper.DESC)));
                    dataBean.setId(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.ID)));
                    dataBean.setKind(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.KIND)));
                    dataBean.setPassword(cursor.getString(cursor.getColumnIndex(SQLiteHelper.PASSWORD)));

                    list.add(dataBean);
                }

            }
            cursor.close();
            return list;
        }
        return null;
    }



}

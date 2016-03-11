package com.hzh.passwordmanager.bean;

/**
 * Created by JarvisHuang on 2016/3/9.
 */
public class DataBean {
    private int id;
    private String name;
    private String Account;
    private int kind;
    private String password;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        this.Account = account;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Account='" + Account + '\'' +
                ", kind=" + kind +
                ", password='" + password + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

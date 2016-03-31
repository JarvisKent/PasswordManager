package com.hzh.passwordmanager.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JarvisHuang on 2016/3/9.
 */
public class DataBean implements Parcelable{
    private int id;
    private String name;
    private String Account;
    private int kind;
    private String password;
    private String desc;

    public DataBean(){}

    public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel in) {
            return new DataBean(in);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };



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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.Account);
        dest.writeString(this.name);
        dest.writeString(this.password);
        dest.writeInt(this.kind);
        dest.writeString(this.desc);
    }
    protected DataBean(Parcel in) {
        this.id = in.readInt();
        this.kind = in.readInt();
        this.password = in.readString();
        this.name = in.readString();
        this.Account = in.readString();
        this.desc = in.readString();
    }
}

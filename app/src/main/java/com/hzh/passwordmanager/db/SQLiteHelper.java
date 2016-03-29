package com.hzh.passwordmanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JarvisHuang on 2016/3/11.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PasswordManagerDataBase";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE = "passwordManagerTable";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ACCOUNT = "account";
    public static final String KIND = "kind";
    public static final String PASSWORD = "password";
    public static final String DESC = "description";
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + TABLE + "(");
        sb.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append(NAME + " VARCHAR(20),");
        sb.append(ACCOUNT + " VARCHAR(30),");
        sb.append(KIND + " INTEGER,");
        sb.append(PASSWORD + " VARCHAR(50),");
        sb.append(DESC +  " VARCHAR(100))");
        System.out.print("createTable : "+sb.toString());
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}

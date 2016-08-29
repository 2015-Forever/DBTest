package com.hhdb.dbtest;

import android.database.sqlite.SQLiteDatabase;

import com.hhdb.dbtest.gen.DaoMaster;
import com.hhdb.dbtest.gen.DaoSession;

/**
 * Created by Administrator on 2016/8/27.
 */
public class Application extends android.app.Application {

    public static Application instance;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override public void onCreate() {
        super.onCreate();

        instance = this;
        setDatabase();
    }

    public static Application getInstance(){
        return instance;
    }

    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    public SQLiteDatabase getDb(){
        return db;
    }
}

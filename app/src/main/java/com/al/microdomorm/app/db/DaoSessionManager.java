package com.al.microdomorm.app.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.mydao.sample.DaoMaster;
import com.mydao.sample.DaoSession;

public class DaoSessionManager {

    public static volatile DaoSession daoSession;

    private final static String DB_NAME = "simple_db";

    public static synchronized DaoSession newInstance(Context context){
        if(daoSession == null){
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
            SQLiteDatabase db = devOpenHelper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
        return  daoSession;
    }
    public void close(){
        daoSession.getDatabase().close();
    }
}

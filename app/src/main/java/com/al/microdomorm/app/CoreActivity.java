package com.al.microdomorm.app;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import com.al.microdomorm.app.db.DaoSessionManager;
import com.mydao.sample.DaoMaster;
import com.mydao.sample.DaoSession;

public class CoreActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaoSessionManager.newInstance(this);
    }
}

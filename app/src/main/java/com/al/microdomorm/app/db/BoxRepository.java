package com.al.microdomorm.app.db;


import android.content.Context;
import com.mydao.sample.Box;
import com.mydao.sample.BoxDao;
import com.mydao.sample.DaoSession;

import java.util.List;

public class BoxRepository {

    private BoxDao boxDao;
    public BoxRepository(Context context, DaoSession daoSession){
        boxDao = daoSession.getBoxDao();
    }
    public void addNew(Box box){
        boxDao.insertOrReplace(box);
    }
    public List<Box> getAll(){
       return boxDao.loadAll();
    }
    public void deleteBuId(long id){
        boxDao.deleteByKey(id);
    }


}

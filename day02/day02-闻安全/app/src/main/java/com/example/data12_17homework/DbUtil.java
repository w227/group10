package com.example.data12_17homework;

import com.example.data12_17homework.MyApp.MyApp;
import com.example.data12_17homework.bean.CollectionDbBean;

import java.util.List;

public class DbUtil {
    private static DbUtil dbUtil;
    private final CollectionDbBeanDao collectionDbBeanDao;

    private DbUtil() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "collection");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        collectionDbBeanDao = daoSession.getCollectionDbBeanDao();
    }

    public static DbUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }


    public boolean insert(CollectionDbBean collectionDbBean) {
        if (!isInserted(collectionDbBean)) {
            long insert = collectionDbBeanDao.insert(collectionDbBean);
            return true;
        }
        return false;
    }

    public List<CollectionDbBean> query() {
        List<CollectionDbBean> dbUserBeans = collectionDbBeanDao.loadAll();
        return dbUserBeans;
    }

    private boolean isInserted(CollectionDbBean collectionDbBean) {
        List<CollectionDbBean> list = collectionDbBeanDao.queryBuilder().where(CollectionDbBeanDao.Properties.Title.eq(collectionDbBean.getTitle())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public void delete(CollectionDbBean collectionDbBean) {
        collectionDbBeanDao.delete(collectionDbBean);
    }
}

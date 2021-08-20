package com.bw.news.db;

import android.content.Context;

import androidx.room.Room;

import com.bw.news.MyApp;

/**
 * @Name:yao
 * @CreateDate: 2021/8/19 20:23
 * @ProjectName: News
 * @Package: com.bw.news.db
 * @ClassName: DBHelper
 */
public class DBHelper {
    private  static DBHelper dbHelper;
    private final TestDao testDao;

    public static DBHelper getDbHelper() {
        if (dbHelper==null){
            synchronized (DBHelper.class){
                if (dbHelper==null){
                    dbHelper=new DBHelper();
                }
            }
        }
        return dbHelper;
    }

    public  TestDao getTestDao() {
        return testDao;
    }

    public DBHelper() {
        testDao= Room.databaseBuilder(MyApp.context,TestDao.class,"PresonTable.db").build();
    }

    public  void closeDB(){
        if (testDao!=null&&testDao.isOpen()){
            testDao.close();
        }
    }

}

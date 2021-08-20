package com.bw.news.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Name:yao
 * @CreateDate: 2021/8/19 20:08
 * @ProjectName: News
 * @Package: com.bw.news.db
 * @ClassName: TestDao
 */
@Database(entities = {PersonEntity.class},version = 2)
public abstract class TestDao extends RoomDatabase {
    public abstract PersonDao personDao();
}

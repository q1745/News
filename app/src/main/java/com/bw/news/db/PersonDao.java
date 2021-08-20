package com.bw.news.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @Name:yao
 * @CreateDate: 2021/8/19 20:03
 * @ProjectName: News
 * @Package: com.bw.news.db
 * @ClassName: PersonDao
 */
@Dao
public interface PersonDao {
    @Query(value = "SELECT * FROM PresonTable")
    List<PersonEntity> All();

    @Query(value = "SELECT * FROM PresonTable WHERE id=:id")
    PersonEntity finId(int id);

    @Insert
    void add(String s);

    @Insert
     void addPreson(PersonEntity entity);

    @Delete
     void delePreson(PersonEntity entity);

    @Update
     void updataPreson(PersonEntity entity);

}

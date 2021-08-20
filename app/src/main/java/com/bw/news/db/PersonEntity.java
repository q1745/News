package com.bw.news.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @Name:yao
 * @CreateDate: 2021/8/19 19:55
 * @ProjectName: News
 * @Package: com.bw.news.db
 * @ClassName: PersonEntity
 */

@Entity(tableName = "PresonTable")
public class PersonEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo
    private String title;

    private int age;

    public PersonEntity() {
    }

    public PersonEntity(int id, String name, String title, int age) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.age = age;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", age=" + age +
                '}';
    }
}

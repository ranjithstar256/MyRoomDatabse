package com.example.mydatabse;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;



@Dao
public interface DaoSuperStars {
    @Query("SELECT * FROM SuperStars")
    List<SuperStars> getAll();

    @Query("SELECT * FROM SuperStars WHERE name LIKE :taskname ")
    SuperStars getdesktn(String taskname);


    @Insert
    void insert(SuperStars stars);
}

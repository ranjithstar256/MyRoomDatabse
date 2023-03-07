package com.example.mydatabse;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {SuperStars.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoSuperStars taskDao();
}
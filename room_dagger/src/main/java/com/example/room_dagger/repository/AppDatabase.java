package com.example.room_dagger.repository;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.room_dagger.model.Intern;

@Database(entities = {Intern.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract InternDao getInternDao();
}

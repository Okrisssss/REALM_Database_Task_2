package com.example.room_db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.room_db.database.dao.InternDAO;
import com.example.room_db.model.Intern;


@Database(entities = {Intern.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract InternDAO internDAO();
    }


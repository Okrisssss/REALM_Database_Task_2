package com.example.room_db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.room_db.model.Employee;

public class MyDatabase {
    @Database(entities = {Employee.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase{
        public abstract EmployeeDAO employeeDAO();
    }
}

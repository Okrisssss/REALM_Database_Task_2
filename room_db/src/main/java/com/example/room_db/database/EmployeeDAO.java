package com.example.room_db.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import com.example.room_db.model.Employee;

import java.util.List;

@Dao
public interface EmployeeDAO {

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee WHERE id = :id" )
    Employee getById(long id);

    @Insert
    void insert (Employee employee);

    @Update
    void update (Employee employee);

    @Delete
    void delete (Employee employee);
}

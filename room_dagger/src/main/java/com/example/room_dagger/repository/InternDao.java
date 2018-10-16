package com.example.room_dagger.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.room_dagger.model.Intern;

import java.util.List;

@Dao
public interface InternDao {
    @Insert
    void insert (Intern intern);

    @Update
    void update (Intern intern);

    @Delete
    void delete (Intern intern);

    @Query("SELECT * FROM Intern")
    List<Intern> getAll();

    @Query("SELECT * FROM Intern WHERE name = :name" )
    Intern getByName(String name);
}

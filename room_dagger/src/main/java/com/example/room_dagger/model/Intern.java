package com.example.room_dagger.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Intern {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String fName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getInfo() {
        return "Intern info" +
                "name=:" + name + ' ' +
                ", fname:" + fName +
                '\n';
    }
}
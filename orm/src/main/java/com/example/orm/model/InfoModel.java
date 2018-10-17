package com.example.orm.model;

import com.j256.ormlite.field.DatabaseField;

public class InfoModel {
    @DatabaseField(generatedId = true, columnName = "id")
    public int id;
    @DatabaseField(columnName = "name")
    public String name;
    public String email;

    public InfoModel(){
    }
    public InfoModel(final String name, final String email){
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.orm_lite_db.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Goals")
public class Goal {
    public static final String NAME = "name";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = NAME)
    private String name;
    @DatabaseField(dataType = DataType.DATE)
    private Date lastEditDate;
    @DatabaseField()
    private String notes;


    public Goal(){
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

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

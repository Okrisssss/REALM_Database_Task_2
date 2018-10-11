package com.example.orm_lite_db.database;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Interns")
public class Intern {
    public static final String NAME = "name";
    public static final String F_NAME = "family name";
    public static final String AGE = "age";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = NAME)
    private String name;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = F_NAME)
    private String fName;
    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER, columnName = AGE)
    private String age;
    @DatabaseField(dataType = DataType.DATE)
    private Date lastEditDate;
    @DatabaseField(dataType = DataType.STRING)
    private String notes;

}

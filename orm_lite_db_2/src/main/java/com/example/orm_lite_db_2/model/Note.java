package com.example.orm_lite_db_2.model;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;
@DatabaseTable(tableName = "Note")
public class Note {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String subject;
    @DatabaseField
    String text;
    @DatabaseField
    Date date;

    public Note() {
    }
    public Note(String subject, String text){
    super();
    this.subject = subject;
    this.text = text;
    }

    public String getInfo(){
        return "Note [id=" + id + ", subject=" + subject + ",text=" + text + ",date=" + date + "]";
    }
}

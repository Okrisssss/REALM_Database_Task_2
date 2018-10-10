package com.example.sql.model;

public class Intern {
    private int id;
    private String name;
    private String fname;
    private Integer age;

    public Intern(){
    }

    public Intern(int id,String name, String fname, Integer age) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.age = age;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

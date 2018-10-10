package apple.example.com.realm_database_task_2.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Intern  extends RealmObject{

    private int id;
    private String name;
    private String fname;
    private Integer age;
    private String stream;
    private String hobby;

    public Intern(){
    }

    public Intern(int id, String name, String fname, Integer age, String stream, String hobby) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.age = age;
        this.stream = stream;
        this.hobby = hobby;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getString() {
        return "Intern " +
                "name=" + name + ' ' +
                ", fname=" + fname + ' ' +
                ", age=" + age +
                ", stream=" + stream + ' ' +
                ", hobby=" + hobby + ' ' +
                '\n';
    }
}

package apple.example.com.realm_database_task_2.model;

import io.realm.RealmObject;

public class Intern  extends RealmObject{
    String name;
    String fname;
    Integer age;
    String stream;
    String hobby;

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

    @Override
    public String toString() {
        return "Intern " +
                "name=" + name + ' ' +
                ", fname=" + fname + ' ' +
                ", age=" + age +
                ", stream=" + stream + ' ' +
                ", hobby=" + hobby + ' ' +
                '\n';
    }
}

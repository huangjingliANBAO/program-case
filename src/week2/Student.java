package week2;

import java.io.Serializable;

/**
 * @Description 学生类
 * @Author jl_huang
 * @Date 2020-01-15
 **/
public class Student implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String grade;
    public Student(){
    }

    public Student(String id, String name, String sex, String grade) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
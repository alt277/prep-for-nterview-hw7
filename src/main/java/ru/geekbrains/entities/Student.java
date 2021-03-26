package ru.geekbrains.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")

        public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String familyName;

    @Column
    private Integer age;;

    @ManyToMany
    @JoinTable(
            name = "ties",
            joinColumns=@JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId")

)
    private List<Course> courses;

    public Student(){};
    public Student(Integer id, String firstName, String familyName, List<Course> courses){
        this.id=id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}'+   '\n';
    }
}


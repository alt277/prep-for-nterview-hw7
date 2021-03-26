package ru.geekbrains.entities;

import javax.persistence.*;


@Entity
@Table(name = "ties")
public class Ties {
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column
private Integer studentId;

@Column
private Integer courseId;

@Column
private Integer mark;

public Ties(){};

    public Ties(Integer id, Integer studentId, Integer courseId, Integer mark) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}

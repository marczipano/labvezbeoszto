package com.demonstrait.model;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)            //secret stuff
    private Integer id;

    private String name;
    private String year;
    private String tutor;

    public Course(String name, String year, String tutor) {
        this.name = name;
        this.year = year;
        this.tutor = tutor;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getTutor() {
        return tutor;
    }
    public Course() { }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    public void setId(Integer id) {
        this.id = id;
    }




    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", tutor='" + tutor + '\'' +
                '}';
    }
}

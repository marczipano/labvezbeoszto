package com.demonstrait.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, columnDefinition = "LONGVARBINARY")
    private Integer id;

    private String name;
    private String beginTime;
    private int duration = 2;

    /**
     * végső oktató majd a generálás után
     */
    private Integer tutorId = null;


    public Course(String name, String beginningTime, int duration) {
        this.name = name;
        this.beginTime = beginningTime;
        this.duration = duration;
    }

    public Course() {    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginningTime() {
        return beginTime;
    }

    public void setBeginningTime(String beginningTime) {
        this.beginTime = beginningTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginningTime=" + beginTime +
                ", duration=" + duration +
                ", tutorId=" + tutorId +
                '}';
    }
}

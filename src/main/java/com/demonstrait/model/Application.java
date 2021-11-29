package com.demonstrait.model;


import javax.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;

    private Integer courseId;
    private Integer candidateId;

    public Application(Integer candidateId, Integer courseId) {
        this.candidateId = candidateId;
        this.courseId = courseId;
    }

    public Application() {   }

    public Integer getId() {
        return id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public String toString() {
        return "TimeOfCourse{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", candidateId=" + candidateId +
                '}';
    }
}

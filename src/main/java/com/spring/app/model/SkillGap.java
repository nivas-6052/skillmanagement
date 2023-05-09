package com.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name="skillgap")
public class SkillGap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="emp_id",nullable = false)
    private String empId;
    @Column(name="emp_name",nullable = false)
    private String empName;
    @Column(name="skill_name",nullable = false)
    private String skillName;
    @Column(name="rating",nullable = false)
    private String rating;



    public long getId() {
        return id;
    }

    public SkillGap(String empId, String empName, String skillName, String rating) {
        this.empId = empId;
        this.empName = empName;
        this.skillName = skillName;
        this.rating = rating;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public SkillGap() {
    }

    @Override
    public String toString() {
        return "SkillGap{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", skillName='" + skillName + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}

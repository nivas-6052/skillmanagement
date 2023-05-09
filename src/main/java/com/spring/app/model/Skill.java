package com.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="emp_id",nullable = false)
    private String empId;
    @Column(name="skill_id",nullable = false)
    private String skillId;

    @Column(name="rating",nullable = false)
    private String rating;

    @Column(name="recently_used",nullable = false)
    private String recentlyUsed;

    @Column(name="experience",nullable = false)
    private String experience;
    public Skill() {
    }

    public Skill(String empId, String skillId, String rating, String recentlyUsed, String experience) {
        this.empId = empId;
        this.skillId = skillId;

        this.rating = rating;
        this.recentlyUsed = recentlyUsed;
        this.experience = experience;
    }

    public long getId() {
        return id;
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

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }



    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRecentlyUsed() {
        return recentlyUsed;
    }

    public void setRecentlyUsed(String recentlyUsed) {
        this.recentlyUsed = recentlyUsed;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "EmpDetails{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", skillId='" + skillId + '\'' +

                ", rating=" + rating +
                ", recentlyUsed=" + recentlyUsed +
                ", experience=" + experience +
                '}';
    }
}

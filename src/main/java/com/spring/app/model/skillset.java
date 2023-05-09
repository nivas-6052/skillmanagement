package com.spring.app.model;

import javax.persistence.*;




@Entity
@Table(name="skillset")
public class skillset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="skill_id",unique = true,nullable = false)
    private String skillId;
    @Column(name="skill_name",nullable = false)
    private String skillname;

    @Column(name="cop",nullable = false)
    private String cop;
    @Column(name="subcop",nullable = false)
    private String subcop;
    @Column(name="version",nullable = false)
    private String version;
    @Column(name="isdepricted",nullable = false)
    private String isdepricted;
    public long getId() {
        return id;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    public String getSubcop() {
        return subcop;
    }

    public void setSubcop(String subcop) {
        this.subcop = subcop;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsdepricted() {
        return isdepricted;
    }

    public void setIsdepricted(String isdepricted) {
        this.isdepricted = isdepricted;
    }


    public skillset() {
    }

    public skillset(String skillId, String skillname, String cop, String subcop, String version, String isdepricted) {
        this.skillId = skillId;
        this.skillname = skillname;
        this.cop = cop;
        this.subcop = subcop;
        this.version = version;
        this.isdepricted = isdepricted;
    }

    @Override
    public String toString() {
        return "skillset{" +
                "id=" + id +
                ", skillId='" + skillId + '\'' +
                ", skillname='" + skillname + '\'' +
                ", cop='" + cop + '\'' +
                ", subcop='" + subcop + '\'' +
                ", version='" + version + '\'' +
                ", isdepricted='" + isdepricted + '\'' +
                '}';
    }
}

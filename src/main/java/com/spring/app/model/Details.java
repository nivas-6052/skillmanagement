package com.spring.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="data")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="emp_id",nullable = false)
    private String empId;
    @Column(name="emp_name",nullable = false)
    private String empName;
    @Embedded

    @ElementCollection
    @CollectionTable(name = "data2", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name="skill_obj")
//    private SkillObj skillObj;
    private List<SkillObj> skillObj;

    public List<SkillObj> getSkillObj() {
        return skillObj;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", skillObj=" + skillObj +
                '}';
    }

    public Details(String empId, String empName, List<SkillObj> skillObj) {
        this.empId = empId;
        this.empName = empName;
        this.skillObj = skillObj;
    }

    public void setSkillObj(List<SkillObj> skillObj) {
        this.skillObj = skillObj;
    }








    public Details() {
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }




}

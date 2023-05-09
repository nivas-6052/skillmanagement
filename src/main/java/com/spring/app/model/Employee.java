package com.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="emp_id",unique = true,nullable = false)
    private String empId;
    @Column(name="emp_name",nullable = false)
    private String empName;

    @Column(name="password",nullable = false)
    private String password;
    public Employee() {
    }

    public Employee(String empId, String empName, String password) {
        this.empId = empId;
        this.empName = empName;
        this.password = password;
    }



    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

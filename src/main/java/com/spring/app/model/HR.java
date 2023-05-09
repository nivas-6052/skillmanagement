package com.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name="manager")
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="hr_id",unique = true,nullable = false)
    private String hrId;
    @Column(name="hr_name",nullable = false)
    private String hrName;

    @Column(name="password",nullable = false)
    private String password;

    public HR(String hrId, String hrName, String password) {
        this.hrId = hrId;
        this.hrName = hrName;
        this.password = password;
    }

    public String getHrId() {
        return hrId;
    }

    public void setHrId(String hrId) {
        this.hrId = hrId;
    }

    public HR() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HR{" +
                "id=" + id +
                ", hrName='" + hrName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

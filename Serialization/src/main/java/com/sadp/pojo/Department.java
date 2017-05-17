package com.sadp.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * Created by srawa5 on 5/15/2017.
 */

public class Department implements Serializable{

    private long deptId;
    private String deptName;
    @JsonIgnore
    private Employee deptLead;

    public Department() {
    }

    public Department(long deptId, String deptName, Employee deptLead) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLead = deptLead;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getDeptLead() {
        return deptLead;
    }

    public void setDeptLead(Employee deptLead) {
        this.deptLead = deptLead;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptLead=" + deptLead +
                '}';
    }
}

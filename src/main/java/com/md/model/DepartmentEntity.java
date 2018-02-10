package com.md.model;

import com.md.model.Annotation.Column;
import com.md.model.Annotation.PrimaryKey;
import com.md.model.Annotation.Table;

@Table(name = "department")
public class DepartmentEntity {
    @PrimaryKey
    @Column(name = "dept_no", length = 5)
    private String deptNo;
    @Column(name = "dept_name", length = 15)
    private String deptName;
    @Column(name = "location", length = 45)
    private String location;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s %s", deptNo, deptName, location);
    }
}

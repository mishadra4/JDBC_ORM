package com.md.model;

import com.md.model.Annotation.Column;
import com.md.model.Annotation.PrimaryKey;
import com.md.model.Annotation.Table;

@Table(name = "employee")
public class EmployeeEntity {
    @PrimaryKey
    @Column(name = "emp_no")
    private Integer empNo;
    @Column(name = "emp_fname",length = 45)
    private String empFirstName;
    @Column(name = "emp_lname",length = 45)
    private String epmLastName;
    @Column(name = "dept_no", length = 5)
    private String deptNo;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer empNo, String empFirstName, String epmLastName, String deptNo) {
        this.empNo = empNo;
        this.empFirstName = empFirstName;
        this.epmLastName = epmLastName;
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEpmLastName() {
        return epmLastName;
    }

    public void setEpmLastName(String epmLastName) {
        this.epmLastName = epmLastName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s %-15s %s", empNo, empFirstName, epmLastName, deptNo);
    }
}

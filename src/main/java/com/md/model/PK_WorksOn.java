package com.md.model;

import com.md.model.Annotation.Column;

public class PK_WorksOn {
    @Column(name = "emp_no")
    private Integer empNo;
    @Column(name = "project_no", length = 10)
    private String projectNo;

    public PK_WorksOn() {
    }

    public PK_WorksOn(Integer empNo, String projectNo) {
        this.empNo = empNo;
        this.projectNo = projectNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
}

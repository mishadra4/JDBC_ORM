package com.md.model;

import com.md.model.Annotation.Column;
import com.md.model.Annotation.PrimaryKey;
import com.md.model.Annotation.Table;

@Table(name = "project")
public class ProjectEntity {
    @PrimaryKey
    @Column(name = "project_no", length = 10)
    private String projectNo;
    @Column(name = "project_name", length = 45)
    private String projectName;
    @Column(name = "budget")
    private Integer budget;

    public ProjectEntity() {
    }

    public ProjectEntity(String projectNo, String projectName, Integer budget) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.budget = budget;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("%-11s %-15s %d", projectNo, projectName, budget);
    }
}

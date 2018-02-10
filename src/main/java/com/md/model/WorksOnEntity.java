package com.md.model;

import com.md.model.Annotation.Column;
import com.md.model.Annotation.PrimaryKeyComposite;
import com.md.model.Annotation.Table;

import java.sql.Date;

@Table(name = "works_on")
public class WorksOnEntity {
    @PrimaryKeyComposite
    private PK_WorksOn pk;
    @Column(name = "job", length = 45)
    private String job;
    @Column(name = "enter_date")
    private Date date;

    public WorksOnEntity() {
    }

    public WorksOnEntity(PK_WorksOn pk, String job, Date date) {
        this.pk = pk;
        this.job = job;
        this.date = date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PK_WorksOn getPk() {
        return pk;
    }

    public void setPk(PK_WorksOn pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-11s %-15s %s", pk.getEmpNo(), pk.getProjectNo(), job, date.toString());
    }
}

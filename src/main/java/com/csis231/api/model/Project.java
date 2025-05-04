package com.csis231.api.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Project implements Cloneable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "employee_name", nullable = true, length = 45)
    private String employeeName;
    @Basic
    @Column(name = "project_name", nullable = true, length = 45)
    private String projectName;
    @Basic
    @Column(name = "project_description", nullable = true, length = 45)
    private String projectDescription;
    @Basic
    @Column(name = "project_start", nullable = true)
    private Date projectStart;
    @Basic
    @Column(name = "project_end", nullable = true)
    private Date projectEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    public Date getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (employeeName != null ? !employeeName.equals(project.employeeName) : project.employeeName != null)
            return false;
        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (projectDescription != null ? !projectDescription.equals(project.projectDescription) : project.projectDescription != null)
            return false;
        if (projectStart != null ? !projectStart.equals(project.projectStart) : project.projectStart != null)
            return false;
        if (projectEnd != null ? !projectEnd.equals(project.projectEnd) : project.projectEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectDescription != null ? projectDescription.hashCode() : 0);
        result = 31 * result + (projectStart != null ? projectStart.hashCode() : 0);
        result = 31 * result + (projectEnd != null ? projectEnd.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

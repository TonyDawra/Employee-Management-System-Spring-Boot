package com.csis231.api.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee_info", schema = "employeemanagementsystem", catalog = "")
public class EmployeeInfo implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "employee_id", nullable = true)
    private Integer employeeId;
    @Basic
    @Column(name = "firstName", nullable = true, length = 100)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = true, length = 100)
    private String lastName;
    @Basic
    @Column(name = "position", nullable = true, length = 100)
    private String position;
    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    private Double salary;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeInfo that = (EmployeeInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                '}';
    }
}

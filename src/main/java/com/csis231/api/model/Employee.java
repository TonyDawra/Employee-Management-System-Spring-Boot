package com.csis231.api.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Employee implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "employee_id", nullable = true)
    private Integer employeeId;
    @Basic
    @Column(name = "first_name", nullable = true, length = 100)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 100)
    private String lastName;
    @Basic
    @Column(name = "gender", nullable = true, length = 100)
    private String gender;
    @Basic
    @Column(name = "phone_num", nullable = true, length = 100)
    private String phoneNum;
    @Basic
    @Column(name = "position", nullable = true, length = 100)
    private String position;
    @Basic
    @Column(name = "image", nullable = true, length = 100)
    private String image;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "status", nullable = true, length = 45)
    private String status;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (gender != null ? !gender.equals(employee.gender) : employee.gender != null) return false;
        if (phoneNum != null ? !phoneNum.equals(employee.phoneNum) : employee.phoneNum != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (image != null ? !image.equals(employee.image) : employee.image != null) return false;
        if (date != null ? !date.equals(employee.date) : employee.date != null) return false;
        if (status != null ? !status.equals(employee.status) : employee.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}

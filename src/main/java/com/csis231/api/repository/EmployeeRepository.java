package com.csis231.api.repository;

import com.csis231.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT COUNT(e.id) FROM Employee e")
    int countEmployees();

    @Query("SELECT e.date, COUNT(e.id) FROM Employee e GROUP BY e.date ORDER BY e.date ASC")
    List<Object[]> getEmployeeDates();

    @Query("SELECT e.firstName, e.lastName FROM Employee e")
    List<Object[]> getEmployeeNames();


}
package com.csis231.api.repository;

import com.csis231.api.model.EmployeeInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {
    @Query("SELECT COUNT(e.id) FROM EmployeeInfo e where e.salary != 0")
    public int countEmployeeInfos();

    @Query("SELECT COUNT(e.id) FROM EmployeeInfo e where e.salary = 0")
    public int countEmployeeInfosWithZeroSalary();

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeInfo e SET e.salary = :salary where e.id = :id")
    public void updateEmployeeInfoBySalary(Long id,Double salary);
}
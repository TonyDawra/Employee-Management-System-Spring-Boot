package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Employee;
import com.csis231.api.model.EmployeeInfo;
import com.csis231.api.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeInfoService {

    private final EmployeeInfoRepository employeeinfoRepository;

    @Autowired
    public EmployeeInfoService(EmployeeInfoRepository employeeinfoRepository) {
        this.employeeinfoRepository = employeeinfoRepository;
    }

    public int countEmployeeInfoById() {
        return employeeinfoRepository.countEmployeeInfos();
    }

    public int countEmployeeInfoByIdWithZeroSalary() {
        return employeeinfoRepository.countEmployeeInfosWithZeroSalary();
    }

    public void updateEmployeeInfoBySalary(Long id, double salary) {
        employeeinfoRepository.updateEmployeeInfoBySalary(id, salary);
    }

    public List<EmployeeInfo> getAllEmployeeInfos() {
        return employeeinfoRepository.findAll();
    }

    public EmployeeInfo getEmployeeInfoById(Long id) {
        return employeeinfoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmployeeInfo not found"));
    }

    public EmployeeInfo createEmployeeInfo(EmployeeInfo employeeinfo) {
        return employeeinfoRepository.save(employeeinfo);
    }

    public EmployeeInfo updateEmployeeInfo(Long id, EmployeeInfo employeeDetails) throws CloneNotSupportedException {
        EmployeeInfo employeeinfo = employeeinfoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmployeeInfo not found"));

        employeeinfo = (EmployeeInfo) employeeDetails.clone();
        return employeeinfoRepository.save(employeeinfo);
    }

    // Update and delete methods would need to be customized based on the fields of the EmployeeInfo class
}
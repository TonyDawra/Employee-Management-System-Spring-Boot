package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Employee;
import com.csis231.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int countEmployeeById() {
        return employeeRepository.countEmployees();
    }

    public Map<Date, Long> getEmployeeDates() {
        List<Object[]> results = employeeRepository.getEmployeeDates();
        Map<Date, Long> dateCounts = new HashMap<>();
        for (Object[] result : results) {
            dateCounts.put((Date) result[0], (Long) result[1]);
        }
        return dateCounts;
    }

    public List<String> getEmployeeNames() {
        List<Object[]> employeeNames = employeeRepository.getEmployeeNames();
        List<String> employeeNamesList = new ArrayList<>();
        for (Object[] employeeName : employeeNames) {
            employeeNamesList.add(employeeName[0] + " " + employeeName[1]);
        }
        return employeeNamesList;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) throws CloneNotSupportedException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employee = (Employee) (employeeDetails).clone();

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employeeRepository.delete(employee);
    }
}
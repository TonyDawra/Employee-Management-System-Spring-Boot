package com.csis231.api.controller;

import com.csis231.api.model.Employee;
import com.csis231.api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping //@addEmployeeListData
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/count") // @homeChart
    public int countEmployee() {
        return employeeService.countEmployeeById();
    }

    @GetMapping("/dates") // @homeEmployeeDates
    public Map<Date, Long> getEmployeeDates() {
        return employeeService.getEmployeeDates();
    }

    @PostMapping //@addEmployeeAdd
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/names")
    public List<String> getEmployeeNames() {
        return employeeService.getEmployeeNames();
    }

    @PutMapping("/{id}") //@addEmployeeupdate
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails, BindingResult result) throws CloneNotSupportedException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid employee data");
        }
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")  //@addEmployeeDelete
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
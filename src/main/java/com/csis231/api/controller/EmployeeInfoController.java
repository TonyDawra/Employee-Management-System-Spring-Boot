package com.csis231.api.controller;

import com.csis231.api.model.Employee;
import com.csis231.api.model.EmployeeInfo;
import com.csis231.api.service.EmployeeInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/employeeinfos")
public class EmployeeInfoController {

    private final EmployeeInfoService employeeinfoService;

    public EmployeeInfoController(EmployeeInfoService employeeinfoService) {
        this.employeeinfoService = employeeinfoService;
    }

    @GetMapping("/count") // @homeEmployeeTotalPresent
    public int countEmployeeInfo() {
        return employeeinfoService.countEmployeeInfoById();
    }

    @GetMapping("/count/zero-salary") // @homeTotalInactive
    public int countEmployeeInfoWithZeroSalary() {
        return employeeinfoService.countEmployeeInfoByIdWithZeroSalary();
    }

    @PutMapping("/{id}/update-salary/{salary}") // @salaryUpdate
    public void updateEmployeeInfoBySalary(@PathVariable Long id, @PathVariable double salary) {
        employeeinfoService.updateEmployeeInfoBySalary(id, salary);
    }

    @GetMapping //@salaryListData
    public List<EmployeeInfo> getAllEmployeeInfos() {
        return employeeinfoService.getAllEmployeeInfos();
    }

    @PostMapping
    public ResponseEntity<EmployeeInfo> createEmployeeInfo(@Valid @RequestBody EmployeeInfo employeeinfo) {
        EmployeeInfo savedEmployeeInfo = employeeinfoService.createEmployeeInfo(employeeinfo);
        return new ResponseEntity<EmployeeInfo>(savedEmployeeInfo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeInfo> getEmployeeInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeinfoService.getEmployeeInfoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployeeInfo(@PathVariable Long id, @Valid @RequestBody EmployeeInfo employeeDetails, BindingResult result) throws CloneNotSupportedException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid employeeinfo data");
        }
        EmployeeInfo updatedEmployeeInfo = employeeinfoService.updateEmployeeInfo(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployeeInfo);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployeeInfo(@PathVariable Long id) {
//        employeeinfoService.deleteEmployeeInfo(id);
//        return ResponseEntity.noContent().build();
//    }
}
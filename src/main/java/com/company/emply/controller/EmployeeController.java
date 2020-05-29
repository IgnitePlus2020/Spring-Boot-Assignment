package com.company.emply.controller;

import com.company.emply.model.Employees;
import com.company.emply.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    private List<Employees> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    private Employees getEmployees(@PathVariable("employeeId") int employeeId)
    {
        return employeeService.getEmployeesById(employeeId);
    }

    @DeleteMapping("/employee/{employeeId}")
    private void deleteEmployee(@PathVariable("employeeId") int employeeId)
    {
        employeeService.delete(employeeId);
    }

    @PostMapping("/employee")
    private  int saveEmployee(@RequestBody Employees employees)
    {
        employeeService.saveOrUpdate(employees);
        return employees.getEmployeeId();
    }

    @PutMapping("/employee/{employeeId}")
    private Employees update(@RequestBody Employees employees,@PathVariable("employeeId") int employeeId)
    {
        employeeService.update(employees,employeeId);
        return  employees;
    }
}

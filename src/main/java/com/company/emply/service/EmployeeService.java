package com.company.emply.service;

import com.company.emply.model.Employees;
import com.company.emply.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employees> getAllEmployees()
    {
        List<Employees> employees = new ArrayList<Employees>();
        employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
        return employees;
    }
    public  Employees getEmployeesById(int id)
    {
        return employeeRepository.findById(id).get();
    }
    public void saveOrUpdate(Employees employees){
        employeeRepository.save(employees);
    }
    public void delete(int id)
    {
        employeeRepository.deleteById(id);
    }
    public void update(Employees employees,int id)
    {
        employees.setEmployeeId(id);
        employeeRepository.save(employees);
    }
}

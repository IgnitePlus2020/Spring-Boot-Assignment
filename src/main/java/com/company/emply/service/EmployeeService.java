package com.company.emply.service;

import com.company.emply.exception.EmployeeNotFoundException;
import com.company.emply.model.Employees;
import com.company.emply.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        //return employeeRepository.findById(id).get();
        Optional<Employees> optionalEmployees = employeeRepository.findById(id);

        if(!optionalEmployees.isPresent())
            throw new EmployeeNotFoundException("Employee Record is not available...");

        return optionalEmployees.get();
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

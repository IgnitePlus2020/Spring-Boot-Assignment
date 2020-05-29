package com.company.emply.repository;

import com.company.emply.model.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employees,Integer> {
}

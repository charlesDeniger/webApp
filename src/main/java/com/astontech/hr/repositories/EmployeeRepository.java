package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chardeni1 on 8/29/2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
}

package com.astontech.hr.rest;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chardeni1 on 8/29/2016.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeRest {

    private Logger log = Logger.getLogger(EmployeeRest.class);

    @Autowired
    private EmployeeService employeeService;

    //Get all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Employee> getAll() {
        return employeeService.listAllEmployees();
        }
    //Get by id
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Employee getById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    //save
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee save(@ModelAttribute("employee") Employee employee) {

        System.out.println(employee.getFirstName());
        System.out.println(employee.getId());
        System.out.println(employee.getVersion());

        return employeeService.saveEmployee(employee);
    }
    //delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        boolean result = false;

        try {
            employeeService.deleteEmployee(id);
            result = true;
        } catch (Exception ex) {
            log.error(ex);
        }
        return result;
    }

    }

package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chardeni1 on 8/29/2016.
 */
@Controller
public class EmployeeController {


    @RequestMapping("/employee")
    public String employeePage() {

        return "employee";
    }

}

package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by chardeni1 on 8/29/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;


    @Test
    public void employeeServiceSaveTest() {
        Employee employee1 = new Employee();
        employee1.setFirstName("Tony");
        employee1.setLastName("Morano");
        employee1.setBackground("Java Developer as well");


        assertNull(employee1.getId());
        employeeService.saveEmployee(employee1);
        System.out.println(employee1.getId());
        System.out.println(employee1.getFirstName());
        Employee employee = employeeService.getEmployeeById(employee1.getId());
        employee.setFirstName("Charles");
        System.out.println(employee.getId());
        employeeService.saveEmployee(employee1);
        System.out.println( employee.getId());

        assertNotNull(employee1.getId());

        //fetch

        Employee fetchedEmployee = employeeService.getEmployeeById(employee1.getId());
        assertNotNull(fetchedEmployee);
        assertEquals(employee1.getId(), fetchedEmployee.getId());


        // update

        fetchedEmployee.setFirstName("TonyTest");
        employeeService.saveEmployee(fetchedEmployee);

        Employee updatedEmployee = employeeService.getEmployeeById(fetchedEmployee.getId());
        assertEquals("TonyTest", updatedEmployee.getFirstName());

    }

}

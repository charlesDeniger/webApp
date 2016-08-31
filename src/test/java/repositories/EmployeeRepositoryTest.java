package repositories;


import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by chardeni1 on 8/29/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setFirstName("BipinTest");
        employee.setLastName("ButalaTest");
        employee.setBackground("Java Developer");


        assertNull(employee.getId());
        employeeRepository.save(employee);
        assertNotNull(employee.getId());

        //fetch
        Employee fetchEmployee = employeeRepository.findOne(employee.getId());

        assertNotNull(fetchEmployee);

        assertEquals(employee.getId(), fetchEmployee.getId());

        //update

        fetchEmployee.setFirstName("Bipin");
        employeeRepository.save(fetchEmployee);

        Employee fetchUpdatedEmployee = employeeRepository.findOne(fetchEmployee.getId());

        assertEquals("Bipin", fetchUpdatedEmployee.getFirstName());
    }
}

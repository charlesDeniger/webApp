package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by chardeni1 on 8/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testSaveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setYear("2012");

        assertNull(vehicle.getId());
        vehicleRepository.save(vehicle);

//        assertNull(vehicle.getId());
        Vehicle fetchedVehicle = vehicleRepository.findOne(vehicle.getId());

        assertEquals(vehicle.getId(), fetchedVehicle.getId());
//        assertEquals()
    }
}

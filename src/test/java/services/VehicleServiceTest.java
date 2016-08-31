package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
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
 * Created by chardeni1 on 8/12/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleModelService vehicleModelService;

    @Test
    public void VehicleServiceTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        System.out.println(vehicle.getId());
        vehicleModelService.deleteVehicleFromVehicleList(1);
        assertNull(vehicleService.getVehicleById(1));

  //      System.out.println(vehicleService.findVehicleModelNameFromVehicleModelByVehicleModelId(1));
//        assertNotNull(vehicle);
    }



}

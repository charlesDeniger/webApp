package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by chardeni1 on 8/17/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class VehicleModelServiceTest {

    @Autowired
    VehicleModelService vehicleModelService;
    @Autowired
    VehicleMakeService vehicleMakeService;

    @Test
    public void findModelTest() {
//        Element element = new Element("ServiceTest");
//
//        //        //save element, verify it has an ID after the save.
//
//        assertNull(element.getId());
//        elementService.saveElement(element);
//        assertNotNull(element.getId());
//
//        //fetch
//        Element fetchedElement = elementService.getElementById(element.getId());
//        assertNotNull(fetchedElement);
//        assertEquals(element.getId(), fetchedElement.getId());
//
//        //update
//        fetchedElement.setElementName("Email");
//        elementService.saveElement(fetchedElement);
//
//        Element updatedElement = elementService.getElementById(fetchedElement.getId());
//        assertEquals(updatedElement.getElementName(), "Email");

    }
    @Test
    public void findModelsByMake() {
        Iterable<VehicleModel> vehicleModels = vehicleModelService.listAllVehicleModels();
        for (VehicleModel vehicleModel : vehicleModels) {
            vehicleModel.getVehicleMake().getId();
        }

    }
}

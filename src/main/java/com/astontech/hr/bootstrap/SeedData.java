package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chardeni1 on 8/8/2016.
 */
/**
 * Created by brenroon1 on 8/8/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateVehicles();

        generateEmployee();

    }

    private void generateVehicles(){

        List<VehicleMake> makeListToUpload = new ArrayList<VehicleMake>();

        makeListToUpload.add(new VehicleMake("Honda"));
        makeListToUpload.add(new VehicleMake("Ford"));
        makeListToUpload.add(new VehicleMake("Jeep"));

        vehicleMakeService.saveVehicleMakeList(makeListToUpload);

        List<VehicleModel> modelListToUpload = new ArrayList<VehicleModel>();

        modelListToUpload.add(new VehicleModel("F-150",vehicleMakeService.getVehicleMakeById(2)));
        modelListToUpload.add(new VehicleModel("F-250",vehicleMakeService.getVehicleMakeById(2)));
        modelListToUpload.add(new VehicleModel("Pilot",vehicleMakeService.getVehicleMakeById(1)));
        modelListToUpload.add(new VehicleModel("CRV",vehicleMakeService.getVehicleMakeById(1)));
        modelListToUpload.add(new VehicleModel("Wrangler",vehicleMakeService.getVehicleMakeById(3)));

        vehicleModelService.saveVehicleModelList(modelListToUpload);

        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(new Vehicle(modelListToUpload.get(2),"1299","license","IIIIIIIIIIIIIIIIIIIIII","red"));
        vehicleList.add(new Vehicle(modelListToUpload.get(0),"2100","plate","|||||||||||||","orange"));
        vehicleList.add(new Vehicle(modelListToUpload.get(1),"1999","info","aihfvas","yellow"));
        vehicleList.add(new Vehicle(modelListToUpload.get(2),"1009","plateInfo","aihfvas","green"));
        vehicleList.add(new Vehicle(modelListToUpload.get(3),"1009","plateInfo","aihfvas","blue"));
        vehicleList.add(new Vehicle(modelListToUpload.get(0),"1239","plateInfo","aihfvas","purple"));
        vehicleList.add(new Vehicle(modelListToUpload.get(1),"1919","plateInfo","aihfvas","red"));
        vehicleList.add(new Vehicle(modelListToUpload.get(1),"1949","plateInfo","aihfvas","yellow"));
        vehicleList.add(new Vehicle(modelListToUpload.get(3),"1939","plateInfo","aihfvas","blue"));
        vehicleList.add(new Vehicle(modelListToUpload.get(2),"1929","licpla","aihfvas","green"));

        vehicleService.saveVehicleList(vehicleList);

    }

    private void generateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Bipin");
        employee.setLastName("Butala");
        employee.setBackground("Java Developer");
        employeeService.saveEmployee(employee);


        Employee employee1 = new Employee();
        employee1.setFirstName("Tony");
        employee1.setLastName("Morano");
        employee1.setBackground("Java Developer as well");

        employeeService.saveEmployee(employee1);


        Employee employee2 = new Employee();
        employee2.setFirstName("Dan");
        employee2.setLastName("Simmer");
        employee2.setBackground("Dot Net Developer");
        employeeService.saveEmployee(employee2);


        Employee employee3 = new Employee();
        employee3.setFirstName("Sean");
        employee3.setLastName("Nilsen");
        employee3.setBackground("Contact Center Engineer");

        employeeService.saveEmployee(employee3);
    }
}

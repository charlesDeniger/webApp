package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by chardeni1 on 8/11/2016.
 */
public class VehicleVO {


    private String newVehicleMake;
    private String newVehicleModel;
    private Iterable<Vehicle> vehicleList;

    private Vehicle vehicle;
    private Iterable<Vehicle> vehicleIterable;
    private VehicleModel vehicleModel;
    private Iterable<VehicleModel> vehicleModelIterable;
    private VehicleMake vehicleMake;
    private Iterable<VehicleMake> vehicleMakeIterable;

    public VehicleVO() {

    }

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public Iterable<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(Iterable<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Iterable<Vehicle> getVehicleIterable() {
        return vehicleIterable;
    }

    public void setVehicleIterable(Iterable<Vehicle> vehicleIterable) {
        this.vehicleIterable = vehicleIterable;
    }

    public Iterable<VehicleModel> getVehicleModelIterable() {
        return vehicleModelIterable;
    }

    public void setVehicleModelIterable(Iterable<VehicleModel> vehicleModelIterable) {
        this.vehicleModelIterable = vehicleModelIterable;
    }

    public Iterable<VehicleMake> getVehicleMakeIterable() {
        return vehicleMakeIterable;
    }

    public void setVehicleMakeIterable(Iterable<VehicleMake> vehicleMakeIterable) {
        this.vehicleMakeIterable = vehicleMakeIterable;
    }
}

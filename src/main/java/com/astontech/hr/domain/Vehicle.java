package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chardeni1 on 8/12/2016.
 */
@Entity

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Integer id;

    @Version
    private Integer version;
    private String year;
    private String LicensePlate;
    private String VIN;
    private String color;

    @ManyToOne( cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinColumn(name="vehicleModel_id")
    private VehicleModel vehicleModel;

    public Vehicle() {
    }

    public Vehicle(String color) {
        this.color = color;
    }

    public Vehicle(VehicleModel vehicleModel) {
        this.setVehicleModel(vehicleModel);
    }
    public Vehicle(VehicleModel vehicleModel, String year,String licensePlate, String vin, String color){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVIN(vin);
        this.setColor(color);
        this.setVehicleModel(vehicleModel);
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}

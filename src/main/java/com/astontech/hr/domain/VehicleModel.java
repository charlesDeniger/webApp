package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chardeni1 on 8/12/2016.
 */
@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleModel_id")
    private Integer id;

    @Version
    private Integer version;
    private String vehicleModelName;

    @ManyToOne( cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinColumn(name="vehicleMake_id")
    private VehicleMake vehicleMake;


    public VehicleModel() {

    }
    public VehicleModel(VehicleMake vehicleMake) {
        this.setVehicleMake(vehicleMake);
    }
    public VehicleModel(String vehicleModelName, VehicleMake vehicleMake) {
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMake(vehicleMake);
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

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }


    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}

package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chardeni1 on 8/12/2016.
 */
@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleMake_id")
    private Integer id;

    @Version
    private Integer version;
    private String vehicleMakeName;
    // private List<VehicleMake>vehicleMakeList;

    public VehicleMake() {
    }

    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
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

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }
}
//
//    public List<VehicleMake> getVehicleMakeList() {
//        return vehicleMakeList;
//    }
//
//    public void setVehicleMakeList(List<VehicleMake> vehicleMakeList) {
//        this.vehicleMakeList = vehicleMakeList;
//    }
//}

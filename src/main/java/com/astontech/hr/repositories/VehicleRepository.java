package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chardeni1 on 8/12/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
    String findVehicleModelNameFromVehicleModelByVehicleModelId(int id);
}

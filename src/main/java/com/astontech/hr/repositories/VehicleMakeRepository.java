package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chardeni1 on 8/12/2016.
 */
public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {
    List<VehicleModel> findVehicleModelsById(Integer id);
}

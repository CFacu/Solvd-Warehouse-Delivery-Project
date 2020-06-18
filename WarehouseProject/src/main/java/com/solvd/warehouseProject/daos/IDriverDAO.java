package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Driver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDriverDAO extends IDAO<Driver>{
    List<Driver> getAllByTruckId(@Param("id")Long id);
}

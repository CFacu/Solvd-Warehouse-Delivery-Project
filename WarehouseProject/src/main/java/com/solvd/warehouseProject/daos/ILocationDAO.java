package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Location;
import org.apache.ibatis.annotations.Param;

public interface ILocationDAO extends IDAO<Location> {
    void addToCity(@Param("city") City city, @Param("location")Location location);
}

package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Company;
import com.solvd.warehouseProject.models.Location;
import com.solvd.warehouseProject.models.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWarehouseDAO extends IDAO<Warehouse> {
    void addLocation(@Param("location")Location location, @Param("warehouse")Warehouse warehouse);
    void addToCompany(@Param("company")Company company, @Param("warehouse")Warehouse warehouse);
    Warehouse getByLocationId(@Param("id")Long id);
    List<Warehouse> getAllByCompanyId(@Param("id")Long id);
}

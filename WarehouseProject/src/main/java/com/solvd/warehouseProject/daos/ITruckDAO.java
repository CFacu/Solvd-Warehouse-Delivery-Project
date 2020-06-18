package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Company;
import com.solvd.warehouseProject.models.Truck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITruckDAO extends IDAO<Truck> {
    void addToCompany(@Param("company") Company company, @Param("truck") Truck truck);
    List<Truck> getAllByCompanyId(@Param("id")Long id);
}

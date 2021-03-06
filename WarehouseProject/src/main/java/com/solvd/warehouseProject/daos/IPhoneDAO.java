package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Driver;
import com.solvd.warehouseProject.models.Phone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPhoneDAO extends IDAO<Phone>{
    void addToDriver(@Param("driver")Driver driver, @Param("phone")Phone phone);
    List<Phone> getAllByDriverId(@Param("id")Long id);
}

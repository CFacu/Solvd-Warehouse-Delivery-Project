package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.City;
import com.solvd.warehouseProject.models.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICityDAO extends IDAO<City>{
    void addToCountry(@Param("country")Country country, @Param("city")City city);
    List<City> getAllByCountryId(@Param("id")Long id);
}

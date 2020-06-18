package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.Truck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderDAO extends IDAO<Order> {
    void updateVolume(@Param("id") Long id);
    void updatePrice(@Param("id") Long id);
    void addToTruck(@Param("truck") Truck truck, @Param("order") Order order);
    List<Order> getAllByTruckId(@Param("id")Long id);
}
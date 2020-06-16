package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Order;
import com.solvd.warehouseProject.models.OrderDetail;
import org.apache.ibatis.annotations.Param;

public interface IOrderDAO extends IDAO<Order> {
    void updateVolume(@Param("id") Long id);
    void updatePrice(@Param("id") Long id);
}
package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.Product;
import org.apache.ibatis.annotations.Param;

public interface IProductDAO extends IDAO<Product> {
    Product getByOrderDetailId(@Param("id")Long id);
}

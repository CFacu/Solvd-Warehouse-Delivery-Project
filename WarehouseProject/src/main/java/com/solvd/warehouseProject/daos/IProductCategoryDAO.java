package com.solvd.warehouseProject.daos;

import com.solvd.warehouseProject.models.ProductCategory;
import org.apache.ibatis.annotations.Param;

public interface IProductCategoryDAO extends IDAO<ProductCategory> {
    ProductCategory getByProductId(@Param("id")Long id);
}

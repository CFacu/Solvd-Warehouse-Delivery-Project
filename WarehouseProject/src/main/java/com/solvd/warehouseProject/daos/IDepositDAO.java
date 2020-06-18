package com.solvd.warehouseProject.daos;

import org.apache.ibatis.annotations.Param;

import com.solvd.warehouseProject.models.Deposit;
import com.solvd.warehouseProject.models.OrderDetail;
import com.solvd.warehouseProject.models.Warehouse;

public interface IDepositDAO extends IDAO<Deposit>{

	Deposit get(@Param("warehouse")Warehouse warehouse,@Param("orderDetail") OrderDetail orderDetail);

}

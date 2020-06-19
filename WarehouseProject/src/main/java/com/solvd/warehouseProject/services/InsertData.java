package com.solvd.warehouseProject.services;

import com.solvd.warehouseProject.models.Company;

public class InsertData {
    public static void insertCompanyIntoDB(Company company) {
        CompanyService companyService = new CompanyService();
        WarehouseService warehouseService = new WarehouseService();
        TruckService truckService = new TruckService();
        OrderService orderService = new OrderService();
        OrderDetailService orderDetailService = new OrderDetailService();
        ProductService productService = new ProductService();
        DriverService driverService = new DriverService();
        PhoneService phoneService = new PhoneService();
        ProductCategoryService categoryService = new ProductCategoryService();

        companyService.insert(company);
        company.getWarehouses().forEach(x -> {
            warehouseService.insert(x);
            warehouseService.addToCompany(company, x);
        });
        company.getTrucks().forEach(x -> {
            truckService.insert(x);
            truckService.addToCompany(company, x);
            x.getDrivers().forEach(z -> {
                driverService.insert(z);
                z.getPhones().forEach(v -> {
                    phoneService.insert(v);
                    phoneService.addToDriver(z, v);
                });
            });
            x.getOrders().forEach(z -> {
                orderService.insert(z);
                orderService.addToTruck(x, z);
                z.getOrderDetails().forEach(v -> {
                    orderDetailService.insert(v);
                    orderDetailService.addToOrder(v, z);
                    productService.insert(v.getProduct());
                    categoryService.insert(v.getProduct().getProductCategory());
                });
            });
        });
    }
}

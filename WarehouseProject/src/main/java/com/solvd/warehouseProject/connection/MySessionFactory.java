package com.solvd.warehouseProject.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.solvd.warehouseProject.daos.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySessionFactory {

	private final static Logger LOGGER = LogManager.getLogger(MySessionFactory.class);
	
	private static SqlSessionFactory sqlSessionFactory;

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			LOGGER.error(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}

	public static ICityDAO getCityMapper() {
		return getSessionFactory().openSession(true).getMapper(ICityDAO.class);
	}

	public static ICompanyDAO getCompanyMapper() {
		return getSessionFactory().openSession(true).getMapper(ICompanyDAO.class);
	}

	public static ICountryDAO getCountryMapper() {
		return getSessionFactory().openSession(true).getMapper(ICountryDAO.class);
	}

	public static IDriverDAO getDriverMapper() {
		return getSessionFactory().openSession(true).getMapper(IDriverDAO.class);
	}

	public static ILocationDAO getLocationMapper() {
		return getSessionFactory().openSession(true).getMapper(ILocationDAO.class);
	}

	public static IOrderDAO getOrderMapper() {
		return getSessionFactory().openSession(true).getMapper(IOrderDAO.class);
	}

	public static IOrderDetailDAO getOrderDetailMapper() {
		return getSessionFactory().openSession(true).getMapper(IOrderDetailDAO.class);
	}

	public static IPhoneDAO getPhoneMapper() {
		return getSessionFactory().openSession(true).getMapper(IPhoneDAO.class);
	}

	public static IPhoneTypeDAO getPhoneTypeMapper() {
		return getSessionFactory().openSession(true).getMapper(IPhoneTypeDAO.class);
	}

	public static IProductCategoryDAO getProductCategoryMapper() {
		return getSessionFactory().openSession(true).getMapper(IProductCategoryDAO.class);
	}

	public static IProductDAO getProductMapper() {
		return getSessionFactory().openSession(true).getMapper(IProductDAO.class);
	}

	public static ITruckDAO getTruckMapper() {
		return getSessionFactory().openSession(true).getMapper(ITruckDAO.class);
	}

	public static IWarehouseDAO getWarehouseMapper() {
		return getSessionFactory().openSession(true).getMapper(IWarehouseDAO.class);
	}


}

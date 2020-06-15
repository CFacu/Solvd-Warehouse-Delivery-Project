package com.solvd.warehouseProject.connection;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySessionFactory {

	private final static Logger LOGGER = LogManager.getLogger(MySessionFactory.class);
	
	private static SqlSessionFactory sqlSessionFactory;
	private static MySessionFactory session;
	
	private MySessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSessionFactory getSessionFactory() {
		if (sqlSessionFactory == null)
			session = new MySessionFactory();
		return sqlSessionFactory;
	}
}

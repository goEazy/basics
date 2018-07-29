package com.goeazy.learn.context;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.goeazy.learn.dao.CustomersDaoImpl;

public class Application {


	private static Application instance;
	
	public static final String DATASOURCE_ID = "db-config.xml";
	public static final String APPLICATION_CONTEXT_KEY = "application-context.xml";
	public static final String JDBC_TEMPLATE_ID = "jdbcTemplate";
	public static final String DATA_SOURCE = "dataSource";
	
	ClassPathXmlApplicationContext appContext;
	ClassPathXmlApplicationContext dataSrcContext;
	
	/**
	 * 
	 */
	private Application() {
		appContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_KEY);
		dataSrcContext = new ClassPathXmlApplicationContext(DATASOURCE_ID);
	}

	/**
	 * @return
	 */
	public JdbcTemplate getJdbcTemplate(){
		return dataSrcContext.getBean(JDBC_TEMPLATE_ID, JdbcTemplate.class);
	}
	
	/**
	 * @return
	 */
	public DataSource getDataSource(){
		return dataSrcContext.getBean(DATA_SOURCE, DataSource.class);
	}
	
	public CustomersDaoImpl getCustomersDao(){
		return appContext.getBean("customersDaoImpl", CustomersDaoImpl.class);
	}
	
	/**
	 * @return instance
	 */
	public static Application getInstance(){
		return instance;
	}
	
	/**
	 * 
	 */
	public static void init(){
		System.out.println("Hello I am Alive!!");
		if(instance == null){
			instance = new Application();
		}
	}
	/**
	 * 
	 */
	private void clearContext(){
		appContext.destroy();
		appContext = null;
		dataSrcContext.destroy();
		dataSrcContext = null;
	}
	
	/**
	 * 
	 */
	public static void destroy(){
		instance.clearContext();
	}
}

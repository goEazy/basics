package com.goeazy.learn.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		Application.destroy();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		Application.init();
	}

}

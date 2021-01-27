package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppPreferenceListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//Access the Application;
		ServletContext appScope=arg0.getServletContext();
		appScope.setAttribute("email", "technohunk100@gmail.com");
		appScope.setAttribute("address", "H-11, SEC-23,SANJAY NAGAR, GHAZIABAD");
		appScope.setAttribute("mobile", "+9198730037202");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}

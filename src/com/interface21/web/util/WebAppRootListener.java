package com.interface21.web.util;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import com.interface21.web.util.WebUtils;

/**
 * Listener that sets a system property to the web application root
 * directory. The key of the system property can be defined with
 * the "webAppRootKey" init parameter at the servlet context level
 * (i.e. web.xml), the default key is "webapp.root".
 *
 * <p>Can be used for toolkits that support substition with
 * system properties (i.e. System.getProperty values),
 * like Log4J's ${key} syntax within log file locations.
 *
 * <p>Note: This listener should be placed before
 * ContextLoaderListener in web.xml, when used for Log4J.
 * 
 * <p>Note: Log4jConfigServlet sets the system property implicitly,
 * so there's no need for this listener in addition to it.
 *
 * @author Juergen Hoeller
 * @since 18.04.2003
 * @see WebUtils#setWebAppRootSystemProperty
 * @see Log4jConfigServlet
 */
public class WebAppRootListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		WebUtils.setWebAppRootSystemProperty(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

}
package car.infrastructure.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import car.infrastructure.util.ApplicationContextUtil;

public class CarContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sce.getServletContext());
		ApplicationContextUtil.setApplicationContext(ac);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}

package de.beuth_hochschule.pfk.enroll.core;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		registerServices(bundleContext);
	}

	private void registerServices(BundleContext context) {
		EnrollService service = new EnrollServiceImpl();
		Properties properties = new Properties();
		context.registerService(EnrollService.class.getName(), service, properties);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
}

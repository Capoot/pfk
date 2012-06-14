package de.beuth_hochschule.pfk.marks.core;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;
import de.beuth_hochschule.pfk.marks.core.service.MarksService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private static ServiceReference enrollReference;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		MarksService service = new MarksServiceImpl(getEnrollService().listCourses());
		Properties properties = new Properties();
		bundleContext.registerService(MarksService.class.getName(), service, properties);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public static EnrollService getEnrollService() {
		BundleContext ctx = getContext();
		enrollReference = ctx.getServiceReference(EnrollService.class.getName());
		return (EnrollService)ctx.getService(enrollReference);
	}
}

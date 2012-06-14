package de.beuth_hochschule.pfk.marks.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;
import de.beuth_hochschule.pfk.marks.core.service.MarksService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.beuth-hochschule.pfk.marks.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private ServiceReference marksReference;
	private ServiceReference enrollReference;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		if(marksReference != null) {
			getBundle().getBundleContext().ungetService(marksReference);
		}
		if(enrollReference != null) {
			getBundle().getBundleContext().ungetService(enrollReference);
		}
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public MarksService getMarksService() {
		BundleContext ctx = getBundle().getBundleContext();
		marksReference = ctx.getServiceReference(MarksService.class.getName());
		return (MarksService)ctx.getService(marksReference);
	}
	
	public EnrollService getEnrollService() {
		BundleContext ctx = getBundle().getBundleContext();
		enrollReference = ctx.getServiceReference(EnrollService.class.getName());
		return (EnrollService)ctx.getService(enrollReference);
	}
}

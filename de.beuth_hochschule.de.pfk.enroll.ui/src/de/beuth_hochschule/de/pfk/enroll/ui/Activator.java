package de.beuth_hochschule.de.pfk.enroll.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.beuth_hochschule.de.pfk.enroll.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private ServiceReference reference;
	
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
		registerImages();
		plugin = this;
	}
	
	private void registerImages() {
		loadAndAddImageToRegistry("icons/folder_user.png", "students_folder_icon");
		loadAndAddImageToRegistry("icons/folder_table.png", "courses_folder_icon");
		loadAndAddImageToRegistry("icons/table.png", "course_icon");
		loadAndAddImageToRegistry("icons/user.png", "student_icon");
	}

	private void loadAndAddImageToRegistry(String resource, String key) {
		ImageDescriptor descriptor =
			imageDescriptorFromPlugin(PLUGIN_ID, resource);
		if(descriptor == null) {
			throw new RuntimeException(
					String.format("Missing resource %s", resource));
		}
		Image image = descriptor.createImage();
		getImageRegistry().put(key, image);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		if(reference != null) {
			getBundle().getBundleContext().ungetService(reference);
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

	public EnrollService getEnrollService() {
		BundleContext ctx = getBundle().getBundleContext();
		reference = ctx.getServiceReference(EnrollService.class.getName());
		return (EnrollService)ctx.getService(reference);
	}
}

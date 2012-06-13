package de.beuth_hochschule.de.pfk.enroll.ui.views;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import de.beuth_hochschule.de.pfk.enroll.ui.Activator;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;

public class EnrollViewLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) { }

	@Override
	public void dispose() { }

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) { }

	@Override
	public Image getImage(Object o) {
		Activator a = Activator.getDefault();
		ImageRegistry r = a.getImageRegistry();
		
		if(o instanceof CourseCollection) {
			return r.get("courses_folder_icon");
		}
		if(o instanceof StudentCollection) {
			return r.get("students_folder_icon");
		}
		if(o instanceof Student) {
			return r.get("student_icon");
		}
		if(o instanceof Course) {
			return r.get("course_icon");
		}
		throw new RuntimeException(String.format("Unsupported object type %s", o.getClass().getName()));
	}

	@Override
	public String getText(Object o) {
		
		if(o instanceof CourseCollection) {
			return "Courses";
		}
		if(o instanceof StudentCollection) {
			return "Students";
		}
		if(o instanceof Student) {
			Student s = (Student)o;
			return String.format("%s, %s", s.getLastName(), s.getFirstName());
		}
		if(o instanceof Course) {
			Course c = (Course)o;
			return c.getTitle();
		}
		throw new RuntimeException(String.format("Unsupported object type %s", o.getClass().getName()));
	}

}

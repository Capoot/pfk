package de.beuth_hochschule.pfk.marks.ui.view;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;

public class MarksViewLabelProvider implements ITableLabelProvider {

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
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(!(element instanceof Object[])) {
			return null;
		}
		switch(columnIndex) {
		case 0:
			Student s = (Student)((Object[])element)[0];
			return String.format("%s, %s", s.getLastName(), s.getFirstName());
		case 1:
			Course c = (Course)((Object[])element)[1];
			return c.getTitle();
		case 2:
			Integer i = (Integer)((Object[])element)[2];
			return i.toString();
		}
		return null;
	}


}

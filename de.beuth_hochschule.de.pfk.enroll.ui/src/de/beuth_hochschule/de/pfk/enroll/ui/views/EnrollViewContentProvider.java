package de.beuth_hochschule.de.pfk.enroll.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;

public class EnrollViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(!(inputElement instanceof EnrollViewTreeInput)) {
			throw new RuntimeException(String.format("Invalid input of type %s", inputElement.getClass().getName()));
		}
		EnrollViewTreeInput input = (EnrollViewTreeInput)inputElement;
		Object[] items = new Object[2];
		items[0] = input.getStudents();
		items[1] = input.getCourses();
		return items;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Collection<?>) {
			Collection<?> c = (Collection<?>)parentElement;
			return c.toArray();
		}
		if(parentElement instanceof Course) {
			Course c = (Course)parentElement; 
			return c.getEnrolledStudents().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof Collection<?>) {
			Collection<?> c = (Collection<?>)element;
			return c.size() > 0;
		}
		if(element instanceof Course) {
			Course c = (Course)element;
			return c.getEnrolledStudents().size() > 0;
		}
		return false;
	}

}

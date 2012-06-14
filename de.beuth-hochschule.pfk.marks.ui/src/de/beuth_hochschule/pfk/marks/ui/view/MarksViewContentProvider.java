package de.beuth_hochschule.pfk.marks.ui.view;

import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.marks.core.businessLogic.CourseAssessment;

public class MarksViewContentProvider implements IStructuredContentProvider  {

	@Override
	public void dispose() { }

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }

	@Override
	public Object[] getElements(Object inputElement) {
		MarksViewTableInput input = (MarksViewTableInput)inputElement;
		LinkedList<Object[]> lines = new LinkedList<Object[]>();
		for(CourseAssessment a : input.getAssessments()) {
			Course c = a.getCourse();
			for(Student s : c.getEnrolledStudents()) {
				Object[] items = new Object[3];
				items[0] = s;
				items[1] = c;
				items[2] = a.getMark(s);
				lines.add(items);
			}
		}
		return lines.toArray();
	}

}

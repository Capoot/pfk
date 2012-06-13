package de.beuth_hochschule.de.pfk.enroll.ui.wizards;

import java.util.Collection;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import de.beuth_hochschule.de.pfk.enroll.ui.Activator;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;

public class EnrollPage extends WizardPage implements Listener {

	private Combo coursesCombo;
	private Combo studentsCombo;

	protected EnrollPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		
		EnrollService service = Activator.getDefault().getEnrollService();
		Collection<Course> courses = service.listCourses();
		Collection<Student> students = service.listStudents();
		
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		Label label = new Label(container, SWT.NONE);
		label.setText("Select Course");
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		coursesCombo = new Combo(container, SWT.SINGLE | SWT.READ_ONLY);
		for(Course c : courses) {
			coursesCombo.setData(c.getTitle(), new Long(c.getId()));
			coursesCombo.add(c.getTitle());
		}
		coursesCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label label2 = new Label(container, SWT.NONE);
		label2.setText("Select Student");
		label2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		
		studentsCombo = new Combo(container, SWT.SINGLE | SWT.READ_ONLY);
		for(Student s : students) {
			String text = String.format("%s, %s", s.getLastName(), s.getFirstName());
			studentsCombo.setData(text, new Integer(s.getMatriculationNumber()));
			studentsCombo.add(text);
		}
		studentsCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		studentsCombo.addListener(SWT.Modify, this);
		coursesCombo.addListener(SWT.Modify, this);
		
		setControl(container);
		setPageComplete(false);
		setMessage("Please select a student and a course to enroll");
		setTitle("New enrollment");
	}

	@Override
	public void handleEvent(Event event) {
		setPageComplete(coursesCombo.getSelectionIndex() != -1 && studentsCombo.getSelectionIndex() != -1);
	}
	
	public int getMatNr() {
		return (Integer)studentsCombo.getData(studentsCombo.getItem(studentsCombo.getSelectionIndex()));
	}
	
	public long getCourseId() {
		return (Long)coursesCombo.getData(coursesCombo.getItem(coursesCombo.getSelectionIndex()));
	}
}

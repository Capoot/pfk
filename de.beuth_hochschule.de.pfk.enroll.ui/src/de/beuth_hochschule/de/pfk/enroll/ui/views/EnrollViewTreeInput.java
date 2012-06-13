package de.beuth_hochschule.de.pfk.enroll.ui.views;

import java.util.Collection;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;

public class EnrollViewTreeInput {

	private Collection<Student> students;
	private Collection<Course> courses;

	public EnrollViewTreeInput(Collection<Student> students, Collection<Course> courses) {
		this.students = new StudentCollection(students);;
		this.courses = new CourseCollection(courses);
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public Collection<Course> getCourses() {
		return courses;
	}
}

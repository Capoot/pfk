package de.beuth_hochschule.pfk.enroll.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.exception.MatriculationNumberNotUniqueException;
import de.beuth_hochschule.pfk.enroll.core.exception.NoSuchCourseException;
import de.beuth_hochschule.pfk.enroll.core.exception.NoSuchStudentException;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollmentChangedListener;

public class EnrollServiceImpl implements EnrollService {

	private List<Student> students = new LinkedList<Student>();
	private List<Course> courses = new LinkedList<Course>();
	
	private HashSet<EnrollmentChangedListener> listeners = new HashSet<EnrollmentChangedListener>();
	
	public EnrollServiceImpl() {
		// FIXME test data
		Student s = createStudent("Heise", "Julian", 782691);
		Course c = createCourse("Programmieren fortg. Konzepte", 25);
		enroll(s, c);
	}
	
	@Override
	public void enroll(Student student, Course course) {
		course.enroll(student);
		fireEnrollmentChanged();
	}

	@Override
	public void cancel(Student student, Course course) {
		course.cancel(student);
		fireEnrollmentChanged();
	}

	@Override
	public Student createStudent(String name, String firstName, int matNr) {
		if(matNrExists(matNr)) {
			throw new MatriculationNumberNotUniqueException();
		}
		Student s = new Student(matNr, firstName, name);
		students.add(s);
		fireEnrollmentChanged();
		return s;
	}

	private boolean matNrExists(int matNr) {
		for(Student s : students) {
			if(s.getMatriculationNumber() == matNr) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Student getStudent(int matNr) {
		for(Student s : students) {
			if(s.getMatriculationNumber() == matNr) {
				return s;
			}
		}
		throw new NoSuchStudentException(matNr);
	}

	@Override
	public void deleteStudent(Student student) {
		if(!students.contains(student)) {
			throw new NoSuchStudentException();
		}
		students.remove(student);
		fireEnrollmentChanged();
	}

	@Override
	public Collection<Student> listStudents() {
		LinkedList<Student> copy = new LinkedList<Student>();
		copy.addAll(students);
		return copy;
	}

	@Override
	public Collection<Course> listCourses() {
		LinkedList<Course> copy = new LinkedList<Course>();
		copy.addAll(courses);
		return copy;
	}

	@Override
	public Course createCourse(String title, int freeSlots) {
		Course c = new Course(title, freeSlots);
		courses.add(c);
		fireEnrollmentChanged();
		return c;
	}

	@Override
	public void deleteCourse(Course course) {
		if(!courses.contains(course)) {
			throw new NoSuchCourseException();
		}
		courses.remove(course);
		fireEnrollmentChanged();
	}
	
	@Override
	public Course getCourse(long id) {
		for(Course c : courses) {
			if(c.getId() == id) {
				return c;
			}
		}
		throw new NoSuchCourseException();
	}
	
	@Override
	public void addEnrollmentChangedListener(EnrollmentChangedListener listener) {
		listeners.add(listener);
	}

	private void fireEnrollmentChanged() {
		for(EnrollmentChangedListener l : listeners) {
			l.enrollmentChanged();
		}
	}
}

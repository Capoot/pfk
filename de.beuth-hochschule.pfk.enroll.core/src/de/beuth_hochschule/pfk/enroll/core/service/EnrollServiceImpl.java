package de.beuth_hochschule.pfk.enroll.core.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import de.beuth_hochschule.pfk.enroll.core.businessLogik.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogik.Student;
import de.beuth_hochschule.pfk.enroll.core.exception.NoSuchCourseException;
import de.beuth_hochschule.pfk.enroll.core.exception.NoSuchStudentException;

public class EnrollServiceImpl implements EnrollService {

	private List<Student> students = new LinkedList<Student>();
	private List<Course> courses = new LinkedList<Course>();
	
	@Override
	public void enroll(Student student, Course course) {
		course.enroll(student);
	}

	@Override
	public void cancel(Student student, Course course) {
		course.cancel(student);
	}

	@Override
	public Student createStudent(String name, String firstName, int matNr) {
		Student s = new Student(matNr, firstName, name);
		students.add(s);
		return s;
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
		return c;
	}

	@Override
	public void deleteCourse(Course course) {
		if(!courses.contains(course)) {
			throw new NoSuchCourseException();
		}
		courses.remove(course);
	}
}

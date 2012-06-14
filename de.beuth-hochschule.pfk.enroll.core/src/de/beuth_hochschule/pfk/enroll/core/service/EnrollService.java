package de.beuth_hochschule.pfk.enroll.core.service;

import java.util.Collection;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.exception.CourseIsFullException;
import de.beuth_hochschule.pfk.enroll.core.exception.StudentNotEnrolledException;

public interface EnrollService {

	/**
	 * Enrolls a student into a course
	 * @param student
	 * @param course
	 * @throws CourseIsFullException if there are no free slots left in the course
	 */
	public void enroll(Student student, Course course);
	
	/**
	 * Cancels the enrollment for a given student
	 * @param student
	 * @param course
	 * @throws StudentNotEnrolledException if the given student was not enrolled in the given course
	 */
	public void cancel(Student student, Course course);
	
	/**
	 * Creates a new Student
	 * @param name student's name
	 * @param firstName student's first name
	 * @param matNr student's matriculation number, must be unique
	 * @return the newly created student
	 */
	public Student createStudent(String name, String firstName, int matNr);
	
	/**
	 * Retrieves a student by the given matriculation Number
	 * @param matNr student's matriculation number
	 * @return the student identified by the given matriculation number
	 * @throws NoSuchStudentException if no student was found with the given matriculation number
	 */
	public Student getStudent(int matNr);
	
	/**
	 * Permanently deletes the given student from the system.
	 * @param student student to delete
	 * @throws NoSuchStudentException if the student isn't part of the system
	 */
	public void deleteStudent(Student student);
	
	/**
	 * Retrieves all students from the system.
	 * @return collection containing all students
	 */
	public Collection<Student> listStudents();
	
	/**
	 * Retrieves all courses from the system.
	 * @return collection containing all courses
	 */
	public Collection<Course> listCourses();
	
	/**
	 * Creates a new course
	 * @param title course's title
	 * @param freeSlots free student slots available in the new course
	 * @return newly created course
	 */
	public Course createCourse(String title, int freeSlots);
	
	/**
	 * Permanently deletes a course from the system
	 * @param course course to delete
	 * @throws NoSuchCourseException if the course does not exist in the system
	 */
	public void deleteCourse(Course course);

	public Course getCourse(long id);

	void addEnrollmentChangedListener(EnrollmentChangedListener listener);
}

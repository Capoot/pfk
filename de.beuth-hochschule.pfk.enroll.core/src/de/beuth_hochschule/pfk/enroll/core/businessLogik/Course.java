package de.beuth_hochschule.pfk.enroll.core.businessLogik;

import java.util.LinkedList;
import java.util.List;

import de.beuth_hochschule.pfk.enroll.core.exception.CourseIsFullException;
import de.beuth_hochschule.pfk.enroll.core.exception.StudentNotEnrolledException;

public class Course {

	private String title;
	private List<Student> enrolledStudents = new LinkedList<Student>();
	private int freeSlots;
	private long id;
	
	public Course(String title, int freeSlots) {
		this.title = title;
		this.freeSlots = freeSlots;
		id = System.currentTimeMillis();
	}
	
	public void enroll(Student student) {
		if(freeSlots == 0) {
			throw new CourseIsFullException();
		}
		enrolledStudents.add(student);
		freeSlots--;
	}
	
	public void cancel(Student student) {
		if(!enrolledStudents.contains(student)) {
			throw new StudentNotEnrolledException();
		}
		enrolledStudents.remove(student);
		freeSlots++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFreeSlots() {
		return freeSlots;
	}

	public long getId() {
		return id;
	}
}

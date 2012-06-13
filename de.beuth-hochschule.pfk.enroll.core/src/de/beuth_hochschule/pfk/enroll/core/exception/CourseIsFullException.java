package de.beuth_hochschule.pfk.enroll.core.exception;

public class CourseIsFullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CourseIsFullException() {
		super("Enrollment in this course is not possible, because there are no free slots left");
	}
}

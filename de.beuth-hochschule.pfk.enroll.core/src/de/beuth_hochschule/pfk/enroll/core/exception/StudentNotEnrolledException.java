package de.beuth_hochschule.pfk.enroll.core.exception;

public class StudentNotEnrolledException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotEnrolledException() {
		super("The given student is not enrolled in this course");
	}
}

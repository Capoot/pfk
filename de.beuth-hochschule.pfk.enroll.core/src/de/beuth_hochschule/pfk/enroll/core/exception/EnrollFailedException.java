package de.beuth_hochschule.pfk.enroll.core.exception;

public class EnrollFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnrollFailedException() {
		super("The Student is already enrolled in this course");
	}
}

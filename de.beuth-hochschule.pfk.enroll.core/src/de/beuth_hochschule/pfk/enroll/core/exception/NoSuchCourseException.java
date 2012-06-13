package de.beuth_hochschule.pfk.enroll.core.exception;

public class NoSuchCourseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSuchCourseException() {
		super("The requested course does not exist");
	}

}

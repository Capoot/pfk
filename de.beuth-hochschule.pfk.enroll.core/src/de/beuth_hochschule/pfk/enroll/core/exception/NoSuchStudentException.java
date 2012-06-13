package de.beuth_hochschule.pfk.enroll.core.exception;

public class NoSuchStudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public NoSuchStudentException(int matNr) {
		super(String.format("Student with matriculation number %d does not exist", matNr));
	}

	public NoSuchStudentException() {
		super("Studen does not exist");
	}
}

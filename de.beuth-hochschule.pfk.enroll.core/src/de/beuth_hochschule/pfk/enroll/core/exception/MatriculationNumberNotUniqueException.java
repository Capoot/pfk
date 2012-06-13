package de.beuth_hochschule.pfk.enroll.core.exception;

public class MatriculationNumberNotUniqueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MatriculationNumberNotUniqueException() {
		super("The given matriculation number already exists. Matriculation numbers must be unique.");
	}

}

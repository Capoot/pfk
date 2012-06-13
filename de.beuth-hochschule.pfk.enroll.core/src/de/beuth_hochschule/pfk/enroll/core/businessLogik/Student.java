package de.beuth_hochschule.pfk.enroll.core.businessLogik;

public class Student {

	private int matriculationNumber;
	private String firstName;
	private String lastName;
	
	public Student(int matriculationNumber, String firstName, String lastName) {
		super();
		this.matriculationNumber = matriculationNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

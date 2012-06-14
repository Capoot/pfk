package de.beuth_hochschule.pfk.marks.core.businessLogic;

import java.util.HashMap;
import java.util.Map;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.exception.StudentNotEnrolledException;

public class CourseAssessment {

	private Course course;
	private Map<Integer, Integer> marks = new HashMap<Integer, Integer>();
	
	public CourseAssessment(Course course) {
		this.course = course;
	}
	
	public int getMark(Student student) {
		return marks.get(student.getMatriculationNumber());
	}
	
	public void setMark(Student student, int mark) {
		if(!course.getEnrolledStudents().contains(student)) {
			throw new StudentNotEnrolledException();
		}
		marks.put(student.getMatriculationNumber(), mark);
	}

	public Course getCourse() {
		return course;
	}

	public boolean containsStudent(Student s) {
		for(Integer i : marks.keySet()) {
			if(i.equals(s.getMatriculationNumber())) {
				return true;
			}
		}
		return false;
	}
}

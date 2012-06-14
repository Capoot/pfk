package de.beuth_hochschule.pfk.marks.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.enroll.core.businessLogic.Student;
import de.beuth_hochschule.pfk.enroll.core.service.EnrollService;
import de.beuth_hochschule.pfk.marks.core.businessLogic.CourseAssessment;
import de.beuth_hochschule.pfk.marks.core.service.MarksService;

public class MarksServiceImpl implements MarksService {

	private Map<Long, CourseAssessment> assessments = new HashMap<Long, CourseAssessment>();
	
	public MarksServiceImpl(Collection<Course> courses) {
		for(Course c : courses) {
			getAssessments(c);
		}
	}

	@Override
	public CourseAssessment getAssessments(Course c) {
		if(!assessments.containsKey(c.getId())) {
			CourseAssessment a = generateMarksForNewCourse(c);
			assessments.put(c.getId(), a);
		}
		return assessments.get(c.getId());
	}

	private CourseAssessment generateMarksForNewCourse(Course c) {
		CourseAssessment a = new CourseAssessment(c);
		Random r = new Random(System.currentTimeMillis());
		for(Student s : c.getEnrolledStudents()) {
			a.setMark(s, r.nextInt(5) + 1);
		}
		return a;
	}

	@Override
	public Collection<CourseAssessment> listAssessments() {
		updateAssessments();
		return assessments.values();
	}

	private void updateAssessments() {
		EnrollService service = Activator.getEnrollService();
		Random r = new Random(System.currentTimeMillis());
		for(Course c : service.listCourses()) {
			CourseAssessment a = getAssessments(c);
			for(Student s : c.getEnrolledStudents()) {
				if(!a.containsStudent(s)) {
					a.setMark(s, r.nextInt(5)+1);
				}
			}
		}
	}
}

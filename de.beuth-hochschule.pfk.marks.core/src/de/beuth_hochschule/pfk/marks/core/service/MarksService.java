package de.beuth_hochschule.pfk.marks.core.service;

import java.util.Collection;

import de.beuth_hochschule.pfk.enroll.core.businessLogic.Course;
import de.beuth_hochschule.pfk.marks.core.businessLogic.CourseAssessment;

public interface MarksService {

	public CourseAssessment getAssessments(Course c);

	public Collection<CourseAssessment> listAssessments();
}

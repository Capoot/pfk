package de.beuth_hochschule.pfk.marks.ui.view;

import java.util.Collection;

import de.beuth_hochschule.pfk.marks.core.businessLogic.CourseAssessment;
import de.beuth_hochschule.pfk.marks.core.service.MarksService;

public class MarksViewTableInput {

	private Collection<CourseAssessment> assessments;

	public MarksViewTableInput(MarksService marksService) {
		assessments = marksService.listAssessments();
	}

	public Collection<CourseAssessment> getAssessments() {
		return assessments;
	}

}

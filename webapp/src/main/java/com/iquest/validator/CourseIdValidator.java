package com.iquest.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.iquest.models.CourseModel;
import com.iquest.services.CourseService;

public class CourseIdValidator implements ConstraintValidator<UniqueIdentifier, Long> {

	@Autowired
	private CourseService courseService;

	public void initialize(UniqueIdentifier constraintAnnotation) {

	}

	public boolean isValid(Long id, ConstraintValidatorContext context) {
		CourseModel course;
		try {
			course = courseService.findCourseById(id);
		} catch (Exception e) {
			return true;
		}

		if (course != null) {
			return false;
		}
		return true;
	}

}
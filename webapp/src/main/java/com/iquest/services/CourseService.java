package com.iquest.services;

import java.util.List;

import com.iquest.data.CourseData;
import com.iquest.models.CourseModel;

public interface CourseService {
	
	void changeCourseDescription(long courseId, String message);
	
	void addCourse(CourseModel course);
	
	List<CourseData> findAllCourses();
	
}

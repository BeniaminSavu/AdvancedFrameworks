package com.iquest.exceptions;

public class CourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -694354952032299587L;

	private String courseId;

	public CourseNotFoundException(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseId() {
		return courseId;
	}

}
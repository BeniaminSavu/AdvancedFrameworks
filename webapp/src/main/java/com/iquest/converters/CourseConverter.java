package com.iquest.converters;

import com.iquest.data.CourseData;
import com.iquest.models.CourseModel;

public class CourseConverter implements Converter<CourseModel, CourseData>{

	public CourseData convertToData(CourseModel model) {
		CourseData courseData = new CourseData();
		courseData.setId(model.getCourseId());
		courseData.setName(model.getName());
		courseData.setDescription(model.getDescription());
		courseData.setPrice(model.getPrice());
		return courseData;
	}

	public CourseModel convertToModel(CourseData data) {
		CourseModel courseModel = new CourseModel();
		courseModel.setDescription(data.getDescription());
		courseModel.setName(data.getName());
		courseModel.setPrice(data.getPrice());
		return courseModel;
	}

}

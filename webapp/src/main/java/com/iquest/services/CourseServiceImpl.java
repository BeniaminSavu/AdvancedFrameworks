package com.iquest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquest.converters.Converter;
import com.iquest.data.CourseData;
import com.iquest.models.CourseModel;
import com.iquest.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private Converter<CourseModel, CourseData> courseConverter;

	public void setCourseConverter(Converter<CourseModel, CourseData> courseConverter) {
		this.courseConverter = courseConverter;
	}

	public List<CourseData> findAllCourses() {
		List<CourseModel> courseModelList = courseRepository.findAll();
		List<CourseData> courseDataList = new ArrayList<CourseData>();
		for (CourseModel course : courseModelList) {
			courseDataList.add(courseConverter.convertToData(course));
		}
		return courseDataList;
	}

	public void addCourse(CourseModel course) {
		courseRepository.save(course);
	}

	public void changeCourseDescription(long courseId, String message) {

	}

	public List<CourseData> findCoursesByType(String type) {
		List<CourseModel> courseModelList = courseRepository.findByType(type);
		List<CourseData> courseDataList = new ArrayList<CourseData>();
		for (CourseModel course : courseModelList) {
			courseDataList.add(courseConverter.convertToData(course));
		}
		return courseDataList;
	}

	public CourseModel findCourseById(long id) {
		return courseRepository.findByCourseId(id);
	}

	public void removeById(long id) {
		courseRepository.delete(id);
	}

}

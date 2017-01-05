package com.iquest.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iquest.persistence.entities.Course;

public interface CourseDao extends CrudRepository<Course, String> {

    List<Course> findAll();

    Course findOne(String problemName);

    Course save(Course problem);

    void delete(String problemName);
}

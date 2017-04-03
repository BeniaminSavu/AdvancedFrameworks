package com.iquest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.CourseModel;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {

	List<CourseModel> findAll();

	List<CourseModel> findByType(String type);

	CourseModel findByCourseId(long id);

}

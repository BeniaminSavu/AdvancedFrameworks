package com.iquest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.CommentModel;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel, Long> {

	List<CommentModel> findAll();

}

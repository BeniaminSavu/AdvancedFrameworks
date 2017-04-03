package com.iquest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquest.models.CommentModel;
import com.iquest.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public void create(CommentModel comment) {
		commentRepository.save(comment);
	}

}

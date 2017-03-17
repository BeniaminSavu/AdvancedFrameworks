package com.iquest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.TransactionModel;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionModel, Long> {
	
	List<TransactionModel> findAll();

}

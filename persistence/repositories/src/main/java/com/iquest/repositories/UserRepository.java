package com.iquest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

	public UserModel findByUsername(String username);

	public UserModel findByUserId(long id);

}

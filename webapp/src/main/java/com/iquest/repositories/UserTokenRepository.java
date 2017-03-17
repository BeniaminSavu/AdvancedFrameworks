package com.iquest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.UserTokenModel;

@Repository
public interface UserTokenRepository extends CrudRepository<UserTokenModel, Long>{

	public UserTokenModel findByToken(String token);
}

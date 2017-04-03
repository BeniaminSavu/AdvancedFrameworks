package com.iquest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iquest.models.CartModel;
import com.iquest.models.UserModel;

@Repository
public interface CartRepository extends CrudRepository<CartModel, Long> {

	@Query("SELECT c FROM CartModel c where c.user = :user and c.approval = :approval")
	List<CartModel> findByUserIdAndApproval(@Param("user") UserModel user, @Param("approval") String approval);

}

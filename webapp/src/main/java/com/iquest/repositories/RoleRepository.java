package com.iquest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iquest.models.RoleModel;

@Repository
public interface RoleRepository extends CrudRepository<RoleModel, Long> {

	public RoleModel findByRoleName(String roleName);

}

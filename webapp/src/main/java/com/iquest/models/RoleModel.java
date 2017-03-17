package com.iquest.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RoleModel {

	@Id
	private long roleId;
	private String roleName;
	
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private Set<UserModel> users;
	
	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

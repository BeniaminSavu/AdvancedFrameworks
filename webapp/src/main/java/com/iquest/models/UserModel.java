package com.iquest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class UserModel {

	@Id
	private long userId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;

	@OneToOne
	@JoinColumn(name = "userTokenId")
	private UserTokenModel userToken;

	@ManyToOne
	@JoinColumn(name = "roleId")
	private RoleModel role;

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserTokenModel getUserToken() {
		return userToken;
	}

	public void setUserToken(UserTokenModel userToken) {
		this.userToken = userToken;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

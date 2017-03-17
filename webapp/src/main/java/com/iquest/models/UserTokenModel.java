package com.iquest.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserTokenModel {

	@Id
	private long userTokenId;
	private String token;
	
	@OneToOne(mappedBy="userToken", cascade=CascadeType.ALL)
	private UserModel user;
	private Date date;

	public long getUserTokenId() {
		return userTokenId;
	}

	public void setUserTokenId(long userTokenId) {
		this.userTokenId = userTokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="User")
public class UserEntity {
	@Id
	private String user;
	@Column(name="password")
	private String pass;
	public UserEntity(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserEntity() {
		
	}
	@Override
	public String toString() {
		return user+" "+pass;
	}
}

package com.dian.model;
/**
 * User class
 * @author guodi
 * used to log users in
 * TODO: missing role's definition, get/set, toString()
 */

public class User {
	private String username;
	private String password;
	
	
//	private Role role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}

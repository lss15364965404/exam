package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * User用户类
 * @author 李少石
 * @version 2018-04-09
 */
@Component
public class User {

	/**
	 * 用户id
	 */
	private int user_id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 用户角色
	 */
	private String role;
	
	/**
	 * 角色id
	 */
	private String role_id;
	
	/**
	 * 无参数构造函数
	 */
	public User() {
		super();
	}
	
	/**
	 * 带参数的构造函数
	 * @param user_id 用户id
	 * @param username 用户名
	 * @param password 密码
	 * @param role 用户角色
	 * @param role_id 角色id
	 */
	public User(int user_id, String username, String password, String role, String role_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	/**
	 * 通过字符串显示用户信息
	 */
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", role_id=" + role_id + "]";
	}
	
	
	
	
}

package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * StudentAndUser学生和用户类
 * @author 李少石
 * @version 2018-04-16
 */
@Component
public class StudentAndUser {

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
	 * 学生id
	 */
	private int student_id;
	
	/**
	 * 学生姓名
	 */
	private String student_name;
	
	/**
	 * 班级号
	 */
	private String class_id;
	
	
	
	/**
	 * 无参数构造函数
	 */
	public StudentAndUser() {
		super();
	}


	/**
	 * 带参数的构造函数
	 * @param user_id
	 * @param username
	 * @param password
	 * @param role
	 * @param role_id
	 * @param student_id
	 * @param student_name
	 * @param class_id
	 */
	public StudentAndUser(int user_id, String username, String password, String role, String role_id, int student_id,
			String student_name, String class_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.role_id = role_id;
		this.student_id = student_id;
		this.student_name = student_name;
		this.class_id = class_id;
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


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public String getClass_id() {
		return class_id;
	}


	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}


	@Override
	public String toString() {
		return "StudentAndUser [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role="
				+ role + ", role_id=" + role_id + ", student_id=" + student_id + ", student_name=" + student_name
				+ ", class_id=" + class_id + "]";
	}
	
	
	

}
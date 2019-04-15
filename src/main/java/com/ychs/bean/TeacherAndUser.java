package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * TeacherAndUser教师和用户类
 * @author 李少石
 * @version 2018-04-16
 */
@Component
public class TeacherAndUser {

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
	 * 教师id
	 */
	private int teacher_id;
	
	/**
	 * 教师姓名
	 */
	private String teacher_name;
	
	
	
	/**
	 * 无参数构造函数
	 */
	public TeacherAndUser() {
		super();
	}

	/**
	 * 带参数的构造函数
	 * @param user_id
	 * @param username
	 * @param password
	 * @param role
	 * @param role_id
	 * @param teacher_id
	 * @param teacher_name
	 */
	public TeacherAndUser(int user_id, String username, String password, String role, String role_id, int teacher_id,
			String teacher_name) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.role_id = role_id;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
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

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	@Override
	public String toString() {
		return "TeacherAndUser [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role="
				+ role + ", role_id=" + role_id + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + "]";
	}
	
	
	
	
	
	
}

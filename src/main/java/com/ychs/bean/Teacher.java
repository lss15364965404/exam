package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * Teacher用户类
 * @author 李少石
 * @version 2018-04-16
 */
@Component
public class Teacher {

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
	public Teacher() {
		super();
	}

	/**
	 * 带参数构造函数
	 * @param teacher_id
	 * @param teacher_name
	 */
	public Teacher(int teacher_id, String teacher_name) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
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
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + "]";
	}
	
	
	
}

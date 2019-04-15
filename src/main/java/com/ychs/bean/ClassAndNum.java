package com.ychs.bean;

import org.springframework.stereotype.Component;
/**
 * 班级类(带学生数)
 * @author 李少石
 * @version 2018-04-18
 */
@Component
public class ClassAndNum {

	/**
	 * 班级id
	 */
	private String class_id;
	/**
	 * 班级名称
	 */
	private String class_name;
	/**
	 * 本班学生数
	 */
	private int class_student_num;

	/**
	 * 无参构造函数
	 */
	public ClassAndNum() {
		super();
	}
	
	
	/**
	 * 带参数的构造函数
	 * @param class_id
	 * @param class_name
	 * @param class_student_num
	 */
	public ClassAndNum(String class_id, String class_name, int class_student_num) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.class_student_num = class_student_num;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getClass_student_num() {
		return class_student_num;
	}

	public void setClass_student_num(int i) {
		this.class_student_num = i;
	}


	@Override
	public String toString() {
		return "ClassAndNum [class_id=" + class_id + ", class_name=" + class_name + ", class_student_num="
				+ class_student_num + "]";
	}

	
	
	
}

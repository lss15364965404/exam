package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * 班级试卷多对多关系类
 * @author 李少石
 * @version 2018-03-10
 *
 */
@Component
public class ClassesAndPapers {
	
	/**
	 * 试卷id
	 */
	private String paper_id;
	
	/**
	 * 班级id
	 */
	private String class_id;

	/**
	 * 无参构造方法
	 */
	public ClassesAndPapers() {
		super();
	}

	/**
	 * 有参构造方法
	 * @param paper_id 试卷id
	 * @param class_id 班级id
	 */
	public ClassesAndPapers(String paper_id, String class_id) {
		super();
		this.paper_id = paper_id;
		this.class_id = class_id;
	}
	
	/**
	 * 得到试卷id
	 * @return 试卷id
	 */
	public String getPaper_id() {
		return paper_id;
	}

	/**
	 * 设置试卷id
	 * @param paper_id 试卷id
	 */
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	/**
	 * 得到班级id
	 * @return 班级id
	 */
	public String getClass_id() {
		return class_id;
	}

	/**
	 * 设置班级id
	 * @param class_id 班级id
	 */
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	@Override
	public String toString() {
		return "ClassesAndPapers [paper_id=" + paper_id + ", class_id=" + class_id + "]";
	}
	
}

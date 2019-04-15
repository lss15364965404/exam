package com.ychs.dao;

import com.ychs.bean.MultipleChoices;

/**
 * 多选题选项的接口
 * @author FENG
 *
 */
public interface IMultipleChoicesDao {

	/**
	 * 插入一条多题的选项
	 * @param check
	 * @return
	 */
	public int insert(MultipleChoices multipleChoices);
	/**
	 * 查询多选题选项
	 * @param multipleChoices
	 * @return
	 */
	public MultipleChoices select (MultipleChoices multipleChoices);
	
	
}

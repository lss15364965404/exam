package com.ychs.service;

import com.ychs.bean.MultipleChoices;

/**
 * MultipleChoice的service接口
 * @author FENG
 *
 */
public interface IMultipleChoicesService {
	/**
	 * 添加多选题
	 * @param multipleChoice
	 * @return
	 */
	public boolean addMultipleChoices(MultipleChoices multipleChoices);
	
	/**
	 * 查询多选题选项
	 * @param multipleChoices
	 * @return
	 */
	public MultipleChoices select (MultipleChoices multipleChoices); 
}

package com.ychs.dao;

import java.util.Map;

import com.ychs.bean.SingleChoices;

/**
 * 单选题的dao层接口
 * 
 * @author 冯永强
 *
 */
public interface ISingleChoicesDao {

	/**
	 * 单选题选项的插入
	 * @param singleChoice
	 * @return
	 */
	public int insert(SingleChoices singleChoices) ;
	/**
	 * 查询单选题选项
	 * @param singleChoices 选项内容
	 * @return
	 */
	public SingleChoices select(SingleChoices singleChoices);
	
}

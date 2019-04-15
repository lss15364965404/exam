package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;

/**
 * 单选题的dao层接口
 * 
 * @author 冯永强
 *
 */
public interface ISingleChoiceDao {

	/**
	 * 单选题的插入
	 * 
	 * @param singleChoice
	 * @return
	 */
	public int insert(SingleChoice singleChoice);
	/**
	 * 单选题的修改
	 * @param singleChoice
	 * @return
	 */
	public int update(SingleChoice singleChoice);
	
	/**
	 * 条件查询
	 * @param map
	 * @return
	 */
	public List<SingleChoiceAndTeacher> selectSingleChoice(Map<String,Object> map);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCount();
	
	public List<SingleChoiceAndTeacher> selectSingleChoiceAdd(Map<String, Object> map);
	public int updateRight(Map<String, String> map);
}

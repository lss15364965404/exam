package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;

/**
 * 多选题的接口
 * @author FENG
 *
 */
public interface IMultipleChoiceDao {

	/**
	 * 插入一条多题
	 * @param check
	 * @return
	 */
	public int insert(MultipleChoice multipleChoice);
	
	
	
	/**
	 * 根据条件查询多选题
	 * @return
	 */
	public List<MultipleChoiceAndTeacher> selectMuByContion(Map<String,Object> map);
	/**
	 * 修改多选题
	 * @param multipleChoice
	 * @return
	 */
	public int update(MultipleChoice multipleChoice);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCount();
}

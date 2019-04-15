package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Check;

/**
 * 判断题的Dao层接口
 * @author 李少石
 *
 */
public interface ICheckDao {

	/**
	 * 插入一条判断题
	 * @param check
	 * @return
	 */
	public int insert(Check check);
	
	
	/**
	 * 根据条件查询判断题
	 * @param check
	 * @return
	 */
	public List<Check> selectCkByCondition(Map<String,Object> map);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCount();
	
}

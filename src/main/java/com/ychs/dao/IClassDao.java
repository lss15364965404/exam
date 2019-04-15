package com.ychs.dao;


import java.util.List;
import java.util.Map;

import com.ychs.bean.Class;

/**
 * 学生的Dao层接口
 * @author 李少石
 * @version 2018-04-16
 */
public interface IClassDao {
	
	/**
	 * 插入一条用户数据
	 * @param user
	 * @return
	 */
	public int insert(Map<String, Object> map);
	
	/**
	 * 根据条件用户数据
	 * @param user
	 * @return
	 */
	public List<Class> selectClassByCondition(Map<String,Object> map);
	
	/**
	 * 查询用户数据总条数
	 * @return
	 */
	public int selectCount();

	/**
	 * 查询本班学生数目
	 * @return
	 */
	public int selectStudentNum(Map<String, Object> map);
}

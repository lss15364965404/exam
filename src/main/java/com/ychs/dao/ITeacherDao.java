package com.ychs.dao;


import java.util.List;
import java.util.Map;

import com.ychs.bean.Teacher;
import com.ychs.bean.TeacherAndUser;

/**
 * 教师的Dao层接口
 * @author 李少石
 * @version 2018-04-16
 */
public interface ITeacherDao {
	
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
	public List<TeacherAndUser> selectTeacherByCondition(Map<String,Object> map);
	
	/**
	 * 查询用户数据总条数
	 * @return
	 */
	public int selectCount();
}

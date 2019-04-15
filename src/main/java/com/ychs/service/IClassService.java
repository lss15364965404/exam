package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Class;

/**
 * 班级的service接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface IClassService {
	/**
	 * 添加班级题
	 * @param map
	 * @return
	 */
	public boolean addClass(Map<String, Object> map);
	
	/**
	 * 按条件查询班级
	 * @param class_name
	 * @param page1
	 * @param limit1
	 * @return
	 */
	public List<Class> selectClassByCondition(Map<String, Object> map);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts();

	/**
	 * 查询本班学生数目
	 * @return
	 */
	public int selectClassStudentNum(Map<String, Object> map);

	
}

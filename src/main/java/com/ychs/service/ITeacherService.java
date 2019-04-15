package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Teacher;
import com.ychs.bean.TeacherAndUser;

/**
 * 教师的service接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface ITeacherService {
	/**
	 * 添加教师题
	 * @param fillBlank
	 * @return
	 */
	public boolean addTeacher(Map<String, Object> map);
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public List<TeacherAndUser> selectTeacherByCondition(String teacher_name,String page1,String limit1);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts();

	
}

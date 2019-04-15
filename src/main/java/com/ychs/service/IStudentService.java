package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.StudentAndUser;

/**
 * 教师的service接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface IStudentService {
	/**
	 * 添加教师题
	 * @param fillBlank
	 * @return
	 */
	public boolean addStudent(Map<String, Object> map);
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public List<StudentAndUser> selectStudentByCondition(String student_name,String page1,String limit1);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts();

	
}

package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.User;

/**
 * 用户的service接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface IUserService {
	/**
	 * 添加判断题
	 * @param fillBlank
	 * @return
	 */
	public boolean addUser(Map<String, Object> map);
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUserByNamePass(Map<String, Object> map);
	
	/**
	 * 根据条件查询判断题
	 * @param User
	 * @return
	 */
	public List<User> selectUserByCondition(String username, String password,String role,String role_id,String page1,String limit1);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts();

	/**
	 * 修改密码
	 * @return
	 */
	public String updatePassword(Map<String, Object> map);

	
}

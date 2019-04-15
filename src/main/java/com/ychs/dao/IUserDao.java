package com.ychs.dao;


import java.util.List;
import java.util.Map;

import com.ychs.bean.User;

/**
 * 用户的Dao层接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface IUserDao {
	
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
	public List<User> selectUserByCondition(Map<String,Object> map);
	
	/**
	 * 查询用户数据总条数
	 * @return
	 */
	public int selectCount();

	/**
	 * 修改用户密码
	 * @param map
	 * @return
	 */
	public int updatePassword(Map<String, Object> map);
}

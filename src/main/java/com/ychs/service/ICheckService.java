package com.ychs.service;

import java.util.List;

import com.ychs.bean.Check;

/**
 * 判断题的service接口
 * @author FENG
 *
 */
public interface ICheckService {
	/**
	 * 添加判断题
	 * @param fillBlank
	 * @return
	 */
	public boolean addCheck(Check check);
	
	
	/**
	 * 根据条件查询判断题
	 * @param check
	 * @return
	 */
	public List<Check> selectCkByCondition(String stage,String stem,String page,String limit);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selcetCountS();
}

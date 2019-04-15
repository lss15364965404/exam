package com.ychs.service;

import java.util.List;

import com.ychs.bean.FillBlank;

/**
 * FillBlank的service接口
 * @author FENG
 *
 */
public interface IFillBlankService {
	/**
	 * 添加填空题
	 * @param fillBlank
	 * @return
	 */
	public boolean addFillBlank(FillBlank fillBlank);
	
	
	
	/**
	 * 根据条件查询填空题
	 * @param fillBlank
	 * @return
	 */
	public List<FillBlank> selectFkByCondition(String stem,String stage,String page,String limit);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selcetCountS();
}

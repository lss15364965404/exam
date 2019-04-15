package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.FillBlank;

/**
 * 填空题的dao
 * 
 * @author FENG
 *
 */
public interface IFillBlankDao {
	/**
	 * 添加一条填空题
	 * @param fillBlank
	 * @return
	 */
	public int insert(FillBlank fillBlank);
	
	
	/**
	 * 根据条件查询填空题
	 * @param fillBlank
	 * @return
	 */
	public List<FillBlank> selectFkByCondition(Map<String,Object> map);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCount();
}

package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Paper;

/**
 * 试卷的service接口
 * @author FENG
 *
 */
public interface IPaperService {
	/**
	 * 添加试卷
	 * @param fillBlank
	 * @return
	 */
	public boolean addPaper(Map<String, String> map);
	
	/**
	 * 查询所有判断题
	 * @param check
	 * @return
	 */
	public List<Paper> selectPaperService(String paperName,String page,String limit);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCountS();
}

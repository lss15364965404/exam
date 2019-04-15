package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;

/**
 * 单选题接口
 * @author 冯永强
 *
 */
public interface ISingleChoiceService {
	/**
	 * 添加单选题
	 * @return boolean
	 */
	public boolean addSingleChoice(SingleChoice singleChoice);
	/**
	 * 修改单选题
	 * @param singleChoice
	 * @return
	 */
	public boolean updateSingleChoice(SingleChoice singleChoice);
	/**
	 * 按条件查询单选题 
	 * @param stage
	 * @param stem
	 * @return
	 */
	public List<SingleChoiceAndTeacher> selectByCondition(String stage,String stem,String page,String limit);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selcetCountS();
	
	public List<SingleChoiceAndTeacher> selectByConditionAdd(String stage, String stem, String page1, String limit1);
	public boolean updateSingleChoiceRight(Map<String, String> map4);
}

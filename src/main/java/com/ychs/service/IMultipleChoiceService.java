package com.ychs.service;

import java.util.List;

import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;
import com.ychs.bean.MultipleChoices;

/**
 * MultipleChoice的service接口
 * @author FENG
 *
 */
public interface IMultipleChoiceService {
	/**
	 * 添加多选题
	 * @param multipleChoice
	 * @return
	 */
	public boolean addMultipleChoice(MultipleChoice multipleChoice);
	
	/**
	 * 根据条件查询多选题
	 * @return
	 */
	public List<MultipleChoiceAndTeacher> selectMuByCondition(String stage ,String stem,String page,String limit);
	/**
	 * 修改多选题
	 * @param multipleChoice
	 * @return
	 */
	public boolean updateMultipleChoice(MultipleChoice multipleChoice);
	/**
	 * 查询总条数
	 * @return
	 */
	public int selcetCountS();
	
}

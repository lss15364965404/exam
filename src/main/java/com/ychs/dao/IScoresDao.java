package com.ychs.dao;


import java.util.List;
import java.util.Map;

import com.ychs.bean.PaperStuRightStuScoGrade;

/**
 * 学生成绩的Dao层接口
 * @author 李少石
 * @version 2018-04-16
 */
public interface IScoresDao {
	
	/**
	 * 根据条件用户数据
	 * @param user
	 * @return
	 */
	public List<PaperStuRightStuScoGrade> selectStudentScoresByCondition(Map<String,Object> map);
	
	/**
	 * 查询用户数据总条数
	 * @return
	 */
	public int selectCount(Map<String, Object> map);
}

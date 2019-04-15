package com.ychs.service;

import java.util.List;

import com.ychs.bean.PaperScoresGrade;
import com.ychs.bean.PaperStuRightStuScoGrade;

/**
 * 教师的service接口
 * @author 李少石
 * @version 2018-04-09
 */
public interface IScoresService {
	
	/**
	 * 按照条件查询学生成绩
	 * @param username
	 * @param password
	 * @return
	 */
	public List<PaperScoresGrade> selectStudentScoresByCondition(String paper_name,int student_id,String page1,String limit1);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts(int student_id);

	/**
	 * 各题型成绩判断
	 * @param answers
	 * @param student
	 * @param score
	 * @return
	 */
	public int judge(String answers, String student, String score);

}

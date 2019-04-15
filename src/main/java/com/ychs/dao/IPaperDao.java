package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Paper;

/**
 * 试卷数据库接口
 * @author 李少石
 * @version 2017-11-30
 */
public interface IPaperDao {

	/**
	 * 增加试卷
	 * @param map	待增加的试卷
	 * @return	返回影响的行数
	 */
	public int insert_paper(Map<String, String> map);
	
	/**
	 * 条件查询试卷
	 * @return
	 */
	public List<Paper> selectPaper(Map<String,Object> paperName);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCount();
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 修改试卷内的单选题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	public int update_paper_singleChoice(Paper paper);
	
	/**
	 * 修改试卷内的判断题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	public int update_paper_check(Paper paper);
	
	/**
	 * 修改试卷内的填空题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	public int update_paper_fillBlank(Paper paper);
	
	/**
	 * 修改试卷内的多选题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	public int update_paper_multipleChoice(Paper paper);
	
	
	/**
	 * 查询试卷信息,通过老师的id
	 * @param teacherId	老师id
	 * @return	返回所有试卷组成的List集合
	 */
	public List<Paper> select_paperByTeacherId(String teacherId);
	
	/**
	 * 查询试卷信息,通过试卷名
	 * @param paperName	试卷名
	 * @return	返回所有试卷组成的List集合
	 */
	public List<Paper> select_paperByPaperName(String paperName);
	
	/**
	 * 查询试卷中的选择题信息
	 * @return	返回所有试卷中的选择题信息组成的List集合
	 */
	public List<Paper> select_paper_singleChoice();
	
	
	
}

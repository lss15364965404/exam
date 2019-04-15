package com.ychs.dao;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Check;
import com.ychs.bean.FillBlank;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoices;
import com.ychs.bean.Paper;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoices;
import com.ychs.bean.TestResult;

/**
 * 学生考试功能接口，Dao层
 * 
 * @author qilijun
 *
 */
public interface IStudentExamDao {

	/**
	 * 查询全部试卷
	 * 
	 * @param map
	 *            查询条件
	 * @return 试卷
	 */
	public List<Paper> selectPapers(Map<String, Object> map);

	/**
	 * 查询指定试卷的试卷内容
	 * 
	 * @param map
	 *            查询条件
	 * @return 试卷的试题
	 */
	public Paper selectPaper(Map<String, Object> map);

	/**
	 * 查询单选题
	 * 
	 * @param map
	 * @return 单选题
	 */
	public SingleChoice selectSingleChoice(Map<String, Object> map);

	/**
	 * 查询出单选题选项
	 * 
	 * @param map
	 *            （需要通过单选题id）
	 * @return
	 */
	public List<SingleChoices> selectSingleChoices(Map<String, Object> map);

	/**
	 * 修改单选题，此处主要用于修改该题的使用次数、正确次数、正确率
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateSingleChoice(Map<String, Object> map);

	/**
	 * 查询判断题
	 * 
	 * @param map
	 * @return 判断题
	 */
	public Check selectCheck(Map<String, Object> map);

	/**
	 * 修改判断题
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateCheck(Map<String, Object> map);

	/**
	 * 查询多选题
	 * 
	 * @return 多选题
	 */
	public MultipleChoice selectMultipleChoice(Map<String, Object> map);

	/**
	 * 查询出多选题的选项
	 * 
	 * @param map
	 * @return
	 */
	public List<MultipleChoices> selectMultipleChoices(Map<String, Object> map);

	/**
	 * 修改多选题
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateMultipleChoice(Map<String, Object> map);

	/**
	 * 查询填空题
	 * 
	 * @param map
	 * @return 填空题
	 */
	public FillBlank selectFillBlank(Map<String, Object> map);

	/**
	 * 修改填空题
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateFillBlank(Map<String, Object> map);

	/**
	 * 学生向答题表中提交答题结果
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int insertTestResult(Map<String, Object> map);

	/**
	 * 查询学生答过的试题结果
	 * 
	 * @param map
	 * @return 学生答过的试题
	 */
	public List<TestResult> selectTestResults(Map<String, Object> map);

	/**
	 * 查询学生做过的某套试题结果
	 * 
	 * @param map
	 * @return
	 */
	public TestResult selectTestResult(Map<String, Object> map);
}

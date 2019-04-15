package com.ychs.service;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Check;
import com.ychs.bean.FillBlank;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.Paper;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.TestResult;

/**
 * 学生考试Service层接口
 * @author qilijun
 *
 */
public interface IStudentExamService {

	/**
	 * 查询全部试卷
	 * @param map 查询条件
	 * @return 试卷
	 */
	public List<Paper> getpapers(Map<String, Object> map);
	
	/**
	 * 查询指定试卷的试卷内容
	 * @param map 查询条件,需要传入试卷的id
	 * @return 试卷的试题
	 */
	public Map<String,Object> getpaper(Map<String,Object> map);
	
	/**
	 * 提交试卷
	 * @param map 提交带的参数
	 * @return 提交结果true/false
	 */
	public boolean commit(Map<String,Object> map);
	
	/**
	 * 得到学生做过的试题
	 * @param map
	 * @return 查询结果
	 */
	public List<TestResult> getTestResults(Map<String,Object> map);
	
	/**
	 * 得到指定试卷的试卷内容
	 * @param map 查询条件
	 * @return 试卷的试题
	 */
	public TestResult getTestResult(Map<String,Object> map);
	
}

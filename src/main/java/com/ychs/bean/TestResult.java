package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * TestResult类	学生的试卷答案（学生答题表）
 * @author 李少石
 * @version 2017-11-29
 */
@Component
public class TestResult {
	
	/**
	 * 学生的试卷答案id
	 */
	private String testResult_id;
	
	/**
	 * 试卷id
	 */
	private String paper_id;
	
	/**
	 * 学生id
	 */
	private String student_id;
	
	/**
	 * 学生单选题答案集合（以“1,2,3”类型存储）
	 */
	private String studentSingleChoice_answers;
	
	/**
	 * 学生判断题答案集合（以“T,F,T”类型存储）
	 */
	private String studentCheck_answers;
	
	/**
	 * 学生填空题答案集合（以“天,地,人”类型存储）
	 */
	private String studentFillBlank_answers;
	
	/**
	 * 学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 */
	private String studentMultipleChoice_answers;
	
	/**
	 * 学生所考试卷的成绩
	 */
	private String testResult_grade;
	
	/**
	 * 无参构造函数
	 */
	public TestResult() {
		super();
	}

	/**
	 * 带参数的构造函数
	 * @param testResult_id	学生的试卷答案id
	 * @param paper_id	试卷id
	 * @param student_id	学生id
	 * @param studentSingleChoice_answers	学生单选题答案集合（以“1,2,3”类型存储）
	 * @param studentCheck_answers	学生判断题答案集合（以“T,F,T”类型存储）
	 * @param studentFillBlank_answers	学生填空题答案集合（以“天,地,人”类型存储）
	 * @param studentMultipleChoice_answers	学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 * @param testResult_grade	学生所考试卷的成绩
	 */
	public TestResult(String testResult_id, String paper_id, String student_id, String studentSingleChoice_answers,
			String studentCheck_answers, String studentFillBlank_answers, String studentMultipleChoice_answers,
			String testResult_grade) {
		super();
		this.testResult_id = testResult_id;
		this.paper_id = paper_id;
		this.student_id = student_id;
		this.studentSingleChoice_answers = studentSingleChoice_answers;
		this.studentCheck_answers = studentCheck_answers;
		this.studentFillBlank_answers = studentFillBlank_answers;
		this.studentMultipleChoice_answers = studentMultipleChoice_answers;
		this.testResult_grade = testResult_grade;
	}
	
	

	/**
	 * 获取学生的试卷答案id
	 * @return	学生的试卷答案id
	 */
	public String getTestResult_id() {
		return testResult_id;
	}
	
	/**
	 * 设置学生的试卷答案id
	 * @param testResult_id	学生的试卷答案id
	 */
	public void setTestResult_id(String testResult_id) {
		this.testResult_id = testResult_id;
	}
	
	/**
	 * 获取试卷id
	 * @return	试卷id
	 */
	public String getPaper_id() {
		return paper_id;
	}
	
	/**
	 * 设置试卷id
	 * @param paper_id	试卷id
	 */
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}
	
	/**
	 * 获取学生id
	 * @return	学生id
	 */
	public String getStudent_id() {
		return student_id;
	}
	
	/**
	 * 设置学生id
	 * @param student_id	学生id
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	/**
	 * 获取学生单选题答案集合（以“1,2,3”类型存储）
	 * @return	学生单选题答案集合（以“1,2,3”类型存储）
	 */
	public String getStudentSingleChoice_answers() {
		return studentSingleChoice_answers;
	}
	
	/**
	 * 设置学生单选题答案集合（以“1,2,3”类型存储）
	 * @param studentSingleChoice_answers	学生单选题答案集合（以“1,2,3”类型存储）
	 */
	public void setStudentSingleChoice_answers(String studentSingleChoice_answers) {
		this.studentSingleChoice_answers = studentSingleChoice_answers;
	}
	
	/**
	 * 获取学生判断题答案集合（以“T,F,T”类型存储）
	 * @return	学生判断题答案集合（以“T,F,T”类型存储）
	 */
	public String getStudentCheck_answers() {
		return studentCheck_answers;
	}
	
	/**
	 * 设置学生判断题答案集合（以“T,F,T”类型存储）
	 * @param studentCheck_answers	学生判断题答案集合（以“T,F,T”类型存储）
	 */
	public void setStudentCheck_answers(String studentCheck_answers) {
		this.studentCheck_answers = studentCheck_answers;
	}
	
	/**
	 * 获取学生填空题答案集合（以“天,地,人”类型存储）
	 * @return	学生填空题答案集合（以“天,地,人”类型存储）
	 */
	public String getStudentFillBlank_answers() {
		return studentFillBlank_answers;
	}
	
	/**
	 * 设置学生填空题答案集合（以“天,地,人”类型存储）
	 * @param studentFillBlank_answers	学生填空题答案集合（以“天,地,人”类型存储）
	 */
	public void setStudentFillBlank_answers(String studentFillBlank_answers) {
		this.studentFillBlank_answers = studentFillBlank_answers;
	}
	
	/**
	 * 获取学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 * @return	学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 */
	public String getStudentMultipleChoice_answers() {
		return studentMultipleChoice_answers;
	}
	
	/**
	 * 设置学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 * @param studentMultipleChoice_answers	学生多选题答案集合（以“AB,AC,BCD”类型存储）
	 */
	public void setStudentMultipleChoice_answers(String studentMultipleChoice_answers) {
		this.studentMultipleChoice_answers = studentMultipleChoice_answers;
	}
	
	/**
	 * 获取学生所考试卷的成绩
	 * @return	学生所考试卷的成绩
	 */
	public String getTestResult_grade() {
		return testResult_grade;
	}
	
	/**
	 * 设置学生所考试卷的成绩
	 * @param testResult_grade	学生所考试卷的成绩
	 */
	public void setTestResult_grade(String testResult_grade) {
		this.testResult_grade = testResult_grade;
	}
	
	/**
	 * 通过字符串显示信息
	 */
	@Override
	public String toString() {
		return "TestResult [testResult_id=" + testResult_id + ", paper_id=" + paper_id + ", student_id=" + student_id
				+ ", studentSingleChoice_answers=" + studentSingleChoice_answers + ", studentCheck_answers="
				+ studentCheck_answers + ", studentFillBlank_answers=" + studentFillBlank_answers
				+ ", studentMultipleChoice_answers=" + studentMultipleChoice_answers + ", testResult_grade="
				+ testResult_grade + "]";
	}
	
	
	
	
}

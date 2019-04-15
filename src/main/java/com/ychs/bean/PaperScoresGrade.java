package com.ychs.bean;
/**
 * 学生试卷各题型成绩及总成绩
 * @author 李少石
 * @version 2018-04-25
 */
public class PaperScoresGrade {
	/**
	 * 学生答案id
	 */
	private String testResult_id;
	/**
	 * 试卷名
	 */
	private String paper_name;
	/**
	 * 学生id
	 */
	private String student_id;
	/**
	 * 学生单选题总分
	 */
	private String singleChoice_grade;
	/**
	 * 学生判断题总分
	 */
	private String check_grade;
	/**
	 * 学生填空题总分
	 */
	private String fillBlank_grade;
	/**
	 * 学生多选题总分
	 */
	private String multipleChoice_grade;
	/**
	 * 学生试卷总成绩
	 */
	private String testResult_grade;
	
	/**
	 * 无参构造函数
	 */
	public PaperScoresGrade() {
		super();
	}

	/**
	 * 带参数的构造函数
	 * @param testResult_id
	 * @param paper_name
	 * @param student_id
	 * @param singleChoice_grade
	 * @param check_grade
	 * @param fillBlank_grade
	 * @param multipleChoice_grade
	 * @param testResult_grade
	 */
	public PaperScoresGrade(String testResult_id, String paper_name, String student_id, String singleChoice_grade,
			String check_grade, String fillBlank_grade, String multipleChoice_grade, String testResult_grade) {
		super();
		this.testResult_id = testResult_id;
		this.paper_name = paper_name;
		this.student_id = student_id;
		this.singleChoice_grade = singleChoice_grade;
		this.check_grade = check_grade;
		this.fillBlank_grade = fillBlank_grade;
		this.multipleChoice_grade = multipleChoice_grade;
		this.testResult_grade = testResult_grade;
	}

	public String getTestResult_id() {
		return testResult_id;
	}

	public void setTestResult_id(String testResult_id) {
		this.testResult_id = testResult_id;
	}

	public String getPaper_name() {
		return paper_name;
	}

	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getSingleChoice_grade() {
		return singleChoice_grade;
	}

	public void setSingleChoice_grade(String singleChoice_grade) {
		this.singleChoice_grade = singleChoice_grade;
	}

	public String getCheck_grade() {
		return check_grade;
	}

	public void setCheck_grade(String check_grade) {
		this.check_grade = check_grade;
	}

	public String getFillBlank_grade() {
		return fillBlank_grade;
	}

	public void setFillBlank_grade(String fillBlank_grade) {
		this.fillBlank_grade = fillBlank_grade;
	}

	public String getMultipleChoice_grade() {
		return multipleChoice_grade;
	}

	public void setMultipleChoice_grade(String multipleChoice_grade) {
		this.multipleChoice_grade = multipleChoice_grade;
	}

	public String getTestResult_grade() {
		return testResult_grade;
	}

	public void setTestResult_grade(String testResult_grade) {
		this.testResult_grade = testResult_grade;
	}

	@Override
	public String toString() {
		return "PaperScoresGrade [testResult_id=" + testResult_id + ", paper_name=" + paper_name + ", student_id="
				+ student_id + ", singleChoice_grade=" + singleChoice_grade + ", check_grade=" + check_grade
				+ ", fillBlank_grade=" + fillBlank_grade + ", multipleChoice_grade=" + multipleChoice_grade
				+ ", testResult_grade=" + testResult_grade + "]";
	}



	
}

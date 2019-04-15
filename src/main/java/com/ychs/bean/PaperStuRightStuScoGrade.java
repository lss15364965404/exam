package com.ychs.bean;
/**
 * 学生试卷答案及成绩
 * @author 李少石
 * @version 2018-04-25
 */
public class PaperStuRightStuScoGrade {
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
	 * 单选题正确答案
	 */
	private String singleChoice_answers;
	/**
	 * 单选题学生答案
	 */
	private String studentSingleChoice_answers;
	/**
	 * 单选题总分
	 */
	private String singleChoice_score;
	/**
	 * 判断题正确答案
	 */
	private String check_answers;
	/**
	 * 判断题学生答案
	 */
	private String studentCheck_answers;
	/**
	 * 判断题总分
	 */
	private String check_score;
	/**
	 * 填空题正确答案
	 */
	private String fillBlank_answers;
	/**
	 * 填空题学生答案
	 */
	private String studentFillBlank_answers;
	/**
	 * 填空题总分
	 */
	private String fillBlank_score;
	/**
	 * 多选题答案
	 */
	private String multipleChoice_answers;
	/**
	 * 多选题学生答案
	 */
	private String studentMultipleChoice_answers;
	/**
	 * 多选题总分
	 */
	private String multipleChoice_score;
	/**
	 * 学生试卷总成绩
	 */
	private String testResult_grade;
	
	/**
	 * 无参构造函数
	 */
	public PaperStuRightStuScoGrade() {
		super();
	}

	/**
	 * 带参数的构造函数
	 * @param testResult_id
	 * @param paper_name
	 * @param student_id
	 * @param singleChoice_answers
	 * @param studentSingleChoice_answers
	 * @param singleChoice_score
	 * @param check_answers
	 * @param studentCheck_answers
	 * @param check_score
	 * @param fillBlank_answers
	 * @param studentFillBlank_answers
	 * @param fillBlank_score
	 * @param multipleChoice_answers
	 * @param studentMultipleChoice_answers
	 * @param multipleChoice_score
	 * @param testResult_grade
	 */
	public PaperStuRightStuScoGrade(String testResult_id, String paper_name, String student_id,
			String singleChoice_answers, String studentSingleChoice_answers, String singleChoice_score,
			String check_answers, String studentCheck_answers, String check_score, String fillBlank_answers,
			String studentFillBlank_answers, String fillBlank_score, String multipleChoice_answers,
			String studentMultipleChoice_answers, String multipleChoice_score, String testResult_grade) {
		super();
		this.testResult_id = testResult_id;
		this.paper_name = paper_name;
		this.student_id = student_id;
		this.singleChoice_answers = singleChoice_answers;
		this.studentSingleChoice_answers = studentSingleChoice_answers;
		this.singleChoice_score = singleChoice_score;
		this.check_answers = check_answers;
		this.studentCheck_answers = studentCheck_answers;
		this.check_score = check_score;
		this.fillBlank_answers = fillBlank_answers;
		this.studentFillBlank_answers = studentFillBlank_answers;
		this.fillBlank_score = fillBlank_score;
		this.multipleChoice_answers = multipleChoice_answers;
		this.studentMultipleChoice_answers = studentMultipleChoice_answers;
		this.multipleChoice_score = multipleChoice_score;
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

	public String getSingleChoice_answers() {
		return singleChoice_answers;
	}

	public void setSingleChoice_answers(String singleChoice_answers) {
		this.singleChoice_answers = singleChoice_answers;
	}

	public String getStudentSingleChoice_answers() {
		return studentSingleChoice_answers;
	}

	public void setStudentSingleChoice_answers(String studentSingleChoice_answers) {
		this.studentSingleChoice_answers = studentSingleChoice_answers;
	}

	public String getSingleChoice_score() {
		return singleChoice_score;
	}

	public void setSingleChoice_score(String singleChoice_score) {
		this.singleChoice_score = singleChoice_score;
	}

	public String getCheck_answers() {
		return check_answers;
	}

	public void setCheck_answers(String check_answers) {
		this.check_answers = check_answers;
	}

	public String getStudentCheck_answers() {
		return studentCheck_answers;
	}

	public void setStudentCheck_answers(String studentCheck_answers) {
		this.studentCheck_answers = studentCheck_answers;
	}

	public String getCheck_score() {
		return check_score;
	}

	public void setCheck_score(String check_score) {
		this.check_score = check_score;
	}

	public String getFillBlank_answers() {
		return fillBlank_answers;
	}

	public void setFillBlank_answers(String fillBlank_answers) {
		this.fillBlank_answers = fillBlank_answers;
	}

	public String getStudentFillBlank_answers() {
		return studentFillBlank_answers;
	}

	public void setStudentFillBlank_answers(String studentFillBlank_answers) {
		this.studentFillBlank_answers = studentFillBlank_answers;
	}

	public String getFillBlank_score() {
		return fillBlank_score;
	}

	public void setFillBlank_score(String fillBlank_score) {
		this.fillBlank_score = fillBlank_score;
	}

	public String getMultipleChoice_answers() {
		return multipleChoice_answers;
	}

	public void setMultipleChoice_answers(String multipleChoice_answers) {
		this.multipleChoice_answers = multipleChoice_answers;
	}

	public String getStudentMultipleChoice_answers() {
		return studentMultipleChoice_answers;
	}

	public void setStudentMultipleChoice_answers(String studentMultipleChoice_answers) {
		this.studentMultipleChoice_answers = studentMultipleChoice_answers;
	}

	public String getMultipleChoice_score() {
		return multipleChoice_score;
	}

	public void setMultipleChoice_score(String multipleChoice_score) {
		this.multipleChoice_score = multipleChoice_score;
	}

	public String getTestResult_grade() {
		return testResult_grade;
	}

	public void setTestResult_grade(String testResult_grade) {
		this.testResult_grade = testResult_grade;
	}

	@Override
	public String toString() {
		return "PaperStuRightStuScoGrade [testResult_id=" + testResult_id + ", paper_name=" + paper_name
				+ ", student_id=" + student_id + ", singleChoice_answers=" + singleChoice_answers
				+ ", studentSingleChoice_answers=" + studentSingleChoice_answers + ", singleChoice_score="
				+ singleChoice_score + ", check_answers=" + check_answers + ", studentCheck_answers="
				+ studentCheck_answers + ", check_score=" + check_score + ", fillBlank_answers=" + fillBlank_answers
				+ ", studentFillBlank_answers=" + studentFillBlank_answers + ", fillBlank_score=" + fillBlank_score
				+ ", multipleChoice_answers=" + multipleChoice_answers + ", studentMultipleChoice_answers="
				+ studentMultipleChoice_answers + ", multipleChoice_score=" + multipleChoice_score
				+ ", testResult_grade=" + testResult_grade + "]";
	}
}

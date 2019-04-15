package com.ychs.bean;

import org.springframework.stereotype.Component;

/**
 * Paper类 试卷表
 * @author 李少石
 * @version 2017-11-29
 */
@Component
public class Paper {
	
	/**
	 * 试卷ID
	 */
	private String paper_id;
	
	/**
	 * 出题老师ID
	 */
	private String teacher_id;
	
	/**
	 * 出题老师name
	 */
	private String teacher_name;
	
	/**
	 * 试卷名称
	 */
	private String paper_name;
	
	/**
	 * 单选题数目
	 */
	private String singleChoice_num;
	
	/**
	 * 单选题ID(以英文状态逗号隔开)
	 */
	private String singleChoice_ids;
	
	/**
	 * 单选题正确答案选项ID(按题号顺序以英文状态逗号隔开)
	 */
	private String singleChoice_answers;
	
	/**
	 * 单选题总分值
	 */
	private String singleChoice_score;
	
	/**
	 * 判断题数目
	 */
	private String check_num;
	
	/**
	 * 判断题ID(以英文状态逗号隔开)
	 */
	private String check_ids;
	
	/**
	 * 判断题正确答案<按题号顺序以英文状态逗号隔开，正确以1表示，错误用0表示>
	 */
	private String check_answers;
	
	/**
	 * 判断题总分值
	 */
	private String check_score;
	
	/**
	 * 填空题数目
	 */
	private String fillBlank_num;
	
	/**
	 * 填空题ID<以英文状态逗号隔开>
	 */
	private String fillBlank_ids;
	
	/**
	 * 填空题正确答案<按题号顺序以英文状态逗号隔开>
	 */
	private String fillBlank_answers;
	
	/**
	 * 填空题总分值
	 */
	private String fillBlank_score;
	
	/**
	 * 多选题数目
	 */
	private String multipleChoice_num;
	
	/**
	 * 多选题ID<以英文状态逗号隔开>
	 */
	private String multipleChoice_ids;
	
	/**
	 * 多选题正确答案选项ID<按题号顺序以英文状态逗号隔开,单题多选项间以&隔开>
	 */
	private String multipleChoice_answers;
	
	/**
	 * 多选题总分值
	 */
	private String multipleChoice_score;
	
	/**
	 * 无参数构造函数
	 */
	public Paper() {
		super();
	}
	
	/**
	 * 带参数的构造函数
	 * @param paper_id
	 * @param teacher_id
	 * @param teacher_name
	 * @param paper_name
	 * @param singleChoice_num
	 * @param singleChoice_ids
	 * @param singleChoice_answers
	 * @param singleChoice_score
	 * @param check_num
	 * @param check_ids
	 * @param check_answers
	 * @param check_score
	 * @param fillBlank_num
	 * @param fillBlank_ids
	 * @param fillBlank_answers
	 * @param fillBlank_score
	 * @param multipleChoice_num
	 * @param multipleChoice_ids
	 * @param multipleChoice_answers
	 * @param multipleChoice_score
	 */
	public Paper(String paper_id, String teacher_id, String teacher_name, String paper_name, String singleChoice_num,
			String singleChoice_ids, String singleChoice_answers, String singleChoice_score, String check_num,
			String check_ids, String check_answers, String check_score, String fillBlank_num, String fillBlank_ids,
			String fillBlank_answers, String fillBlank_score, String multipleChoice_num, String multipleChoice_ids,
			String multipleChoice_answers, String multipleChoice_score) {
		super();
		this.paper_id = paper_id;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.paper_name = paper_name;
		this.singleChoice_num = singleChoice_num;
		this.singleChoice_ids = singleChoice_ids;
		this.singleChoice_answers = singleChoice_answers;
		this.singleChoice_score = singleChoice_score;
		this.check_num = check_num;
		this.check_ids = check_ids;
		this.check_answers = check_answers;
		this.check_score = check_score;
		this.fillBlank_num = fillBlank_num;
		this.fillBlank_ids = fillBlank_ids;
		this.fillBlank_answers = fillBlank_answers;
		this.fillBlank_score = fillBlank_score;
		this.multipleChoice_num = multipleChoice_num;
		this.multipleChoice_ids = multipleChoice_ids;
		this.multipleChoice_answers = multipleChoice_answers;
		this.multipleChoice_score = multipleChoice_score;
	}
	
	/**
	 * 获取试卷id
	 * @return
	 */
	public String getPaper_id() {
		return paper_id;
	}

	/**
	 * 设置试卷id
	 * @param paper_id 试卷id
	 */
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	/**
	 * 获取老师id
	 * @return
	 */
	public String getTeacher_id() {
		return teacher_id;
	}

	/**
	 * 设置老师id
	 * @param teacher_id 老师id
	 */
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	/**
	 * 获取试卷名称
	 * @return
	 */
	public String getPaper_name() {
		return paper_name;
	}

	/**
	 * 设置试卷名称
	 * @param paper_name 试卷名称
	 */
	public void setPaper_name(String paper_name) {
		this.paper_name = paper_name;
	}

	/**
	 * 获取单选题数目
	 * @return
	 */
	public String getSingleChoice_num() {
		return singleChoice_num;
	}

	/**
	 * 设置单选题数目
	 * @param singleChoice_num 单选题数目
	 */
	public void setSingleChoice_num(String singleChoice_num) {
		this.singleChoice_num = singleChoice_num;
	}

	/**
	 * 获取单选题ID<以英文状态逗号隔开>
	 * @return
	 */
	public String getSingleChoice_ids() {
		return singleChoice_ids;
	}

	/**
	 * 设置单选题ID<以英文状态逗号隔开>
	 * @param singleChoice_ids 单选题ID<以英文状态逗号隔开>
	 */
	public void setSingleChoice_ids(String singleChoice_ids) {
		this.singleChoice_ids = singleChoice_ids;
	}

	/**
	 * 获取单选题正确答案选项ID<按题号顺序以英文状态逗号隔开>
	 * @return
	 */
	public String getSingleChoice_answers() {
		return singleChoice_answers;
	}

	/**
	 * 设置单选题正确答案选项ID<按题号顺序以英文状态逗号隔开>
	 * @param singleChoice_answers 单选题正确答案选项ID<按题号顺序以英文状态逗号隔开>
	 */
	public void setSingleChoice_answers(String singleChoice_answers) {
		this.singleChoice_answers = singleChoice_answers;
	}

	/**
	 * 获取单选题总分值
	 * @return
	 */
	public String getSingleChoice_score() {
		return singleChoice_score;
	}

	/**
	 * 设置单选题总分值
	 * @param singleChoice_score 单选题总分值
	 */
	public void setSingleChoice_score(String singleChoice_score) {
		this.singleChoice_score = singleChoice_score;
	}

	/**
	 * 获取判断题数目
	 * @return
	 */
	public String getCheck_num() {
		return check_num;
	}

	/**
	 * 设置判断题数目
	 * @param check_num 判断题数目
	 */
	public void setCheck_num(String check_num) {
		this.check_num = check_num;
	}

	/**
	 * 获取判断题ID<以英文状态逗号隔开>
	 * @return
	 */
	public String getCheck_ids() {
		return check_ids;
	}

	/**
	 * 设置判断题ID<以英文状态逗号隔开>
	 * @param check_ids 判断题ID<以英文状态逗号隔开>
	 */
	public void setCheck_ids(String check_ids) {
		this.check_ids = check_ids;
	}

	/**
	 * 获取判断题正确答案<按题号顺序以英文状态逗号隔开，正确以1表示，错误用0表示>
	 * @return
	 */
	public String getCheck_answers() {
		return check_answers;
	}

	/**
	 * 设置获取判断题正确答案<按题号顺序以英文状态逗号隔开，正确以1表示，错误用0表示>
	 * @param check_answers 获取判断题正确答案<按题号顺序以英文状态逗号隔开，正确以1表示，错误用0表示>
	 */
	public void setCheck_answers(String check_answers) {
		this.check_answers = check_answers;
	}

	/**
	 * 获取判断题总分值
	 * @return
	 */
	public String getCheck_score() {
		return check_score;
	}

	/**
	 * 设置判断题总分值
	 * @param check_score 判断题总分值
	 */
	public void setCheck_score(String check_score) {
		this.check_score = check_score;
	}

	/**
	 * 获取填空题数目
	 * @return
	 */
	public String getFillBlank_num() {
		return fillBlank_num;
	}

	/**
	 * 设置填空题数目
	 * @param fillBlank_num 填空题数目
	 */
	public void setFillBlank_num(String fillBlank_num) {
		this.fillBlank_num = fillBlank_num;
	}

	/**
	 * 获取填空题ID<以英文状态逗号隔开>
	 * @return
	 */
	public String getFillBlank_ids() {
		return fillBlank_ids;
	}

	/**
	 * 设置填空题ID<以英文状态逗号隔开>
	 * @param fillBlank_ids 填空题ID<以英文状态逗号隔开>
	 */
	public void setFillBlank_ids(String fillBlank_ids) {
		this.fillBlank_ids = fillBlank_ids;
	}

	/**
	 * 获取填空题正确答案<按题号顺序以英文状态逗号隔开>
	 * @return
	 */
	public String getFillBlank_answers() {
		return fillBlank_answers;
	}

	/**
	 * 设置填空题正确答案<按题号顺序以英文状态逗号隔开>
	 * @param fillBlank_answers 填空题正确答案<按题号顺序以英文状态逗号隔开>
	 */
	public void setFillBlank_answers(String fillBlank_answers) {
		this.fillBlank_answers = fillBlank_answers;
	}

	/**
	 * 获取填空题总分值
	 * @return
	 */
	public String getFillBlank_score() {
		return fillBlank_score;
	}

	/**
	 * 设置填空题总分值
	 * @param fillBlank_score 填空题总分值
	 */
	public void setFillBlank_score(String fillBlank_score) {
		this.fillBlank_score = fillBlank_score;
	}

	/**
	 * 获取多选题数目
	 * @return
	 */
	public String getMultipleChoice_num() {
		return multipleChoice_num;
	}

	/**
	 * 设置多选题数目
	 * @param multipleChoice_num 多选题数目
	 */
	public void setMultipleChoice_num(String multipleChoice_num) {
		this.multipleChoice_num = multipleChoice_num;
	}

	/**
	 * 获取多选题ID<以英文状态逗号隔开>
	 * @return
	 */
	public String getMultipleChoice_ids() {
		return multipleChoice_ids;
	}

	/**
	 * 设置多选题ID<以英文状态逗号隔开>
	 * @param multipleChoice_ids 多选题ID<以英文状态逗号隔开>
	 */
	public void setMultipleChoice_ids(String multipleChoice_ids) {
		this.multipleChoice_ids = multipleChoice_ids;
	}

	/**
	 * 获取多选题正确答案选项ID<按题号顺序以英文状态逗号隔开,单题多选项间以&隔开>
	 * @return
	 */
	public String getMultipleChoice_answers() {
		return multipleChoice_answers;
	}

	/**
	 * 设置多选题正确答案选项ID<按题号顺序以英文状态逗号隔开,单题多选项间以&隔开>
	 * @param multipleChoice_answers 多选题正确答案选项ID<按题号顺序以英文状态逗号隔开,单题多选项间以&隔开>
	 */
	public void setMultipleChoice_answers(String multipleChoice_answers) {
		this.multipleChoice_answers = multipleChoice_answers;
	}

	/**
	 * 获取多选题总分值
	 * @return
	 */
	public String getMultipleChoice_score() {
		return multipleChoice_score;
	}

	/**
	 * 设置多选题总分值
	 * @param multipleChoice_score
	 */
	public void setMultipleChoice_score(String multipleChoice_score) {
		this.multipleChoice_score = multipleChoice_score;
	}
	
	/**
	 * 获取出题老师name
	 * @return
	 */
	public String getTeacher_name() {
		return teacher_name;
	}

	/**
	 * 设置出题老师name
	 * @param name
	 */
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	
	/**
	 * 通过字符串显示信息
	 */
	@Override
	public String toString() {
		return "Paper [paper_id=" + paper_id + ", teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", paper_name="
				+ paper_name + ", singleChoice_num=" + singleChoice_num + ", singleChoice_ids=" + singleChoice_ids
				+ ", singleChoice_answers=" + singleChoice_answers + ", singleChoice_score=" + singleChoice_score
				+ ", check_num=" + check_num + ", check_ids=" + check_ids + ", check_answers=" + check_answers
				+ ", check_score=" + check_score + ", fillBlank_num=" + fillBlank_num + ", fillBlank_ids="
				+ fillBlank_ids + ", fillBlank_answers=" + fillBlank_answers + ", fillBlank_score=" + fillBlank_score
				+ ", multipleChoice_num=" + multipleChoice_num + ", multipleChoice_ids=" + multipleChoice_ids
				+ ", multipleChoice_answers=" + multipleChoice_answers + ", multipleChoice_score="
				+ multipleChoice_score + "]";
	}
	
}

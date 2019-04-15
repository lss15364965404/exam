package com.ychs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.PaperScoresGrade;
import com.ychs.bean.PaperStuRightStuScoGrade;
import com.ychs.dao.IScoresDao;

/**
 * 学生成绩的Service层
 * @author 李少石
 * @version 2018-04-09
 */
@Service
public class ScoresService implements IScoresService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IScoresDao scoresDao;
	
	
	
	/**
	 * 按照条件查询学生成绩
	 */
	@Override
	public List<PaperScoresGrade> selectStudentScoresByCondition(String paper_name1,int student_id1,String page1,String limit1) {
		log.debug("*******************StudentService selectStudentByCondition in*******************");
		List<PaperStuRightStuScoGrade> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(paper_name1 == null){	//对首次加载的页面进行处理，如果为null则为“”
			paper_name1 = "";
		}
		if(student_id1 == 0){	//对首次加载的页面进行处理，如果为null则为“”
			student_id1 = 1;
		}
		if(page1 == null){
			page1 = "1" ;
		}
		if(limit1 == null){
			limit1 = "10";
		}
		int page = Integer.parseInt(page1) -1;
		int limit = Integer.parseInt(limit1) ;
		page = page * limit ;			//分页的起始位置
		map.put("paper_name", "%"+paper_name1+"%");
		map.put("student_id", student_id1);
		map.put("page", page);
		map.put("limit", limit);
		log.debug("*******************StudentService selectStudentByCondition paper_name:"+paper_name1+"*******************");
		log.debug("*******************StudentService selectStudentByCondition student_id:"+student_id1+"*******************");
		log.debug("*******************StudentService selectStudentByCondition page:"+page+"*******************");
		log.debug("*******************StudentService selectStudentByCondition limit:"+limit+"*******************");
		
		list = scoresDao.selectStudentScoresByCondition(map);
		
		List<PaperScoresGrade> list_grade = new ArrayList();
		for(int i=0;i<list.size();i++) {
			String paper_name = list.get(i).getPaper_name();
			String testResult_id = list.get(i).getTestResult_id();
			String student_id = list.get(i).getStudent_id();
			String testResult_grade = list.get(i).getTestResult_grade();
			//单选题分数判断
			String singleChoice_answers = list.get(i).getSingleChoice_answers();
			String studentSingleChoice_answers = list.get(i).getStudentSingleChoice_answers();
			String singleChoice_score = list.get(i).getSingleChoice_score();
			int singleChoice_grade = judge(singleChoice_answers,studentSingleChoice_answers,singleChoice_score);
			//判断题分数判断
			String check_answers = list.get(i).getCheck_answers();
			String studentCheck_answers = list.get(i).getStudentCheck_answers();
			String check_score = list.get(i).getCheck_score();
			int check_grade = judge(check_answers,studentCheck_answers,check_score);
			//填空题分数判断
			String fillBlank_answers = list.get(i).getSingleChoice_answers();
			String studentFillBlank_answers = list.get(i).getStudentSingleChoice_answers();
			String fillBlank_score = list.get(i).getSingleChoice_score();
			int fillBlank_grade = judge(fillBlank_answers,studentFillBlank_answers,fillBlank_score);
			//多选题分数判断
			String multipleChoice_answers = list.get(i).getSingleChoice_answers();
			String studentMultipleChoice_answers = list.get(i).getStudentSingleChoice_answers();
			String multipleChoice_score = list.get(i).getSingleChoice_score();
			int multipleChoice_grade = judge(multipleChoice_answers,studentMultipleChoice_answers,multipleChoice_score);
			
			PaperScoresGrade paperScoresGrade = new PaperScoresGrade();
			paperScoresGrade.setTestResult_id(testResult_id);
			paperScoresGrade.setPaper_name(paper_name);
			paperScoresGrade.setStudent_id(student_id);
			paperScoresGrade.setSingleChoice_grade(Integer.toString(singleChoice_grade));
			paperScoresGrade.setCheck_grade(Integer.toString(check_grade));
			paperScoresGrade.setFillBlank_grade(Integer.toString(fillBlank_grade));
			paperScoresGrade.setMultipleChoice_grade(Integer.toString(multipleChoice_grade));
			paperScoresGrade.setTestResult_grade(testResult_grade);
			
			list_grade.add(paperScoresGrade);
			
		}
		
		log.debug("*******************StudentService selectStudentByCondition out*******************");
		return list_grade;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCounts(int student_id) {
		log.debug("******************* StudentService selcetCounts service in*******************");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("student_id", student_id);
		int num = scoresDao.selectCount(map);
		log.debug("******************* StudentService selcetCounts service out*******************");
		return num;
	}
	
	/**
	 * 各题型成绩判断
	 * @param answers
	 * @param student
	 * @param score
	 * @return
	 */
	@Override
	public int judge(String answer,String student,String score) {
		int result = 0;
		String answers[] = answer.split(",");
		String students[] = student.split(",");
		int num = 0;
		for(int i = 0 ; i<answers.length;i++) {
			if(answers[i].equals(students[i])) {
				num++;
			}
		}
		result = (Integer.parseInt(score))*num/(answers.length);
		
		return result;
	}


}

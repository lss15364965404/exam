package com.ychs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ychs.bean.PaperScoresGrade;
import com.ychs.service.IScoresService;

/**成绩controller
 * @author 李少石
 * @version 2018-04-25
 */
@Controller
public class ScoresController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IScoresService iScoresService ;
	
	/**
	 * 查看成绩
	 * @return
	 */
	@RequestMapping("/viewScores")
	public String viewScores(){
		
		log.debug("**********viewScores  controller in**********");
		
		log.debug("**********viewScores  controller out**********");
		return "viewScores";
	}
	
	
	/**
	 * 按条件查询学生成绩
	 * @return
	 */
	@RequestMapping(value="/selectStudentGrade",produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String selectStudentGrade(String paper_name,String page,String limit,HttpSession session){
		log.debug("********************************ScoresController  selectStudentGrade  in********************************");
		List<PaperScoresGrade> list = null;
		log.debug("********************************ScoresController  selectStudentGrade student_name:"+paper_name+"********************************");

		session.setAttribute("student_id", 1);
		int student_id = (Integer) session.getAttribute("student_id");
		
		log.debug("********************************ScoresController  student_id" + student_id );
		list = iScoresService.selectStudentScoresByCondition(paper_name,student_id,page,limit);
		int length = iScoresService.selectCounts(student_id);
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("********************************jihe:" + str);
		log.debug("********************************ScoresController  selectStudentGrade   out********************************");
		return str;
	}
	
}

package com.ychs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;
import com.ychs.service.ISingleChoiceService;

/**
 * 单选题的controller层
 * @author 李少石
 *
 */
@Controller
public class SingleChoiceController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ISingleChoiceService iscs;		//单选题接口
	
	/**
	 * 添加单选题的页面
	 * @return
	 */
	@RequestMapping("/addIndex")
	public String addIndex(){
		log.debug("********************************SingleChoice  controller in********************************");
		return "index";
	}
	/**
	 * 添加一个单选题
	 * @return
	 */
	@RequestMapping("/addSingleChoice")
	public String addSingleChoice(){
		log.debug("********************************SingleChoice  controller in*************************");
		String result = "success";
		SingleChoice singleChoice = new SingleChoice();
		singleChoice.setTeacher_id("1");
		singleChoice.setSingleChoice_question("2");
		singleChoice.setSingleChoiceAnswer_id("3,2,34");
		singleChoice.setSingleChoice_stage("java");
		singleChoice.setSingleChoice_useNum("23");
		singleChoice.setSingleChoice_rightNum("10");
		singleChoice.setSingleChoice_accuracy("09");
		log.debug("********************************SingleChoice  controller +++++++++++++********************************");
		if(!(iscs.addSingleChoice(singleChoice))) {
			result = "error";
		}
		log.debug("********************************SingleChoice  controller out********************************");
		return result;
	}
	
	/**
	 * 按条件查询单选题
	 * @return
	 */
	@RequestMapping(value="/selectSingleChoice",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selSingleChoice(String stem,String stage,String page,String limit,HttpSession session){
		log.debug("********************************SingleChoice  selSingleChoice in********************************");
		List<SingleChoiceAndTeacher> list = null;
		
		session.setAttribute("teacher_id", 1);
		
		log.debug("********************************stage：" + stage + "**********stem：" + stem);
		list = iscs.selectByCondition(stage, stem,page,limit);
		int length = iscs.selcetCountS();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("********************************jihe:" + str);
		log.debug("********************************selectSingleChoice  selSingleChoice  out********************************");
		return str;
	}
	
	
}

package com.ychs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ychs.bean.Check;
import com.ychs.service.ICheckService;

/**
 * 判断题controller
 * @author FENG
 *
 */
@Controller
public class CheckController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ICheckService checkService ;
	/**
	 * 添加一条判断题
	 * @return
	 */
	@RequestMapping("/checkAdd")
	public String add1(){
		
		log.debug("**********check  controller in**********");
		String result = "success";
		Check check = new Check();
		check.setTeacher_id("1");
		check.setCheck_question("asdf");
		check.setCheck_answer("adfdf");
		check.setCheck_stage("sdad");
		check.setCheck_useNum("12");
		check.setCheck_rightNum("23");
		check.setCheck_accuracy("0.9");
		
		//fs.addCheck(check);
		
		log.debug("**********check  controller out**********");
		return result;
	}
	
	
	/**
	 * 对判断题进行查询
	 * @param stem
	 * @param stage
	 * @return
	 */
	@RequestMapping(value="/selectCk",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCk(String stem,String stage,String page,String limit){
		
		log.debug("**********Check selectCk controller out**********");
		List<Check> list = null;
		list = checkService.selectCkByCondition(stage, stem,page,limit);
		int length = checkService.selcetCountS();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("jihe:" + str);
		
		log.debug("**********Check selectCk controller out**********");
		
		return str;
		
	}
	
}

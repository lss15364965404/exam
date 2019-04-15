package com.ychs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;
import com.ychs.service.IMultipleChoiceService;

/**
 * 填空题controller
 * @author FENG
 *
 */
@Controller
public class MultipleChoiceController {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMultipleChoiceService imcs ;
	
	@RequestMapping("/MultipleChoice")
	public String add1(){
		
		log.debug("MultipleChoice  controller in");
		String result = "success";
		MultipleChoice multipleChoice = new MultipleChoice();
		multipleChoice.setTeacher_id("1");
		multipleChoice.setMultipleChoice_question("asdf");
		multipleChoice.setMultipleChoiceAnswer_ids("adfdf");
		multipleChoice.setMultipleChoice_stage("sdad");
		multipleChoice.setMultipleChoice_useNum("12");
		multipleChoice.setMultipleChoice_rightNum("23");
		multipleChoice.setMultipleChoice_accuracy("0.9");
		
		//imcs.addMultipleChoice(multipleChoice);
		
		/*imcs.selectMuAll();
		imcs.selectMuByStage("sdad");
		imcs.selectMuByStem("a");*/
		log.debug("MultipleChoice  controller out");
		return result;
	}
	
	@RequestMapping(value="/selectMu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMu(String stem,String stage,String page,String limit){
		log.debug("MultipleChoice selectMu controller in");
		
		List<MultipleChoiceAndTeacher> list = null;
		list = imcs.selectMuByCondition(stage, stem,page,limit);
		int length = imcs.selcetCountS();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("jihe:" + str);
		
		log.debug("MultipleChoice selectMu controller out");
		return str;
		
	}
}

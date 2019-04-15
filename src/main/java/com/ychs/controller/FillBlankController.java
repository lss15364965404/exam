package com.ychs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ychs.bean.FillBlank;
import com.ychs.service.IFillBlankService;

/**
 * 填空题controller
 * @author FENG
 *
 */
@Controller
public class FillBlankController {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IFillBlankService fs ;
	
	@RequestMapping("/fillBlank")
	public String add1(){
		
		log.debug("fillBlank  controller in");
		String result = "success";
		FillBlank fb = new FillBlank();
		fb.setTeacher_id("1");
		fb.setFillBlank_question("asdf");
		fb.setFillBlank_answer("adfdf");
		fb.setFillBlank_stage("sdad");
		fb.setFillBlank_useNum("12");
		fb.setFillBlank_rightNum("23");
		fb.setFillBlank_accuracy("0.9");
		
		//fs.addFillBlank(fb);
		/*fs.selectFkAll();
		fs.selectFkByStage("ds");
		fs.selectFkByStem("ad");*/
		
		log.debug("fillBlank  controller out");
		return result;
	}
	
	/**
	 * 对填空题进行查询
	 * @param stem 题干
	 * @param stage 阶段
	 * @return
	 */
	@RequestMapping(value="/selectFk",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectFk(String stem,String stage,String page,String limit){
		log.debug("***********FillBlankController selectFk out***********");
		List<FillBlank> list = null;
		list = fs.selectFkByCondition(stem, stage,page,limit);
		int length = fs.selcetCountS();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("jihe:" + str);
		
		log.debug("***********FillBlankController selectFk out***********");
		
		return str;
	}
}
